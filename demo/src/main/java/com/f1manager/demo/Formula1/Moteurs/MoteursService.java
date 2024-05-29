package com.f1manager.demo.Formula1.Moteurs;

import com.f1manager.demo.Log.Log;
import com.f1manager.demo.Utils.*;
import com.f1manager.demo.ErrorHandling.throwException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoteursService {

    @Autowired
    private MoteursRepository moteurRepository;

    /**
     * Calcule le coefficient de consommation d'essence d'un moteur.
     *
     * @param moteur Le moteur pour lequel on calcule le coefficient.
     * @return Le coefficient de consommation d'essence du moteur.
     */
    public Double getConsommationEscenceCoef(Moteurs moteur) {
        Check.doitEtrePlusgrandQueZero(moteur.getConsommationEssence(), "consommation du moteur");
        double[] consoList = Lists.getConsoListMoteur();
        Log.infoLog("getConsommationEscenceCoef : début calcul du coefficient de consommation d'escence du moteur");
        return assignCoef.assignCoefficient(findCloserInList.findCloser(moteur.getConsommationEssence(), consoList), consoList);
    }

    /**
     * Calcule le coefficient de puissance d'un moteur.
     *
     * @param moteur Le moteur pour lequel on calcule le coefficient.
     * @return Le coefficient de puissance du moteur.
     */
    public Double getPuissanceCoef(Moteurs moteur) {
        Check.doitEtrePlusgrandQueZero(moteur.getPuissance(), "puissance du moteur");
        double[] puissanceList = Lists.getPuissanceListMoteur();
        Log.infoLog("getPuissanceCoef : début calcul du coefficient de la puissance du moteur");
        return assignCoef.assignCoefficient(findCloserInList.findCloser(moteur.getPuissance(), puissanceList), puissanceList);
    }

    /**
     * Calcule le coefficient global d'un moteur en fonction de sa consommation d'essence et de sa puissance.
     *
     * @param moteurs Le moteur pour lequel on calcule le coefficient global.
     * @return Le coefficient global du moteur.
     */
    public Double getMoteurCoef(Moteurs moteurs) {
        Double coef = (getConsommationEscenceCoef(moteurs) + getPuissanceCoef(moteurs)) / 2;
        Log.infoLog("getMoteurCoef les coefs du moteur valent " + coef);
        return coef;
    }

    /**
     * Récupère un moteur par son identifiant.
     *
     * @param id L'identifiant du moteur.
     * @return Le moteur correspondant à l'identifiant donné.
     * @throws IllegalArgumentException si le moteur n'est pas trouvé.
     */
    public Moteurs getMoteurById(int id) {
        Optional<Moteurs> moteurOptional = moteurRepository.findById(id);
        if (moteurOptional.isPresent()) {
            Log.traceLog("getMoteurById : le moteur est présent");
            return moteurOptional.get();
        } else {
            throwException.throwIllegalArgumentException("Le moteur n'est pas présent en base");
            return null;
        }
    }

    /**
     * Sauvegarde un moteur dans le dépôt.
     *
     * @param moteurs Le moteur à sauvegarder.
     */
    public void saveMoteur(Moteurs moteurs) {
        moteurRepository.save(moteurs);
    }

    /**
     * Récupère la liste de tous les moteurs.
     *
     * @return La liste de tous les moteurs.
     */
    public List<Moteurs> getAllMoteurs() {
        return moteurRepository.findAll();
    }

    /**
     * Crée un nouveau moteur et le sauvegarde dans le dépôt.
     *
     * @param nomMoteur          Le nom du moteur.
     * @param consomationEscence La consommation d'essence du moteur.
     * @param puissance          La puissance du moteur.
     * @param prixMoteur         Le prix du moteur.
     * @param imageMoteur        L'image du moteur.
     * @param nivActuel          Le niveau actuel du moteur.
     * @return Le nouveau moteur créé.
     */
    public Moteurs createNewMoteur(String nomMoteur, double consomationEscence, double puissance, int prixMoteur, String imageMoteur, int nivActuel) {
        Moteurs moteurs = new Moteurs(nomMoteur, consomationEscence, puissance, prixMoteur, imageMoteur, nivActuel);
        moteurs.setCoefMoteur(getMoteurCoef(moteurs));
        saveMoteur(moteurs);
        Log.infoLog("createNewMoteur : moteur Sauvegardé");
        return moteurs;
    }

    /**
     * Met à jour la puissance d'un moteur existant.
     *
     * @param idMoteur L'identifiant du moteur à mettre à jour.
     * @param puissance La nouvelle puissance du moteur.
     * @return Le moteur mis à jour.
     * @throws IllegalArgumentException si la puissance est inférieure ou égale à zéro.
     */
    public Moteurs updatePuissanceMoteur(int idMoteur, double puissance) {
        Check.doitEtrePlusgrandQueZero(puissance, "puissance du moteur");
        Moteurs moteurs = getMoteurById(idMoteur);
        moteurs.setPuissance(puissance);
        saveMoteur(moteurs);
        Log.infoLog("updatePuissanceMoteur : puissance du moteur mise à jour");
        return moteurs;
    }

    /**
     * Met à jour la consommation d'essence d'un moteur existant.
     *
     * @param idMoteur    L'identifiant du moteur à mettre à jour.
     * @param consommation La nouvelle consommation d'essence du moteur.
     * @return Le moteur mis à jour.
     * @throws IllegalArgumentException si la consommation est inférieure ou égale à zéro.
     */
    public Moteurs updateConsommationMoteur(int idMoteur, double consommation) {
        Check.doitEtrePlusgrandQueZero(consommation, "consommation du moteur");
        Moteurs moteurs = getMoteurById(idMoteur);
        moteurs.setConsommationEssence(consommation);
        saveMoteur(moteurs);
        Log.infoLog("updateConsommationMoteur : consommation du moteur mise à jour");
        return moteurs;
    }

    /**
     * Met à jour le prix d'un moteur existant.
     *
     * @param idMoteur L'identifiant du moteur à mettre à jour.
     * @param prix     Le nouveau prix du moteur.
     * @return Le moteur mis à jour.
     * @throws IllegalArgumentException si le prix est inférieur ou égal à zéro.
     */
    public Moteurs updatePrixMoteur(int idMoteur, int prix) {
        Check.doitEtrePlusgrandQueZero(prix, "prix du moteur");
        Moteurs moteurs = getMoteurById(idMoteur);
        moteurs.setPrixMoteur(prix);
        saveMoteur(moteurs);
        Log.infoLog("updatePrixMoteur : prix du moteur mis à jour");
        return moteurs;
    }

    /**
     * Augmente le niveau d'un moteur et met à jour son prix pour le prochain niveau.
     *
     * @param moteurs Le moteur dont le niveau doit être augmenté.
     */
    public void levelUpMoteurs(Moteurs moteurs) {
        moteurs.setNivActuel(moteurs.getNivActuel() + 1);
        moteurs.setPrixMoteur(Niveaux.getPrixNextUpdate(moteurs.getNivActuel()));
        saveMoteur(moteurs);
    }
}
