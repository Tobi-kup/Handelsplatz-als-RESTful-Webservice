    package com.example.restservice;
import java.util.*;
/*
    Command-Line Login mit festgelegten Nutzernamen und Passwörtern.
 */
public class UserLogin {

    public static void main(String[] args) {
        Scanner UserName = new Scanner(System.in);
        System.out.println("Nutzername: ");
        String Name = UserName.nextLine();

        if ("Tobias".equals(Name)) {
            Scanner Passwort = new Scanner(System.in);
            System.out.println("Passwort: ");
            String Passwort1 = Passwort.nextLine();
            if (Passwort1.equals("TPasswort"))
                System.out.println("Willkommen Tobias!");
            else
                System.out.println("Passwort falsch");
            Passwort.close();


        } else if ("Fengyi".equals(Name)) {
            Scanner Passwort = new Scanner(System.in);
            System.out.println("Passwort: ");
            String Passwort2 = Passwort.nextLine();
            if (Passwort2.equals("FPasswort"))
                System.out.println("Willkommen Fengyi!");
            else
                System.out.println("Passwort falsch");
            Passwort.close();

        } else if ("Max".equals(Name)) {
            Scanner Passwort = new Scanner(System.in);
            System.out.println("Passwort: ");
            String Passwort3 = Passwort.nextLine();

            if (Passwort3.equals("MPasswort"))
                System.out.println("Willkommen Max!");
            else
                System.out.println("Passwort falsch");
            Passwort.close();
        }
        else {
            System.out.println("Dieser Nutzer existiert nicht");
        }
    }
}
