package tubitak.intern.spring.project.DTO.EventDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDTO {

    private Long eventId;
    private String eventName;
    private LocalDateTime startDate;
    private LocalDateTime finishDate;
    private String info;
    private String address;
    private Boolean isValid;

}
