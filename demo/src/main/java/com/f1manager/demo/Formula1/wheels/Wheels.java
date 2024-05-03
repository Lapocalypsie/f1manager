package com.f1manager.demo.Formula1.wheels;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
@Table(name = "wheels")
public class Wheels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nomPneu;
    private double poidsPneus;
    private double prixPneus;
    private String typePneus;
    private double coefPneus;

    public Wheels(String nomPneu, double poidsPneus, double prixPneus, String typePneus) {
        this.nomPneu = nomPneu;
        this.poidsPneus = poidsPneus;
        this.prixPneus = prixPneus;
        this.typePneus = typePneus;
    }

    public Wheels() {

    }
}