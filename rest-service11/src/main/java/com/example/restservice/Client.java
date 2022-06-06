package com.example.restservice;
import java.util.*;

public class Client {
        public String UserName;
        public String UserPasswort;
        Scanner s = new Scanner(System.in);
        UserInteraction ui = new UserInteraction();

        boolean angemeldet = false;


        public Client() {

                String eingabe = "";
                System.out.println("Möchten Sie sich registrieren oder einloggen? \n" +
                                   "Wählen Sie 'r' um sich zu registrieren oder 'l' um sich einzuloggen.");

                eingabe = s.nextLine();
                if(eingabe.equals("r")){
                        System.out.println("Geben sie bitte ihren gewünschten Nutzernamen und ihr gewünschtes Passwort in dem Format \n <name> \n <password> \n ein.");
                        String name = s.nextLine();
                        String password = s.nextLine();
                        ui.signup(name, password);

                } else if(eingabe.equals("l")){
                        System.out.println("Geben sie bitte ihren Nutzernamen und ihr  Passwort in dem Format \n <name> \n <password> \n ein.");
                        String name = s.nextLine();
                        String password = s.nextLine();
                        if(ui.login(name, password) == "Login erfolgreich") { angemeldet = true; }
                }




//
//                System.out.println("Nutzername eingeben:");
//                Scanner UName = new Scanner(System.in);
//                this.UserName = UName.nextLine();
//                System.out.println("Passwort eingeben:");
//                Scanner UPasswort = new Scanner(System.in);
//                this.UserPasswort = UPasswort.nextLine();
//                System.out.println("Neuen Nutzer erstellt: \nNutzername: " + UserName + "\nPasswort: " + UserPasswort);
        }
}


