package tubitak.intern.spring.project.ServiceImplementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tubitak.intern.spring.project.DTO.QuestionDTO.NewQuestionDTO;
import tubitak.intern.spring.project.Entity.Events;
import tubitak.intern.spring.project.Entity.Question;
import tubitak.intern.spring.project.Repository.EventRepository;
import tubitak.intern.spring.project.Repository.QuestionRepository;
import tubitak.intern.spring.project.Service.QuestionService;

import java.time.LocalDateTime;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class QuestionServiceImplementation implements QuestionService {

    private final QuestionRepository questionRepository;
    private final EventRepository eventRepository;

    @Override
    public Set<Question> getQuestions(long parseLong) {
        return questionRepository.getQuestions(parseLong);
    }



    @Override
    public void addQuestion(NewQuestionDTO newQuestionDTO) {
        Events event = eventRepository.findById(newQuestionDTO.getEventId()).get();
        /* zaman kontrolu yapılır burda*/

        event.getAskedQuestions().add(newQuestionDTO);
        eventRepository.save(event);
    }

    @Override
    public void deleteQuestion(Long id) {
        /* burda zaman kontrolu yapılıp ona göre eklenebilir*/
        questionRepository.deleteById(id);
    }

}
