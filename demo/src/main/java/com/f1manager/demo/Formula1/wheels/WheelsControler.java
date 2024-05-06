package com.f1manager.demo.Formula1.wheels;


import com.f1manager.demo.Formula1.F1Service;
import com.f1manager.demo.Formula1.wheels.Wheels;
import com.f1manager.demo.Formula1.wheels.WheelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/wheels")
public class WheelsControler {
    private final WheelsService wheelsService;
    @Autowired
    public WheelsControler(WheelsService wheelsService) {
        this.wheelsService = wheelsService;
    }
    @PostMapping("/createWheels/{nomPneu}/{poidsPneus}/{prixUnitairePneus}/{typePneus}")
    public ResponseEntity<Wheels> createPneu(@PathVariable String nomPneu, @PathVariable double poidsPneus, @PathVariable double prixUnitairePneus, @PathVariable String typePneus, @PathVariable String imagePneus, @PathVariable int nivActuel){
        return new ResponseEntity<>(wheelsService.createNewWheels(nomPneu,poidsPneus, prixUnitairePneus,typePneus, imagePneus, nivActuel), HttpStatus.OK);
    }
    @PutMapping("/updateWheelsPoids/{idPneus}/{poidsPneus}")
    public ResponseEntity<Wheels> updatePoidsWheels(@PathVariable int idPneus, @PathVariable double poidsPneus){
        return new ResponseEntity<>(wheelsService.updatePoidsWheels(idPneus, poidsPneus), HttpStatus.OK);
    }
    @PutMapping("/updatePrixPneux/{idPneus}/{prixUnitairePneus}")
    public ResponseEntity<Wheels> updateConsommationmoteur(@PathVariable int idPneus, @PathVariable double prixUnitairePneus){
        return new ResponseEntity<>(wheelsService.updatePrixWheels(idPneus, prixUnitairePneus), HttpStatus.OK);
    }

}
