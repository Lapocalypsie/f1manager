package com.f1manager.demo.Personnel.pilote;

import com.f1manager.demo.Personnel.Personne;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

@Entity
@Table(name = "pilote")
@Getter
@Setter
public class Pilote extends Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "number")
    private int number;
    @Column(name = "price")
    private double price;
    @Column(name = "force")
    private double force;
    @Column(name = "endurance")
    private double endurance;
    @Column(name = "appartient")
    private boolean appartient;

    public Pilote() {
    }

    public Pilote(String nom, String prenom, int niveauActuel, int number, double price, double force, double endurance, boolean appartient) {
        super(nom, prenom, niveauActuel);
        this.number = number;
        this.price = price;
        this.force = force;
        this.endurance = endurance;
        this.appartient = appartient;
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
                ", appartient=" + appartient +
                '}';
    }
}
