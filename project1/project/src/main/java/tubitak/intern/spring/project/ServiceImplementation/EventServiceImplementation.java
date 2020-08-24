package tubitak.intern.spring.project.ServiceImplementation;


import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import tubitak.intern.spring.project.DTO.EventDTO.EventDTO;
import tubitak.intern.spring.project.DTO.EventDTO.NewEventDTO;
import tubitak.intern.spring.project.Entity.Events;
import tubitak.intern.spring.project.Repository.EventRepository;
import tubitak.intern.spring.project.Service.EventService;

@Service
@RequiredArgsConstructor
public class EventServiceImplementation implements EventService {

    private final EventRepository eventRepository;
    private final ModelMapper modelMapper;

    @Override
    public void createActivity(NewEventDTO newEventDTO) {
        newEventDTO.setIsValid(false);
        eventRepository.save(modelMapper.map(newEventDTO, Events.class));
    }

    @Override
    public EventDTO updateActivity(EventDTO eventDTO) {
        Events oldEvent = eventRepository.findById(eventDTO.getEventId()).get();
        modelMapper.map(eventDTO, oldEvent);
        return modelMapper.map(eventRepository.save(oldEvent), EventDTO.class);
    }

    @Override
    public void deleteActivity(long parseLong) {
        eventRepository.deleteById(parseLong);
    }

    @Override
    public Page<Events> listEvents(Integer page, Integer size, String sortBy, String search) {
        return null;
    }

    @Override
    public Page<EventDTO> listValidEvents(Integer page, Integer size, String sortBy, String search) {
        return null;
    }


    @Override
    public Page<Events> listActivitiesAfterNow(Integer page, Integer size, String sortBy, String search) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(sortBy).ascending());
        if (search == null || search.trim().equals(""))
            return eventRepository.getActivities(pageRequest);
        else return eventRepository.getActivities(pageRequest);
    }

    @Override
    public Page<Events> listActivities(Integer page, Integer size, String sortBy, String search) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(sortBy).ascending());
        if (search == null || search.trim().equals("")) return eventRepository.getActivities(pageRequest);
        else return eventRepository.getActivities(pageRequest);
    }
}
