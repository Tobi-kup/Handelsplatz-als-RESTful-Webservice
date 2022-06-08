package com.example.restservice;
import javax.print.DocFlavor;
import java.util.*;

/*
    Command-Line Login mit festgelegten Nutzernamen und Passwörtern.
 */
/**
 * UserLogin ist die Klasse zur Abfrage der Nutzerdaten.
 * Sie prüft, ob die eigegeben Daten einem Profil zugeorndet werden können, und bestimmmt, ob Zugang zum Server gewährt wird.
 */
public class UserLogin {

    /**
     * Konstruktor, um eine Instanz von UserLogin zu erzeuge.
     */

    public UserLogin(){}

    /**
     * Erhält Namen und Passwort eines Anmeldeversuchs und prüft, ob diese einem Profil zugeschrieben werden können.
     * Die Methode gibt einen angepassten String aus.
     * @param name - Name des Nutzerprofils eines Anmeldeversuchs vom Typ String
     * @param password - Passwort des Nutzerprofils eines Anmeldeversuchs vom Typ String
     * @return einen angepassten String, je nachdem ob die Anmeldung geglückt oder welcher Fehler aufgetreten ist
     */
    public String check(String name, String password){
        String ausgabe = "";

        if(name.equals("Max") && password.equals("MPasswort") ||
           name.equals("Fengyi") && password.equals("FPasswort") ||
           name.equals("Tobi") && password.equals("TPasswort")) {
            ausgabe = "Willkommen";

        } else if(name.equals("Max") || name.equals("Fengyi") ||  name.equals("Tobi")){
            ausgabe = "Das Passwort ist falsch!";

        }else{
            ausgabe = "Dieser Nutzer existiert nicht.";
        }
        return ausgabe;
    }


//    public static void main(String[] args) {
//        Scanner UserName = new Scanner(System.in);
//        System.out.println("Nutzername: ");
//        String Name = UserName.nextLine();
//
//        if ("Tobias".equals(Name)) {
//            Scanner Passwort = new Scanner(System.in);
//            System.out.println("Passwort: ");
//            String Passwort1 = Passwort.nextLine();
//            if (Passwort1.equals("TPasswort"))
//                System.out.println("Willkommen Tobias!");
//            else
//                System.out.println("Passwort falsch");
//            Passwort.close();
//
//
//        } else if ("Fengyi".equals(Name)) {
//            Scanner Passwort = new Scanner(System.in);
//            System.out.println("Passwort: ");
//            String Passwort2 = Passwort.nextLine();
//            if (Passwort2.equals("FPasswort"))
//                System.out.println("Willkommen Fengyi!");
//            else
//                System.out.println("Passwort falsch");
//            Passwort.close();
//
//        } else if ("Max".equals(Name)) {
//            Scanner Passwort = new Scanner(System.in);
//            System.out.println("Passwort: ");
//            String Passwort3 = Passwort.nextLine();
//
//            if (Passwort3.equals("MPasswort"))
//                System.out.println("Willkommen Max!");
//            else
//                System.out.println("Passwort falsch");
//            Passwort.close();
//        }
//        else {
//            System.out.println("Dieser Nutzer existiert nicht");
//        }
//    }
}
