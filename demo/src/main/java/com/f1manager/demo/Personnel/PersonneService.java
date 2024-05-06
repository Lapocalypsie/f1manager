package com.f1manager.demo.Personnel;

import com.f1manager.demo.Personnel.Mecanicien.Mecanicien;
import com.f1manager.demo.Personnel.Mecanicien.MecanicienService;
import com.f1manager.demo.Personnel.pilote.Pilote;
import com.f1manager.demo.Utils.CalculStats;
import com.f1manager.demo.Utils.Niveaux;
import com.f1manager.demo.systemeco.MonteeDeNiveau;
import org.springframework.stereotype.Service;

@Service
public class PersonneService {

    private static  MecanicienService mecanicienService;

    public PersonneService(MecanicienService mecanicienService) {
        PersonneService.mecanicienService = mecanicienService;
    }

    public static void upgradePersonneLevel(Mecanicien mecanicien) {
        if (MonteeDeNiveau.isAmeliorationPossible(mecanicien.getNiveauActuel())) {
            mecanicien.setNiveauActuel(mecanicien.getNiveauActuel() + 1);
            mecanicien.setVitesse(CalculStats.calculerVitesse(mecanicien));
            mecanicien.setPerformance(CalculStats.calculerPerformance(mecanicien));
            mecanicien.setCoefficient(mecanicienService.getMecanicienCoef(mecanicien.getId()));
            mecanicien.setPrice(Niveaux.getPrixNextUpdate(mecanicien.getNiveauActuel()));
        }
    }

    public static void upgradePersonneLevel(Pilote pilote) {
        pilote.setNiveauActuel(pilote.getNiveauActuel() + 1);
        pilote.setForce(CalculStats.calculerForce(pilote.getNiveauActuel()));
        pilote.setEndurance(CalculStats.calculerEndurance(pilote.getNiveauActuel()));
    }
}
