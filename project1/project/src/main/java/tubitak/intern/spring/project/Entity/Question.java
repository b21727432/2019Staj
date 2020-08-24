package tubitak.intern.spring.project.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
@Data
public class Question extends BaseEntity{

    private String question;
    private LocalDateTime askTime;

    /* one to many relation with answers*/
    @OneToMany
    @JoinColumn(name = "answers")
    private Set<Answer> answers;
}
