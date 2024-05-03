package com.f1manager.demo.Utils;

public class CalculStats {
    public static double calculerVitesse(int niveau) {
        double baseVitesse = 10.0;
        double tauxCroissanceVitesse = 1.05;
        return baseVitesse * Math.pow(tauxCroissanceVitesse, niveau - 1);
    }

    public static double calculerProductivite(int niveau) {
        double baseProductivite = 5.0;
        double tauxCroissanceProductivite = 1.07;
        return baseProductivite * Math.pow(tauxCroissanceProductivite, niveau - 1);
    }
}
