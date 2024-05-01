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
    @PostMapping("/createAileron/{poidsAileron}/")
    public ResponseEntity<Ailerons> createAileron(@PathVariable double poidsAileron){
        return new ResponseEntity<>(aileronsService.createNewAileron(poidsAileron), HttpStatus.OK);
    }
    @PutMapping("/updatePoidsAileron/{idAileron}/{poidsAileron}")
    public ResponseEntity<Ailerons> updateAileron(@PathVariable int idAileron, @PathVariable double poidsAileron){
        return new ResponseEntity<>(aileronsService.updatePoidsAileron(idAileron, poidsAileron), HttpStatus.OK);
    }
}
