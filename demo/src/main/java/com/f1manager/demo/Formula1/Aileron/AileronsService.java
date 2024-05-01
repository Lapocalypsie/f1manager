package com.f1manager.demo.Formula1.Aileron;

import com.f1manager.demo.ErrorHandling.throwException;
import com.f1manager.demo.Formula1.Moteurs.Moteurs;
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
            return aileronOptional.get();
        } else {
            throwException.throwIllegalArgumentException("L'aileron n'est pas présent en base");
            return null;
        }
    }
    public Ailerons saveAileron(Ailerons ailerons) {
        return aileronsRepository.save(ailerons);
    }

    public List<Ailerons> getAllAilerons() {
        return aileronsRepository.findAll();
    }
    public Ailerons createNewAileron(double poids){
        Ailerons ailerons = new Ailerons(poids);
        ailerons.setCoefAileron(getAileronCoef(ailerons));
        saveAileron(ailerons);
        return ailerons;
    }
    public Ailerons updatePoidsAileron(int idAileron, double poids){
        Ailerons ailerons = getAileronsById(idAileron);
        ailerons.setPoidsAileron(poids);
        saveAileron(ailerons);
        return ailerons;
    }
}
