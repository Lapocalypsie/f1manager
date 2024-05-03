package com.f1manager.demo.Utils;

import com.f1manager.demo.ErrorHandling.throwException;
import com.f1manager.demo.Joueur.Joueur;

public class Niveaux {

     public static int nextLevel(int niveauActuel){
         if (niveauActuel < 1 ) {
             throwException.throwIllegalArgumentException("Le niveau actuel doit être positif");
         }
         int requirement = (int) Math.pow(2, niveauActuel/ 10) * 1000;

         return requirement;
     }
     public static boolean isLevelUp(int niveauActuel, double xpActuelle){
         if (niveauActuel < 1 || xpActuelle < 0){
             throwException.throwIllegalArgumentException("Les valeurs de niveauActuel et xpJoueur doivent être positives");
         }
         return nextLevel(niveauActuel) < xpActuelle;
     }
}
