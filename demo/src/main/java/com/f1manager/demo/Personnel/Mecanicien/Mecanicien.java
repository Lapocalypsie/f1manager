package com.f1manager.demo.Personnel.Mecanicien;

import com.f1manager.demo.Personnel.Personne;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "mecanicien")
public class Mecanicien extends Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double vitesse;
    private double performance;
    public Mecanicien(String nom, String prenom, int niveauActuel, double vitesse, double performance) {
        super(nom, prenom, niveauActuel);
        this.vitesse = vitesse;
        this.performance = performance;
    }
    public Mecanicien() {

    }
}
