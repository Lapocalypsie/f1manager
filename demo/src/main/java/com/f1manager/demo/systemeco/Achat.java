package com.f1manager.demo.systemeco;

import com.f1manager.demo.ErrorHandling.throwException;
import com.f1manager.demo.Joueur.Joueur;
import com.f1manager.demo.Log.Log;
import com.f1manager.demo.Personnel.Mecanicien.Mecanicien;
import com.f1manager.demo.Personnel.pilote.Pilote;

public class Achat {


    // methode qui permet d'acheter un pilote
    public static void effectuerAchat(Pilote pilote, Joueur joueur) {

        if (pilote != null && pilote.getPrice() <= joueur.getArgent()) { // si le joueur possède suffisamment d'argent pour acheter un pilote
            double nouveauSolde = joueur.getArgent() - pilote.getPrice(); // alors on diminue la valeur du solde du joueur du montant de la valeur du prix du pilote
            joueur.setArgent(nouveauSolde); // on actualise le solde du joueur
            pilote.setAppartient(true); // on actualise le statut du pilote afin de qu'il appartienne au joueur
            Log.infoLog("Achat effectué avec succès !"); // affichage du succès de l'achat
        } else {
            throwException.throwIllegalArgumentException("Vous n'avez pas assez d'argent pour acheter ce pilote."); // renvoie une erreur si le joueur ne possède pas assez d'argent
        }
    }

    // surcharge de la methode précédente afin d'acheter un mécanicien à la place d'un pilote
    public static void effectuerAchat(Mecanicien mecanicien, Joueur joueur) {

        if (mecanicien != null && mecanicien.getPrice() <= joueur.getArgent()) {
            double nouveauSolde = joueur.getArgent() - mecanicien.getPrice();
            joueur.setArgent(nouveauSolde);
            mecanicien.setAppartient(true);

            Log.infoLog("Achat effectué avec succès !");
        } else {
            throwException.throwIllegalArgumentException("Vous n'avez pas assez d'argent pour acheter ce mécanicien.");
        }
    }

}


