package com.f1manager.demo.Formula1.Moteurs;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "moteurs")
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

    public Moteurs(String nomMoteur, double consommationEssence, double puissance, double prixMoteur, int nivActuel) {
        this.nomMoteur = nomMoteur;
        this.consommationEssence = consommationEssence;
        this.puissance = puissance;
        this.prixMoteur = prixMoteur;
        this.nivActuel = nivActuel;
    }

    public Moteurs() {
    }

}