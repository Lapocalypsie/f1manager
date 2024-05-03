package com.f1manager.demo.Personnel;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class Personne {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nom")
    private String nom;
    @Column (name ="prenom")
    private String prenom;
    @Column(name = "niveauActuel")
    private int niveauActuel;

    public Personne(String nom, String prenom, int niveauActuel) {
        this.nom = nom;
        this.prenom = prenom;
        this.niveauActuel = niveauActuel;
    }

    public Personne() {
    }

}
