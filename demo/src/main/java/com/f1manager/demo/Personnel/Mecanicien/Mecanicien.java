package com.f1manager.demo.Personnel.Mecanicien;

import com.f1manager.demo.Personnel.Personne;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "mecanicien")
public class Mecanicien extends Personne {
    private double vitesse;
    private double performance;
}
