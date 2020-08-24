package tubitak.intern.spring.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tubitak.intern.spring.project.Entity.Users;

public interface UserRepository extends JpaRepository<Users, Long> {


    Users findByIdentificationNumber(String identificationNumber);
}
