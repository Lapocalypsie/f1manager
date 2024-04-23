package com.f1manager.demo.Formula1;


import com.f1manager.demo.Formula1.Moteurs.Moteurs;
import com.f1manager.demo.Formula1.wheels.Wheels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/f1")
public class F1Controler {

    private final F1Service f1Service;

    @Autowired
    public F1Controler(F1Service f1Service) {
        this.f1Service = f1Service;
    }

    @PostMapping("/add")
    public ResponseEntity<F1> addF1(@RequestBody F1 f1) {
        F1 savedF1 = f1Service.saveF1(f1);
        return ResponseEntity.ok(savedF1);
    }
    @GetMapping("/all")
    public ResponseEntity<List<F1>> getAllF1() {
        List<F1> allF1 = f1Service.getAllF1();
        return ResponseEntity.ok(allF1);
    }

    @GetMapping("/moyenne/{id}")
    public ResponseEntity<Double> getMoyenneF1(@PathVariable int id){
        Double moyenne = f1Service.f1MoyenneCoef(id);
        return ResponseEntity.ok(moyenne);
    }
    @PostMapping("createF1/{poidsF1}/{vitesseMax}/{zeroTo100}/{maniabilty}/{wheelsId}/{moteurId}/{aileronsId}")
    public ResponseEntity<F1> createNewF1(@PathVariable double poidsF1, @PathVariable double vitesseMax, @PathVariable double zeroTo100,
                                        @PathVariable int maniabilty, @PathVariable int wheelsId, @PathVariable int moteurId, @PathVariable int aileronsId){
        return new ResponseEntity<>(f1Service.createNewF1(poidsF1, vitesseMax, zeroTo100, maniabilty, wheelsId, moteurId, aileronsId), HttpStatus.CREATED);
    }

}