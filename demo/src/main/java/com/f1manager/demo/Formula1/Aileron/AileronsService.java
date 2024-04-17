package com.f1manager.demo.Formula1.Aileron;

import com.f1manager.demo.Formula1.ErrorHandling.throwException;
import com.f1manager.demo.Formula1.Utils.assignCoef;
import com.f1manager.demo.Formula1.Utils.findCloserInList;
public class AileronsService {
    public static Double getAileronCoef(Ailerons ailerons){
        if (ailerons.getPoidsAileron() < 0){
            throwException.throwIllegalArgumentException("Le poids de l'ailron ne peut pas être négatif");
        }
        double[] poidsListe = {300,310,320,330,340,350,360};
        return assignCoef.assignCoefficient(findCloserInList.findCloser(ailerons.getPoidsAileron(), poidsListe), poidsListe);
    }
}
