package com.f1manager.demo.Formula1;


import org.springframework.beans.factory.annotation.Autowired;
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
/*
    @GetMapping
    public ResponseEntity<Double> getF1Moyenne() {
        Wheels roues1 = new Wheels("Michelin 1", 40.5, 100, "Pluie");
        Ailerons aileron1 = new Ailerons(341);
        Moteurs moteurs1 = new Moteurs("Moteur Hider", 45, 890);
        F1 f1 = new F1()
        Double moyenne = f1Service.f1MoyenneCoef();
        return new ResponseEntity<>(moyenne, HttpStatus.OK);
    }*/

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


}