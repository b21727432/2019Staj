package tubitak.intern.spring.project.Service;

import tubitak.intern.spring.project.DTO.QuestionDTO.NewQuestionDTO;
import tubitak.intern.spring.project.Entity.Question;

import java.util.Set;

public interface QuestionService {

    Set<Question> getQuestions(long parseLong);

    void addQuestion(NewQuestionDTO question);

    void deleteQuestion(Long id);
}
