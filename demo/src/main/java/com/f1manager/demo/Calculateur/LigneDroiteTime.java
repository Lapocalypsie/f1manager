package com.f1manager.demo.Calculateur;

import com.f1manager.demo.Formula1.F1;

import java.util.ArrayList;
import java.util.List;

public class LigneDroiteTime {

    public static List<Double> calculVitesseSortie(double distance, List<Double> vitesseTempsEntree, F1 voiture) {
        double vitesseEntree = vitesseTempsEntree.get(0);
        double tempsEntree = vitesseTempsEntree.get(1);

        // Calcul de la vitesse de sortie du virage (hypothétique)
        double vitesseSortie = calculVitesseSortie(vitesseEntree, voiture);

        // Calcul du temps parcouru sur la distance donnée en fonction de la moyenne pondérée entre la vitesse d'entrée et la vitesse de sortie
        double tempsParcouru = (distance / ((vitesseEntree + vitesseSortie) / 2));

        // Mise à jour du temps total
        double tempsTotal = tempsEntree + tempsParcouru;

        // Mise à jour de la liste avec la nouvelle vitesse de sortie et le temps total
        List<Double> resultat = new ArrayList<>();
        resultat.add(vitesseSortie);
        resultat.add(tempsTotal);

        return resultat;
    }

    // Méthode pour calculer la vitesse de sortie du virage
    private static double calculVitesseSortie(double vitesseEntree, F1 voiture) {
        //Fonction calcul vitesse sortie
        return 0.0; // Placeholder, remplacez par le calcul réel
    }
}
