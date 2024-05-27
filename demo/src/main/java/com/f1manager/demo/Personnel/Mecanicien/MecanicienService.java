package com.f1manager.demo.Personnel.Mecanicien;

import com.f1manager.demo.ErrorHandling.throwException;
import com.f1manager.demo.Joueur.Joueur;
import com.f1manager.demo.Joueur.JoueurService;
import com.f1manager.demo.Logging.Log;
import com.f1manager.demo.Personnel.PersonneService;
import com.f1manager.demo.Utils.CalculStats;
import com.f1manager.demo.systemeco.Achat;
import com.f1manager.demo.systemeco.Vente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MecanicienService {
    @Autowired
    MecanicienRepository mecanicienRepository;
    @Autowired
    private JoueurService joueurService;

    public void saveMecanicien(Mecanicien mecanicien) {
        mecanicienRepository.save(mecanicien);
    }
    public double getVitesseMecanicienbyId(int id) {
        Mecanicien mecano = getMecanicienById(id);
        Log.traceLog("La vitesse du mecanicien est " + mecano.getVitesse());
        return mecano.getVitesse();
    }

    public double getPerformanceMecanicienbyId(int id) {
        Mecanicien mecano = getMecanicienById(id);
        Log.traceLog("La performance du mecano est " + mecano.getPerformance());
        return mecano.getPerformance();
    }

    public Mecanicien creerMecanicien(String nom, String prenom, int level, double vitesse, double performance, double price, boolean appartient){
        Mecanicien mecanicien = new Mecanicien(nom, prenom, level, vitesse, performance, price, appartient);
        mecanicien.setCoefficient(CalculStats.calculerCoefficientMecanicien(mecanicien));
        saveMecanicien(mecanicien);
        Log.traceLog("le mecanicien a bien été créé");
        return mecanicien;
    }
    public Mecanicien getMecanicienById(int id) {
        Optional<Mecanicien> mecanicienOprional =  mecanicienRepository.findById(id);
        if (mecanicienOprional.isPresent()) {
            Log.traceLog("Le mecanicicn à été trouvé");
            return mecanicienOprional.get();
        } else {
            throwException.throwIllegalArgumentException("Le mécanicien n'est pas présent en base");
            return null;
        }
    }
    public Mecanicien upgradeMecanicien(int idMecanicien){
        Mecanicien mecanicien = getMecanicienById(idMecanicien);
        PersonneService.upgradePersonneLevel(mecanicien);
        saveMecanicien(mecanicien);
        Log.infoLog("Le mecanicien a bien été mis à jour");
        return mecanicien;
    }
    public double getMecanicienCoef(int idMecanicien){
        Mecanicien mecanicien = getMecanicienById(idMecanicien);
        double coefficient = CalculStats.calculerCoefficientMecanicien(mecanicien);
        Log.traceLog("Le coefficient du mecanicient vaut " + coefficient);
        return coefficient;
    }
    public double buyMecanicien(int idMecanicien, int idJoueur) {
        Mecanicien mecanicien = getMecanicienById(idMecanicien);
        Joueur joueur = joueurService.getJoueurById(idJoueur);
        Achat.effectuerAchat(mecanicien, joueur);
        Log.infoLog("Le mecanicien à bien été acheté");
        return joueur.getArgent();
    }

    public double sellMecanicien(int idMecanicien, int idJoueur) {
        Mecanicien mecanicien = getMecanicienById(idMecanicien);
        Joueur joueur = joueurService.getJoueurById(idJoueur);
        Vente.effectuerVente(mecanicien, joueur);
        Log.infoLog("Le mecanicien à bien été vendu");
        return joueur.getArgent();
    }
}
