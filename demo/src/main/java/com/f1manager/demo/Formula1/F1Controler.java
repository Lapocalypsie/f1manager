package com.f1manager.demo.Formula1;

import com.f1manager.demo.Formula1.Aileron.Ailerons;
import com.f1manager.demo.Formula1.Moteurs.Moteurs;
import com.f1manager.demo.Formula1.wheels.Wheels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}