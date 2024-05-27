package com.f1manager.demo.Formula1.Moteurs;

import com.f1manager.demo.Joueur.Joueur;
import com.f1manager.demo.Joueur.JoueurRepository;
import com.f1manager.demo.Joueur.JoueurService;
import com.f1manager.demo.Logging.Log;
import com.f1manager.demo.Utils.Check;
import com.f1manager.demo.Utils.Niveaux;
import com.f1manager.demo.Utils.assignCoef;
import com.f1manager.demo.Utils.findCloserInList;
import com.f1manager.demo.ErrorHandling.throwException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoteursService{

   @Autowired
    private MoteursRepository moteurRepository;
   @Autowired
    private JoueurService joueurService;

    public  Double getConsommationEscenceCoef(Moteurs moteur){
        if (moteur.getConsommationEssence() < 0) {
            throwException.throwIllegalArgumentException("La consommation du moteur ne peut pas être négative");
        }
        double[] consoList = {40.0,42.0,45.0,50.0,55.0};
        Log.infoLog("getConsommationEscenceCoef : début calcul du coefficient de consommation d'escence du moteur");
        return assignCoef.assignCoefficient(findCloserInList.findCloser(moteur.getConsommationEssence(),consoList), consoList);
    }
    public  Double getPuissanceCoef(Moteurs moteur){
        if (moteur.getPuissance() < 0){
            throwException.throwIllegalArgumentException("La puissance du moteur ne peut pas être négative");
        }
        double[] puissanceList = {750,800,850,900,950,1000,1001};
        Log.infoLog("getPuissanceCoef : début calcul du coefficient de la puissance du moteur");
        return assignCoef.assignCoefficient(findCloserInList.findCloser(moteur.getPuissance(),puissanceList), puissanceList);
    }
    public  Double getMoteurCoef(Moteurs moteurs){
        Double coef  = (getConsommationEscenceCoef(moteurs)+ getPuissanceCoef(moteurs))/2;
        Log.infoLog("getMoteurCoef les coefs du moteur valent " + coef);
        return coef;
    }
    public Moteurs getMoteurById(int id) {
        Optional<Moteurs> moteurOptional =  moteurRepository.findById(id);
        if (moteurOptional.isPresent()) {
            Log.traceLog("getMoteurById : le moteur est présent");
            return moteurOptional.get();
        } else {
            throwException.throwIllegalArgumentException("Le moteur n'est pas présent en base");
            return null;
        }
    }
    public void saveMoteur(Moteurs moteurs) {
        moteurRepository.save(moteurs);
    }

    public List<Moteurs> getAllMoteurs() {
        return moteurRepository.findAll();
    }

    public Moteurs createNewMoteur(String nomMoteur, double consomationEscence, double puissance, double prixMoteur, String imageMoteur, int nivActuel){
        Moteurs moteurs = new Moteurs(nomMoteur, consomationEscence, puissance, prixMoteur, imageMoteur, nivActuel);
        moteurs.setCoefMoteur(getMoteurCoef(moteurs));
        saveMoteur(moteurs);
        Log.infoLog("createNewMoteur : moteur Sauvegardé");
        return moteurs;
    }
    public Moteurs updatePuissanceMoteur(int idMoteur, double puissance){
        Check.doitEtrePlusgrandQueZero(puissance, "puissance du moteur");
        Moteurs moteurs = getMoteurById(idMoteur);
        moteurs.setPuissance(puissance);
        saveMoteur(moteurs);
        Log.infoLog("updatePuissanceMoteur : puissance du moteur mise à jour");
        return moteurs;
    }

    public Moteurs updateConsommationMoteur(int idMoteur, double consommation){
        Check.doitEtrePlusgrandQueZero(consommation, "consommation du moteur");
        Moteurs moteurs = getMoteurById(idMoteur);
        moteurs.setConsommationEssence(consommation);
        saveMoteur(moteurs);
        Log.infoLog("updateConsommationMoteur : consommation du moteur mise à jour");
        return moteurs;
    }
    public Moteurs updatePrixMoteur(int idMoteur, double prix){
        Check.doitEtrePlusgrandQueZero(prix, "prix du moteur");
        Moteurs moteurs = getMoteurById(idMoteur);
        moteurs.setPrixMoteur(prix);
        saveMoteur(moteurs);
        Log.infoLog("updatePrixMoteur : prix du moteur mis à jour");
        return moteurs;
    }

}
