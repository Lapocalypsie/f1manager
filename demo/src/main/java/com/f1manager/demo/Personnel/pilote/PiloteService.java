package com.f1manager.demo.Personnel.pilote;

import com.f1manager.demo.ErrorHandling.throwException;
import com.f1manager.demo.Joueur.Joueur;
import com.f1manager.demo.Joueur.JoueurService;
import com.f1manager.demo.Personnel.Mecanicien.Mecanicien;
import com.f1manager.demo.Personnel.PersonneService;
import com.f1manager.demo.Utils.CalculStats;
import com.f1manager.demo.systemeco.Achat;
import com.f1manager.demo.systemeco.Vente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PiloteService {

    @Autowired
    private PiloteRepository piloteRepository;
    @Autowired
    private JoueurService joueurService;

    public List<Pilote> getAllPilotes() {
        return piloteRepository.findAll();
    }

    public Pilote createPilote(Pilote pilote) {
        return piloteRepository.save(pilote);
    }
    public Pilote createPilote(String nom, String prenom, int niveauActuel, int number, double price, double force, double endurance, boolean appartient){
        Pilote pilote = new Pilote(nom, prenom, niveauActuel, number, price, force, endurance, appartient);
        pilote.setCoefficient(CalculStats.doublecalculerCoefficientPilote(pilote.getNiveauActuel()));
        savePilote(pilote);
        return pilote;
    }

    public void deletePilote(int id) {
        piloteRepository.deleteById(id);
    }

    public void savePilote(Pilote pilote) {
        piloteRepository.save(pilote);
    }

    public Pilote getPiloteById(int id) {
        Optional<Pilote> piloteoptional =  piloteRepository.findById(id);
        if (piloteoptional.isPresent()) {
            return piloteoptional.get();
        } else {
            throwException.throwIllegalArgumentException("Le pilote n'est pas présent en base");
            return null;
        }
    }
    public void modifyNamePilote(int id, String firstName, String lastName) {
        Pilote pilote = getPiloteById(id);
        pilote.setNom(firstName);
        pilote.setPrenom(lastName);
        savePilote(pilote);
    }

    public void modifyNumberPilote(int id, int newNumber) {
        Pilote pilote = getPiloteById(id);
        pilote.setNumber(newNumber);
        savePilote(pilote);
    }

    public void modifyPricePilote(int id, int newPrice) {
        Pilote pilote = getPiloteById(id);
        pilote.setPrice( newPrice);
        savePilote(pilote);
}

    public void modifyForcePilote(int id, int newForce) {
        Pilote pilote = getPiloteById(id);
        pilote.setForce(newForce);
        savePilote(pilote);
    }

    public void modifyEndurancePilote(int id, int endurance) {
        Pilote pilote = getPiloteById(id);
        pilote.setEndurance(endurance);
        savePilote(pilote);
    }
    public Pilote upgradePilote(int idPilote){
        Pilote pilote = getPiloteById(idPilote);
        PersonneService.upgradePersonneLevel(pilote);
        savePilote(pilote);
        return pilote;
    }
    public double getPiloteCoef(int idPilote){
        Pilote pilote = getPiloteById(idPilote);
        return CalculStats.calculerCoefficientMecanicien(pilote.getNiveauActuel());
    }
    public double buyPilote(int idPilote, int idJoueur) {
        Pilote pilote = getPiloteById(idPilote);
        Joueur joueur = joueurService.getJoueurById(idJoueur);
        Achat.effectuerAchat(pilote, joueur);
        return joueur.getArgent();
    }

    public double sellPilote(int idPilote, int idJoueur) {
        Pilote pilote = getPiloteById(idPilote);
        Joueur joueur = joueurService.getJoueurById(idJoueur);
        Vente.effectuerVente(pilote, joueur);
        return joueur.getArgent();
    }
}