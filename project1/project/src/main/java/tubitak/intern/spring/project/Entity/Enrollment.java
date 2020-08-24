package tubitak.intern.spring.project.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;


@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Enrollment extends BaseEntity{

        private LocalDateTime enrollmentDate;

        @OneToMany
        @JoinColumn(name = "enrollment_id")
        private List<Answer> givenAnswers;
}
