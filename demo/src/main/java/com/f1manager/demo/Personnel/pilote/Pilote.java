package com.f1manager.demo.Personnel.pilote;

import com.f1manager.demo.Personnel.Personne;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "pilote")
public class Pilote extends Personne {
    private int number;
    private int price;
    private int force;
    private int endurance;

    public Pilote() {
    }

    public Pilote(int number, int price, int force, int endurance) {
        this.number = number;
        this.price = price;
        this.force = force;
        this.endurance = endurance;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    @Override
    public String toString() {
        return "Pilote{" +
                "id=" + getId() +
                ", name='" + getNom() + ' ' + getPrenom() +
                ", number=" + number +
                ", price=" + price +
                ", force=" + force +
                ", endurance=" + endurance +
                '}';
    }
}
