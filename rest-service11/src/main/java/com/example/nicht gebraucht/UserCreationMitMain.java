package com.example.restservice;
import org.json.simple.*;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class UserCreationMitMain {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("");
        String directoryName = path.toAbsolutePath().toString();
        JSONObject newUser = new JSONObject();
        Scanner sc = new Scanner(System.in);
        String name = "";
        System.out.println("Nutzername eingeben:");
        name = sc.nextLine();
        String password = "";
        System.out.println("Passwort eingeben:");
        password = sc.nextLine();
        newUser.put("name", name);
        newUser.put( "password", password);
        newUser.put("balance", 0.0);
        newUser.put("Grafikkarten", 0.0);
        newUser.put("CsgoCaseKeys", 0.0);
        newUser.put("DiscordNitro", 0.0);
        newUser.put("LSD", 0.0);
        newUser.put("Nieren", 0.0);
        newUser.put("Rapsoel", 0.0);
        newUser.put("RedditKarma", 0.0);
        newUser.put("Toilettenpapier", 0.0);
        newUser.put("VpPoints", 0.0);
        newUser.put("NFTs", 0.0);

        FileWriter file = new FileWriter(directoryName + "/rest-service11/src/main/java/com/example/restservice/" + name + ".json");
        //FileWriter file = new FileWriter(directoryName + "/src/main/java/com/example/restservice/" + name + ".json");
        file.write(newUser.toJSONString());
        file.close();
    }
}
