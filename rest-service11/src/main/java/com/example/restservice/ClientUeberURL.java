package com.example.restservice;
import org.json.simple.parser.ParseException;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;


public class ClientUeberURL {

    public static void main(String[] args) throws IOException, ParseException, URISyntaxException {


        String name;
        String password;
        Scanner s = new Scanner(System.in);
        boolean angemeldet = false;
        boolean registered = false;
        String ausgabe = "";
        RestTemplate rt = new RestTemplate();


        String eingabe = "";

        while (angemeldet == false || registered == false) {
            System.out.println("Moechten Sie sich registrieren oder einloggen? \n" +
                    "Waehlen Sie 'r' um sich zu registrieren oder 'l' um sich einzuloggen.");

            eingabe = s.nextLine();

            //Registrieren:
            if (eingabe.equals("r")) {
                System.out.println("Geben sie bitte ihren gewuenschten Nutzernamen und ihr gewuenschtes Passwort in dem Format \nname \npassword\nein.");
                name = s.nextLine();
                password = s.nextLine();
                ausgabe = rt.getForObject("http://localhost:8080/signup?name="+name+"&password="+password+"", String.class);

                if (ausgabe.equals("Erfolgreich registiert.")) {
                    System.out.println(ausgabe + "\n");
                    registered = true;

                } else if (ausgabe == "User existiert bereits.") {
                    System.out.println(ausgabe + "\n");
                    registered = true;

                } else if (ausgabe.equals("Die maximale Anzahl an registrierten Nutzern ist bereits erreicht.")) {
                    System.out.println(ausgabe + "\n");
                    System.out.println("Melden Sie sich bitte mit einem Konto an, wenn Sie eins besitzen, wenn nicht, tut es uns leid.");
                }

            //Einloggen:
            } else if (eingabe.equals("l")) {
                System.out.println("Geben sie bitte ihren Nutzernamen und ihr Passwort in dem Format \nname\npassword\nein.");
                name = s.nextLine();
                password = s.nextLine();
                ausgabe = rt.getForObject("http://localhost:8080/login?name="+name+"&password="+password+"", String.class);

                if (ausgabe.equals("Login erfolgreich.")) {
                    System.out.println(ausgabe + "\n");
                    angemeldet = true;
                    registered = true;

                } else if (ausgabe.equals("Es ist noch kein Nutzer registriert.")) {
                    System.out.println(ausgabe + "\n");
                    System.out.println("Wir bitten Sie sich zu registrieren.");

                } else if (ausgabe.equals("Passwort ist falsch.")) {
                    System.out.println(ausgabe + "\n");

                } else if (ausgabe.equals("Dieser Nutzer existiert nicht.")) {
                    System.out.println(ausgabe + "\n");
                }
            }
        }

        System.out.println("Geben sie 'help' ein, um alle akzeptierten Befehle anzuzeigen.\n");

        while (angemeldet == true) {

            eingabe = s.nextLine();


            //Verfügbare Befehle ausgeben
            if (eingabe.equals("help")) {
                System.out.println("");
                System.out.println("Moechten Sie etwas kaufen, etwas verkaufen, sich Informationen ueber ihr Konto ausgeben lassen, die Preise aktualisieren, Geld abzuheben, Geld einzahlen oder sich ausloggen?");
                System.out.println("Geben Sie 'buy' ein, um Gueter zu erwerben.");
                System.out.println("Geben Sie 'sell' ein, um Gueter zu verkaufen.");
                System.out.println("Geben Sie 'info' ein, um Informationen ueber ihr Konto zu erhalten.");
                System.out.println("Geben Sie 'refresh' ein, um die Preise zu aktualisieren.");
                System.out.println("Geben Sie 'withdraw' ein, um Geld abzuheben.");
                System.out.println("Geben Sie 'deposit' ein, um Geld einzuzahlen.");
                System.out.println("Geben Sie 'logout' ein, um sich auszuloggen." + "\n");
                System.out.println("Geben Sie 'delete' ein, um ihr Konto zu löschen.");
            }


            //Güter kaufen:
            if (eingabe.equals("buy")) {
                System.out.println("Welches Gut moechten Sie erwerben?");
                System.out.println("Es stehen folgende Gueter zur Auswahl: \n1.Reddit_Karma\n2.Valorant_Point\n3.Toilettenpapier\n4.Rapsoel\n5.NFT\n6.LSD\n7.Grafikkarten\n8.Discord_Nitro\n9.CSGO_Case_Keys\n10.Nieren\n");
                System.out.println("Bitte geben Sie den Namen den Gutes genau so wie genannt ein.");
                String item = s.nextLine();
                System.out.println("Wie viele moechten Sie erwerben?");
                int amount = s.nextInt();
                System.out.println(rt.getForObject("http://localhost:8080/buy?item="+item+"&amount="+amount+"", String.class) + "\n");
            }


            //Güter verkaufen:
            if (eingabe.equals("sell")) {
                System.out.println("Welches Gut moechten Sie verkaufen?");
                String item = s.nextLine();
                System.out.println("Wie viele moechten Sie verkaufen?");
                int amount = s.nextInt();
                System.out.println(rt.getForObject("http://localhost:8080/sell?item="+item+"&amount="+amount+"", String.class) + "\n");
            }


            //Preise aktualisieren
            if (eingabe.equals("refresh")) {
                System.out.println("Die Preise haben sich veraendert ;) \n");
                System.out.println(rt.getForObject("http://localhost:8080/refresh", String.class));
            }


            //Kontoinformationen ausgeben
            if (eingabe.equals("info")) {
                System.out.println(rt.getForObject("http://localhost:8080/info", String.class));
            }


            //Geld abheben
            if (eingabe.equals("withdraw")) {
                System.out.println("Wie viele Primogems sollen abgehoben werden?");
                double menge = s.nextDouble();
                System.out.println(rt.getForObject("http://localhost:8080/withdraw?amount="+menge+"", String.class) + "\n");
            }


            //Geld einzahlen
            if (eingabe.equals("deposit")) {
                System.out.println("Wie viele Primogems sollen eingezahlt werden?");
                double menge = s.nextDouble();
                System.out.println(rt.getForObject("http://localhost:8080/deposit?amount="+menge+"", String.class) + "\n");
            }


            //Ausloggen
            if (eingabe.equals("logout")) {
                angemeldet = false;
            }


            //Konto löschen
            if (eingabe.equals("delete")) {
                System.out.println(rt.getForObject("http://localhost:8080/delete", String.class));
                angemeldet = false;
            }
        }

    }
}

