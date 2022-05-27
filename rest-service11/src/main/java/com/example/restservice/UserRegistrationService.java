package com.example.restservice;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserRegistrationService {

    //http://localhost:8080/login?name=<Name>&password=<Passwort>
    @GetMapping("/login")
    public String login(@RequestParam(value = "name") String name, @RequestParam(value = "password") String password){
    UserLogin neu = new UserLogin();
    return neu.check(name, password);
    }

    @GetMapping("/refresh")
    public String refresh(@RequestParam(value = "name") String name, @RequestParam(value = "password") String password){
        UserLogin neu = new UserLogin();
        if(neu.check(name, password) == "Willkommen."){
            return "Ich würde refreshen, wenn es implementiert wäre.";
        }
        return "Ich würde dir keine Erlaubnis dafür geben, wenn es implementiert wäre";
    }

}

