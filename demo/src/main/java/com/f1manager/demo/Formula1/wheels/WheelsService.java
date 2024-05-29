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

    /**
     * Calcule le coefficient des roues en fonction de leur poids.
     *
     * @param wheels Les roues pour lesquelles on calcule le coefficient.
     * @return Le coefficient des roues.
     */
    public double getWheelsCoef(Wheels wheels) {
        Check.doitEtrePlusgrandQueZero(wheels.getPoidsPneus(), "poids des roues");
        double[] poidsList = Lists.getPoidsListWheels();
        Log.infoLog("getWheelsCoef : début calcul coefficient des roues");
        return assignCoef.assignCoefficient(findCloserInList.findCloser(wheels.getPoidsPneus(), poidsList), poidsList);
    }

    /**
     * Récupère des roues par leur identifiant.
     *
     * @param id L'identifiant des roues.
     * @return Les roues correspondant à l'identifiant donné.
     * @throws IllegalArgumentException si les roues ne sont pas trouvées.
     */
    public Wheels getWheelsById(int id) {
        Optional<Wheels> wheelsOptional = wheelsRepository.findById(id);
        if (wheelsOptional.isPresent()) {
            Log.traceLog("getWheelsById : la roue est bien présente en base");
            return wheelsOptional.get();
        } else {
            throwException.throwIllegalArgumentException("La roue n'est pas présente en base");
            return null;
        }
    }

    /**
     * Sauvegarde des roues dans le dépôt.
     *
     * @param wheels Les roues à sauvegarder.
     */
    public void saveWheels(Wheels wheels) {
        wheelsRepository.save(wheels);
    }

    /**
     * Récupère la liste de toutes les roues.
     *
     * @return La liste de toutes les roues.
     */
    public List<Wheels> getAllWheels() {
        return wheelsRepository.findAll();
    }

    /**
     * Crée de nouvelles roues et les sauvegarde dans le dépôt.
     *
     * @param nomRoue   Le nom des roues.
     * @param poidsPneus Le poids des pneus.
     * @param prixPneus  Le prix des pneus.
     * @param typePneus  Le type des pneus.
     * @param imagePneus L'image des pneus.
     * @param nivActuel  Le niveau actuel des roues.
     * @return Les nouvelles roues créées.
     */
    public Wheels createNewWheels(String nomRoue, double poidsPneus, int prixPneus, String typePneus, String imagePneus, int nivActuel) {
        Wheels wheels = new Wheels(nomRoue, poidsPneus, prixPneus, typePneus, imagePneus, nivActuel);
        wheels.setCoefPneus(getWheelsCoef(wheels));
        saveWheels(wheels);
        Log.infoLog("createNewWheels : la roue a bien été créée");
        return wheels;
    }

    /**
     * Met à jour le poids des pneus d'un ensemble de roues existant.
     *
     * @param idPneus    L'identifiant des pneus à mettre à jour.
     * @param poidsPneus Le nouveau poids des pneus.
     * @return Les roues mises à jour.
     * @throws IllegalArgumentException si le poids est inférieur ou égal à zéro.
     */
    public Wheels updatePoidsWheels(int idPneus, double poidsPneus) {
        Check.doitEtrePlusgrandQueZero(poidsPneus, "poids des pneus");
        Wheels wheels = getWheelsById(idPneus);
        wheels.setPoidsPneus(poidsPneus);
        saveWheels(wheels);
        Log.infoLog("updatePoidsWheels : le poids des pneus a bien été mis à jour");
        return wheels;
    }

    /**
     * Met à jour le prix des pneus d'un ensemble de roues existant.
     *
     * @param idPneus  L'identifiant des pneus à mettre à jour.
     * @param prixPneus Le nouveau prix des pneus.
     * @return Les roues mises à jour.
     * @throws IllegalArgumentException si le prix est inférieur ou égal à zéro.
     */
    public Wheels updatePrixWheels(int idPneus, int prixPneus) {
        Check.doitEtrePlusgrandQueZero(prixPneus, "prix des pneus");
        Wheels wheels = getWheelsById(idPneus);
        wheels.setPrixPneus(prixPneus);
        saveWheels(wheels);
        Log.infoLog("updatePrixWheels : le prix des roues a bien été mis à jour");
        return wheels;
    }

    /**
     * Augmente le niveau des roues et met à jour leur prix pour le prochain niveau.
     *
     * @param wheels Les roues dont le niveau doit être augmenté.
     */
    public void levelUpWheels(Wheels wheels) {
        wheels.setNivActuel(wheels.getNivActuel() + 1);
        wheels.setPrixPneus(Niveaux.getPrixNextUpdate(wheels.getNivActuel()));
        saveWheels(wheels);
    }
}
