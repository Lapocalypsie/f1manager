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

    @Column(name ="poid_f1")
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
    @JoinColumn(name = "wheel_id")
    private Wheels wheels;

    @ManyToOne
    @JoinColumn(name = "moteur_id")
    private Moteurs moteur;

    @OneToOne
    @JoinColumn(name = "aileron_id")
    private Ailerons ailerons;
    @Column(name = "image_f1")
    private String imageF1;
    public F1(){}


    public F1(double poidsF1, double vitesseMax, double zeroTo100, int maniabilty, Wheels wheels, Moteurs moteur, Ailerons ailerons, String imageF1) {
        this.poidsF1 = poidsF1;
        this.vitesseMax = vitesseMax;
        this.zeroTo100 = zeroTo100;
        this.maniabilty = maniabilty;
        this.wheels = wheels;
        this.moteur = moteur;
        this.ailerons = ailerons;
        this.imageF1 = imageF1;
    }
}