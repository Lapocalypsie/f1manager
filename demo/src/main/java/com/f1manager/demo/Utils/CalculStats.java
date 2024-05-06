package com.f1manager.demo.Utils;

import com.f1manager.demo.Personnel.Mecanicien.Mecanicien;

public class CalculStats {
    private static final int niveauMaxPersonne = 10;
    public static double calculerVitesse(Mecanicien mecanicien) {
        double baseVitesse = mecanicien.getVitesse();
        double tauxCroissanceVitesse = 1.05;
        return baseVitesse * Math.pow(tauxCroissanceVitesse, mecanicien.getNiveauActuel() - 1);
    }
    public static double calculerVitesse(Mecanicien mecanicien, int niveauMax) {
        double baseVitesse = mecanicien.getVitesse();
        double tauxCroissanceVitesse = 1.05;
        return baseVitesse * Math.pow(tauxCroissanceVitesse, niveauMax);
    }
    public static double calculerPerformance(Mecanicien mecanicien) {
        double basePerformance = mecanicien.getPerformance();
        double tauxCroissancePerformance = 1.07;
        return basePerformance * Math.pow(tauxCroissancePerformance, mecanicien.getNiveauActuel() - 1);
    }
    public static double calculerPerformance(Mecanicien mecanicien, int niveauMax) {
        double basePerformance = mecanicien.getPerformance();
        double tauxCroissancePerformance = 1.07;
        return basePerformance * Math.pow(tauxCroissancePerformance, niveauMax);
    }
    public static double calculerCoefficientMecanicien(Mecanicien mecanicien) {
        double vitesse = calculerVitesse(mecanicien);
        double performance = calculerPerformance(mecanicien);
        double sommeMaxNiveauMax = calculerPerformance(mecanicien,niveauMaxPersonne) + calculerVitesse(mecanicien,niveauMaxPersonne); // La somme des valeurs de vitesse et productivité au niveau 10
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
