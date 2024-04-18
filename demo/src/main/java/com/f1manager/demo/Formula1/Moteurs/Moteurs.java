package com.f1manager.demo.Formula1.Moteurs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Moteurs {

    private int id;
    private String nomMoteur;
    private double consommationEssence;
    private int puissance;
    private double coefMoteur;

    public Moteurs(int id, String nomMoteur, double consommationEssence, int puissance, double coefMoteur) {
        this.id = id;
        this.nomMoteur = nomMoteur;
        this.consommationEssence = consommationEssence;
        this.puissance = puissance;
        this.coefMoteur = coefMoteur;
    }

    public Moteurs(String nomMoteur, double consommationEssence, int puissance, double coefMoteur) {
        this.nomMoteur = nomMoteur;
        this.consommationEssence = consommationEssence;
        this.puissance = puissance;
        this.coefMoteur = coefMoteur;
    }

    public Moteurs(String nomMoteur, double consommationEssence, int puissance) {
        this.nomMoteur = nomMoteur;
        this.consommationEssence = consommationEssence;
        this.puissance = puissance;
    }
}
