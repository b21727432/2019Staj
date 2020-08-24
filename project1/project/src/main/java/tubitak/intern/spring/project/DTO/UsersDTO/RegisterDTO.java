package tubitak.intern.spring.project.DTO.UsersDTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {


    private String identificationNumber;

    private String email;

    private String password;

    private String name;
}
