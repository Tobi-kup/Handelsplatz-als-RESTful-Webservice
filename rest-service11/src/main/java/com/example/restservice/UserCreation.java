package com.example.restservice;

import java.util.*;

public class UserCreation {
        public String UserName;
        public String UserPasswort;

        UserCreation()
        {
                System.out.println("Nutzername eingeben:");
                Scanner UName = new Scanner(System.in);
                this.UserName = UName.nextLine();
                System.out.println("Passwort eingeben:");
                Scanner UPasswort = new Scanner(System.in);
                this.UserPasswort = UPasswort.nextLine();
                System.out.println("Neuen Nutzer erstellt: \nNutzername: " + UserName + "\nPasswort: " + UserPasswort);
        }
}


