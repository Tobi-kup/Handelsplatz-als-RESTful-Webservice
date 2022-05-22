package com.example.restservice;

import org.springframework.http.MediaType;

import java.util.ArrayList;


@Path("verwaltung")
public class UserRegistrationService {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/start")
    public String bereit(){
    return "Alles bereit";
}

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/registrierterKunde")
    public UserRegistration registrierterKunde(){
        UserRegistration userDaten = new UserRegistration();
        userDaten.setNachname("Fengyi");
        userDaten.setVorname("Goertz");
        userDaten.setEmail("max.zhao@oose.de");
        userDaten.setPasswort("qwertz");

        return userDaten;
    }

}
