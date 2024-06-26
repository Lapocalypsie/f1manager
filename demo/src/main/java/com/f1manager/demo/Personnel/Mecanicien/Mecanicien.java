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
    @Column(name = "vitesse")
    private double vitesse;
    @Column(name = "performance")
    private double performance;
    @Column(name = "price")
    private double price;
    @Column (name = "coef")
    private double coefficient;
    @Column(name = "appartient")
    private boolean appartient;

    public Mecanicien(String nom, String prenom, int niveauActuel, double vitesse, double performance, double price, boolean appartient) {
        super(nom, prenom, niveauActuel);
        this.vitesse = vitesse;
        this.performance = performance;
        this.price = price;
        this.appartient = appartient;
    }
    public Mecanicien() {

    }
}
