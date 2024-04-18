package com.f1manager.demo.Calculateur;

import com.f1manager.demo.Circuit.Circuit;
import com.f1manager.demo.Formula1.F1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class LapTime {
    public List<Double> calculLapTime(List<Double> vitesseTempsEntree, Circuit circuit, F1 voiture) {
        double vitesseEntree = vitesseTempsEntree.get(0);
        double tempsEntree = vitesseTempsEntree.get(1);

        LinkedHashMap<String, Double> Circuit = circuit.getCircuit(circuit);

        List<Double> resultat = new ArrayList<>();

        for (String key : Circuit.keySet()) {
            if (key.startsWith("DROITE")) {
                //Recupération distance ligne droite
                Double distance = Circuit.get(key);
                //Recuperation de la nouvelle Vitesse de Sortie et du Temps Total
                resultat = LigneDroiteTime.calculVitesseSortie(distance, vitesseTempsEntree, voiture);
            }else if (key.startsWith("VIRAGE")) {
                //Recupération angle virage
                Double angle = Circuit.get(key);
                //Recuperation de la nouvelle Vitesse de Sortie et du Temps Total
                resultat = LigneDroiteTime.calculVitesseSortie(angle, vitesseTempsEntree, voiture);
            }

        }

        //Renvoie la vitesse de fin de tour et le Temps au Tour
        return resultat;
    }
}
