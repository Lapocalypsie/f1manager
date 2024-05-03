package com.f1manager.demo.Personnel;

import com.f1manager.demo.Personnel.Mecanicien.Mecanicien;
import com.f1manager.demo.Personnel.Mecanicien.MecanicienService;
import com.f1manager.demo.Utils.CalculStats;
import org.springframework.stereotype.Service;

@Service
public class PersonneService {

    public int getPrixNextUpdate(int niveau){
        double basePrix = 100.0;
        double tauxCroissance = 1.15;
        return (int) (basePrix * Math.pow(tauxCroissance, niveau - 1));
    }
    public static Mecanicien upgradePersonneLevel(Mecanicien mecanicien){
        mecanicien.setNiveauActuel(mecanicien.getNiveauActuel()+1);
        mecanicien.setVitesse(CalculStats.calculerVitesse(mecanicien.getNiveauActuel()));
        mecanicien.setPerformance(CalculStats.calculerProductivite(mecanicien.getNiveauActuel()));
        return mecanicien;
    }
}
