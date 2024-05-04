package com.f1manager.demo.Personnel;

import com.f1manager.demo.Personnel.Mecanicien.Mecanicien;
import com.f1manager.demo.Personnel.pilote.Pilote;
import com.f1manager.demo.Utils.CalculStats;
import org.springframework.stereotype.Service;

@Service
public class PersonneService {

    public static void upgradePersonneLevel(Mecanicien mecanicien){
        mecanicien.setNiveauActuel(mecanicien.getNiveauActuel()+1);
        mecanicien.setVitesse(CalculStats.calculerVitesse(mecanicien.getNiveauActuel()));
        mecanicien.setPerformance(CalculStats.calculerPerformance(mecanicien.getNiveauActuel()));
    }
    public static void upgradePersonneLevel(Pilote pilote){
        pilote.setNiveauActuel(pilote.getNiveauActuel()+1);
        pilote.setForce(CalculStats.calculerForce(pilote.getNiveauActuel()));
        pilote.setEndurance(CalculStats.calculerEndurance(pilote.getNiveauActuel()));
    }
}
