package com.f1manager.demo.Formula1.Aileron;

import com.f1manager.demo.ErrorHandling.throwException;
import com.f1manager.demo.Log.Log;
import com.f1manager.demo.Utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AileronsService {

    @Autowired
    private AileronsRepository aileronsRepository;

    /**
     * Calcule le coefficient d'un aileron en fonction de son poids.
     *
     * @param ailerons L'aileron dont on veut calculer le coefficient.
     * @return Le coefficient de l'aileron.
     */
    public Double getAileronCoef(Ailerons ailerons){
        Check.doitEtrePlusgrandQueZero(ailerons.getPoidsAileron(), "poide de l'aileron");
        double[] poidsListe = Lists.getPoidsListeAilerons();
        return assignCoef.assignCoefficient(findCloserInList.findCloser(ailerons.getPoidsAileron(), poidsListe), poidsListe);
    }

    /**
     * Récupère un aileron par son identifiant.
     *
     * @param id L'identifiant de l'aileron.
     * @return L'aileron correspondant à l'identifiant donné.
     * @throws IllegalArgumentException si l'aileron n'est pas trouvé.
     */
    public Ailerons getAileronsById(int id) {
        Optional<Ailerons> aileronOptional = aileronsRepository.findById(id);
        if (aileronOptional.isPresent()) {
            Log.traceLog("getAileronsById : le moteur est présent");
            return aileronOptional.get();
        } else {
            throwException.throwIllegalArgumentException("L'aileron n'est pas présent en base");
            return null;
        }
    }

    /**
     * Sauvegarde un aileron dans le dépôt.
     *
     * @param ailerons L'aileron à sauvegarder.
     */
    public void saveAileron(Ailerons ailerons) {
        aileronsRepository.save(ailerons);
    }

    /**
     * Récupère la liste de tous les ailerons.
     *
     * @return La liste de tous les ailerons.
     */
    public List<Ailerons> getAllAilerons() {
        return aileronsRepository.findAll();
    }

    /**
     * Crée un nouvel aileron et le sauvegarde dans le dépôt.
     *
     * @param poids Le poids de l'aileron.
     * @param prixAileron Le prix de l'aileron.
     * @param imageAileron L'image de l'aileron.
     * @param nivActuel Le niveau actuel de l'aileron.
     * @return Le nouvel aileron créé.
     */
    public Ailerons createNewAileron(double poids, int prixAileron, String imageAileron, int nivActuel){
        Ailerons ailerons = new Ailerons(poids, prixAileron, imageAileron, nivActuel);
        ailerons.setCoefAileron(getAileronCoef(ailerons));
        saveAileron(ailerons);
        Log.infoLog("createNewAIleron : aileron Sauvegardé");
        return ailerons;
    }

    /**
     * Met à jour le poids d'un aileron existant.
     *
     * @param idAileron L'identifiant de l'aileron à mettre à jour.
     * @param poids Le nouveau poids de l'aileron.
     * @return L'aileron mis à jour.
     * @throws IllegalArgumentException si le poids est inférieur ou égal à zéro.
     */
    public Ailerons updatePoidsAileron(int idAileron, double poids){
        Check.doitEtrePlusgrandQueZero(poids, "poids de l'aileron");
        Ailerons ailerons = getAileronsById(idAileron);
        ailerons.setPoidsAileron(poids);
        saveAileron(ailerons);
        Log.infoLog("updatePoidsAileron : aileron Sauvegardé");
        return ailerons;
    }

    /**
     * Met à jour le prix d'un aileron existant.
     *
     * @param idAileron L'identifiant de l'aileron à mettre à jour.
     * @param prix Le nouveau prix de l'aileron.
     * @return L'aileron mis à jour.
     * @throws IllegalArgumentException si le prix est inférieur ou égal à zéro.
     */
    public Ailerons updatePrixAileron(int idAileron, int prix){
        Check.doitEtrePlusgrandQueZero(prix, "prix de l'aileron");
        Ailerons ailerons = getAileronsById(idAileron);
        ailerons.setPrixAileron(prix);
        saveAileron(ailerons);
        Log.infoLog("updatePrixAileron : aileron Sauvegardé");
        return ailerons;
    }

    /**
     * Augmente le niveau d'un aileron et met à jour son prix pour le prochain niveau.
     *
     * @param ailerons L'aileron dont le niveau doit être augmenté.
     */
    public void levelUpAilerons(Ailerons ailerons){
        ailerons.setNivActuel(ailerons.getNivActuel() + 1);
        ailerons.setPrixAileron(Niveaux.getPrixNextUpdate(ailerons.getNivActuel()));
        saveAileron(ailerons);
    }
}
