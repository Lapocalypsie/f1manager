package com.f1manager.demo.Personnel.pilote;

import com.f1manager.demo.Personnel.Personne;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pilote")
@Getter
@Setter
public class Pilote extends Personne {
    private int number;
    private int price;
    private int force;
    private int endurance;

    public Pilote() {
    }

    public Pilote(String nom, String prenom, int niveauActuel, int number, int price, int force, int endurance) {
        super(nom, prenom, niveauActuel);
        this.number = number;
        this.price = price;
        this.force = force;
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
