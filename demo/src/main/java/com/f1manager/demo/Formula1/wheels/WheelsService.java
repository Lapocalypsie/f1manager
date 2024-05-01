package com.f1manager.demo.Formula1.wheels;

import com.f1manager.demo.ErrorHandling.throwException;
import com.f1manager.demo.Formula1.Moteurs.Moteurs;
import com.f1manager.demo.Utils.assignCoef;
import com.f1manager.demo.Utils.findCloserInList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WheelsService {
    @Autowired
    private  wheelsRepository wheelsRepository;
    public  double getWheelsCoef(Wheels wheels){
        if (wheels.getPoidsPneus() < 0){
            throwException.throwIllegalArgumentException("Le poids des roues ne peut pas être négatif");
        }
        double[] poidsList = {37,38,39,40,41,42,43,44,45,46,47,48,49};
        return assignCoef.assignCoefficient(findCloserInList.findCloser(wheels.getPoidsPneus(), poidsList), poidsList);
    }
    public  Wheels getWheelsById(int id) {
        Optional<Wheels> wheelsOptional =  wheelsRepository.findById(id);
        if (wheelsOptional.isPresent()) {
            return wheelsOptional.get();
        } else {
            throwException.throwIllegalArgumentException("La roue n'est pas présent en base");
            return null;
        }
    }
    public Wheels saveWheels(Wheels wheels) {
        return wheelsRepository.save(wheels);
    }

    public List<Wheels> getAllWheels() {
        return wheelsRepository.findAll();
    }
    public Wheels createNewWheels(String nomRoue, double poidsPneus, double prixPneus, String typePneus){
        Wheels wheels = new Wheels(nomRoue, poidsPneus, prixPneus, typePneus);
        wheels.setCoefPneus(getWheelsCoef(wheels));
        saveWheels(wheels);
        return wheels;
    }
    public Wheels updatePoidsWheels(int idPneus, double poidsPneus){
        Wheels wheels = getWheelsById(idPneus);
        wheels.setPoidsPneus(poidsPneus);
        saveWheels(wheels);
        return wheels;
    }
    public Wheels updatePrixWheels(int idPneus, double prixPneus){
        Wheels wheels = getWheelsById(idPneus);
        wheels.setPrixUnitairePneus(prixPneus);
        saveWheels(wheels);
        return wheels;
    }

}
