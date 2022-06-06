package com.example.restservice;
import org.json.simple.*;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class UserCreation {
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
        newUser.put("\npassword", password);
        newUser.put("\nbalance", 0.0);
        newUser.put("\nGrafikkarten", 0.0);
        newUser.put("\nCsgoCaseKeys", 0.0);
        newUser.put("\nDiscordNitro", 0.0);
        newUser.put("\nLSD", 0.0);
        newUser.put("\nNieren", 0.0);
        newUser.put("\nRapsoel", 0.0);
        newUser.put("\nRedditKarma", 0.0);
        newUser.put("\nToilettenpapier", 0.0);
        newUser.put("\nVpPoints", 0.0);
        newUser.put("\nNFTs", 0.0);

        FileWriter file = new FileWriter(directoryName + "/rest-service11/src/main/java/com/example/restservice/" + name + ".json");
        file.write(newUser.toJSONString());
        file.close();
    }
}
