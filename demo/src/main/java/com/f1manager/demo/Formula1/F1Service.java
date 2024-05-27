package com.f1manager.demo.Formula1;

import com.f1manager.demo.Formula1.Aileron.Ailerons;
import com.f1manager.demo.Formula1.Aileron.AileronsService;
import com.f1manager.demo.ErrorHandling.throwException;
import com.f1manager.demo.Formula1.Moteurs.Moteurs;
import com.f1manager.demo.Formula1.Moteurs.MoteursService;
import com.f1manager.demo.Joueur.JoueurService;
import com.f1manager.demo.Logging.Log;
import com.f1manager.demo.Utils.Check;
import com.f1manager.demo.Utils.assignCoef;
import com.f1manager.demo.Utils.findCloserInList;
import com.f1manager.demo.Formula1.wheels.Wheels;
import com.f1manager.demo.Formula1.wheels.WheelsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class F1Service {

    @Autowired
    private F1Repository repository;
    private final MoteursService moteursService;
    private final AileronsService aileronsService;
    private final WheelsService wheelsService;
    private final JoueurService joueurService;


    public Double getManiabilityCoef(F1 f1) {
        double maniabilityCoef = f1.getManiabilty();
        maniabilityCoef = (maniabilityCoef * 2 + aileronsService.getAileronCoef(f1.getAilerons())) /3;
        Log.traceLog("getManiabilityCoef : le coefficient de maniabilité est " + maniabilityCoef);
        return maniabilityCoef;
    }

    public Double vMaxCoef(F1 f1) {
        Check.doitEtrePlusgrandQueZero(f1.getVitesseMax(), "vitesse max");
        double[] vitessList = {300, 310, 320, 330, 340, 350, 360};
        Log.infoLog("vMaxCoef : début calcul du coef de vMax");
        double vMaxCoeff =  assignCoef.assignCoefficient(findCloserInList.findCloser(f1.getVitesseMax(), vitessList), vitessList);
        vMaxCoeff = (vMaxCoeff * 2 + aileronsService.getAileronCoef(f1.getAilerons()) + moteursService.getMoteurCoef(f1.getMoteur()) + wheelsService.getWheelsCoef(f1.getWheels())) / 5;
        Log.infoLog("vMaxCoef : fin calcul du coef de vMax qui vaut " + vMaxCoeff);
        return vMaxCoeff;
    }
    public Double getPoidsCoef(F1 f1) {
        double poidsMinLogique = 200.0;
        if(f1.getPoidsF1() < poidsMinLogique){
            throwException.throwIllegalArgumentException("Le poids de la f1 ne peur pas être inférieure à " + poidsMinLogique + "kg");
        }
        double[] poidsList = {798,800,810,830,850};
        Log.infoLog("getPoidsCoef : début calcul du coef de poids");
        double poidsCoef =  1-assignCoef.assignCoefficient(findCloserInList.findCloser(f1.getPoidsF1(),poidsList), poidsList);
        poidsCoef = (poidsCoef*6 + aileronsService.getAileronCoef(f1.getAilerons()) + moteursService.getMoteurCoef(f1.getMoteur()) + wheelsService.getWheelsCoef(f1.getWheels())) / 9;
        Log.infoLog("getPoidsCoef : fin calcul du coef de poids qui vaut " + poidsCoef );
        return poidsCoef;
    }
    public Double getZeroTo100Coef(F1 f1) {
        Check.doitEtrePlusgrandQueZero(f1.getZeroTo100(), "zéro à 100");
        double[] timeList = {1.46,1.5,1.6,1.7,1.9,2.0,2.1,2.2,2.3,2.4,2.5,2.6,2.7,2.8};
        Log.infoLog("getZeroTo100Coef : début calcul du coef de zéro à 100");
        double zeroTo100Coef =  1-assignCoef.assignCoefficient(findCloserInList.findCloser(f1.getZeroTo100(),timeList), timeList);
        zeroTo100Coef = (zeroTo100Coef * 2 + moteursService.getMoteurCoef(f1.getMoteur())) / 3;
        Log.infoLog(("getZeroTo100Coef : fin calcul du coef de zéro à 100 qui vaut " + zeroTo100Coef));
        return zeroTo100Coef;
    }

    public Double f1MoyenneCoef (int idF1){
        F1 f1 = getF1ById(idF1);
        return (getPoidsCoef(f1) + getManiabilityCoef(f1) + vMaxCoef(f1) + getZeroTo100Coef(f1))/4;
    }
    public Double f1MoyenneCoef (F1 f1){
        return (getPoidsCoef(f1) + getManiabilityCoef(f1) + vMaxCoef(f1) + getZeroTo100Coef(f1))/4;
    }

    public F1 saveF1(F1 f1) {
        return repository.save(f1);
    }

    public List<F1> getAllF1() {
        return repository.findAll();
    }
    public F1 getF1ById(int id) {
        Optional<F1> f1Oprional =  repository.findById(id);
        if (f1Oprional.isPresent()) {
            Log.traceLog("getF1ById : la F1 est bien présente en base");
            return f1Oprional.get();
        } else {
            throwException.throwIllegalArgumentException("La F1 n'est pas présent en base");
            return null;
        }
    }
    /*
    Pour créer une nouvelle f1, on créé d'abord un moteur en le récupérant en base avec son ID
    On fait de même pour l'aileron et les roues. Ensuite, on créé une f1 sans coefficent à l'aide du
    constructeur ne contenant pas de coef de la classe F1. On lui assigne ensuite le coefficient avec un setCoef
    qui va calculer ce coefficient puis on enregistre le f1 en base et on la renvoie au cas ou l'utilisateur en
    aurait besoin.
     */
    public F1 createNewF1(double poidsF1, double vitesseMax, double zeroTo100,
                           int maniabilty,  int wheelsId,  int moteurId, int aileronsId, String imageF1){
        Moteurs moteur = moteursService.getMoteurById(moteurId);
        Ailerons aileron = aileronsService.getAileronsById(aileronsId);
        Wheels wheel = wheelsService.getWheelsById(wheelsId);
        F1 f1 = new F1(poidsF1, vitesseMax, zeroTo100, maniabilty,wheel, moteur, aileron, imageF1);
        f1.setCoef(f1MoyenneCoef(f1));
        saveF1(f1);
        Log.infoLog("createNewF1 : la F1 est bien créée en base");
        return f1;
    }
    public F1 changeMoteurF1(int idF1, int idMoteur){
        F1 f1 = getF1ById(idF1);
        Moteurs moteur = moteursService.getMoteurById(idMoteur);
        f1.setMoteur(moteur);
        Log.infoLog("changeMoteurF1 : le moteur a bien été changé");
        return f1;
    }
    public F1 changeAileronF1(int ifF1, int idAileron){
        F1 f1 = getF1ById(ifF1);
        Ailerons ailerons = aileronsService.getAileronsById(idAileron);
        f1.setAilerons(ailerons);
        Log.infoLog("changeAileronF1 : l'aileron a bien été changé");
        return f1;
    }
    public F1 changeWheelsF1(int idF1, int idWheels){
        F1 f1 = getF1ById(idF1);
        Wheels wheels = wheelsService.getWheelsById(idWheels);
        f1.setWheels(wheels);
        saveF1(f1);
        Log.infoLog("changeWheelsF1 : les roues ont bien été changées");
        return f1;
    }
    public F1 changeManiabilityF1(int idF1, double maniability){
        Check.doitEtrePlusgrandQueZero(maniability, "maniabilité");
        F1 f1 = getF1ById(idF1);
        f1.setManiabilty(maniability);
        saveF1(f1);
        Log.infoLog("changeManiabilityF1 : la maniabilité a bien été changée");
        return f1;
    }
    public F1 changeZeroTo100(int idF1, double zeroTo100){
        Check.doitEtrePlusgrandQueZero(zeroTo100, "zéro a 100");
        F1 f1 = getF1ById(idF1);
        f1.setZeroTo100(zeroTo100);
        saveF1(f1);
        Log.infoLog("changeZeroTo100 : le zéro à 100 de la F1 a bien été changé");
        return f1;
    }
    public F1 changeVitesseMax(int idF1, double vitesseMax){
        Check.doitEtrePlusgrandQueZero(vitesseMax, "vitesse maximum de la F1");
        F1 f1 = getF1ById(idF1);
        f1.setVitesseMax(vitesseMax);
        Log.infoLog("changeVitesseMax :  la vitesse max de la F1 a bien été changée");
        return f1;
    }
    public double levelUpWheels(int idF1, int idJoueur) {
        F1 f1 = getF1ById(idF1);
        Wheels wheels = wheelsService.getWheelsById(f1.getWheels().getId());
        if(joueurService.isAchatPossible(wheels,idJoueur)){
            wheelsService.levelUpWheels(wheels);
            System.out.println("La montée de niveau de ces roues a été effectué");
        }else {
        throwException.throwIllegalArgumentException("Vous n'avez pas assez d'argent pour effectuer cette montée de niveau.");
    }
        return wheels.getNivActuel();
    }

    public double levelUpMoteur(int idF1, int idJoueur) {
        F1 f1 = getF1ById(idF1);
        Moteurs moteurs = moteursService.getMoteurById(f1.getMoteur().getId());
        if (joueurService.isAchatPossible(moteurs, idJoueur)) {
            moteursService.levelUpMoteurs(moteurs);
            System.out.println("La montée de niveau de ce moteur a été effectué");
        } else {
            throwException.throwIllegalArgumentException("Vous n'avez pas assez d'argent pour effectuer cette montée de niveau.");
        }
        return moteurs.getNivActuel();
    }

    public double levelUpAileron(int idF1, int idJoueur) {
        F1 f1 = getF1ById(idF1);
        Ailerons ailerons = aileronsService.getAileronsById(f1.getAilerons().getId());
        if(joueurService.isAchatPossible(ailerons, idJoueur)){
            aileronsService.levelUpAilerons(ailerons);
            System.out.println("La montée de niveau de cet aileron a été effectué");
        }
        else {
                throwException.throwIllegalArgumentException("Vous n'avez pas assez d'argent pour effectuer cette montée de niveau.");
            }
        return ailerons.getNivActuel();
    }
}
