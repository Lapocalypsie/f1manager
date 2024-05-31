package com.f1manager.demo.Personnel.Mecanicien;

import com.f1manager.demo.ErrorHandling.throwException;
import com.f1manager.demo.Joueur.Joueur;
import com.f1manager.demo.Joueur.JoueurService;
import com.f1manager.demo.Log.Log;
import com.f1manager.demo.Personnel.PersonneService;
import com.f1manager.demo.Utils.CalculStats;
import com.f1manager.demo.systemeco.Achat;
import com.f1manager.demo.systemeco.Vente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service pour la gestion des mécaniciens.
 */
@Service
public class MecanicienService {

    @Autowired
    MecanicienRepository mecanicienRepository;
    @Autowired
    private JoueurService joueurService;

    /**
     * Enregistre un mécanicien en base de données.
     *
     * @param mecanicien le mécanicien à enregistrer.
     */
    public void saveMecanicien(Mecanicien mecanicien) {
        mecanicienRepository.save(mecanicien);
    }

    /**
     * Obtient la vitesse d'un mécanicien à partir de son identifiant.
     *
     * @param id l'identifiant du mécanicien.
     * @return la vitesse du mécanicien.
     */
    public double getVitesseMecanicienbyId(int id) {
        Mecanicien mecano = getMecanicienById(id);
        Log.traceLog("La vitesse du mécanicien est " + mecano.getVitesse());
        return mecano.getVitesse();
    }

    /**
     * Obtient la performance d'un mécanicien à partir de son identifiant.
     *
     * @param id l'identifiant du mécanicien.
     * @return la performance du mécanicien.
     */
    public double getPerformanceMecanicienbyId(int id) {
        Mecanicien mecano = getMecanicienById(id);
        Log.traceLog("La performance du mécanicien est " + mecano.getPerformance());
        return mecano.getPerformance();
    }

    /**
     * Crée un nouveau mécanicien avec les attributs spécifiés.
     *
     * @param nom         le nom du mécanicien.
     * @param prenom      le prénom du mécanicien.
     * @param level       le niveau du mécanicien.
     * @param vitesse     la vitesse du mécanicien.
     * @param performance la performance du mécanicien.
     * @param price       le prix du mécanicien.
     * @return le mécanicien créé.
     */
    public Mecanicien creerMecanicien(String nom, String prenom, int level, double vitesse, double performance, double price){
        boolean appartient = false;
        Mecanicien mecanicien = new Mecanicien(nom, prenom, level, vitesse, performance, price, appartient);
        mecanicien.setCoefficient(CalculStats.calculerCoefficientMecanicien(mecanicien));
        saveMecanicien(mecanicien);
        Log.traceLog("le mecanicien a bien été créé");
        return mecanicien;
    }

    /**
     * Obtient un mécanicien à partir de son identifiant.
     *
     * @param id l'identifiant du mécanicien.
     * @return le mécanicien trouvé.
     * @throws IllegalArgumentException si le mécanicien n'est pas présent en base.
     */
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

    /**
     * Augmente le niveau d'un mécanicien à partir de son identifiant.
     *
     * @param idMecanicien l'identifiant du mécanicien à mettre à jour.
     * @return le mécanicien mis à jour.
     */
    public Mecanicien upgradeMecanicien(int idMecanicien){
        Mecanicien mecanicien = getMecanicienById(idMecanicien);
        PersonneService.upgradePersonneLevel(mecanicien);
        saveMecanicien(mecanicien);
        Log.infoLog("Le mecanicien a bien été mis à jour");
        return mecanicien;
    }

    /**
     * Obtient le coefficient d'un mécanicien à partir de son identifiant.
     *
     * @param idMecanicien l'identifiant du mécanicien.
     * @return le coefficient du mécanicien.
     */
    public double getMecanicienCoef(int idMecanicien){
        Mecanicien mecanicien = getMecanicienById(idMecanicien);
        double coefficient = CalculStats.calculerCoefficientMecanicien(mecanicien);
        Log.traceLog("Le coefficient du mecanicient vaut " + coefficient);
        return coefficient;
    }

    /**
     * Achète un mécanicien pour un joueur à partir des identifiants du mécanicien et du joueur.
     *
     * @param idMecanicien l'identifiant du mécanicien à acheter.
     * @param idJoueur     l'identifiant du joueur qui achète le mécanicien.
     * @return le montant d'argent restant au joueur après l'achat.
     */
    public double buyMecanicien(int idMecanicien, int idJoueur) {
        Mecanicien mecanicien = getMecanicienById(idMecanicien);
        Joueur joueur = joueurService.getJoueurById(idJoueur);
        Achat.effectuerAchat(mecanicien, joueur);
        joueurService.saveJoueur(joueur);
        saveMecanicien(mecanicien);
        Log.infoLog("Le mecanicien à bien été acheté");
        return joueur.getArgent();
    }

    /**
     * Vend un mécanicien pour un joueur à partir des identifiants du mécanicien et du joueur.
     *
     * @param idMecanicien l'identifiant du mécanicien à vendre.
     */
    public double sellMecanicien(int idMecanicien, int idJoueur) {
        Mecanicien mecanicien = getMecanicienById(idMecanicien);
        Joueur joueur = joueurService.getJoueurById(idJoueur);
        Vente.effectuerVente(mecanicien, joueur);
        joueurService.saveJoueur(joueur);
        saveMecanicien(mecanicien);
        Log.infoLog("Le mecanicien à bien été vendu");
        return joueur.getArgent();
    }
}
