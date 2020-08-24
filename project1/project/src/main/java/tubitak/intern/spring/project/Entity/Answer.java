package tubitak.intern.spring.project.Entity;


import lombok.*;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
@Data
public class Answer extends BaseEntity{

    private String answer;
    private LocalDateTime replyTime;
}
