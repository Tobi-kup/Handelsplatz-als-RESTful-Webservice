package com.example.restservice;
import  java.util.*;

public class UserInteraction {
    public double Reddit_Karma_Menge;
    public double VP_Point_Menge;
    public double Toilettenpapier_Menge;
    public double Rapsoel_Menge;
    public double NFT_Menge;
    public double LSD_Menge;
    public double Grafikkarten_Menge;
    public double Discord_Nitro_Menge;
    public double Nieren_Menge;
    public double CSGO_Case_Key_Menge;
    public double Primogem_Anzahl;
    public double Reddit_Karma_Preis;
    public double VP_Point_Preis;
    public double Toilettenpapier_Preis;
    public double Rapsoel_Preis;
    public double NFT_Preis;
    public double LSD_Preis;
    public double Grafikkarten_Preis;
    public double Discord_Nitro_Preis;
    public double CSGO_Case_Key_Preis;
    public double Nieren_Preis;

    public String UserInfo() {
        String ausgabe = "Primogems: " + Primogem_Anzahl + "\nGüter:\nReddit_Karma: " + Reddit_Karma_Menge + "\nVP_Points: " + VP_Point_Menge + "\nToilettenpapier: " + Toilettenpapier_Menge + "\nRapsoel: " + Rapsoel_Menge + "\nNFT: " + NFT_Menge + "\nLSD: " + LSD_Menge + "\nGrafikkarten: " + Grafikkarten_Menge + "\nDiscord_Nitro: " + Discord_Nitro_Menge + "\nNieren" + Nieren_Menge + "\nCSGO_Case_Keys: " + CSGO_Case_Key_Menge;
        return ausgabe;
    }

    public void Ankaufen() {
        System.out.println("Welches Gut wollen Sie kaufen?\nReddit Karma: 1\nVP Point: 2\nToilettenpapier: 3\nRapsöl: 4\nNFT: 5\nLSD: 6\nGrafikkarten: 7\nDiscord Nitro: 8\nNieren: 9\nCSGO Case Key: 10");
        Scanner sc = new Scanner(System.in);
        int auswahl = sc.nextInt();
        sc.close();
        System.out.println("Wie viel wollen Sie kaufen?");
        Scanner s = new Scanner(System.in);
        int menge = s.nextInt();
        s.close();
        switch(auswahl) {
            case 1:
                if(Primogem_Anzahl - (menge * Reddit_Karma_Preis)>=0) {
                    Reddit_Karma_Menge = Reddit_Karma_Menge + menge;
                    Primogem_Anzahl = Primogem_Anzahl - (menge * Reddit_Karma_Preis);
                }else
                    System.out.println("Sie haben nicht genug Primogems, versuchen Sie er erneut");
                    Ankaufen();
            case 2:
                if(Primogem_Anzahl - (menge * VP_Point_Preis)>=0) {
                    VP_Point_Menge = VP_Point_Menge + menge;
                    Primogem_Anzahl = Primogem_Anzahl - (menge * VP_Point_Preis);
                }else
                    System.out.println("Sie haben nicht genug Primogems, versuchen Sie er erneut");
                Ankaufen();
            case 3:
                if(Primogem_Anzahl - (menge * Toilettenpapier_Preis)>=0) {
                    Toilettenpapier_Menge = Toilettenpapier_Menge + menge;
                    Primogem_Anzahl = Primogem_Anzahl - (menge * Toilettenpapier_Preis);
                }else
                    System.out.println("Sie haben nicht genug Primogems, versuchen Sie er erneut");
                Ankaufen();
            case 4:
                if(Primogem_Anzahl - (menge * Rapsoel_Preis)>=0) {
                    Rapsoel_Menge = Rapsoel_Menge + menge;
                Primogem_Anzahl = Primogem_Anzahl - (menge * Rapsoel_Preis);
                }else
                    System.out.println("Sie haben nicht genug Primogems, versuchen Sie er erneut");
                    Ankaufen();
            case 5:
                if(Primogem_Anzahl - (menge * NFT_Preis)>=0) {
                    NFT_Menge = NFT_Menge + menge;
                Primogem_Anzahl = Primogem_Anzahl - (menge * NFT_Preis);
                }else
                    System.out.println("Sie haben nicht genug Primogems, versuchen Sie er erneut");
                    Ankaufen();
            case 6:
                if(Primogem_Anzahl - (menge * LSD_Preis)>=0) {
                    LSD_Menge =LSD_Menge + menge;
                Primogem_Anzahl = Primogem_Anzahl - (menge * LSD_Preis);
                }else
                    System.out.println("Sie haben nicht genug Primogems, versuchen Sie er erneut");
                Ankaufen();
            case 7:
                if(Primogem_Anzahl - (menge * Grafikkarten_Preis)>=0) {
                    Grafikkarten_Menge = Grafikkarten_Menge + menge;
                Primogem_Anzahl = Primogem_Anzahl - (menge * Grafikkarten_Preis);
                }else
                    System.out.println("Sie haben nicht genug Primogems, versuchen Sie er erneut");
                Ankaufen();
            case 8:
                if(Primogem_Anzahl - (menge * Discord_Nitro_Preis)>=0) {
                    Discord_Nitro_Menge = Discord_Nitro_Menge + menge;
                Primogem_Anzahl = Primogem_Anzahl - (menge * Discord_Nitro_Preis);
                }else
                    System.out.println("Sie haben nicht genug Primogems, versuchen Sie er erneut");
                Ankaufen();
            case 9:
                if(Primogem_Anzahl - (menge * Nieren_Preis)>=0) {
                    Nieren_Menge = Nieren_Menge + menge;
                Primogem_Anzahl = Primogem_Anzahl - (menge * Nieren_Preis);
                }else
                    System.out.println("Sie haben nicht genug Primogems, versuchen Sie er erneut");
                Ankaufen();
            case 10:
                if(Primogem_Anzahl - (menge * CSGO_Case_Key_Preis)>=0) {
                    CSGO_Case_Key_Menge = CSGO_Case_Key_Menge + menge;
                Primogem_Anzahl = Primogem_Anzahl - (menge * CSGO_Case_Key_Preis);
                }else
                    System.out.println("Sie haben nicht genug Primogems, versuchen Sie er erneut");
                Ankaufen();
            default:
                System.out.println("ungültige Eingabe, versuchen Sie es erneut");
                Ankaufen();
        }
    }

    public void Verkaufen() {
        System.out.println("Welches Gut wollen Sie verkaufen?\nReddit Karma: 1\nVP Point: 2\nToilettenpapier: 3\nRapsöl: 4\nNFT: 5\nLSD: 6\nGrafikkarten: 7\nDiscord Nitro: 8\nNieren: 9\nCSGO Case Key: 10");
        Scanner sc = new Scanner(System.in);
        int auswahl = sc.nextInt();
        sc.close();
        System.out.println("Wie viel wollen Sie verkaufen?");
        Scanner s = new Scanner(System.in);
        int menge = s.nextInt();
        s.close();
        switch(auswahl) {
            case 1:
                if(menge > Reddit_Karma_Menge) {
                    System.out.println("So viel besitzen Sie nicht, versuchen Sie es erneut");
                    Verkaufen();
                }
                else
                    Reddit_Karma_Menge = Reddit_Karma_Menge - menge;
                    Primogem_Anzahl = Primogem_Anzahl + (menge * Reddit_Karma_Preis);
            case 2:
                if(menge > VP_Point_Menge) {
                    System.out.println("So viel besitzen Sie nicht, versuchen Sie es erneut");
                    Verkaufen();
                }
                else
                    VP_Point_Menge = VP_Point_Menge - menge;
                Primogem_Anzahl = Primogem_Anzahl + (menge * VP_Point_Preis);
            case 3:
                if(menge > Toilettenpapier_Menge) {
                    System.out.println("So viel besitzen Sie nicht, versuchen Sie es erneut");
                    Verkaufen();
                }
                else
                    Toilettenpapier_Menge = Toilettenpapier_Menge - menge;
                Primogem_Anzahl = Primogem_Anzahl + (menge * Toilettenpapier_Preis);
            case 4:
                if(menge > Rapsoel_Menge) {
                    System.out.println("So viel besitzen Sie nicht, versuchen Sie es erneut");
                    Verkaufen();
                }
                else
                    Rapsoel_Menge = Rapsoel_Menge - menge;
                Primogem_Anzahl = Primogem_Anzahl + (menge * Rapsoel_Preis);
            case 5:
                if(menge > NFT_Menge) {
                    System.out.println("So viel besitzen Sie nicht, versuchen Sie es erneut");
                    Verkaufen();
                }
                else
                    NFT_Menge = NFT_Menge - menge;
                Primogem_Anzahl = Primogem_Anzahl + (menge * NFT_Preis);
            case 6:
                if(menge > LSD_Menge) {
                    System.out.println("So viel besitzen Sie nicht, versuchen Sie es erneut");
                    Verkaufen();
                }
                else
                    LSD_Menge =LSD_Menge - menge;
                Primogem_Anzahl = Primogem_Anzahl + (menge * LSD_Preis);
            case 7:
                if(menge > Grafikkarten_Menge) {
                    System.out.println("So viel besitzen Sie nicht, versuchen Sie es erneut");
                    Verkaufen();
                }
                else
                    Grafikkarten_Menge = Grafikkarten_Menge - menge;
                Primogem_Anzahl = Primogem_Anzahl + (menge * Grafikkarten_Preis);
            case 8:
                if(menge > Discord_Nitro_Menge) {
                    System.out.println("So viel besitzen Sie nicht, versuchen Sie es erneut");
                    Verkaufen();
                }
                else
                    Discord_Nitro_Menge = Discord_Nitro_Menge - menge;
                Primogem_Anzahl = Primogem_Anzahl + (menge * Discord_Nitro_Preis);
            case 9:
                if(menge > Nieren_Menge) {
                    System.out.println("So viel besitzen Sie nicht, versuchen Sie es erneut");
                    Verkaufen();
                }
                else
                    Nieren_Menge = Nieren_Menge - menge;
                Primogem_Anzahl = Primogem_Anzahl + (menge * Nieren_Preis);
            case 10:
                if(menge > CSGO_Case_Key_Menge) {
                    System.out.println("So viel besitzen Sie nicht, versuchen Sie es erneut");
                    Verkaufen();
                }
                else
                    CSGO_Case_Key_Menge = CSGO_Case_Key_Menge - menge;
                Primogem_Anzahl = Primogem_Anzahl + (menge * CSGO_Case_Key_Preis);
            default:
                System.out.println("ungültige Eingabe, versuchen Sie es erneut");
                Verkaufen();
        }
    }
}