package tubitak.intern.spring.project.DTO.UsersDTO;


import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
@Data
public class EnrollmentDTO {

    private String identificationNumber;

    private Long eventId;

}
