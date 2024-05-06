package com.f1manager.demo.Formula1.Aileron;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Entity
@Getter
@Setter
@Table(name = "ailerons") // Assurez-vous que le nom de la table est correct
public class Ailerons {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="coefAileron")
    private double coefAileron;

    @Column(name="poidsAileron")
    private double poidsAileron;
    private double prixAileron;
    private int nivActuel;
    public Ailerons(double poidsAileron, double prixAileron, int nivActuel) {
        this.poidsAileron = poidsAileron;
        this.prixAileron = prixAileron;
        this.nivActuel = nivActuel;
    }
}