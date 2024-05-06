package com.f1manager.demo.Formula1.wheels;

import com.f1manager.demo.ErrorHandling.throwException;
import com.f1manager.demo.Formula1.Moteurs.Moteurs;
import com.f1manager.demo.Joueur.Joueur;
import com.f1manager.demo.Joueur.JoueurService;
import com.f1manager.demo.Utils.Check;
import com.f1manager.demo.Utils.assignCoef;
import com.f1manager.demo.Utils.findCloserInList;
import com.f1manager.demo.systemeco.MonteeDeNiveau;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WheelsService {
    @Autowired
    private  wheelsRepository wheelsRepository;
    @Autowired
    private JoueurService joueurService;

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
    public Wheels createNewWheels(String nomRoue, double poidsPneus, double prixPneus, String typePneus, String imagePneus, int nivActuel){
        Wheels wheels = new Wheels(nomRoue, poidsPneus, prixPneus, typePneus, imagePneus, nivActuel);
        wheels.setCoefPneus(getWheelsCoef(wheels));
        saveWheels(wheels);
        return wheels;
    }
    public Wheels updatePoidsWheels(int idPneus, double poidsPneus){
        Check.doitEtrePlusgrandQueZero(poidsPneus, "poids des pneus");
        Wheels wheels = getWheelsById(idPneus);
        wheels.setPoidsPneus(poidsPneus);
        saveWheels(wheels);
        return wheels;
    }
    public Wheels updatePrixWheels(int idPneus, double prixPneus){
        Check.doitEtrePlusgrandQueZero(prixPneus, "prix des pneus");
        Wheels wheels = getWheelsById(idPneus);
        wheels.setPrixPneus(prixPneus);
        saveWheels(wheels);
        return wheels;
    }
    public double levelUpWheels(int idWheels, int idJoueur) {
        Wheels wheels = getWheelsById(idWheels);
        Joueur joueur = joueurService.getJoueurById(idJoueur);
        MonteeDeNiveau.monteeWheels(wheels, joueur);
        return joueur.getArgent();
    }

}
