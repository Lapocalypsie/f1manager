package com.f1manager.demo.Formula1.Moteurs;


import com.f1manager.demo.Formula1.F1Service;
import com.f1manager.demo.Formula1.wheels.Wheels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/moteur")
public class MoteursControler {
    private final MoteursService moteursService;
    @Autowired
    public MoteursControler(MoteursService moteursService) {
        this.moteursService = moteursService;
    }
    @PostMapping("/createMoteur/{nomMoteur}/{consommationEssence}/{puissance}/{prixMoteur}")
    public ResponseEntity<Moteurs> createMoteur(@PathVariable String nomMoteur, @PathVariable double consommationEssence, @PathVariable double puissance,@PathVariable int prixMoteur, @PathVariable String imageMoteur, @PathVariable int nivActuel){
        return new ResponseEntity<>(moteursService.createNewMoteur(nomMoteur,consommationEssence, puissance, prixMoteur, imageMoteur, nivActuel), HttpStatus.OK);
    }
    @PutMapping("/updatePuissanceMoteur/{idMoteur}/{puissance}")
    public ResponseEntity<Moteurs> updatePuissanceMoteur(@PathVariable int idMoteur, @PathVariable double puissance){
        return new ResponseEntity<>(moteursService.updatePuissanceMoteur(idMoteur, puissance), HttpStatus.OK);
    }
    @PutMapping("/updateConsommationMoteur/{idMoteur}/{consommation}")
    public ResponseEntity<Moteurs> updateConsommationMoteur(@PathVariable int idMoteur, @PathVariable double consommation){
        return new ResponseEntity<>(moteursService.updateConsommationMoteur(idMoteur, consommation), HttpStatus.OK);
    }
    @PutMapping("/updatePrixMoteur/{idMoteur}/{prix}")
    public ResponseEntity<Moteurs> updatePrixMoteur(@PathVariable int idMoteur, @PathVariable int prix){
        return new ResponseEntity<>(moteursService.updatePrixMoteur(idMoteur, prix), HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Moteurs>> getAllMoteurs(){
        return new ResponseEntity<>(moteursService.getAllMoteurs(), HttpStatus.OK);
    }

}
