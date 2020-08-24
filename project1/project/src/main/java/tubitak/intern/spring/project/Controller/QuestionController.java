package tubitak.intern.spring.project.Controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tubitak.intern.spring.project.DTO.QuestionDTO.NewQuestionDTO;
import tubitak.intern.spring.project.Service.QuestionService;

@RestController
@RequestMapping("/questions")
@CrossOrigin
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping
    public ResponseEntity getQuestions(@RequestParam String activityId){
        try{
            return ResponseEntity.ok(questionService.getQuestions(Long.parseLong(activityId)));
        }catch (Exception e){
            return ResponseEntity.unprocessableEntity().body("No such activity");
        }
    }
    @PostMapping
    public ResponseEntity addQuestion(@RequestBody NewQuestionDTO newQuestionDTO){
        questionService.addQuestion(newQuestionDTO);
        return ResponseEntity.ok("Added");
    }
    @DeleteMapping
    public ResponseEntity deleteQuestion(@RequestParam Long id){
        questionService.deleteQuestion(id);
        return ResponseEntity.ok("Deleted");
    }


}
