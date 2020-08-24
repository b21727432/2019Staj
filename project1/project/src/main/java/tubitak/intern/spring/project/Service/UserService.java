package tubitak.intern.spring.project.Service;

import tubitak.intern.spring.project.DTO.UsersDTO.LoginDTO;
import tubitak.intern.spring.project.DTO.UsersDTO.RegisterDTO;
import tubitak.intern.spring.project.Entity.Users;

public interface UserService {
     void register(RegisterDTO registerDTO);

     String login(LoginDTO loginDTO);

     Users findByIdentificationNumber(String identificationNumber);

}
