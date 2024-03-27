package com.example.demo.login;

import com.example.demo.login.LoginForm;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class LoginService {
    //private final UserRepository userRepository
    private final PasswordEncoder passwordEncoder;
    @Value("${jwt.token.key}")
    private String key;


    @Autowired
    public LoginService(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
        //this.userRepository = userRepository;
}
    public String login(LoginForm loginForm){
        if(passwordEncoder.matches(loginForm.getPassword(),/*user.getPassword()*/"")){
        //if(passwordEncoder.encode(loginForm.getPassword().equals(/*user.getPassword()*/""))) {
            long timeMills = System.currentTimeMillis();
            String token = Jwts.builder()
                    .issuedAt(new Date(timeMills))
                    .expiration(new Date(timeMills + 5 * 60 * 1000))
                    .claim("id", "userId")
                    .claim("userRole", "ROLE_")
                    .signWith(SignatureAlgorithm.HS256, key)
                    .compact();
            return token;
        }else{
            return null;
        }
    }
}

