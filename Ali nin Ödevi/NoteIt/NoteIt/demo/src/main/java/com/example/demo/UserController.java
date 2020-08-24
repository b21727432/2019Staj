package com.example.demo;

import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.sql.ResultSet;
import java.util.Base64;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRep;

    public UserController(UserRepository userRep) {
        this.userRep = userRep;
    }
    public static String webToken;

    @RequestMapping(value="/all", method = RequestMethod.GET)
    public  Iterable<Users> getAllUsers() {
       Iterable<Users> users3 = userRep.findAll();
       return users3;
    }

    @RequestMapping(value="/login/{username}/{password}/{token}", method = RequestMethod.GET)
    public String findUser(HttpServletRequest request, HttpServletResponse response, @PathVariable("username")String username1, @PathVariable("password")String password, @PathVariable("token")String token){
        try{
            String myDriver = "com.mysql.cj.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/kullanicidb";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "123456");
            PreparedStatement safeQuery = null;
            String query = "SELECT * FROM users WHERE username = ? AND password=?";
            safeQuery = conn.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            safeQuery.setString(1,username1);
            safeQuery.setString(2,password);
            ResultSet resultSet = safeQuery.executeQuery(); // this gives error if one of them is not true
            resultSet.next();
            if(resultSet.getString(2) != null){
                if(resultSet.getInt(4) == 3){
                    JSONObject json = new JSONObject();
                    json.put("message","User is Blocked");
                     return json.toString();
                }
                resultSet.updateInt("tries",0);
                resultSet.updateRow();
                JSONObject json = new JSONObject();
                json.put("message","Succesful");
                return json.toString();
            }
        }catch(Exception e){
            try{
                String myDriver = "com.mysql.cj.jdbc.Driver";
                String myUrl = "jdbc:mysql://localhost:3306/kullanicidb";
                Class.forName(myDriver);
                Connection conn = DriverManager.getConnection(myUrl, "root", "123456");

                PreparedStatement safeQuery = null;
                String query = "SELECT * FROM users WHERE username = ?";
                safeQuery = conn.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
                safeQuery.setString(1,username1);

                ResultSet resultSet = safeQuery.executeQuery();
                resultSet.next();

                if(resultSet.getInt(4) == 3){
                    JSONObject json = new JSONObject();
                    json.put("message","User is Blocked");
                    return json.toString();
                }
                resultSet.updateInt("tries",resultSet.getInt(4)+1);
                resultSet.updateRow();

                JSONObject json = new JSONObject();
                json.put("message","Unsuccesful");
                return json.toString();
            }catch (Exception a){
                JSONObject json = new JSONObject();
                json.put("message","Unsuccesful");
                return json.toString();
            }
        }
        return null;
    }
    @RequestMapping(value="/myUser/test/delete", method = RequestMethod.POST)
    public String forger(){

        /* User deletion part */

        return "User is Deleted Without Token";
    }
    @RequestMapping(value="/myUser/delete", method = RequestMethod.POST)
    public String deleteUser(HttpServletRequest request,@RequestBody Token body){
        if(!request.getCookies()[0].getValue().equals(body.token)){
            return "You are a Cross Site Request Forger";
        }
        //User Deletion Part
        JSONObject json = new JSONObject();
        json.put("message","User is Deleted");
        return json.toString();
    }

    @RequestMapping(value="", method = RequestMethod.POST)
    public void addNewUser (@RequestBody Users user){

        Users n = new Users(user.getUsername(),user.getPassword(),user.getRole());

        userRep.save(n);
    }

    public String cryptPassword(String password){
        String strongPass = Base64.getEncoder().encodeToString(password.getBytes());
        return strongPass;
    }

}
