package tubitak.intern.spring.project.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tubitak.intern.spring.project.DTO.EventDTO.EventDTO;
import tubitak.intern.spring.project.Entity.Events;

import java.time.LocalDateTime;

public interface EventRepository extends JpaRepository<Events, Long>{



    @Query("SELECT a " +
            "FROM Events a ")
    Page<Events> getActivities(PageRequest pageRequest);


}
