package com.f1manager.demo.systemeco;

import com.f1manager.demo.ErrorHandling.throwException;
import com.f1manager.demo.Formula1.Aileron.Ailerons;
import com.f1manager.demo.Formula1.Aileron.AileronsService;
import com.f1manager.demo.Formula1.Moteurs.Moteurs;
import com.f1manager.demo.Formula1.Moteurs.MoteursService;
import com.f1manager.demo.Formula1.wheels.Wheels;
import com.f1manager.demo.Formula1.wheels.WheelsControler;
import com.f1manager.demo.Formula1.wheels.WheelsService;
import com.f1manager.demo.Joueur.Joueur;
import com.f1manager.demo.Personnel.pilote.Pilote;
import com.f1manager.demo.Utils.Niveaux;

public class MonteeDeNiveau {

    private static AileronsService aileronsService;
    private static MoteursService moteursService;
    private static WheelsService wheelsService;

    public MonteeDeNiveau(AileronsService aileronsService, MoteursService moteursService, WheelsService wheelsService) {
        MonteeDeNiveau.aileronsService = aileronsService;
        MonteeDeNiveau.moteursService = moteursService;
        MonteeDeNiveau.wheelsService = wheelsService;
    }

    public static boolean isAmeliorationPossible(int nivActuel){
        if(nivActuel < 10){
            return true;
        }
        throwException.throwIllegalArgumentException("Le niveau est déjà au maximum");
        return false;
    }
    public static void monteeAilerons(Ailerons ailerons, Joueur joueur) {
        if (isAmeliorationPossible(ailerons.getNivActuel())) {
            double prixPourProchainNiveau = Niveaux.nextLevel(ailerons.getNivActuel());
            if (joueur.getArgent() >= prixPourProchainNiveau) {
                ailerons.setNivActuel(ailerons.getNivActuel() + 1);
                joueur.setArgent(joueur.getArgent() - prixPourProchainNiveau);
                aileronsService.saveAileron(ailerons);
                System.out.println("La montée de niveau de l'aileron a été effectué");
            } else {
                throwException.throwIllegalArgumentException("Vous n'avez pas assez d'argent pour effectuer cette montée de niveau.");
            }
        } else {
            throwException.throwIllegalArgumentException("Cet aileron a déjà atteint le niveau maximum.");
        }
    }
    public static void monteeMoteurs(Moteurs moteurs, Joueur joueur) {
        if (isAmeliorationPossible(moteurs.getNivActuel())) {
            double prixPourProchainNiveau = Niveaux.nextLevel(moteurs.getNivActuel());
            if (joueur.getArgent() >= prixPourProchainNiveau) {
                moteurs.setNivActuel(moteurs.getNivActuel() + 1);
                joueur.setArgent(joueur.getArgent() - prixPourProchainNiveau);
                moteursService.saveMoteur(moteurs);
                System.out.println("La montée de niveau du moteur a été effectué");
            } else {
                throwException.throwIllegalArgumentException("Vous n'avez pas assez d'argent pour effectuer cette montée de niveau.");
            }
        } else {
            throwException.throwIllegalArgumentException("Ce moteur a déjà atteint le niveau maximum.");
        }
    }
    public static void monteeWheels(Wheels wheels, Joueur joueur) {
        if (isAmeliorationPossible(wheels.getNivActuel())) {
            double prixPourProchainNiveau = Niveaux.nextLevel(wheels.getNivActuel());
            if (joueur.getArgent() >= prixPourProchainNiveau) {
                wheels.setNivActuel(wheels.getNivActuel() + 1);
                joueur.setArgent(joueur.getArgent() - prixPourProchainNiveau);
                wheelsService.saveWheels(wheels);
                System.out.println("La montée de niveau de ces roues ont été effectué");
            } else {
                throwException.throwIllegalArgumentException("Vous n'avez pas assez d'argent pour effectuer cette montée de niveau.");
            }
        } else {
            throwException.throwIllegalArgumentException("Ces roues ont déjà atteint le niveau maximum.");
        }

    }
}
