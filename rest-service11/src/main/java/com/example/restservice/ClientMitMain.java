package com.example.restservice;
import java.io.IOException;
import java.net.Socket;
import java.util.*;

public class ClientMitMain {

    public static void main(String[] args) {

        String name;
        String password;
        Scanner s = new Scanner(System.in);
        UserInteraction ui = new UserInteraction();
        boolean angemeldet = false;
        boolean registered = false;
        String ausgabe = "";


        String eingabe = "";

        while(angemeldet == false || registered == false) {
            System.out.println("Möchten Sie sich registrieren oder einloggen? \n" +
                    "Wählen Sie 'r' um sich zu registrieren oder 'l' um sich einzuloggen.");

            eingabe = s.nextLine();

            //Registrieren:
            if (eingabe.equals("r")) {
                System.out.println("Geben sie bitte ihren gewünschten Nutzernamen und ihr gewünschtes Passwort in dem Format \n <name> \n <password> \n ein.");
                name = s.nextLine();
                password = s.nextLine();
                ausgabe = ui.signup(name, password);
                if (ausgabe == "Erfolgreich registiert.") {
                    System.out.println(ausgabe);
                    registered = true;

                } else if (ausgabe == "User existiert bereits.") {
                    System.out.println(ausgabe);
                    registered = true;

                } else if (ausgabe == "Die maximale Anzahl an registrierten Nutzern ist bereits erreicht.") {
                    System.out.println(ausgabe);
                    System.out.println("Melden Sie sich bitte mit einem Konto an, wenn Sie eins besitzen, wenn nicht, tut es uns leid.");
                }

                //Einloggen:
            } else if (eingabe.equals("l")) {
                System.out.println("Geben sie bitte ihren Nutzernamen und ihr Passwort in dem Format \n <name> \n <password> \n ein.");
                name = s.nextLine();
                password = s.nextLine();
                ausgabe = ui.login(name, password);
                if (ausgabe == "Login erfolgreich.") {
                    System.out.println(ausgabe);
                    angemeldet = true;
                    registered = true;

                } else if (ausgabe == "Es ist noch kein Nutzer registriert.") {
                    System.out.println(ausgabe);
                    System.out.println("Wir bitten Sie sich zu registrieren.");

                } else if (ausgabe == "Passwort ist falsch.") {
                    System.out.println(ausgabe);

                } else if (ausgabe == "Dieser Nutzer existiert nicht.") {
                    System.out.println(ausgabe);
                }
            }
        }



//        //Einloggen nach Registrierung
//        if (angemeldet == false) {
//            System.out.println("Melden Sie sich nun auf die Eingabe 'l' folgend mit ihrem Konto an, um auf den Markt zu gelagen.");
//            if(eingabe.equals("l")){
//                System.out.println("Geben sie bitte ihren Nutzernamen und ihr  Passwort in dem Format \n <name> \n <password> \n ein.");
//                name = s.nextLine();
//                password = s.nextLine();
//                if(ui.login(name, password) == "Login erfolgreich") { angemeldet = true; }
//            }
//        }


//        if (angemeldet == true) { System.out.println("Willkommen,"+ name +" " ); }
//
//            while(angemeldet == true){
//                if(eingabe.equals("kaufen")) {
//                    String item = "";
//                    int amount = 0;
//                    System.out.println("Welches Gegenstand?");
//                    item = s.nextLine();
//                    System.out.println("Wie viele davon?");
//                    amount = s.nextInt();
//                    System.out.println(ui.buy(item, amount));
//                }
//                if(eingabe.equals("verkaufen")) {
//                    String item = "";
//                    int amount = 0;
//                    System.out.println("Welches Gegenstand?");
//                    item = s.nextLine();
//                    System.out.println("Wie viele davon?");
//                    amount = s.nextInt();
//                    System.out.println(ui.sell(item, amount));
//                }
//
//            }
        }

    }
