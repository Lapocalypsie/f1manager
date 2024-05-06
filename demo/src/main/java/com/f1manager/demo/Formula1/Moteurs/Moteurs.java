package com.f1manager.demo.Formula1.Moteurs;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "moteur")
public class Moteurs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nomMoteur;
    private double consommationEssence;
    private double puissance;
    private double coefMoteur;
    private double prixMoteur;
    private int nivActuel;
    private String imageMoteur;

    public Moteurs(String nomMoteur, double consommationEssence, double puissance, double prixMoteur, String imageMoteur, int nivActuel) {
        this.nomMoteur = nomMoteur;
        this.consommationEssence = consommationEssence;
        this.puissance = puissance;
        this.prixMoteur = prixMoteur;
        this.imageMoteur = imageMoteur;
        this.nivActuel = nivActuel;
    }

    public Moteurs() {
    }

}