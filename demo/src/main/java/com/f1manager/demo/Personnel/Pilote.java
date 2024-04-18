package com.f1manager.demo.Personnel;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pilotes")
public class Pilote {
    @Id
    private int id;
    private String name;
    private int number;
    private int price;
    private int force;
    private int endurance;

    public Pilote() {
    }

    public Pilote(int id, String name, int number, int price, int force, int endurance) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.price = price;
        this.force = force;
        this.endurance = endurance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", price=" + price +
                ", force=" + force +
                ", endurance=" + endurance +
                '}';
    }
}
