package com.f1manager.demo.Formula1;

import com.f1manager.demo.Formula1.Aileron.Ailerons;
import com.f1manager.demo.Formula1.Aileron.AileronsService;
import com.f1manager.demo.Formula1.ErrorHandling.throwException;
import com.f1manager.demo.Formula1.Moteurs.Moteurs;
import com.f1manager.demo.Formula1.Moteurs.MoteursService;
import com.f1manager.demo.Formula1.Utils.assignCoef;
import com.f1manager.demo.Formula1.Utils.findCloserInList;
import com.f1manager.demo.Formula1.wheels.WheelsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class F1Service {

    private final F1Repository repository;

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
            throwException.throwIllegalArgumentException("Le Coefficient de Maniabilité est erroné");
        }
        maniabilityCoef = (maniabilityCoef * 2 + AileronsService.getAileronCoef(f1.getAilerons())) /3;
        return maniabilityCoef;
    }

    public Double vMaxCoef(F1 f1) {

        if (f1.getVitesseMax() < 0){
            throwException.throwIllegalArgumentException("La vitesse ne peut pas être négative");
        }
        double[] vitessList = {300, 310, 320, 330, 340, 350, 360};
        double vMaxCoeff =  assignCoef.assignCoefficient(findCloserInList.findCloser(f1.getVitesseMax(), vitessList), vitessList);
        vMaxCoeff = (vMaxCoeff * 2 + AileronsService.getAileronCoef(f1.getAilerons()) + MoteursService.getMoteurCoef(f1.getMoteur()) + WheelsService.getWheelsCoef(f1.getWheels())) / 5;
        return vMaxCoeff;
    }
        //
    public Double getPoidsCoef(F1 f1) {
        double poidsMinLogique = 200.0;
        if(f1.getPoidsF1() < poidsMinLogique){
            throwException.throwIllegalArgumentException("Le poids de la f1 ne peur pas être inférieure à " + poidsMinLogique + "kg");
        }
        double[] poidsList = {798,800,810,830,850};
        double poidsCoef =  1-assignCoef.assignCoefficient(findCloserInList.findCloser(f1.getPoidsF1(),poidsList), poidsList);
        poidsCoef = (poidsCoef*6 + AileronsService.getAileronCoef(f1.getAilerons()) + MoteursService.getMoteurCoef(f1.getMoteur()) + WheelsService.getWheelsCoef(f1.getWheels())) / 9;
        return poidsCoef;
    }
        //
    public Double getZeroTo100Coef(F1 f1) {
        if (f1.getZeroTo100() < 0){
            throwException.throwIllegalArgumentException("le zéro à 100 ne peut pas être négtif");
        }
        double[] timeList = {1.46,1.5,1.6,1.7,1.9,2.0,2.1,2.2,2.3,2.4,2.5,2.6,2.7,2.8};
        double zeroTo100Coef =  1-assignCoef.assignCoefficient(findCloserInList.findCloser(f1.getZeroTo100(),timeList), timeList);
        zeroTo100Coef = (zeroTo100Coef * 2 + MoteursService.getMoteurCoef(f1.getMoteur())) / 3;
        return zeroTo100Coef;
    }
    public Double f1MoyenneCoef (int idF1){
        Optional<F1> f1Optional = repository.findById(idF1);
        if (f1Optional.isPresent()) {
            F1 f1 = f1Optional.get();
            return (getPoidsCoef(f1) + getManiabilityCoef(f1) + vMaxCoef(f1) + getZeroTo100Coef(f1))/4;
        } else {
            throwException.throwIllegalArgumentException("La F1 n'est pas présente en base");
            return null; // Just for the sake of compilation, this line will never be reached
        }

    }
}
