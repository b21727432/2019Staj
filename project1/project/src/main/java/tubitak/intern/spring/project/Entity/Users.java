package tubitak.intern.spring.project.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Users extends BaseEntity {

    private String identificationNumber;
    private String email;
    private String password;
    private String name;
    private boolean isAdmin;


    @ManyToMany
    @JoinTable(
            name = "enrollment",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id"))
    private Set<Events> enrolledEvents;


}
