package com.f1manager.demo.Formula1.Moteurs;


import com.f1manager.demo.Formula1.Aileron.Ailerons;
import com.f1manager.demo.Formula1.Aileron.AileronsRepository;
import com.f1manager.demo.Formula1.Aileron.AileronsService;
import com.f1manager.demo.Formula1.F1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/aileron")
public class AileronsControler {
    private final AileronsService aileronsService;
    @Autowired
    public AileronsControler(AileronsService aileronsService) {
        this.aileronsService = aileronsService;
    }
    @PostMapping("/createAileron/{poidsAileron}/{prixAileron}")
    public ResponseEntity<Ailerons> createAileron(@PathVariable double poidsAileron, @PathVariable double prixAileron){
        return new ResponseEntity<>(aileronsService.createNewAileron(poidsAileron,prixAileron), HttpStatus.OK);
    }
    @PutMapping("/updatePoidsAileron/{idAileron}/{poidsAileron}")
    public ResponseEntity<Ailerons> updatePoidsAileron(@PathVariable int idAileron, @PathVariable double poidsAileron){
        return new ResponseEntity<>(aileronsService.updatePoidsAileron(idAileron, poidsAileron), HttpStatus.OK);
    }
    @PutMapping("/updatePrixAileron/{idAileron}/{prixAileron}")
    public ResponseEntity<Ailerons> updatePrixAileron(@PathVariable int idAileron, @PathVariable double prixAileron){
        return new ResponseEntity<>(aileronsService.updatePrixAileron(idAileron, prixAileron), HttpStatus.OK);
    }
}
