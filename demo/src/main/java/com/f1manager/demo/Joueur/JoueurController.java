package com.f1manager.demo.Joueur;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/joueur")
public class JoueurController {
    private final JoueurService joueurService;

    public JoueurController(JoueurService joueurService) {
        this.joueurService = joueurService;
    }
    @PostMapping("/creerJoueur/{nom}/{prenom}")
    public ResponseEntity<Joueur> creerJoueur(@PathVariable String nom, @PathVariable String prenom){
        return new ResponseEntity<>(joueurService.creerJoueur(nom, prenom), HttpStatus.OK);
    }
    @PutMapping("/gagnerXp/{idJoueur}/{quantite}")
    public ResponseEntity<Joueur> gagnerXp(@PathVariable int idJoueur, @PathVariable int quantite){
        return new ResponseEntity<>(joueurService.gagnerXp(idJoueur, quantite), HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Joueur>> getAllJoueurs(){
        return new ResponseEntity<>(joueurService.getAllJoueurs(), HttpStatus.OK);
    }
}
