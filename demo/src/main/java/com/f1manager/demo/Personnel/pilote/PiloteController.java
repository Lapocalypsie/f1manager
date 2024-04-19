package com.f1manager.demo.Personnel.pilote;

import org.springframework.beans.factory.annotation.Autowired;
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
    public Pilote getPiloteById(@PathVariable Long id) {
        return piloteService.getPiloteById(id);
    }

    // Endpoint pour créer un nouveau pilote
    @PostMapping
    public Pilote createPilote(@RequestBody Pilote pilote) {
        return piloteService.createPilote(pilote);
    }

    // Endpoint pour supprimer un pilote
    @DeleteMapping("/{id}")
    public void deletePilote(@PathVariable Long id) {
        piloteService.deletePilote(id);
    }

    @PutMapping("name/{id}")
    public void modifyNamePilote(@PathVariable Long id, @RequestBody String newName) {
        piloteService.modifyNamePilote(id, newName);
    }

    @PutMapping("number/{id}")
    public void modifyNumberPilote(@PathVariable Long id, @RequestBody int newNumber) {
        piloteService.modifyNumberPilote(id, newNumber);
    }

    @PutMapping("price/{id}")
    public void modifyPricePilote(@PathVariable Long id, @RequestBody int newPrice) {
        piloteService.modifyPricePilote(id, newPrice);
    }

    @PutMapping("force/{id}")
    public void modifyForcePilote(@PathVariable Long id, @RequestBody int force) {
        piloteService.modifyForcePilote(id, force);
    }

    @PutMapping("endurance/{id}")
    public void modifyEndurancePilote(@PathVariable Long id, @RequestBody int endurance) {
        piloteService.modifyEndurancePilote(id, endurance);
    }
}
