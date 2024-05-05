package com.f1manager.demo.Utils;

public class CalculStats {
    private static final int niveauMaxPersonne = 10;
    public static double calculerVitesse(int niveau) {
        double baseVitesse = 10.0;
        double tauxCroissanceVitesse = 1.05;
        return baseVitesse * Math.pow(tauxCroissanceVitesse, niveau - 1);
    }
    public static double calculerPerformance(int niveau) {
        double basePerformance = 5.0;
        double tauxCroissancePerformance = 1.07;
        return basePerformance * Math.pow(tauxCroissancePerformance, niveau - 1);
    }
    public static double calculerCoefficientMecanicien(int niveau) {
        double vitesse = calculerVitesse(niveau);
        double performance = calculerPerformance(niveau);
        double sommeMaxNiveauMax = calculerPerformance(niveauMaxPersonne) + calculerVitesse(niveauMaxPersonne); // La somme des valeurs de vitesse et productivité au niveau 10
        return (vitesse + performance) / sommeMaxNiveauMax;
    }
    public static double calculerForce(int niveau){
        double baseForce = 5.0;
        double tauxCroissanceForce = 1.04;
        return baseForce * Math.pow(tauxCroissanceForce, niveau-1);
    }
    public static double calculerEndurance(int niveau){
        double baseEndurance = 8.0;
        double tauxCroissanceEndurance = 1.05;
        return baseEndurance * Math.pow(tauxCroissanceEndurance, niveau - 1);
    }
    public static double doublecalculerCoefficientPilote(int niveau){
        double force = calculerForce(niveau);
        double endurance = calculerEndurance(niveau);
        double sommeMaxNiveauMax = calculerForce(niveauMaxPersonne) + calculerEndurance(niveauMaxPersonne);
        return (force + endurance) / sommeMaxNiveauMax;
    }
}
