package com.f1manager.demo.Formula1.Aileron;

import com.f1manager.demo.Formula1.ErrorHandling.throwException;
import com.f1manager.demo.Formula1.Moteurs.Moteurs;
import com.f1manager.demo.Formula1.Utils.assignCoef;
import com.f1manager.demo.Formula1.Utils.findCloserInList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
