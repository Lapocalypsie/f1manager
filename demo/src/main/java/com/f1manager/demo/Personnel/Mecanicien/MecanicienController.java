package com.f1manager.demo.Personnel.Mecanicien;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/mecano")
public class MecanicienController {

    @Autowired
    private MecanicienService mecanicienService;

    @GetMapping("/vitesse/{id}")
    public double getVitesseMecanicienbyId(@PathVariable Long id){
       return mecanicienService.getVitesseMecanicienbyId(id);
    }

    @GetMapping("/perf/{id}")
    public double getPerformanceMecanicienbyId(@PathVariable Long id){
        return mecanicienService.getPerformanceMecanicienbyId(id);
    }


}
