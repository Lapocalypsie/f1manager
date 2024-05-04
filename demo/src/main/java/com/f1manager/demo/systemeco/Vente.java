package com.f1manager.demo.systemeco;

import com.f1manager.demo.ErrorHandling.throwException;
import com.f1manager.demo.Joueur.Joueur;
import com.f1manager.demo.Personnel.Mecanicien.Mecanicien;
import com.f1manager.demo.Personnel.pilote.Pilote;


public class Vente {

    public static void effectuerVente(Pilote pilote, Joueur joueur) {

        if (pilote != null && pilote.isAppartient()) {
            double nouveauSolde = joueur.getArgent() + pilote.getPrice();
            joueur.setArgent(nouveauSolde);
            pilote.setAppartient(false);
            System.out.println("Vente effectuée avec succès !");
        } else {
            throwException.throwIllegalArgumentException("Ce pilote ne vous appartient pas.");
        }
    }

    public static void effectuerVente(Mecanicien mecanicien, Joueur joueur) {

        if (mecanicien != null && mecanicien.isAppartient()) {
            double nouveauSolde = joueur.getArgent() + mecanicien.getPrice();
            joueur.setArgent(nouveauSolde);
            mecanicien.setAppartient(false);
            System.out.println("Vente effectuée avec succès !");
        } else {
            throwException.throwIllegalArgumentException("Ce mécanicien ne vous appartient pas.");
        }
    }
}
