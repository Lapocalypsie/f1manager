package com.f1manager.demo.Personnel.Mecanicien;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MecanicienService {

    @Autowired
    MecanicienRepository mecanicienRepository;

    public double getVitesseMecanicienbyId(Long id) {
        Mecanicien mecano = mecanicienRepository.findById(id).orElse(null);
        return mecano.getVitesse();
    }

    public double getPerformanceMecanicienbyId(Long id) {
        Mecanicien mecano = mecanicienRepository.findById(id).orElse(null);;
        return mecano.getPerformance();
    }
}
