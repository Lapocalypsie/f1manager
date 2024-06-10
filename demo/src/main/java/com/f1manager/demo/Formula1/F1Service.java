package com.f1manager.demo.Formula1;

import com.f1manager.demo.Formula1.Aileron.Ailerons;
import com.f1manager.demo.Formula1.Aileron.AileronsService;
import com.f1manager.demo.ErrorHandling.throwException;
import com.f1manager.demo.Formula1.Moteurs.Moteurs;
import com.f1manager.demo.Formula1.Moteurs.MoteursService;
import com.f1manager.demo.Joueur.Joueur;
import com.f1manager.demo.Joueur.JoueurService;
import com.f1manager.demo.Log.Log;
import com.f1manager.demo.Utils.Check;
import com.f1manager.demo.Utils.Lists;
import com.f1manager.demo.Utils.assignCoef;
import com.f1manager.demo.Utils.findCloserInList;
import com.f1manager.demo.Formula1.wheels.Wheels;
import com.f1manager.demo.Formula1.wheels.WheelsService;
import com.f1manager.demo.systemeco.Achat;
import com.f1manager.demo.systemeco.Vente;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class F1Service {

    @Autowired
    private F1Repository repository;
    private final MoteursService moteursService;
    private final AileronsService aileronsService;
    private final WheelsService wheelsService;
    private final JoueurService joueurService;

    // Obtiens le coefficient de maniabilité de la F1

    public Double getManiabilityCoef(F1 f1) {
        // obtention de la maniabilité de la F1

        double maniabilityCoef = f1.getManiabilty();
        // calcul du coefficient :

        maniabilityCoef = (maniabilityCoef * 2 + aileronsService.getAileronCoef(f1.getAilerons())) / 3;
        Log.traceLog("getManiabilityCoef : le coefficient de maniabilité est " + maniabilityCoef);
        return maniabilityCoef;
    }

    // Obtiens le coefficient de vitesse max de la F1 :
    public Double vMaxCoef(F1 f1) {

        // Vérifie que la vitesse max est positive

        Check.doitEtrePlusgrandQueZero(f1.getVitesseMax(), "vitesse max");
        double[] vitesseList = Lists.getVitesseListF1();
        Log.infoLog("vMaxCoef : début calcul du coef de vMax");

        // calcul du coefficient de vitesse de la f1 par rapport à vitesseList

        double vMaxCoeff = assignCoef.assignCoefficient(findCloserInList.findCloser(f1.getVitesseMax(), vitesseList),
                vitesseList);
        vMaxCoeff = (vMaxCoeff * 2 + aileronsService.getAileronCoef(f1.getAilerons())
                + moteursService.getMoteurCoef(f1.getMoteur()) + wheelsService.getWheelsCoef(f1.getWheels())) / 5;
        Log.infoLog("vMaxCoef : fin calcul du coef de vMax qui vaut " + vMaxCoeff);
        return vMaxCoeff;
    }

    // Obtiens le coefficient de poids de la F1
    public Double getPoidsCoef(F1 f1) {
        final double poidsMinLogique = 200.0;

        // vérifie que le poids est supérieur à un poids minimum défini;

        if (f1.getPoidsF1() < poidsMinLogique) {
            throwException.throwIllegalArgumentException(
                    "Le poids de la f1 ne peur pas être inférieure à " + poidsMinLogique + "kg");
        }
        double[] poidsList = Lists.getPoidsListF1();
        Log.infoLog("getPoidsCoef : début calcul du coef de poids");

        // calcul du coefficient de poids de la f1 par rapport à poidsList

        double poidsCoef = 1
                - assignCoef.assignCoefficient(findCloserInList.findCloser(f1.getPoidsF1(), poidsList), poidsList);
        poidsCoef = (poidsCoef * 6 + aileronsService.getAileronCoef(f1.getAilerons())
                + moteursService.getMoteurCoef(f1.getMoteur()) + wheelsService.getWheelsCoef(f1.getWheels())) / 9;
        Log.infoLog("getPoidsCoef : fin calcul du coef de poids qui vaut " + poidsCoef);
        return poidsCoef;
    }

    // Obtiens le coefficient de zéro à 100 de la F1
    public Double getZeroTo100Coef(F1 f1) {
        Check.doitEtrePlusgrandQueZero(f1.getZeroTo100(), "zéro à 100");
        double[] timeList = Lists.getTimeListF1();
        Log.infoLog("getZeroTo100Coef : début calcul du coef de zéro à 100");

        // calcul du coefficient de zéro à 100 de la f1 par rapport à timeList

        double zeroTo100Coef = 1
                - assignCoef.assignCoefficient(findCloserInList.findCloser(f1.getZeroTo100(), timeList), timeList);
        zeroTo100Coef = (zeroTo100Coef * 2 + moteursService.getMoteurCoef(f1.getMoteur())) / 3;
        Log.infoLog(("getZeroTo100Coef : fin calcul du coef de zéro à 100 qui vaut " + zeroTo100Coef));
        return zeroTo100Coef;
    }

    // réalise une simple moyenne pondérée des coefficients de la f1 à l'aide de
    // l'id de la F1
    public Double f1MoyenneCoef(int idF1) {
        F1 f1 = getF1ById(idF1);
        return (getPoidsCoef(f1) + getManiabilityCoef(f1) + vMaxCoef(f1) + getZeroTo100Coef(f1)) / 4;
    }

    // réalise une simple moyenne pondérée des coefficients de la f1 à l'aide d'un
    // objet F1
    public Double f1MoyenneCoef(F1 f1) {
        return (getPoidsCoef(f1) + getManiabilityCoef(f1) + vMaxCoef(f1) + getZeroTo100Coef(f1)) / 4;
    }

    // Enregistre une F1 en base
    public F1 saveF1(F1 f1) {
        return repository.save(f1);
    }

    // Récupère toute les F1 en base
    public List<F1> getAllF1() {
        return repository.findAll();
    }

    // Récupère une F1 à l'aide de son Id
    public F1 getF1ById(int id) {
        Optional<F1> f1Oprional = repository.findById(id);
        if (f1Oprional.isPresent()) {
            Log.traceLog("getF1ById : la F1 est bien présente en base");
            return f1Oprional.get();
        } else {
            throwException.throwIllegalArgumentException("La F1 n'est pas présent en base");
            return null;
        }
    }

    /*
     * Pour créer une nouvelle f1, on créé d'abord un moteur en le récupérant en
     * base avec son ID
     * On fait de même pour l'aileron et les roues. Ensuite, on créé une f1 sans
     * coefficent à l'aide du
     * constructeur ne contenant pas de coef de la classe F1. On lui assigne ensuite
     * le coefficient avec un setCoef
     * qui va calculer ce coefficient puis on enregistre le f1 en base et on la
     * renvoie au cas ou l'utilisateur en
     * aurait besoin.
     */
    public F1 createNewF1(double poidsF1, double vitesseMax, double zeroTo100,
            int maniabilty, int wheelsId, int moteurId, int aileronsId, String imageF1) {
        Moteurs moteur = moteursService.getMoteurById(moteurId);
        Ailerons aileron = aileronsService.getAileronsById(aileronsId);
        Wheels wheel = wheelsService.getWheelsById(wheelsId);
        F1 f1 = new F1(poidsF1, vitesseMax, zeroTo100, maniabilty, wheel, moteur, aileron, imageF1);
        f1.setCoef(f1MoyenneCoef(f1));
        saveF1(f1);
        Log.infoLog("createNewF1 : la F1 est bien créée en base");
        return f1;
    }

    // Permets de changer le moteur d'un id de F1 à partir de l'id de la f1 et de
    // l'id du nouveau moteur
    public F1 changeMoteurF1(int idF1, int idMoteur) {

        // Récupération de la f1 et du moteur

        F1 f1 = getF1ById(idF1);
        Moteurs moteur = moteursService.getMoteurById(idMoteur);

        // Changement du moteur de la F1

        f1.setMoteur(moteur);
        Log.infoLog("changeMoteurF1 : le moteur a bien été changé");
        return f1;
    }

    // Permets de changer l'aileron d'un id de F1 à partir de l'id de la f1 et de
    // l'id du nouvel aileron
    public F1 changeAileronF1(int ifF1, int idAileron) {

        // Récupération de la f1 et de l'aileron

        F1 f1 = getF1ById(ifF1);
        Ailerons ailerons = aileronsService.getAileronsById(idAileron);

        // Changement de l'aileron de la F1

        f1.setAilerons(ailerons);
        Log.infoLog("changeAileronF1 : l'aileron a bien été changé");
        return f1;
    }

    // Permets de changer le moteur d'un id de F1 à partir de l'id de la f1 et de
    // l'id des nouvelles roues
    public F1 changeWheelsF1(int idF1, int idWheels) {
        // Récupération de la f1 et des roues
        F1 f1 = getF1ById(idF1);
        Wheels wheels = wheelsService.getWheelsById(idWheels);
        // Changement des roues de la F1
        f1.setWheels(wheels);
        saveF1(f1);
        Log.infoLog("changeWheelsF1 : les roues ont bien été changées");
        return f1;
    }

    // Permets de changer la maniabilité d'un id de F1 à partir de l'id de la f1 et
    // de la nouvelle valeur de la maniabilité
    public F1 changeManiabilityF1(int idF1, double maniability) {
        // On vérifie que la nouvelle valeur de la maniabilité soit plus grande que 0
        Check.doitEtrePlusgrandQueZero(maniability, "maniabilité");
        // Récupération de la f1
        F1 f1 = getF1ById(idF1);
        // Changement de la maniabilité de la F1 et enregistrement en base
        f1.setManiabilty(maniability);
        saveF1(f1);
        Log.infoLog("changeManiabilityF1 : la maniabilité a bien été changée");
        return f1;
    }

    // Permets de changer le zéro à 100 d'un id de F1 à partir de l'id de la f1 et
    // de la nouvelle valeur du zéro à 100
    public F1 changeZeroTo100(int idF1, double zeroTo100) {
        // On vérifie que la nouvelle valeur du zéro à 100 soit plus grande que 0
        Check.doitEtrePlusgrandQueZero(zeroTo100, "zéro a 100");
        // Récupération de la f1
        F1 f1 = getF1ById(idF1);
        // Changement du zéro à 100 de la F1 et enregistrement en base
        f1.setZeroTo100(zeroTo100);
        saveF1(f1);
        Log.infoLog("changeZeroTo100 : le zéro à 100 de la F1 a bien été changé");
        return f1;
    }

    // Permets de changer la vitessse max d'un id de F1 à partir de l'id de la f1 et
    // de la nouvelle valeur de la vitesse max
    public F1 changeVitesseMax(int idF1, double vitesseMax) {
        // On vérifie que la nouvelle valeur de la vitesse max soit plus grande que 0
        Check.doitEtrePlusgrandQueZero(vitesseMax, "vitesse maximum de la F1");
        // Récupération de la f1
        F1 f1 = getF1ById(idF1);
        // Changement de la vitesse max de la F1 et enregistrement en base
        f1.setVitesseMax(vitesseMax);
        Log.infoLog("changeVitesseMax :  la vitesse max de la F1 a bien été changée");
        return f1;
    }

    // Fonction qui améliore le niveau des roues d'une f1 avec l'id de cette f1 et
    // l'id du joueur pour l'achat. La méthode mets à jour le prix des roues
    public double levelUpWheels(int idF1, int idJoueur) {
        // Récupération de la f1 et des roues associées à cette f1
        F1 f1 = getF1ById(idF1);
        Wheels wheels = wheelsService.getWheelsById(f1.getWheels().getId());
        // Vérification de la possibilité de l'achat. Si l'achat est possible, on
        // effectue directement le payement du joueur
        if (joueurService.isAchatPossible(wheels, idJoueur)) {
            // Amélioration des roues
            wheelsService.levelUpWheels(wheels);
            System.out.println("La montée de niveau de ces roues a été effectué");
        } else {
            throwException.throwIllegalArgumentException(
                    "Vous n'avez pas assez d'argent pour effectuer cette montée de niveau.");
        }
        return wheels.getNivActuel();
    }

    // Fonction qui améliore le niveau du moteur d'une f1 avec l'id de cette f1 et
    // l'id du joueur pour l'achat. La méthode mets à jour le prix de ce moteur
    public double levelUpMoteur(int idF1, int idJoueur) {
        // Récupération de la f1 et du moteur associé à cette f1
        F1 f1 = getF1ById(idF1);
        Moteurs moteurs = moteursService.getMoteurById(f1.getMoteur().getId());
        // Vérification de la possibilité de l'achat. Si l'achat est possible, on
        // effectue directement le payement du joueur
        if (joueurService.isAchatPossible(moteurs, idJoueur)) {
            // Amélioration du moteur
            moteursService.levelUpMoteurs(moteurs);
            System.out.println("La montée de niveau de ce moteur a été effectué");
        } else {
            throwException.throwIllegalArgumentException(
                    "Vous n'avez pas assez d'argent pour effectuer cette montée de niveau.");
        }
        return moteurs.getNivActuel();
    }

    // Fonction qui améliore le niveau de l'aileron d'une f1 avec l'id de cette f1
    // et l'id du joueur pour l'achat. La méthode mets à jour le prix de cet
    // aileron.
    public double levelUpAileron(int idF1, int idJoueur) {
        // Récupération de la f1 et de l'aileron associé à cette f1
        F1 f1 = getF1ById(idF1);
        Ailerons ailerons = aileronsService.getAileronsById(f1.getAilerons().getId());
        // Vérification de la possibilité de l'achat. Si l'achat est possible, on
        // effectue directement le payement du joueur
        if (joueurService.isAchatPossible(ailerons, idJoueur)) {
            // Amélioration de l'aileron
            aileronsService.levelUpAilerons(ailerons);
            System.out.println("La montée de niveau de cet aileron a été effectué");
        } else {
            throwException.throwIllegalArgumentException(
                    "Vous n'avez pas assez d'argent pour effectuer cette montée de niveau.");
        }
        return ailerons.getNivActuel();
    }
    /**
     * Achète une f1 pour un joueur à partir des identifiants de la f1 et du joueur.
     *
     * @param idF1 l'identifiant de la f1 à acheter.
     * @param idJoueur     l'identifiant du joueur qui achète le mécanicien.
     * @return le montant d'argent restant au joueur après l'achat.
     */
    public double buyF1(int idF1, int idJoueur) {
        F1 f1 = getF1ById(idF1);
        Joueur joueur = joueurService.getJoueurById(idJoueur);
        Achat.effectuerAchat(f1, joueur);
        joueurService.saveJoueur(joueur);
        saveF1(f1);
        Log.infoLog("Le mecanicien à bien été acheté");
        return joueur.getArgent();
    }

    /**
     * Vend une f1 pour un joueur à partir des identifiants de la f1 et du joueur.
     * @param idF1 l'identifiant de la f1 à acheter.
     * @param idJoueur l'identifiant du mécanicien à vendre.
     */
    public double sellF1(int idF1, int idJoueur) {
        F1 f1 = getF1ById(idF1);
        Joueur joueur=  joueurService.getJoueurById(idJoueur);
        Vente.effectuerVente(f1, joueur);
        joueurService.saveJoueur(joueur);
        saveF1(f1);
        Log.infoLog("La f1 à bien été vendue");
        return joueur.getArgent();
    }
    public void deleteF1(int id) {
        repository.deleteById(id);
    }
    public List<Integer> getAllF1Ids() {
        return repository.findAllF1Ids();
    }
}
