//package com.example.restservice;
//
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.*;
//
///**
// * UserRegistrationService ist die Klasse zur Erstellung der URIs.
// * Sie erstellt die Pfade innerhalb des Marktplatzes.
// * Der Client soll diesen dann folgenden, um sich auf dem Server zurechzufinden.
// */
//
//@RestController
//public class UserRegistrationService {
//
//
//    //bsp: http://localhost:8080/signup?name=Max&password=MPasswort
//
//    /**
//     * Fordert den Nutzer auf seine gewünschten Zugangsdaten zu wählen und somit einen Account zu erstellen
//     * @param name - Name des Nutzerprofils vom Typ String
//     * @param password - Passwort des Nutzerprofils vom Typ String
//     * @return erstmal nur einen String, der ausgibt, was geschehen sollte
//     */
//    @GetMapping("/signup")
//    public String signup(@RequestParam(value = "name") String name, @RequestParam(value = "password") String password){
//        //UserInteraction ui = new UserInteraction();
//        //ui.signup(name, password) beispielsweise
//        return "Hier würde eine entsprechende Methode aus UserInteraction aufgerufen worden die alles weitere in die Wege setzt.";
//    }
//
//
//    //http://localhost:8080/login?name=<Name>&password=<Passwort>
//    //bsp: http://localhost:8080/login?name=Max&password=MPasswort
//
//    /**
//     * Fragt den Nutzer nach seinen Nutzerdaten, um ihm Daten den Zugang zu gewähren
//     * @param name - Name des Nutzerprofils vom Typ String
//     * @param password - Passwort des Nutzerprofils vom Typ String
//     * @return einen angepassten String, der in der Methode check der Klasse UserLogin erstellt wird
//     */
//    @GetMapping("/login")
//    public String login(@RequestParam(value = "name") String name, @RequestParam(value = "password") String password){
//    UserLogin neu = new UserLogin();
//    return neu.check(name, password) + " " + name + ".";
//    }
//
//
//    //bsp: http://localhost:8080/refresh?name=Max&password=MPasswort
//    /**
//     * Aktualisiert die Preise der angebotenen Güter auf Nutzeranfrage, nach dessen Anmeldung
//     * @param name - Name des Nutzerprofils vom Typ String
//     * @param password - Passwort des Nutzerprofils vom Typ String
//     * @return erstmal nur einen angepassten String, der ausgibt, ob der Nutzer die nötigen Rechte besitz
//     */
//    @GetMapping("/refresh")
//    public String refresh(@RequestParam(value = "name") String name, @RequestParam(value = "password") String password){
//        UserLogin neu = new UserLogin();
//        if(neu.check(name, password) == "Willkommen"){
//            return "Ich würde refreshen, wenn es implementiert wäre.";
//        }
//        return "Ich würde dir keine Erlaubnis dafür geben, wenn es implementiert wäre";
//    }
//
//
//    //bsp: http://localhost:8080/buy?name=Max&password=MPasswort&item=Discord_Nitro
//    /**
//     * Kauft angegebenes Gut für den aktuellen Preis auf Nutzeranfrage, nach dessen Anmeldung
//     * @param name - Name des Nutzerprofils vom Typ String
//     * @param password - Passwort des Nutzerprofils vom Typ String
//     * @param item- Gut, das gekauft werden soll
//     * @return erstmal nur einen String, der sagt, was getan werden sollte
//     */
//    @GetMapping("/buy")
//    public String buy(@RequestParam(value = "name") String name, @RequestParam(value = "password") String password, @RequestParam(value = "item") String item){
//        UserLogin neu = new UserLogin();
//        if(neu.check(name, password) == "Willkommen"){
//            return "Ich würde die benötige Methode aus UserInteraction aufrufen, wenn es implementiert wäre.";
//        }
//        return "Ich würde dir keine Erlaubnis dafür geben, wenn es implementiert wäre";
//    }
//
//
//    //bsp: http://localhost:8080/sell?name=Max&password=MPasswort&item=NFT
//    /**
//     * Verkauft angegebenes Gut für den aktuellen Preis auf Nutzeranfrage, nach dessen Anmeldung
//     * @param name - Name des Nutzerprofils vom Typ String
//     * @param password - Passwort des Nutzerprofils vom Typ String
//     * @param item- Gut, das verkauft werden soll
//     * @return erstmal nur einen String, der sagt, was getan werden sollte
//     */
//    @GetMapping("/sell")
//    public String sell(@RequestParam(value = "name") String name, @RequestParam(value = "password") String password, @RequestParam(value = "item") String item){
//        UserLogin neu = new UserLogin();
//        //UserInteraction ui = new UserInteraction();
//        if(neu.check(name, password) == "Willkommen"){
//            return "Ich würde die benötige Methode aus UserInteraction aufrufen, wenn es implementiert wäre.";
//        }
//        return "Ich würde dir keine Erlaubnis dafür geben, wenn es implementiert wäre";
//    }
//}
//
