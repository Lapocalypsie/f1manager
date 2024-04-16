package com.f1manager.demo.Formula1.wheels;

public class Wheels {

    private int idWheels;
    private String nomPneu;
    private double poidsPneus;
    private double prixUnitairePneus;
    private double coefPneus;

    public int getIdWheels() {
        return idWheels;
    }

    public void setIdWheels(int idWheels) {
        this.idWheels = idWheels;
    }

    public String getNomPneu() {
        return nomPneu;
    }

    public void setNomPneu(String nomPneu) {
        this.nomPneu = nomPneu;
    }

    public double getPoidsPneus() {
        return poidsPneus;
    }

    public void setPoidsPneus(double poidsPneus) {
        this.poidsPneus = poidsPneus;
    }

    public double getPrixUnitairePneus() {
        return prixUnitairePneus;
    }

    public void setPrixUnitairePneus(double prixUnitairePneus) {
        this.prixUnitairePneus = prixUnitairePneus;
    }

    public double getCoefPneus() {
        return coefPneus;
    }

    public void setCoefPneus(double coefPneus) {
        this.coefPneus = coefPneus;
    }
}
