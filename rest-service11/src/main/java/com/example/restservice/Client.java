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
                String name = "";
                System.out.println("Möchten Sie sich registrieren oder einloggen? \n" +
                                   "Wählen Sie 'r' um sich zu registrieren oder 'l' um sich einzuloggen.");

                eingabe = s.nextLine();
                if(eingabe.equals("r")){
                        System.out.println("Geben sie bitte ihren gewünschten Nutzernamen und ihr gewünschtes Passwort in dem Format \n <name> \n <password> \n ein.");
                        name = s.nextLine();
                        String password = s.nextLine();
                        System.out.println(ui.signup(name, password));

                } else if(eingabe.equals("l")){
                        System.out.println("Geben sie bitte ihren Nutzernamen und ihr  Passwort in dem Format \n <name> \n <password> \n ein.");
                        name = s.nextLine();
                        String password = s.nextLine();
                        if(ui.login(name, password) == "Login erfolgreich") { angemeldet = true; }
                }

                if (angemeldet = true) {
                        System.out.println("willkommen,"+ name +" " );
                        //anzeigen von produkte die der benutzer besitzt
                        //hier muss /info funktion auf verschiedene nutzer angepasst werden mit eingabe nutzername als string

                        //liste von befehle als benutzerhilfe

                        //befehl dass angemeldete User als Json datei findet

                        while(angemeldet = true){

                                if(eingabe.equals("kaufen")) {
                                        String item = "";
                                        int amount = 0;
                                        System.out.println("Welches Gegenstand?");
                                        item = s.nextLine();
                                        System.out.println("Wie viele davon?");
                                        amount = s.nextInt();
                                        System.out.println(ui.buy(item, amount));
                                }
                                if(eingabe.equals("verkaufen")) {
                                        String item = "";
                                        int amount = 0;
                                        System.out.println("Welches Gegenstand?");
                                        item = s.nextLine();
                                        System.out.println("Wie viele davon?");
                                        amount = s.nextInt();
                                        System.out.println(ui.sell(item, amount));
                                }
                                if(eingabe.equals("aktualisieren")) {
                                        System.out.println("Die Preise haben sich verändert ;)");
                                        System.out.println(ui.refresh());
                                }
                                if (eingabe.equals("infos")) {
                                        System.out.println("Sie haben folgendes im Inventar: ");
                                        System.out.println(ui.UserInfo());

                                }

                }
                }
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


