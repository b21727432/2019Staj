package tubitak.intern.spring.project.Controller;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tubitak.intern.spring.project.DTO.UsersDTO.LoginDTO;
import tubitak.intern.spring.project.DTO.UsersDTO.RegisterDTO;
import tubitak.intern.spring.project.Service.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
@CrossOrigin
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping("/register")
    public ResponseEntity createNewUser(@Valid @RequestBody RegisterDTO registerDTO){
        userService.register(registerDTO);
        return ResponseEntity.ok("Succesful");
        /* try catch can be added here*/
    }

    @PostMapping("/login")
    public ResponseEntity login(@Valid @RequestBody LoginDTO loginDTO){
        try{
            return ResponseEntity.ok(userService.login(loginDTO));
        }catch (Exception e){
            return ResponseEntity.unprocessableEntity().body("Id or password is wrong...");
        }

    }

}
