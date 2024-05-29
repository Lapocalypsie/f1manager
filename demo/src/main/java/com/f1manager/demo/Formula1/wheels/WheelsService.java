package com.f1manager.demo.Formula1.wheels;

import com.f1manager.demo.ErrorHandling.throwException;
import com.f1manager.demo.Log.Log;
import com.f1manager.demo.Utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WheelsService {
    @Autowired
    private WheelsRepository wheelsRepository;
    public  double getWheelsCoef(Wheels wheels){
        Check.doitEtrePlusgrandQueZero(wheels.getPoidsPneus(), "poids des roues");
        double[] poidsList = Lists.getPoidsListWheels();
        Log.infoLog("getWheelsCoef : début calcul coefficient des roues");
        return assignCoef.assignCoefficient(findCloserInList.findCloser(wheels.getPoidsPneus(), poidsList), poidsList);
    }
    public  Wheels getWheelsById(int id) {
        Optional<Wheels> wheelsOptional =  wheelsRepository.findById(id);
        if (wheelsOptional.isPresent()) {
            Log.traceLog("getWheelsById : la roue est bien présente en base");
            return wheelsOptional.get();
        } else {
            throwException.throwIllegalArgumentException("La roue n'est pas présent en base");
            return null;
        }
    }
    public void saveWheels(Wheels wheels) {
        wheelsRepository.save(wheels);
    }

    public List<Wheels> getAllWheels() {
        return wheelsRepository.findAll();
    }
    public Wheels createNewWheels(String nomRoue, double poidsPneus, int prixPneus, String typePneus, String imagePneus, int nivActuel){
        Wheels wheels = new Wheels(nomRoue, poidsPneus, prixPneus, typePneus, imagePneus, nivActuel);
        wheels.setCoefPneus(getWheelsCoef(wheels));
        saveWheels(wheels);
        Log.infoLog("createNewWheels : la roue a bien été créée");
        return wheels;
    }
    public Wheels updatePoidsWheels(int idPneus, double poidsPneus){
        Check.doitEtrePlusgrandQueZero(poidsPneus, "poids des pneus");
        Wheels wheels = getWheelsById(idPneus);
        wheels.setPoidsPneus(poidsPneus);
        saveWheels(wheels);
        Log.infoLog("updatePoidsWheels le poids de la voiture a bien été mis à jour");
        return wheels;
    }
    public Wheels updatePrixWheels(int idPneus, int prixPneus){
        Check.doitEtrePlusgrandQueZero(prixPneus, "prix des pneus");
        Wheels wheels = getWheelsById(idPneus);
        wheels.setPrixPneus(prixPneus);
        saveWheels(wheels);
        Log.infoLog("updatePrixWheels : le prix des roues à bien été mis à jour");
        return wheels;
    }
    public void levelUpWheels(Wheels wheels){
        wheels.setNivActuel(wheels.getNivActuel() + 1);
        wheels.setPrixPneus(Niveaux.getPrixNextUpdate(wheels.getNivActuel()));
        saveWheels(wheels);
    }
}
