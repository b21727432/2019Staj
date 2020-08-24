package tubitak.intern.spring.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tubitak.intern.spring.project.Entity.Question;

import java.util.Set;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    Set<Question> getQuestions(long parseLong);
}
