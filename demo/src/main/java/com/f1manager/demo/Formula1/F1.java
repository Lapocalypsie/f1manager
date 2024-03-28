package com.f1manager.demo.Formula1;

import com.f1manager.demo.Formula1.Aileron.Ailerons;
import com.f1manager.demo.Formula1.Moteurs.Moteurs;
import com.f1manager.demo.Formula1.wheels.Wheels;
import jakarta.persistence.*;

@Entity
public class F1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double poidsF1;
    private double vitesseMax;
    private int zeroTo100;
    private Level maniabilty;

    @Embedded
    private Wheels wheels;

    @Embedded
    private Moteurs moteur;

    @Embedded
    private Ailerons ailerons;

    public F1(){}

    public F1(double poidsF1, double vitesseMax, int zeroTo100, Level maniabilty, Wheels wheels, Moteurs moteur) {
        this.poidsF1 = poidsF1;
        this.vitesseMax = vitesseMax;
        this.zeroTo100 = zeroTo100;
        this.maniabilty = maniabilty;
        this.wheels = wheels;
        this.moteur = moteur;
    }

}
