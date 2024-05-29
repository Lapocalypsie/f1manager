package com.f1manager.demo.Utils;

public enum Lists {
    VITESSE_LIST_F1(new double[]{300, 310, 320, 330, 340, 350, 360}),
    POIDS_LIST_F1(new double[]{798, 800, 810, 830, 850}),
    TIME_LIST_F1(new double[]{1.46, 1.5, 1.6, 1.7, 1.9, 2.0, 2.1, 2.2, 2.3, 2.4, 2.5, 2.6, 2.7, 2.8}),
    POIDS_LIST_WHEELS(new double[]{37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49}),
    CONSO_LIST_MOTEUR(new double[]{40.0, 42.0, 45.0, 50.0, 55.0}),
    PUISSANCE_LIST_MOTEUR(new double[]{750, 800, 850, 900, 950, 1000, 1001}),
    POIDS_LISTE_AILERONS(new double[]{300, 310, 320, 330, 340, 350, 360});

    private final double[] values;

    Lists(double[] values) {
        this.values = values;
    }

    public double[] getValues() {
        return values;
    }
    // Méthodes pour obtenir des tableaux spécifiques
    public static double[] getVitesseListF1() {
        return VITESSE_LIST_F1.values;
    }

    public static double[] getPoidsListF1() {
        return POIDS_LIST_F1.values;
    }

    public static double[] getTimeListF1() {
        return TIME_LIST_F1.values;
    }

    public static double[] getPoidsListWheels() {
        return POIDS_LIST_WHEELS.values;
    }

    public static double[] getConsoListMoteur() {
        return CONSO_LIST_MOTEUR.values;
    }

    public static double[] getPuissanceListMoteur() {
        return PUISSANCE_LIST_MOTEUR.values;
    }

    public static double[] getPoidsListeAilerons() {
        return POIDS_LISTE_AILERONS.values;
    }
}
