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

    public Moteurs(String nomMoteur, double consommationEssence, double puissance) {
        this.nomMoteur = nomMoteur;
        this.consommationEssence = consommationEssence;
        this.puissance = puissance;
    }

    public Moteurs() {
    }

}