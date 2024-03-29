package com.f1manager.demo.Formula1.Moteurs;

public abstract class Moteurs {

    private int id;
    private String nomMoteur;
    private double consommationEssence;
    private int puissance;
    private double coefMoteur;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomMoteur() {
        return nomMoteur;
    }

    public void setNomMoteur(String nomMoteur) {
        this.nomMoteur = nomMoteur;
    }

    public double getConsommationEssence() {
        return consommationEssence;
    }

    public void setConsommationEssence(double consommationEssence) {
        this.consommationEssence = consommationEssence;
    }

    public int getPuissance() {
        return puissance;
    }

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }

    public double getCoefMoteur() {
        return coefMoteur;
    }

    public void setCoefMoteur(double coefMoteur) {
        this.coefMoteur = coefMoteur;
    }
}
