package com.f1manager.demo.Formula1.Moteurs;

import com.f1manager.demo.Formula1.Utils.assignCoef;
import com.f1manager.demo.Formula1.Utils.findCloserInList;
import com.f1manager.demo.Formula1.ErrorHandling.throwException;

public class MoteursService {
    public Double getConsommationEscenceCoef(Moteurs moteur){
        if (moteur.getConsommationEssence() < 0) {
            throwException.throwIllegalArgumentException("La consommation du moteur ne peut pas être négative");
        }
        double[] consoList = {40.0,42.0,45.0,50.0,55.0};
        return assignCoef.assignCoefficient(findCloserInList.findCloser(moteur.getConsommationEssence(),consoList), consoList);
    }
    public Double getPuissanceCoef(Moteurs moteur){
        if (moteur.getPuissance() < 0){
            throwException.throwIllegalArgumentException("La puissance du moteur ne peut pas être négative");
        }
        double[] puissanceList = {750,800,850,900,950,1000,1001};
        return assignCoef.assignCoefficient(findCloserInList.findCloser(moteur.getPuissance(),puissanceList), puissanceList);
    }
    public static Double getMoteurCoef(Moteurs moteurs){
        return (getPuissanceCoef(moteurs)+ getConsommationEscenceCoef(moteurs))/2;
    }
}
