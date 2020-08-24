package tubitak.intern.spring.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tubitak.intern.spring.project.Entity.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

}
