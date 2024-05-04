package com.f1manager.demo.Personnel.Mecanicien;

import com.f1manager.demo.Personnel.pilote.PiloteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/mecano")
public class MecanicienController {


    @Autowired
    private MecanicienService mecanicienService;
    @PostMapping("/creerMecanicien/{nom}/{prenom}/{niveauActuel}/{vitesse}/{performance}")
    public ResponseEntity<Mecanicien> creerMecanicien(@PathVariable String nom, @PathVariable String prenom, @PathVariable int niveauActuel, @PathVariable double vitesse, @PathVariable double performance, @PathVariable boolean appartient ){
        return new ResponseEntity<>(mecanicienService.creerMecanicien(nom, prenom, niveauActuel, vitesse, performance, appartient), HttpStatus.OK);
    }
    @GetMapping("/vitesse/{id}")
    public double getVitesseMecanicienbyId(@PathVariable int id){
       return mecanicienService.getVitesseMecanicienbyId(id);
    }

    @GetMapping("/perf/{id}")
    public double getPerformanceMecanicienbyId(@PathVariable int id){
        return mecanicienService.getPerformanceMecanicienbyId(id);
    }
    @PostMapping("upgradeMecanicien/{idMecanicien}")
    public ResponseEntity<Mecanicien> upgradeMecanicien(@PathVariable int idMecanicien){
        return new ResponseEntity<>(mecanicienService.upgradeMecanicien(idMecanicien), HttpStatus.OK);
    }

    @PutMapping("acheterMecanicien/{idMecanicien}/{idJoueur}")
    public ResponseEntity<Double> acheterMecanicien(@PathVariable int idMecanicien, @PathVariable int idJoueur) {
        return new ResponseEntity<>(mecanicienService.buyMecanicien(idMecanicien, idJoueur), HttpStatus.OK);
    }

    @PutMapping("vendreMecanicien/{idMecanicien}/{idJoueur}")
    public ResponseEntity<Double> vendreMecanicien(@PathVariable int idMecanicien, @PathVariable int idJoueur) {
        return new ResponseEntity<>(mecanicienService.sellMecanicien(idMecanicien, idJoueur), HttpStatus.OK);
    }

}
