package tubitak.intern.spring.project.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tubitak.intern.spring.project.DTO.EventDTO.EventDTO;
import tubitak.intern.spring.project.DTO.EventDTO.NewEventDTO;
import tubitak.intern.spring.project.Service.EventService;

import javax.validation.Valid;

@RestController
@RequestMapping("/events")
@CrossOrigin
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @DeleteMapping("/{id}")
    public ResponseEntity deleteEvent(@PathVariable String id){
        eventService.deleteActivity(Long.parseLong(id));
        return ResponseEntity.ok("Deleted");
    }

    @PutMapping
    public ResponseEntity updateEvent(@Valid @RequestBody EventDTO eventDTO){
        return ResponseEntity.ok(eventService.updateActivity(eventDTO));
    }

    @PostMapping
    public ResponseEntity createEvent(@Valid @RequestBody NewEventDTO newEventDTO){
        eventService.createActivity(newEventDTO);
        return ResponseEntity.ok("Created");
    }

    @GetMapping("/admin")
    public ResponseEntity listActivities(@RequestParam Integer page, @RequestParam Integer size, @RequestParam String sortBy, @RequestParam String search) {
        return ResponseEntity.ok(eventService.listActivities(page, size, sortBy, search));
    }

    @GetMapping("/change")
    public ResponseEntity changeActive(@RequestParam Long id){
        eventService.changeActive(id);
        return ResponseEntity.ok("Event is active");
    }
}
