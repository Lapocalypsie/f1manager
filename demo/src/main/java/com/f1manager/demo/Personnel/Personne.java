package com.f1manager.demo.Personnel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Personne {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;
    private String prenom;
    private double xpActuelle;
    private double nivActuelle;
    private double xpNextLevel;
}
