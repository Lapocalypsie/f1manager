package com.f1manager.demo.Formula1.Aileron;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "aileron")
public class Ailerons {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "coef_aileron")
    private double coefAileron;

    @Column(name = "poid_aileron")
    private double poidsAileron;
    @Column(name = "prix_aileron")
    private int prixAileron;
    @Column(name = "niv_actuel")
    private int nivActuel;
    @Column(name = "image_aileron")
    private String imageAileron;

    public Ailerons(double poidsAileron, int prixAileron, String imageAileron, int nivActuel) {
        this.poidsAileron = poidsAileron;
        this.prixAileron = prixAileron;
        this.imageAileron = imageAileron;
        this.nivActuel = nivActuel;

    }

    // Default constructor
    public Ailerons() {
    }

}