package tubitak.intern.spring.project.ServiceImplementation;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import tubitak.intern.spring.project.DTO.UsersDTO.LoginDTO;
import tubitak.intern.spring.project.DTO.UsersDTO.RegisterDTO;
import tubitak.intern.spring.project.Entity.Users;
import tubitak.intern.spring.project.Repository.UserRepository;
import tubitak.intern.spring.project.Service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import tubitak.intern.spring.project.Security.JwtToken;


import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImplementation implements UserService {

    private  UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final AuthenticationManager authenticationManager;
    private final JwtToken jwtToken;


    @Override
    public void register(RegisterDTO registerDTO){
        Users x =modelMapper.map(registerDTO, Users.class);
        x.setAdmin(false);
        x.setEnrolledEvents(Set.of());
        x.setPassword(x.getPassword());
        userRepository.save(x);
    }

    @Override
    public String login(LoginDTO loginDTO){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getIdentificationNumber(), loginDTO.getPassword()));
        return jwtToken.generateToken(findByIdentificationNumber(loginDTO.getIdentificationNumber()));

    }

    @Override
    public Users findByIdentificationNumber(String identificationNumber){
        return userRepository.findByIdentificationNumber(identificationNumber);
    }

}
