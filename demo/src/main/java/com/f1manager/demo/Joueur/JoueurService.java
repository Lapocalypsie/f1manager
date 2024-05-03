package com.f1manager.demo.Joueur;

import com.f1manager.demo.ErrorHandling.throwException;
import com.f1manager.demo.Formula1.F1;
import com.f1manager.demo.Utils.Niveaux;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JoueurService {
    private JoueurRepository joueurRepository;

    public Joueur saveJoueur(Joueur joueur) {
        return joueurRepository.save(joueur);
    }

    public List<Joueur> getAllJoueurs() {
        return joueurRepository.findAll();
    }

    public Joueur getJoueurById(int id) {
        Optional<Joueur> joueurOptional =  joueurRepository.findById(id);
        if (joueurOptional.isPresent()) {
            return joueurOptional.get();
        } else {
            throwException.throwIllegalArgumentException("Le joueur n'est pas présent en base");
            return null;
        }
    }
    public boolean monterDeNiveauJoueur(int idJoueur){
        Joueur joueur = getJoueurById(idJoueur);
        if (Niveaux.isLevelUp(joueur.getNivActuel(), joueur.getXpActuelle())){
            joueur.setXpActuelle(joueur.getXpActuelle() - Niveaux.nextLevel(joueur.getNivActuel()));
            joueur.setNivActuel(joueur.getNivActuel() + 1);
            saveJoueur(joueur);
            return true;
        }
        return false;
    }
    public boolean gagnerXp(int idJoueur, int quantite){
        if(quantite < 0 ){
            throwException.throwIllegalArgumentException("La quantité ne peut pas être négative");
        }
        Joueur joueur = getJoueurById(idJoueur);
        joueur.setXpActuelle(joueur.getXpActuelle() + quantite);
        saveJoueur(joueur);
        monterDeNiveauJoueur(idJoueur);
        return true;
    }
}
