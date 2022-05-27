package com.example.restservice;

public class UserInteraction {
    public int Reddit_Karma_Menge;
    public int VP_Point_Menge;
    public int Toilettenpapier_Menge;
    public int Rapsoel_Menge;
    public int NFT_Menge;
    public int LSD_Menge;
    public int Grafikkarten_Menge;
    public int Discord_Nitro_Menge;
    public int Nieren_Menge;
    public int CSGO_Case_Key_Menge;
    public int Primogem_Anzahl;

    public String UserInfo() {
        String ausgabe = "Primogems: " + Primogem_Anzahl + "\nGüter:\nReddit_Karma: " + Reddit_Karma_Menge + "\nVP_Points: " + VP_Point_Menge + "\nToilettenpapier: " + Toilettenpapier_Menge + "\nRapsoel: " + Rapsoel_Menge + "\nNFT: " + NFT_Menge + "\nLSD: " + LSD_Menge + "\nGrafikkarten: " + Grafikkarten_Menge + "\nDiscord_Nitro: " + Discord_Nitro_Menge + "\nNieren" + Nieren_Menge + "\nCSGO_Case_Keys: " + CSGO_Case_Key_Menge;
        return ausgabe;
    }
}
