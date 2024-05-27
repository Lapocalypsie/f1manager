package com.f1manager.demo.Joueur;

import com.f1manager.demo.ErrorHandling.throwException;
import com.f1manager.demo.Formula1.Aileron.Ailerons;
import com.f1manager.demo.Formula1.Moteurs.Moteurs;
import com.f1manager.demo.Formula1.wheels.Wheels;
import com.f1manager.demo.Logging.Log;
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

    public Joueur saveJoueur(Joueur joueur) {
        return joueurRepository.save(joueur);
    }

    public List<Joueur> getAllJoueurs() {
        return joueurRepository.findAll();
    }

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
    public void monterDeNiveauJoueur(int idJoueur){
        Joueur joueur = getJoueurById(idJoueur);
        if (Niveaux.isLevelUp(joueur.getNivActuel(), joueur.getXpActuelle())){
            Log.traceLog("Le joueur peut monter de niveau");
            joueur.setXpActuelle(joueur.getXpActuelle() - Niveaux.nextLevel(joueur.getNivActuel()));
            joueur.setNivActuel(joueur.getNivActuel() + 1);
            saveJoueur(joueur);
        }
    }
    public Joueur gagnerXp(int idJoueur, int quantite){
        Check.doitEtrePlusgrandQueZero(quantite, "xp");
        Joueur joueur = getJoueurById(idJoueur);
        joueur.setXpActuelle(joueur.getXpActuelle() + quantite);
        saveJoueur(joueur);
        monterDeNiveauJoueur(idJoueur);
        Log.infoLog("L'xp a été ajoutée");
        return joueur;
    }
    public Joueur creerJoueur(String nom, String prenom){
        Joueur joueur = new Joueur(nom, prenom);
        saveJoueur(joueur);
        Log.infoLog("Le joueur à été créé");
        return joueur;
    }
    public boolean isAchatPossible(Wheels wheels, int idJoueur){
        if(! Niveaux.isAmeliorationPossible(wheels.getNivActuel())){
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
    public boolean isAchatPossible(Moteurs moteur, int idJoueur){
        if(! Niveaux.isAmeliorationPossible(moteur.getNivActuel())){
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
    public boolean isAchatPossible(Ailerons ailerons, int idJoueur){
        if(! Niveaux.isAmeliorationPossible(ailerons.getNivActuel())){
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
