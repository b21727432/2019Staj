package tubitak.intern.spring.project.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
public class Events extends BaseEntity {


    private String eventName;
    private LocalDateTime startDate;
    private LocalDateTime finishDate;
    private String info;
    private String address;
    private Boolean isValid;

    @ManyToMany(mappedBy = "enrolledEvents")
    private Set<Users> enrolledUsers;

    @OneToMany
    @JoinColumn(name = "activity_id")
    private Set<Question> askedQuestions;

}
