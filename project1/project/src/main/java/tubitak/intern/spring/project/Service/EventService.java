package tubitak.intern.spring.project.Service;

import org.springframework.data.domain.Page;
import tubitak.intern.spring.project.DTO.EventDTO.EventDTO;
import tubitak.intern.spring.project.DTO.EventDTO.NewEventDTO;
import tubitak.intern.spring.project.Entity.Events;

public interface EventService {

    void createActivity(NewEventDTO newEventDTO);

    EventDTO updateActivity(EventDTO eventDTO);

    void deleteActivity(long parseLong);

    Page<Events> listEvents(Integer page , Integer size, String sortBy, String search);

    Page<EventDTO> listValidEvents(Integer page , Integer size, String sortBy, String search);

    Page<Events> listActivitiesAfterNow(Integer page , Integer size, String sortBy, String search);

    Page<Events> listActivities(Integer page , Integer size, String sortBy, String search);

    void changeActive(Long id);
}
