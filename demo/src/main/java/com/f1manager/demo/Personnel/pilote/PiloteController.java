package com.f1manager.demo.Personnel.pilote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pilotes")
public class PiloteController {

    @Autowired
    private PiloteService piloteService;

    // Endpoint pour récupérer tous les pilotes
    @GetMapping()
    public List<Pilote> getAllPilotes() {
        List<Pilote> pilotes = piloteService.getAllPilotes();
        for (Pilote pilote : pilotes) {
            System.out.println(pilote);
        }
        return pilotes;
    }

    // Endpoint pour récupérer un pilote par son ID
    @GetMapping("/{id}")
    public Pilote getPiloteById(@PathVariable int id) {
        return piloteService.getPiloteById(id);
    }

    // Endpoint pour créer un nouveau pilote
    @PostMapping
    public Pilote createPilote(@RequestBody Pilote pilote) {
        return piloteService.createPilote(pilote);
    }
    @PostMapping("/createPilote/{nom}/{prenom}/{niveauActuel}/{number}/{price}/{force}/{endurance}")

// PiloteController.java
public ResponseEntity<Pilote> createPilote(@PathVariable String nom, @PathVariable String prenom, @PathVariable int niveauActuel, @PathVariable int number, @PathVariable double price, @PathVariable double force, @PathVariable double endurance, @PathVariable boolean appartient, @PathVariable String imagePilote) {
    Pilote newPilote = piloteService.createPilote(nom, prenom, niveauActuel, number, price, force, endurance, appartient, imagePilote);
    return new ResponseEntity<>(newPilote, HttpStatus.CREATED);
}

    // Endpoint pour supprimer un pilote
    @DeleteMapping("/{id}")
    public void deletePilote(@PathVariable int id) {
        piloteService.deletePilote(id);
    }

    @PutMapping("/name/{id}")
    public void modifyNamePilote(@PathVariable int id, @RequestParam String firstName, @RequestParam String lastName) {
        piloteService.modifyNamePilote(id, firstName, lastName);
    }

    @PutMapping("/number/{id}")
    public void modifyNumberPilote(@PathVariable int id, @RequestBody int newNumber) {
        piloteService.modifyNumberPilote(id, newNumber);
    }

    @PutMapping("/price/{id}")
    public void modifyPricePilote(@PathVariable int id, @RequestBody int newPrice) {
        piloteService.modifyPricePilote(id, newPrice);
    }

    @PutMapping("/force/{id}")
    public void modifyForcePilote(@PathVariable int id, @RequestBody int force) {
        piloteService.modifyForcePilote(id, force);
    }

    @PutMapping("/endurance/{id}")
    public void modifyEndurancePilote(@PathVariable int id, @RequestBody int endurance) {
        piloteService.modifyEndurancePilote(id, endurance);
    }
    @PutMapping("/upgradePilote/{idPilote}")
    public ResponseEntity<Pilote> upgradePilote(@PathVariable int idPilote){
        return new ResponseEntity<>(piloteService.upgradePilote(idPilote), HttpStatus.OK);
    }
    @GetMapping("/piloteCoefficientById/{idPilote}")
    public ResponseEntity<Double>getPiloteCoef(@PathVariable int idPilote){
        return new ResponseEntity<>(piloteService.getPiloteCoef(idPilote),HttpStatus.OK);
    }
    @PutMapping("acheterPilote/{idPilote}/{idJoueur}")
    public ResponseEntity<Double> acheterPilote(@PathVariable int idPilote, @PathVariable int idJoueur) {
        return new ResponseEntity<>(piloteService.buyPilote(idPilote, idJoueur), HttpStatus.OK);
    }

    @PutMapping("vendrePilote/{idPilote}/{idJoueur}")
    public ResponseEntity<Double> vendrePilote(@PathVariable int idPilote, @PathVariable int idJoueur) {
        return new ResponseEntity<>(piloteService.sellPilote(idPilote, idJoueur), HttpStatus.OK);
    }
}