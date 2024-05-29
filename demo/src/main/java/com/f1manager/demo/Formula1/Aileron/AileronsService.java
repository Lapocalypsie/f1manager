package com.f1manager.demo.Formula1.Aileron;

import com.f1manager.demo.ErrorHandling.throwException;
import com.f1manager.demo.Log.Log;
import com.f1manager.demo.Utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AileronsService {
    @Autowired
    private  AileronsRepository aileronsRepository;

    public  Double getAileronCoef(Ailerons ailerons){
        Check.doitEtrePlusgrandQueZero(ailerons.getPoidsAileron(), "poide de l'aileron");
        double[] poidsListe = Lists.getPoidsListeAilerons();
        return assignCoef.assignCoefficient(findCloserInList.findCloser(ailerons.getPoidsAileron(), poidsListe), poidsListe);
    }
    public  Ailerons getAileronsById(int id) {
        Optional<Ailerons> aileronOptional = aileronsRepository.findById(id);
        if (aileronOptional.isPresent()) {
            Log.traceLog("getAileronsById : le moteur est présent");
            return aileronOptional.get();
        } else {
            throwException.throwIllegalArgumentException("L'aileron n'est pas présent en base");
            return null;
        }
    }
    public void saveAileron(Ailerons ailerons) {
        aileronsRepository.save(ailerons);
    }

    public List<Ailerons> getAllAilerons() {
        return aileronsRepository.findAll();
    }

    public Ailerons createNewAileron(double poids, int prixAileron, String imageAileron, int nivActuel){
        Ailerons ailerons = new Ailerons(poids, prixAileron, imageAileron, nivActuel);
        ailerons.setCoefAileron(getAileronCoef(ailerons));
        saveAileron(ailerons);
        Log.infoLog("createNewAIleron : aileron Sauvegardé");
        return ailerons;
    }
    public Ailerons updatePoidsAileron(int idAileron, double poids){
        Check.doitEtrePlusgrandQueZero(poids, "poids de l'aileron");
        Ailerons ailerons = getAileronsById(idAileron);
        ailerons.setPoidsAileron(poids);
        saveAileron(ailerons);
        Log.infoLog("updatePoidsAileron : aileron Sauvegardé");
        return ailerons;
    }

    public Ailerons updatePrixAileron(int idAileron, int prix){
        Check.doitEtrePlusgrandQueZero(prix, "prix de l'aileron");
        Ailerons ailerons = getAileronsById(idAileron);
        ailerons.setPrixAileron(prix);
        saveAileron(ailerons);
        Log.infoLog("updatePrixAileron : aileron Sauvegardé");
        return ailerons;
    }
    public void levelUpAilerons(Ailerons ailerons){
        ailerons.setNivActuel(ailerons.getNivActuel() + 1);
        ailerons.setPrixAileron(Niveaux.getPrixNextUpdate(ailerons.getNivActuel()));
        saveAileron(ailerons);
    }

}
