package tubitak.intern.spring.project.Security;

import org.springframework.stereotype.Service;
import tubitak.intern.spring.project.Entity.Users;

@Service
public class UserDetails {
    public static String getUserAuthority(Users user){
        if(user.isAdmin()){
            return "ADMIN";
        }
        return "USER";
    }
}
