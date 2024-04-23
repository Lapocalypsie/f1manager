package com.f1manager.demo.Personnel;

import jakarta.persistence.*;

@MappedSuperclass
public class Personne {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;
    @Column(name = "xpactuelle")
    private double xpActuelle;
    @Column(name = "nivactuelle")
    private double nivActuelle;
    @Column(name = "xpnextlevel")
    private double xpNextLevel;

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public double getXpActuelle() {
        return xpActuelle;
    }

    public double getNivActuelle() {
        return nivActuelle;
    }

    public double getXpNextLevel() {
        return xpNextLevel;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setXpActuelle(double xpActuelle) {
        this.xpActuelle = xpActuelle;
    }

    public void setNivActuelle(double nivActuelle) {
        this.nivActuelle = nivActuelle;
    }

    public void setXpNextLevel(double xpNextLevel) {
        this.xpNextLevel = xpNextLevel;
    }
}
