package tubitak.intern.spring.project.Security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import tubitak.intern.spring.project.Entity.Users;
import tubitak.intern.spring.project.ServiceImplementation.UserServiceImplementation;

import java.util.Arrays;
import java.util.Date;

@Component
public class JwtToken {

    static final long TOKEN_VALIDITY_SECONDS = 60 * 60 * 2;
    static final String SECRET_KEY = "alik";

    public String generateToken(Users x){
        Claims claims = Jwts.claims().setSubject(x.getIdentificationNumber());
        claims.put("scopes", Arrays.asList(new SimpleGrantedAuthority(
                "ROLE_"+ UserDetails.getUserAuthority(x))));
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+TOKEN_VALIDITY_SECONDS))
                .signWith(SignatureAlgorithm.HS256,SECRET_KEY)
                .compact();
    }

}
