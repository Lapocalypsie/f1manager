package com.f1manager.demo.systemeco;

import com.f1manager.demo.ErrorHandling.throwException;
import com.f1manager.demo.Joueur.Joueur;
import com.f1manager.demo.Personnel.Mecanicien.Mecanicien;
import com.f1manager.demo.Personnel.pilote.Pilote;
import com.f1manager.demo.Personnel.pilote.PiloteService;
import com.f1manager.demo.Joueur.JoueurService;

public class Achat {

    public static void effectuerAchat(Pilote pilote, Joueur joueur) {

        if (pilote != null && pilote.getPrice() <= joueur.getArgent()) {
            double nouveauSolde = joueur.getArgent() - pilote.getPrice();
            joueur.setArgent(nouveauSolde);
            pilote.setAppartient(true);
            System.out.println("Achat effectué avec succès !");
        } else {
            throwException.throwIllegalArgumentException("Vous n'avez pas assez d'argent pour acheter ce pilote.");
        }
    }

    public static void effectuerAchat(Mecanicien mecanicien, Joueur joueur) {

        if (mecanicien != null && mecanicien.getPrice() <= joueur.getArgent()) {
            double nouveauSolde = joueur.getArgent() - mecanicien.getPrice();
            joueur.setArgent(nouveauSolde);
            mecanicien.setAppartient(true);
            System.out.println("Achat effectué avec succès !");
        } else {
            throwException.throwIllegalArgumentException("Vous n'avez pas assez d'argent pour acheter ce mécanicien.");
        }
    }

}

