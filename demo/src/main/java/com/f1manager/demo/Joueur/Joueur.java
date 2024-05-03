package com.f1manager.demo.Joueur;

import com.fasterxml.jackson.databind.annotation.EnumNaming;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Joueur")
@Getter
@Setter
public class Joueur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "argent")
    private double argent;
    @Column(name = "xpActuelle")
    private double xpActuelle;
    @Column(name = "nivActuel")
    private int nivActuel;

    public Joueur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        this.argent = 0;
        this.nivActuel = 1;
        this.xpActuelle = 0;
    }

    public Joueur(String nom, String prenom, double xpActuelle, int nivActuel, double argent) {
        this.nom = nom;
        this.prenom = prenom;
        this.xpActuelle = xpActuelle;
        this.nivActuel = nivActuel;
        this.argent = argent;
    }

    public Joueur() {

    }
}
