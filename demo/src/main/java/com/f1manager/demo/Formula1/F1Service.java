package com.f1manager.demo.Formula1;

import com.f1manager.demo.Formula1.Aileron.Ailerons;
import com.f1manager.demo.Formula1.Moteurs.Moteurs;
import com.f1manager.demo.Formula1.Utils.assignCoef;
import com.f1manager.demo.Formula1.Utils.findCloserInList;
import org.springframework.stereotype.Service;

@Service
public class F1Service {
    public Double coefTotal(F1 f1, Moteurs moteur, Ailerons ailerons){
        return f1.getCoef() + moteur.getCoefMoteur() + ailerons.getCoefAileron();
    }

    public Double getManiabilityCoef(F1 f1) {
        double maniabilityCoef = 0.1;
        if (f1.getManiabilty().equals(Level.PERFECTION)) {
            maniabilityCoef = 1.0;
        } else if (f1.getManiabilty().equals(Level.HIGH)) {
            maniabilityCoef = 0.8;
        } else if (f1.getManiabilty().equals(Level.MEDIUM)) {
            maniabilityCoef = 0.6;
        } else if (f1.getManiabilty().equals(Level.LOW)) {
            maniabilityCoef = 0.4;
        } else if (f1.getManiabilty().equals(Level.DISASTER)) {
            maniabilityCoef = 0.2;
        } else {
            throw new IllegalArgumentException("Le Coefficient de Maniabilité est erroné");
        }
        return maniabilityCoef;
    }

    public Double vMaxCoef(F1 f1) {
        int[] vitessList = {300, 310, 320, 330, 340, 350, 360};
        return assignCoef.assignCoeficient(findCloserInList.findCloser(f1.getVitesseMax(), vitessList),vitessList);
    }
        //
    public Double getPoidsCoef(F1 f1) {
        int[] poidsList = {798,800,810,830,850};
        return 1-assignCoef.assignCoeficient(findCloserInList.findCloser(f1.getPoidsF1(),poidsList), poidsList);
    }
        //
    public Double getZeroTo100Coef(F1 f1) {
        double zeroTo100Coef = 0.1;
        if (f1.getZeroTo100() < 3) {
            zeroTo100Coef = 0.2;
        }
        if (f1.getZeroTo100() < 2.8) {
            zeroTo100Coef = 0.4;
        }
        if (f1.getZeroTo100() < 2.5) {
            zeroTo100Coef = 0.5;
        }
        if (f1.getZeroTo100() < 2.3) {
            zeroTo100Coef = 0.6;
        }
        if (f1.getZeroTo100() < 2.1) {
            zeroTo100Coef = 0.7;
        }
        if (f1.getZeroTo100() < 1.9) {
            zeroTo100Coef = 0.8;
        }
        if (f1.getZeroTo100() < 1.6) {
            zeroTo100Coef = 0.9;
        }
        if (f1.getZeroTo100() <= 1.46) {
            zeroTo100Coef = 1.0;
        }
        return zeroTo100Coef;
    }
    public Double f1MoyenneCoef (F1 f1){
        return (getPoidsCoef(f1) + getManiabilityCoef(f1) + vMaxCoef(f1) + getZeroTo100Coef(f1))/4;
    }
}
