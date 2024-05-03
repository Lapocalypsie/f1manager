package com.f1manager.demo.Formula1;

import com.f1manager.demo.Formula1.Aileron.Ailerons;
import com.f1manager.demo.Formula1.Moteurs.Moteurs;
import com.f1manager.demo.Formula1.wheels.Wheels;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "f1")
public class F1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name ="poidsf1")
    private double poidsF1;

    @Column(name ="vitessemax")
    private double vitesseMax;

    @Column(name ="zeroto100")
    private double zeroTo100;

    @Column(name ="maniability")
    private double maniabilty;

    @Column(name = "coef")
    private Double coef;

    @ManyToOne
    @JoinColumn(name = "wheels_id")
    private Wheels wheels;

    @ManyToOne
    @JoinColumn(name = "moteur_id")
    private Moteurs moteur;

    @OneToOne
    @JoinColumn(name = "ailerons_id")
    private Ailerons ailerons;
    public F1(){}

    public F1(double poidsF1, double vitesseMax, double zeroTo100, double maniabilty, Wheels wheels, Moteurs moteur, Ailerons ailerons, Double coef) {
        this.poidsF1 = poidsF1;
        this.vitesseMax = vitesseMax;
        this.zeroTo100 = zeroTo100;
        this.maniabilty = maniabilty;
        this.wheels = wheels;
        this.moteur = moteur;
        this.ailerons = ailerons;
        this.coef = coef;
    }

    public F1(double poidsF1, double vitesseMax, double zeroTo100, int maniabilty, Wheels wheels, Moteurs moteur, Ailerons ailerons) {
        this.poidsF1 = poidsF1;
        this.vitesseMax = vitesseMax;
        this.zeroTo100 = zeroTo100;
        this.maniabilty = maniabilty;
        this.wheels = wheels;
        this.moteur = moteur;
        this.ailerons = ailerons;
    }
}