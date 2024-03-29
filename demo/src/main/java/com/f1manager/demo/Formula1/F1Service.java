package com.f1manager.demo.Formula1;

import com.f1manager.demo.Formula1.Aileron.Ailerons;
import com.f1manager.demo.Formula1.Moteurs.Moteurs;
import org.springframework.stereotype.Service;

@Service
public class F1Service {
    public Double coefTotal(F1 f1, Moteurs moteur, Ailerons ailerons){
        return f1.getCoef() + moteur.getCoefMoteur() + ailerons.getCoefAileron();
    }
    public Double coefF1(F1 f1){
        double maniabilityCoef = 0.1;
        double vMaxCoef = 0.1;
        double poidsCoef = 0.1;
        double zeroTo100Coef = 0.1;
        //

        if (f1.getManiabilty().equals(Level.PERFECTION)){
            maniabilityCoef = 1.0;
        }
        if (f1.getManiabilty().equals(Level.HIGH)){
            maniabilityCoef = 0.8;
        }
        if (f1.getManiabilty().equals(Level.MEDIUM)){
            maniabilityCoef = 0.6;
        }
        if (f1.getManiabilty().equals(Level.LOW)){
            maniabilityCoef = 0.3;
        }

        //

        if(f1.getVitesseMax() < 300){
            vMaxCoef = 0.3;
        }
        else if(f1.getVitesseMax() < 320){
            vMaxCoef = 0.5;
        }
        else if(f1.getVitesseMax() < 340){
            vMaxCoef = 0.7;
        }
        else if(f1.getVitesseMax() < 360){
            vMaxCoef = 0.8;
        }
        else if (f1.getVitesseMax() > 360){
            vMaxCoef = 0.8;
        }

        //
        if (f1.getPoidsF1() < 798){
            throw new IllegalArgumentException("Le poids de la F1 n'a pas le droit d'être inférieur à 798 KG depuis 2022");
        }
        if(f1.getPoidsF1() == 798){
            poidsCoef = 1.0;
        }
        if(f1.getPoidsF1() > 800){
            poidsCoef = 0.8;
        }
        if (f1.getPoidsF1() > 810) {
            poidsCoef = 0.6;
        }
        if (f1.getPoidsF1() > 830){
            poidsCoef = 0.4;
        }
        if (f1.getPoidsF1() > 850 ){
            poidsCoef = 0.2;
        }

        //

        if (f1.getZeroTo100() < 3){
            zeroTo100Coef = 0.2;
        }
        if(f1.getZeroTo100() < 2.8){
            zeroTo100Coef = 0.4;
        }
        if(f1.getZeroTo100() < 2.5){
            zeroTo100Coef = 0.5;
        }
        if (f1.getZeroTo100() < 2.3){
            zeroTo100Coef = 0.6;
        }
        if (f1.getZeroTo100() < 2.1){
            zeroTo100Coef = 0.7;
        }
        if (f1.getZeroTo100() < 1.9){
            zeroTo100Coef = 0.8;
        }
        if(f1.getZeroTo100() < 1.6){
            zeroTo100Coef = 0.9;
        }
        if(f1.getZeroTo100() <= 1.46){
            zeroTo100Coef = 1.0;
        }

        return (maniabilityCoef + vMaxCoef + poidsCoef+ zeroTo100Coef)/4;
    }
}
