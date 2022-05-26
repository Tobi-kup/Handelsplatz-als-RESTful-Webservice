package com.example.restservice;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class UserRegistrationService {

    //http://localhost:8080/login?name=Max&password=MPasswort
    @GetMapping("/login")
    public String bereit(@RequestParam(value = "name") String name, @RequestParam(value = "password") String password){
    UserLogin neu = new UserLogin();
    return neu.check(name, password);
}

}

