package com.example.restservice;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * UserRegistrationService ist die Klasse zur Erstellung der URIs.
 * Sie erstellt die Pfade innerhalb des Marktplatzes.
 * Der Client soll diesen dann folgenden, um sich auf dem Server zurechzufinden.
 */

@RestController
public class UserRegistrationService {


    //http://localhost:8080/login?name=<Name>&password=<Passwort>

    /**
     * Fragt den Nutzer nach seinen Nutzerdaten, um ihm Daten den Zugang zu gewähren
     * @param name - Name des Nutzerprofils vom Typ String
     * @param password - Passwort des Nutzerprofils vom Typ String
     * @return einen angepassten String, der in der Methode check der Klasse UserLogin erstellt wird
     */
    @GetMapping("/login")
    public String login(@RequestParam(value = "name") String name, @RequestParam(value = "password") String password){
    UserLogin neu = new UserLogin();
    return neu.check(name, password);
    }


    /**
     * Aktualisiert die Preise der angebotenen Güter auf Nutzeranfrage, nach dessen Anmeldung
     * @param name - Name des Nutzerprofils vom Typ String
     * @param password - Passwort des Nutzerprofils vom Typ String
     * @return erstmal nur einen angepassten, der ausgibt, ob der Nutzer die nötigen Rechte besitz
     */
    @GetMapping("/refresh")
    public String refresh(@RequestParam(value = "name") String name, @RequestParam(value = "password") String password){
        UserLogin neu = new UserLogin();
        if(neu.check(name, password) == "Willkommen."){
            return "Ich würde refreshen, wenn es implementiert wäre.";
        }
        return "Ich würde dir keine Erlaubnis dafür geben, wenn es implementiert wäre";
    }

}

