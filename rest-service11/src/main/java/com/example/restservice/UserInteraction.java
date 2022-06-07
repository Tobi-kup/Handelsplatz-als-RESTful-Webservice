package com.example.restservice;
import org.springframework.web.bind.annotation.*;

import  java.util.*;

@RestController
public class UserInteraction {

    public double Reddit_Karma_Preis = 1;
    public double Valorant_Points_Preis = 1;
    public double Toilettenpapier_Preis = 1;
    public double Rapsoel_Preis = 1;
    public double NFT_Preis = 1;
    public double LSD_Preis = 1;
    public double Grafikkarten_Preis = 1;
    public double Discord_Nitro_Preis = 1;
    public double CSGO_Case_Key_Preis = 1;
    public double Nieren_Preis = 1;

    User[] users = new User[3];
    int aktuellerNutzer = 0;
    //boolean angemeldet = false;


    public UserInteraction(){}


    //bsp: http://localhost:8080/registeredUsers
    /**
     * Listet alle registrierten Nutzer auf
     * @return einen String, der alle  registrierten Nutzer auflistet
     */
    @GetMapping("/registeredUsers")
    public String alle() {
        String ausgabe = "Folgend eine Auflistung aller registrierter Nutzer: ";
        for (int i = 0; i < users.length; i++) {
            if(users[i] != null) {
                ausgabe += "\n" + users[i].getName();
            }
        }
    return ausgabe;
}

    //bsp: http://localhost:8080/signup?name=Max&password=MPasswort
    /**
     * Fordert den Nutzer auf seine gewünschten Zugangsdaten zu wählen und somit einen Account zu erstellen,
     * wenn dieser Nutzer nicht bereits existiert, und noch genügend Platz für einen weiteren ist, wird der neue Nutzer in das Array  mitaufgenommen.
     * @param name - Name des Nutzerprofils vom Typ String
     * @param password - Passwort des Nutzerprofils vom Typ String
     * @return einen String, der ausgibt, welcher Fehler aufgetreten ist, oder ob es funktioniert hat
     */
    @GetMapping("/signup")
    public String signup(@RequestParam(value = "name") String name, @RequestParam(value = "password") String password){
        String ausgabe = "";
        User neu = new User(name, password);

        if(users[0] == null) {                        //bisher existiert kein User
            users[0] = neu;
            ausgabe = "Erfolgreich registiert.";
            return ausgabe;
        }

        int anzahlExistenterNutzer = 0;
        for(int i=0; i<users.length; i++) {
            if(users[i] != null){ anzahlExistenterNutzer++; }
        }

           for(int i=0; i<anzahlExistenterNutzer; i++) {  //Array wird durchlaufen
               if (users[i].getName().equals(name)) {    //wenn dem Namen bereits einem Konto innerhalb des Arrays zugeorndet ist
                   ausgabe = "User existiert bereits.";  //wird dies so ausgegeben
                   return ausgabe;
               }
           }

           int j = 0;
           while (j < users.length && users[j] != null) { j++; }  //Array wird durchlaufen

                   if(j < users.length) {                        //wenn die Zählvariable kleiner aus die Länge des Array ist
                       users[j] = neu;                           //wird der neue Nutzer in das Array mitaufgenommen
                       ausgabe = "Erfolgreich registiert.";
                    } else ausgabe = "Die maximale Anzahl an registrierten Nutzern ist bereits erreicht.";
        return ausgabe;
    }


    //bsp: http://localhost:8080/login?name=Max&password=MPasswort
    /**
     * Fragt den Nutzer nach seinen Nutzerdaten, um ihm den Zugang zu gewähren
     * @param name - Name des Nutzerprofils vom Typ String
     * @param password - Passwort des Nutzerprofils vom Typ String
     * @return einen String, der ausgibt, welcher Fehler aufgetreten ist, oder ob es funktioniert hat
     */
    @GetMapping("/login")
    public String login(@RequestParam(value = "name") String name, @RequestParam(value = "password") String password){
        String ausgabe = "";

        if(users[0] == null){ return "Es ist noch kein Nutzer registriert."; }

            int anzahlExistenterNutzer = 0;
            for(int i=0; i<users.length; i++) {
                if(users[i] != null){ anzahlExistenterNutzer++; }
        }


        for(int i=0; i<anzahlExistenterNutzer; i++) {
            if (users[i].getName().equals(name) && users[i].getPassword().equals(password)) {
                aktuellerNutzer = i;
                //angemeldet = true;
                ausgabe = "Login erfolgreich.";
                return ausgabe;

            } else if (users[i].getName().equals(name)) {
                ausgabe = "Passwort ist falsch.";
                return ausgabe;
            }
        }

             ausgabe = "Dieser Nutzer existiert nicht.";

        return ausgabe;
    }


    //bsp: http://localhost:8080/info
    /**
     * Gibt den Kontostand des Nutzers und jeweils die Menge der Güter, die er besitzt, aus, wenn ein Nutzer angemeldet ist
     * @return einen String, der den Kontostand die und die Güter des Nutzes ausgibt, oder, dass kein Nutzer angemeldet ist.
     */
    @GetMapping("/info")
    public String UserInfo() {
        String ausgabe = "";
        //if (angemeldet == true) {

            ausgabe = "Primogems: " + users[aktuellerNutzer].getCoins() +
                      "\nGueter:\n" +
                      "Reddit_Karma: " + users[aktuellerNutzer].getReddit_Karma() +
                      "\nVP_Points: " + users[aktuellerNutzer].getValorant_Points() +
                      "\nToilettenpapier: " + users[aktuellerNutzer].getToilettenpapier() +
                      "\nRapsoel: " + users[aktuellerNutzer].getRapsoel() +
                      "\nNFTs: " + users[aktuellerNutzer].getNFTs() +
                      "\nLSD: " + users[aktuellerNutzer].getLSD() +
                      "\nGrafikkarten: " + users[aktuellerNutzer].getGrafikkarten() +
                      "\nDiscord_Nitro: " + users[aktuellerNutzer].getDiscord_Nitro() +
                      "\nNieren: " + users[aktuellerNutzer].getNieren() +
                      "\nCSGO_Case_Keys: " + users[aktuellerNutzer].getCSGO_Case_Keys() + "\n";

       // } else ausgabe = "Sie sind nicht angemeldet.";

        return ausgabe;
    }


    //bsp: http://localhost:8080/buy?item=Reddit_Karma&amount=1
    /**
     * Kauft angegebenes Gut für den aktuellen Preis auf Nutzeranfrage
     * Erhöht dafür entsprechend die Menge des Gutes innerhalb des Nutzerkontos und vermindert dessen Kontostand.
     * @param item - Gut, das gekauft werden soll
     * @param amount - Menge, die gekauft werden soll
     * @return einen String, der ausgibt, welcher Fehler aufgetreten ist, oder ob es funktioniert hat
     */
    @GetMapping("/buy")
    public String buy(@RequestParam(value = "item") String item, @RequestParam(value = "amount") int amount) {
        String ausgabe = "";

        //if (angemeldet == true) {

            switch(item) {
                case "Reddit_Karma":
                    if(users[aktuellerNutzer].getCoins() - (amount * Reddit_Karma_Preis)>=0) {
                        users[aktuellerNutzer].kaufeReddit_Karma(amount);
                        users[aktuellerNutzer].vermindereCoins(Reddit_Karma_Preis * amount);
                        ausgabe = "Kauf erfolgreich abgeschlossen";
                    }else
                        ausgabe = "Sie haben nicht genug Primogems.";
                    break;

                case "Valorant_Points":
                    if(users[aktuellerNutzer].getCoins() - (amount * Valorant_Points_Preis)>=0) {
                        users[aktuellerNutzer].kaufeValorant_Points(amount);
                        users[aktuellerNutzer].vermindereCoins(Valorant_Points_Preis * amount);
                        ausgabe = "Kauf erfolgreich abgeschlossen";
                    }else
                        ausgabe = "Sie haben nicht genug Primogems.";
                    break;

                case "Toilettenpapier":
                    if(users[aktuellerNutzer].getCoins() - (amount * Toilettenpapier_Preis)>=0) {
                        users[aktuellerNutzer].kaufeToilettenpapier(amount);
                        users[aktuellerNutzer].vermindereCoins(Toilettenpapier_Preis * amount);
                        ausgabe = "Kauf erfolgreich abgeschlossen";
                    }else
                        ausgabe = "Sie haben nicht genug Primogems.";
                    break;

                case "Rapsoel":
                    if(users[aktuellerNutzer].getCoins() - (amount * Rapsoel_Preis)>=0) {
                        users[aktuellerNutzer].kaufeRapsoel(amount);
                        users[aktuellerNutzer].vermindereCoins(Rapsoel_Preis * amount);
                        ausgabe = "Kauf erfolgreich abgeschlossen";
                    }else
                        ausgabe = "Sie haben nicht genug Primogems.";
                    break;

                case "NFT":
                    if(users[aktuellerNutzer].getCoins() - (amount * NFT_Preis)>=0) {
                        users[aktuellerNutzer].kaufeNFTs(amount);
                        users[aktuellerNutzer].vermindereCoins(NFT_Preis * amount);
                        ausgabe = "Kauf erfolgreich abgeschlossen";
                    }else
                        ausgabe = "Sie haben nicht genug Primogems.";
                    break;

                case "LSD":
                    if(users[aktuellerNutzer].getCoins() - (amount * LSD_Preis)>=0) {
                        users[aktuellerNutzer].kaufeLSD(amount);
                        users[aktuellerNutzer].vermindereCoins(LSD_Preis * amount);
                        ausgabe = "Kauf erfolgreich abgeschlossen";
                    }else
                        ausgabe = "Sie haben nicht genug Primogems.";
                    break;

                case "Grafikkarten":
                    if(users[aktuellerNutzer].getCoins() - (amount * Grafikkarten_Preis)>=0) {
                        users[aktuellerNutzer].kaufeGrafikkarten(amount);
                        users[aktuellerNutzer].vermindereCoins(Grafikkarten_Preis * amount);
                        ausgabe = "Kauf erfolgreich abgeschlossen";
                    }else
                        ausgabe = "Sie haben nicht genug Primogems.";
                    break;

                case "Discord_Nitro":
                    if(users[aktuellerNutzer].getCoins() - (amount * Discord_Nitro_Preis)>=0) {
                        users[aktuellerNutzer].kaufeDiscord_Nitro(amount);
                        users[aktuellerNutzer].vermindereCoins(Discord_Nitro_Preis * amount);
                        ausgabe = "Kauf erfolgreich abgeschlossen";
                    }else
                        ausgabe = "Sie haben nicht genug Primogems.";
                    break;

                case "CSGO_Case_Key":
                    if(users[aktuellerNutzer].getCoins() - (amount * CSGO_Case_Key_Preis)>=0) {
                        users[aktuellerNutzer].kaufeCSGO_Case_Keys(amount);
                        users[aktuellerNutzer].vermindereCoins(CSGO_Case_Key_Preis * amount);
                        ausgabe = "Kauf erfolgreich abgeschlossen";
                    }else
                        ausgabe = "Sie haben nicht genug Primogems.";
                    break;

                case "Nieren":
                    if(users[aktuellerNutzer].getCoins() - (amount * Nieren_Preis)>=0) {
                        users[aktuellerNutzer].kaufeNieren(amount);
                        users[aktuellerNutzer].vermindereCoins(Nieren_Preis * amount);
                        ausgabe = "Kauf erfolgreich abgeschlossen";
                    }else
                        ausgabe = "Sie haben nicht genug Primogems.";
                    break;

                default:
                    ausgabe = "Ungueltige Eingabe, dieses Gut wird nicht angeboten.";
            }

      //  } else ausgabe = "Sie sind nicht angemeldet";

        return ausgabe;
    }


    //bsp: http://localhost:8080/sell?item=Valorant_Points&amount=1
    /**
     * Verkauft angegebenes Gut für den aktuellen Preis auf Nutzeranfrage
     * Vermindert dafür entsprechend die Menge des Gutes innerhalb des Nutzerkontos und erhöht dessen Kontostand.
     * @param item - Gut, das verkauft werden soll
     * @param amount - Menge, die verkauft werden soll
     * @return einen String, der ausgibt, welcher Fehler aufgetreten ist, oder ob es funktioniert hat
     */
    @GetMapping("/sell")
    public String sell(@RequestParam(value = "item") String item, @RequestParam(value = "amount") int amount) {
        String ausgabe = "";

    //    if (angemeldet == true) {

            switch(item) {
                case "Reddit_Karma":
                    if(users[aktuellerNutzer].getReddit_Karma() >= amount) {
                        users[aktuellerNutzer].verkaufeReddit_Karma(amount);
                        users[aktuellerNutzer].erhoeheCoins(Reddit_Karma_Preis * amount);
                        ausgabe = "Verkauf erfolgreich abgeschlossen.";
                    }else
                        ausgabe = "Sie besitzen nicht so viel Reddit_Karma";
                    break;

                case "Valorant_Points":
                    if(users[aktuellerNutzer].getValorant_Points() >= amount) {
                        users[aktuellerNutzer].verkaufeValorant_Points(amount);
                        users[aktuellerNutzer].erhoeheCoins(Valorant_Points_Preis * amount);
                        ausgabe = "Verkauf erfolgreich abgeschlossen.";
                    }else
                        ausgabe = "Sie besitzen nicht so viele Valorant_Points";
                    break;

                case "Toilettenpapier":
                    if(users[aktuellerNutzer].getToilettenpapier() >= amount) {
                        users[aktuellerNutzer].verkaufeToilettenpapier(amount);
                        users[aktuellerNutzer].erhoeheCoins(Toilettenpapier_Preis * amount);
                        ausgabe = "Verkauf erfolgreich abgeschlossen.";
                    }else
                        ausgabe = "Sie besitzen nicht so viel Toilettenpapier";
                    break;


                case "Rapsoel":
                    if(users[aktuellerNutzer].getRapsoel() >= amount) {
                        users[aktuellerNutzer].verkaufeRapsoel(amount);
                        users[aktuellerNutzer].erhoeheCoins(Rapsoel_Preis * amount);
                        ausgabe = "Verkauf erfolgreich abgeschlossen.";
                    }else
                        ausgabe = "Sie besitzen nicht so viel Rapsoel";
                    break;

                case "NFT":
                    if(users[aktuellerNutzer].getNFTs() >= amount) {
                        users[aktuellerNutzer].verkaufeNFTs(amount);
                        users[aktuellerNutzer].erhoeheCoins(NFT_Preis * amount);
                        ausgabe = "Verkauf erfolgreich abgeschlossen.";
                    }else
                        ausgabe = "Sie besitzen nicht so viele NFTs";
                    break;

                case "LSD":
                    if(users[aktuellerNutzer].getLSD() >= amount) {
                        users[aktuellerNutzer].verkaufeLSD(amount);
                        users[aktuellerNutzer].erhoeheCoins(LSD_Preis * amount);
                        ausgabe = "Verkauf erfolgreich abgeschlossen.";
                    }else
                        ausgabe = "Sie besitzen nicht so viel LSD";
                    break;

                case "Grafikkarten":
                    if(users[aktuellerNutzer].getGrafikkarten() >= amount) {
                        users[aktuellerNutzer].verkaufeGrafikkarten(amount);
                        users[aktuellerNutzer].erhoeheCoins(Grafikkarten_Preis * amount);
                        ausgabe = "Verkauf erfolgreich abgeschlossen.";
                    }else
                        ausgabe = "Sie besitzen nicht so viele Grafikkarten";
                    break;

                case "Discord_Nitro":
                    if(users[aktuellerNutzer].getDiscord_Nitro() >= amount) {
                        users[aktuellerNutzer].verkaufeDiscord_Nitro(amount);
                        users[aktuellerNutzer].erhoeheCoins(Discord_Nitro_Preis * amount);
                        ausgabe = "Verkauf erfolgreich abgeschlossen.";
                    }else
                        ausgabe = "Sie besitzen nicht so viel Discord_Nitro";
                    break;

                case "CSGO_Case_Key":
                    if(users[aktuellerNutzer].getCSGO_Case_Keys() >= amount) {
                        users[aktuellerNutzer].verkaufeCSGO_Case_Keys(amount);
                        users[aktuellerNutzer].erhoeheCoins(CSGO_Case_Key_Preis * amount);
                        ausgabe = "Verkauf erfolgreich abgeschlossen.";
                    }else
                        ausgabe = "Sie besitzen nicht so viele CSGO_Case_Keys";
                    break;

                case "Nieren":
                    if(users[aktuellerNutzer].getNieren() >= amount) {
                        users[aktuellerNutzer].verkaufeNieren(amount);
                        users[aktuellerNutzer].erhoeheCoins(Nieren_Preis * amount);
                        ausgabe = "Verkauf erfolgreich abgeschlossen.";
                    }else
                        ausgabe = "Sie besitzen nicht so viele Nieren";
                    break;

                default:
                    ausgabe = "Ungueltige Eingabe, dieses Gut wird nicht angeboten.";
            }

       // } else ausgabe = "Sie sind nicht angemeldet";

        return ausgabe;
    }


        //bsp: http://localhost:8080/refresh
    /**
     * Aktualisiert die Preise der angebotenen Güter auf Nutzeranfrage
     * @return erstmal nur einen angepassten String, der ausgibt, ob der Nutzer die nötigen Rechte besitz
     */
    @GetMapping("/refresh")
    public String refresh() {
        String ausgabe = "";
       // if (angemeldet == true) {

            Randomwalk r = new Randomwalk();

            Reddit_Karma_Preis = r.rWalk(Reddit_Karma_Preis);
            Valorant_Points_Preis = r.rWalk(Valorant_Points_Preis);
            Toilettenpapier_Preis = r.rWalk(Toilettenpapier_Preis);
            Rapsoel_Preis = r.rWalk(Rapsoel_Preis);
            NFT_Preis = r.rWalk(NFT_Preis);
            LSD_Preis = r.rWalk(LSD_Preis);
            Grafikkarten_Preis = r.rWalk(Grafikkarten_Preis);
            Discord_Nitro_Preis = r.rWalk(Discord_Nitro_Preis);
            CSGO_Case_Key_Preis = r.rWalk(CSGO_Case_Key_Preis);
            Nieren_Preis = r.rWalk(Nieren_Preis);

            ausgabe = "Reddit_Karma_Preis: " + Reddit_Karma_Preis + "\n" +
                    "Valorant_Points_Preis: " + Valorant_Points_Preis + "\n" +
                    "Toilettenpapier_Preis: " + Toilettenpapier_Preis + "\n" +
                    "Rapsoel_Preis: " + Rapsoel_Preis + "\n" +
                    "NFT_Preis: " + NFT_Preis + "\n" +
                    "LSD_Preis: " + LSD_Preis + "\n" +
                    "Grafikkarten_Preis: " + Grafikkarten_Preis + "\n" +
                    "Discord_Nitro_Preis: " + Discord_Nitro_Preis + "\n" +
                    "CSGO_Case_Key_Preis: " + CSGO_Case_Key_Preis + "\n" +
                    "Nieren_Preis: " + Nieren_Preis + "\n";

       // } else ausgabe = "Sie sind nicht angemeldet";
        return ausgabe;
    }


    //bsp: http://localhost:8080/withdraw
    /**
     * Zieht die eingebene Menge an Primogems vom Benutzkonto ab
     * @param amount - Menge der Primogems, die abgehoben werden soll
     * @return einen String, der angibt, ob der Abzug erfolgreich war
     */
    @GetMapping("/withdraw")
    public String withdraw(@RequestParam(value = "amount") double amount) {
        String ausgabe = "";
        if(users[aktuellerNutzer].getCoins() >= amount) {
            users[aktuellerNutzer].abheben(amount);
            ausgabe = "Sie haben erfolgreich " + amount + " Primogems abgehoben.";

        } else ausgabe = "So viele Primogems haben Sie nicht auf dem Konto";

        return ausgabe;
    }


    //bsp: http://localhost:8080/withdraw
    /**
     * Zahlt die eingebene Menge an Primogems in das Benutzkonto ein
     * @param amount - Menge der Primogems, die eingezahlt werden soll
     * @return einen String, der angibt, ob die Einzahlung erfolgreich war
     */
    @GetMapping("/deposit")
    public String deposit(@RequestParam(value = "amount") double amount) {
            users[aktuellerNutzer].einzahlen(amount);
            String ausgabe = "Sie haben erfolgreich " +amount+ " Primogems in ihr Konto eingezahlt.";

        return ausgabe;
    }


//    public void Ankaufen() {
//        System.out.println("Welches Gut wollen Sie kaufen?\nReddit Karma: 1\nVP Point: 2\nToilettenpapier: 3\nRapsöl: 4\nNFT: 5\nLSD: 6\nGrafikkarten: 7\nDiscord Nitro: 8\nNieren: 9\nCSGO Case Key: 10");
//        Scanner sc = new Scanner(System.in);
//        int auswahl = sc.nextInt();
//        sc.close();
//        System.out.println("Wie viel wollen Sie kaufen?");
//        Scanner s = new Scanner(System.in);
//        int menge = s.nextInt();
//        s.close();
//        switch(auswahl) {
//            case 1:
//                if(Primogem_Anzahl - (menge * Reddit_Karma_Preis)>=0) {
//                    Reddit_Karma_Menge = Reddit_Karma_Menge + menge;
//                    Primogem_Anzahl = Primogem_Anzahl - (menge * Reddit_Karma_Preis);
//                }else
//                    System.out.println("Sie haben nicht genug Primogems, versuchen Sie er erneut");
//                    Ankaufen();
//            case 2:
//                if(Primogem_Anzahl - (menge * VP_Point_Preis)>=0) {
//                    VP_Point_Menge = VP_Point_Menge + menge;
//                    Primogem_Anzahl = Primogem_Anzahl - (menge * VP_Point_Preis);
//                }else
//                    System.out.println("Sie haben nicht genug Primogems, versuchen Sie er erneut");
//                Ankaufen();
//            case 3:
//                if(Primogem_Anzahl - (menge * Toilettenpapier_Preis)>=0) {
//                    Toilettenpapier_Menge = Toilettenpapier_Menge + menge;
//                    Primogem_Anzahl = Primogem_Anzahl - (menge * Toilettenpapier_Preis);
//                }else
//                    System.out.println("Sie haben nicht genug Primogems, versuchen Sie er erneut");
//                Ankaufen();
//            case 4:
//                if(Primogem_Anzahl - (menge * Rapsoel_Preis)>=0) {
//                    Rapsoel_Menge = Rapsoel_Menge + menge;
//                Primogem_Anzahl = Primogem_Anzahl - (menge * Rapsoel_Preis);
//                }else
//                    System.out.println("Sie haben nicht genug Primogems, versuchen Sie er erneut");
//                    Ankaufen();
//            case 5:
//                if(Primogem_Anzahl - (menge * NFT_Preis)>=0) {
//                    NFT_Menge = NFT_Menge + menge;
//                Primogem_Anzahl = Primogem_Anzahl - (menge * NFT_Preis);
//                }else
//                    System.out.println("Sie haben nicht genug Primogems, versuchen Sie er erneut");
//                    Ankaufen();
//            case 6:
//                if(Primogem_Anzahl - (menge * LSD_Preis)>=0) {
//                    LSD_Menge =LSD_Menge + menge;
//                Primogem_Anzahl = Primogem_Anzahl - (menge * LSD_Preis);
//                }else
//                    System.out.println("Sie haben nicht genug Primogems, versuchen Sie er erneut");
//                Ankaufen();
//            case 7:
//                if(Primogem_Anzahl - (menge * Grafikkarten_Preis)>=0) {
//                    Grafikkarten_Menge = Grafikkarten_Menge + menge;
//                Primogem_Anzahl = Primogem_Anzahl - (menge * Grafikkarten_Preis);
//                }else
//                    System.out.println("Sie haben nicht genug Primogems, versuchen Sie er erneut");
//                Ankaufen();
//            case 8:
//                if(Primogem_Anzahl - (menge * Discord_Nitro_Preis)>=0) {
//                    Discord_Nitro_Menge = Discord_Nitro_Menge + menge;
//                Primogem_Anzahl = Primogem_Anzahl - (menge * Discord_Nitro_Preis);
//                }else
//                    System.out.println("Sie haben nicht genug Primogems, versuchen Sie er erneut");
//                Ankaufen();
//            case 9:
//                if(Primogem_Anzahl - (menge * Nieren_Preis)>=0) {
//                    Nieren_Menge = Nieren_Menge + menge;
//                Primogem_Anzahl = Primogem_Anzahl - (menge * Nieren_Preis);
//                }else
//                    System.out.println("Sie haben nicht genug Primogems, versuchen Sie er erneut");
//                Ankaufen();
//            case 10:
//                if(Primogem_Anzahl - (menge * CSGO_Case_Key_Preis)>=0) {
//                    CSGO_Case_Key_Menge = CSGO_Case_Key_Menge + menge;
//                Primogem_Anzahl = Primogem_Anzahl - (menge * CSGO_Case_Key_Preis);
//                }else
//                    System.out.println("Sie haben nicht genug Primogems, versuchen Sie er erneut");
//                Ankaufen();
//            default:
//                System.out.println("ungültige Eingabe, versuchen Sie es erneut");
//                Ankaufen();
//        }
//    }


//    public void Verkaufen() {
//        System.out.println("Welches Gut wollen Sie verkaufen?\nReddit Karma: 1\nVP Point: 2\nToilettenpapier: 3\nRapsöl: 4\nNFT: 5\nLSD: 6\nGrafikkarten: 7\nDiscord Nitro: 8\nNieren: 9\nCSGO Case Key: 10");
//        Scanner sc = new Scanner(System.in);
//        int auswahl = sc.nextInt();
//        sc.close();
//        System.out.println("Wie viel wollen Sie verkaufen?");
//        Scanner s = new Scanner(System.in);
//        int menge = s.nextInt();
//        s.close();
//        switch(auswahl) {
//            case 1:
//                if(menge > Reddit_Karma_Menge) {
//                    System.out.println("So viel besitzen Sie nicht, versuchen Sie es erneut");
//                    Verkaufen();
//                }
//                else
//                    Reddit_Karma_Menge = Reddit_Karma_Menge - menge;
//                    Primogem_Anzahl = Primogem_Anzahl + (menge * Reddit_Karma_Preis);
//            case 2:
//                if(menge > VP_Point_Menge) {
//                    System.out.println("So viel besitzen Sie nicht, versuchen Sie es erneut");
//                    Verkaufen();
//                }
//                else
//                    VP_Point_Menge = VP_Point_Menge - menge;
//                Primogem_Anzahl = Primogem_Anzahl + (menge * VP_Point_Preis);
//            case 3:
//                if(menge > Toilettenpapier_Menge) {
//                    System.out.println("So viel besitzen Sie nicht, versuchen Sie es erneut");
//                    Verkaufen();
//                }
//                else
//                    Toilettenpapier_Menge = Toilettenpapier_Menge - menge;
//                Primogem_Anzahl = Primogem_Anzahl + (menge * Toilettenpapier_Preis);
//            case 4:
//                if(menge > Rapsoel_Menge) {
//                    System.out.println("So viel besitzen Sie nicht, versuchen Sie es erneut");
//                    Verkaufen();
//                }
//                else
//                    Rapsoel_Menge = Rapsoel_Menge - menge;
//                Primogem_Anzahl = Primogem_Anzahl + (menge * Rapsoel_Preis);
//            case 5:
//                if(menge > NFT_Menge) {
//                    System.out.println("So viel besitzen Sie nicht, versuchen Sie es erneut");
//                    Verkaufen();
//                }
//                else
//                    NFT_Menge = NFT_Menge - menge;
//                Primogem_Anzahl = Primogem_Anzahl + (menge * NFT_Preis);
//            case 6:
//                if(menge > LSD_Menge) {
//                    System.out.println("So viel besitzen Sie nicht, versuchen Sie es erneut");
//                    Verkaufen();
//                }
//                else
//                    LSD_Menge =LSD_Menge - menge;
//                Primogem_Anzahl = Primogem_Anzahl + (menge * LSD_Preis);
//            case 7:
//                if(menge > Grafikkarten_Menge) {
//                    System.out.println("So viel besitzen Sie nicht, versuchen Sie es erneut");
//                    Verkaufen();
//                }
//                else
//                    Grafikkarten_Menge = Grafikkarten_Menge - menge;
//                Primogem_Anzahl = Primogem_Anzahl + (menge * Grafikkarten_Preis);
//            case 8:
//                if(menge > Discord_Nitro_Menge) {
//                    System.out.println("So viel besitzen Sie nicht, versuchen Sie es erneut");
//                    Verkaufen();
//                }
//                else
//                    Discord_Nitro_Menge = Discord_Nitro_Menge - menge;
//                Primogem_Anzahl = Primogem_Anzahl + (menge * Discord_Nitro_Preis);
//            case 9:
//                if(menge > Nieren_Menge) {
//                    System.out.println("So viel besitzen Sie nicht, versuchen Sie es erneut");
//                    Verkaufen();
//                }
//                else
//                    Nieren_Menge = Nieren_Menge - menge;
//                Primogem_Anzahl = Primogem_Anzahl + (menge * Nieren_Preis);
//            case 10:
//                if(menge > CSGO_Case_Key_Menge) {
//                    System.out.println("So viel besitzen Sie nicht, versuchen Sie es erneut");
//                    Verkaufen();
//                }
//                else
//                    CSGO_Case_Key_Menge = CSGO_Case_Key_Menge - menge;
//                Primogem_Anzahl = Primogem_Anzahl + (menge * CSGO_Case_Key_Preis);
//            default:
//                System.out.println("ungültige Eingabe, versuchen Sie es erneut");
//                Verkaufen();
//        }
//    }
}