package com.example.restservice;

import java.io.Serializable;

public class UserRegistration implements Serializable {

    private String nachname;

    private String vorname;

    private String email;

    private String passwort;


    public UserRegistration(){}


    public void setNachname(String nachname){
        this.nachname = nachname;
    }

    private String getNachname(){ return nachname; }



    public void setVorname(String vorname){
        this.vorname = vorname;
    }

    private String getVorname(){ return vorname; }



    public void setEmail(String email){
        this.email = email;
    }

    private String getEmail(){ return email; }



    public void setPasswort(String passwort){
        this.passwort = passwort;
    }

    private String getPasswort(){ return passwort; }

}
