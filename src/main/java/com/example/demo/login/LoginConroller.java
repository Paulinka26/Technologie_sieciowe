package com.example.demo.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginConroller {
    private final LoginService loginService;
    @Autowired
    public LoginConroller(LoginService loginService){
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginForm loginForm) {
        String token = loginService.login(loginForm);
        if(token==null) {
            return new ResponseEntity<>("Incorrect login or password", HttpStatus.UNAUTHORIZED);
        }else{
            return new ResponseEntity<>(token, HttpStatus.OK);
        }
    }
}