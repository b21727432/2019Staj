package tubitak.intern.spring.project.DTO.QuestionDTO;


import lombok.*;
import tubitak.intern.spring.project.Entity.Question;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewQuestionDTO extends Question {

    private Long eventId;

    private String question;

}
