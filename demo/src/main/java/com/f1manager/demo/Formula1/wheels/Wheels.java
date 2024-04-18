package com.f1manager.demo.Formula1.wheels;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Wheels {

    private int idWheels;
    private String nomPneu;
    private double poidsPneus;
    private double prixUnitairePneus;
    private String typePneus;
    private double coefPneus;

    public Wheels(int idWheels, String nomPneu, double poidsPneus, double prixUnitairePneus, String typePneus, double coefPneus) {
        this.idWheels = idWheels;
        this.nomPneu = nomPneu;
        this.poidsPneus = poidsPneus;
        this.prixUnitairePneus = prixUnitairePneus;
        this.typePneus = typePneus;
        this.coefPneus = coefPneus;
    }

    public Wheels(String nomPneu, double poidsPneus, double prixUnitairePneus, String typePneus, double coefPneus) {
        this.nomPneu = nomPneu;
        this.poidsPneus = poidsPneus;
        this.prixUnitairePneus = prixUnitairePneus;
        this.typePneus = typePneus;
        this.coefPneus = coefPneus;
    }

    public Wheels(String nomPneu, double poidsPneus, double prixUnitairePneus, String typePneus) {
        this.nomPneu = nomPneu;
        this.poidsPneus = poidsPneus;
        this.prixUnitairePneus = prixUnitairePneus;
        this.typePneus = typePneus;
    }
}
