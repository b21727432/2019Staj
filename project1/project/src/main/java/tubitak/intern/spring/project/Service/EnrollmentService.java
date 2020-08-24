package tubitak.intern.spring.project.Service;

import tubitak.intern.spring.project.DTO.UsersDTO.EnrollmentDTO;

public interface EnrollmentService {
    String makeEnrollment(EnrollmentDTO enrollmentDTO);

    void cancelEnrollment(EnrollmentDTO enrollmentDTO);

    String checkEnrollment(EnrollmentDTO enrollmentDTO);
}
