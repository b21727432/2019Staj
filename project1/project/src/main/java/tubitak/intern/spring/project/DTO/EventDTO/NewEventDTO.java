package tubitak.intern.spring.project.DTO.EventDTO;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.implementation.bind.annotation.Empty;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewEventDTO {

    @NotNull
    private String eventName;
    @NotNull
    private LocalDateTime startDate;
    @NotNull
    private LocalDateTime finishDate;
    private String info;
    @NotNull
    private String address;
    private Boolean isValid;

}
