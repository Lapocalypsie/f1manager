package com.f1manager.demo.Formula1.Aileron;

import com.f1manager.demo.ErrorHandling.throwException;
import com.f1manager.demo.Joueur.Joueur;
import com.f1manager.demo.Joueur.JoueurService;
import com.f1manager.demo.Logging.Log;
import com.f1manager.demo.Utils.Check;
import com.f1manager.demo.Utils.Niveaux;
import com.f1manager.demo.Utils.assignCoef;
import com.f1manager.demo.Utils.findCloserInList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AileronsService {
    @Autowired
    private  AileronsRepository aileronsRepository;
    @Autowired
    private JoueurService joueurService;
    public  Double getAileronCoef(Ailerons ailerons){
        if (ailerons.getPoidsAileron() < 0){
            throwException.throwIllegalArgumentException("Le poids de l'ailron ne peut pas être négatif");
        }
        double[] poidsListe = {300,310,320,330,340,350,360};
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

    public Ailerons createNewAileron(double poids, double prixAileron, String imageAileron, int nivActuel){
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

    public Ailerons updatePrixAileron(int idAileron, double prix){
        Check.doitEtrePlusgrandQueZero(prix, "prix de l'aileron");
        Ailerons ailerons = getAileronsById(idAileron);
        ailerons.setPrixAileron(prix);
        saveAileron(ailerons);
        Log.infoLog("updatePrixAileron : aileron Sauvegardé");
        return ailerons;
    }




}
