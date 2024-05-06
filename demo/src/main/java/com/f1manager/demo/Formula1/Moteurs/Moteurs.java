package com.f1manager.demo.Formula1.Moteurs;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CollectionId;

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
    @Column(name="coef_moteur")
    private double coefMoteur;
    @Column(name="prix_moteur")
    private double prixMoteur;
    @Column(name="niv_actuel")
    private int nivActuel;
    @Column(name="image_moteur")
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