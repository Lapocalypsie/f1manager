package com.f1manager.demo.Circuit;

import java.util.*;

public class CircuitService {

    //Saisie de circuit Brut sous forme de texte
    private String saisieMonaco = "DROITE:100,VIRAGE:90,DROITE:300,VIRAGE:15,VIRAGE:160,VIRAGE:90,DROITE:140,VIRAGE:110," +
            "VIRAGE:180,DROITE:50,VIRAGE:90,DROITE:450,VIRAGE:180,DROITE:50,VIRAGE:90,DROITE:30,VIRAGE:135,DROITE:50," +
            "VIRAGE:135,VIRAGE:80,DROITE:50,VIRAGE:90,DROITE:200";

    public List<Circuit> findAll(){

        //Circuit de Monaco
        LinkedHashMap<String, Double> MonacoMAP = saisieToHashMAP(saisieMonaco);
        Circuit Monaco = new CircuitCreation(MonacoMAP);

        return Arrays.asList(Monaco);
    }

    //Transforme notre circuit sous forme de texte en une HashMAP
    private static LinkedHashMap<String, Double> saisieToHashMAP(String saisieCircuit){
        LinkedHashMap<String, Double> map = new LinkedHashMap<>();
        String[] pairs = saisieCircuit.split(",");
        int temp = 0;
        for (String pair : pairs) {
            String[] keyValue = pair.split(":");
            map.put((keyValue[0]+temp), Double.parseDouble(keyValue[1]));
            temp++;
        }
        return map;
    }

}
