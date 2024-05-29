package com.f1manager.demo.systemeco;

import com.f1manager.demo.ErrorHandling.throwException;
import com.f1manager.demo.Joueur.Joueur;
import com.f1manager.demo.Log.Log;
import com.f1manager.demo.Personnel.Mecanicien.Mecanicien;
import com.f1manager.demo.Personnel.pilote.Pilote;


public class Vente {

    // méthode qui permet de vendre un pilote
    public static void effectuerVente(Pilote pilote, Joueur joueur) {

        if (pilote != null && pilote.isAppartient()) { // si le pilote nous appartient
            double nouveauSolde = joueur.getArgent() + pilote.getPrice(); // alors on augmente la valeur du solde du joueur du montant de la valeur du prix du pilote
            joueur.setArgent(nouveauSolde); // on actualise le solde
            pilote.setAppartient(false); // on actualise le statut du pilote afin que le pilote n'appartienne plus au joueur
            Log.infoLog("Vente effectuée avec succès !"); // affichage du succès de la vente
        } else {
            throwException.throwIllegalArgumentException("Ce pilote ne vous appartient pas."); // renvoie une erreur si le pilote n'appartient pas au joueur
        }
    }

    // surcharge de la methode précédente afin de vendre un mécanicien à la place d'un pilote
    public static void effectuerVente(Mecanicien mecanicien, Joueur joueur) {

        if (mecanicien != null && mecanicien.isAppartient()) {
            double nouveauSolde = joueur.getArgent() + mecanicien.getPrice();
            joueur.setArgent(nouveauSolde);
            mecanicien.setAppartient(false);
            Log.infoLog("Vente effectuée avec succès !");
        } else {
            throwException.throwIllegalArgumentException("Ce mécanicien ne vous appartient pas.");
        }
    }
}

