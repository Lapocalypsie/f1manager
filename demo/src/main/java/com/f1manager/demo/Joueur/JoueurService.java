package com.f1manager.demo.Joueur;

import com.f1manager.demo.ErrorHandling.throwException;
import com.f1manager.demo.Formula1.Aileron.Ailerons;
import com.f1manager.demo.Formula1.Moteurs.Moteurs;
import com.f1manager.demo.Formula1.wheels.Wheels;
import com.f1manager.demo.Log.Log;
import com.f1manager.demo.Utils.Check;
import com.f1manager.demo.Utils.Niveaux;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JoueurService {

    private final JoueurRepository joueurRepository;

    /**
     * Sauvegarde un joueur dans le repository.
     *
     * @param joueur Le joueur à sauvegarder
     * @return Le joueur sauvegardé
     */
    public Joueur saveJoueur(Joueur joueur) {
        return joueurRepository.save(joueur);
    }

    /**
     * Récupère tous les joueurs depuis le repository.
     *
     * @return La liste de tous les joueurs
     */
    public List<Joueur> getAllJoueurs() {
        return joueurRepository.findAll();
    }

    /**
     * Récupère un joueur par son identifiant.
     *
     * @param id L'identifiant du joueur
     * @return Le joueur correspondant à l'identifiant
     */
    public Joueur getJoueurById(int id) {
        Optional<Joueur> joueurOptional =  joueurRepository.findById(id);
        if (joueurOptional.isPresent()) {
            Log.traceLog("Le joueur est présent en base");
            return joueurOptional.get();
        } else {
            throwException.throwIllegalArgumentException("Le joueur n'est pas présent en base");
            return null;
        }
    }

    /**
     * Augmente le niveau d'un joueur si les conditions sont remplie : le joueur a assez d'xp pour monter de niveau
     *
     * @param idJoueur L'identifiant du joueur
     */
    public void monterDeNiveauJoueur(int idJoueur){
        Joueur joueur = getJoueurById(idJoueur);
        if (Niveaux.isLevelUp(joueur.getNivActuel(), joueur.getXpActuelle())){
            Log.traceLog("Le joueur peut monter de niveau");
            joueur.setXpActuelle(joueur.getXpActuelle() - Niveaux.nextLevel(joueur.getNivActuel()));
            joueur.setNivActuel(joueur.getNivActuel() + 1);
            saveJoueur(joueur);
        }
    }

    /**
     * Ajoute de l'XP à un joueur et vérifie s'il peut monter de niveau.
     *
     * @param idJoueur L'identifiant du joueur
     * @param quantite La quantité d'XP à ajouter
     * @return Le joueur mis à jour
     */
    public Joueur gagnerXp(int idJoueur, int quantite){
        Check.doitEtrePlusgrandQueZero(quantite, "xp");
        Joueur joueur = getJoueurById(idJoueur);
        joueur.setXpActuelle(joueur.getXpActuelle() + quantite);
        saveJoueur(joueur);
        monterDeNiveauJoueur(idJoueur);
        Log.infoLog("L'xp a été ajoutée");
        return joueur;
    }

    /**
     * Crée un nouveau joueur avec un nom et un prénom.
     *
     * @param nom Le nom du joueur
     * @param prenom Le prénom du joueur
     * @return Le joueur créé
     */
    public Joueur creerJoueur(String nom, String prenom){
        Joueur joueur = new Joueur(nom, prenom);
        saveJoueur(joueur);
        Log.infoLog("Le joueur à été créé");
        return joueur;
    }

    /**
     * Vérifie si un achat de roues est possible pour un joueur (surchargé pour les roues)
     *
     * @param wheels Les roues à acheter
     * @param idJoueur L'identifiant du joueur
     * @return true si l'achat est possible, sinon false
     */
    public boolean isAchatPossible(Wheels wheels, int idJoueur){
        if(!Niveaux.isAmeliorationPossible(wheels.getNivActuel())){
            Log.errorLog("Le niveau des roues est déjà au maximum");
            return false;
        }
        Joueur joueur = getJoueurById(idJoueur);
        double prixPourProchainNiveau = Niveaux.nextLevel(wheels.getNivActuel());
        if(joueur.getArgent() >= prixPourProchainNiveau){
            joueur.setArgent(joueur.getArgent() - prixPourProchainNiveau);
            saveJoueur(joueur);
            Log.infoLog("L'achat est possible");
            return true;
        }
        Log.infoLog("L'achat est impossible");
        return false;
    }

    /**
     * Vérifie si un achat de moteur est possible pour un joueur (surchargé pour le moteur)
     *
     * @param moteur Le moteur à acheter
     * @param idJoueur L'identifiant du joueur
     * @return true si l'achat est possible, sinon false
     */
    public boolean isAchatPossible(Moteurs moteur, int idJoueur){
        if(!Niveaux.isAmeliorationPossible(moteur.getNivActuel())){
            Log.errorLog("Le niveau du moteur est déjà au maximum");
            return false;
        }
        Joueur joueur = getJoueurById(idJoueur);
        double prixPourProchainNiveau = Niveaux.nextLevel(moteur.getNivActuel());
        if(joueur.getArgent() >= prixPourProchainNiveau){
            joueur.setArgent(joueur.getArgent() - prixPourProchainNiveau);
            saveJoueur(joueur);
            Log.infoLog("L'achat est possible");
            return true;
        }
        Log.infoLog("L'achat est impossible");
        return false;
    }

    /**
     * Vérifie si un achat d'ailerons est possible pour un joueur (surchargé pour l'aileron)
     *
     * @param ailerons L'ailerons à acheter
     * @param idJoueur L'identifiant du joueur
     * @return true si l'achat est possible, sinon false
     */
    public boolean isAchatPossible(Ailerons ailerons, int idJoueur){
        if(!Niveaux.isAmeliorationPossible(ailerons.getNivActuel())){
            Log.errorLog("Le niveau de l'aileron est déjà au maximum");
            return false;
        }
        Joueur joueur = getJoueurById(idJoueur);
        double prixPourProchainNiveau = Niveaux.nextLevel(ailerons.getNivActuel());
        if(joueur.getArgent() >= prixPourProchainNiveau){
            joueur.setArgent(joueur.getArgent() - prixPourProchainNiveau);
            saveJoueur(joueur);
            Log.infoLog("L'achat est possible");
            return true;
        }
        Log.infoLog("L'achat est impossible");
        return false;
    }
}
