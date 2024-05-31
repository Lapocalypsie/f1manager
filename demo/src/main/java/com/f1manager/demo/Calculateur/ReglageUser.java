package com.f1manager.demo.Calculateur;

import com.f1manager.demo.Formula1.F1;

public class ReglageUser {
    public Double newVmax;
    public Double newZeroa100;
    public Double newManiabiliteCoef;

    public Double getNewVmax(F1 voiture) {
        Double Vmax = voiture.getVitesseMax();
        // Changer réglages en fonction de
        newVmax = Vmax;
        return newVmax;
    }

    public Double setNewZeroa100(F1 voiture) {
        Double Zeroa100 = voiture.getZeroTo100();
        // Changer réglages en fonction de
        newZeroa100 = Zeroa100;
        return newZeroa100;
    }

    public Double getNewManiabilite(F1 voiture) {
        // Double ManiabiliteCoef = voiture.getManiabilty();
        // Changer reglages en fonction de
        return newManiabiliteCoef;
    }
}
