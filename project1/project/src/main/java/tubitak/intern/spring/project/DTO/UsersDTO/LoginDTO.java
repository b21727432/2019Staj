package tubitak.intern.spring.project.DTO.UsersDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {


    private String identificationNumber;

    private String password;

}
