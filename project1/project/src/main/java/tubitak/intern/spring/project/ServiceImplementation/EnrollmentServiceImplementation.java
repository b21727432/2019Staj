package tubitak.intern.spring.project.ServiceImplementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tubitak.intern.spring.project.DTO.UsersDTO.EnrollmentDTO;
import tubitak.intern.spring.project.Service.EnrollmentService;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImplementation implements EnrollmentService {

    @Override
    public String makeEnrollment(EnrollmentDTO enrollmentDTO) {
        return null;
    }

    @Override
    public void cancelEnrollment(EnrollmentDTO enrollmentDTO) {

    }

    @Override
    public String checkEnrollment(EnrollmentDTO enrollmentDTO) {
        return null;
    }
}
