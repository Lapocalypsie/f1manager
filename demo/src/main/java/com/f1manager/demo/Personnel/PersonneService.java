package com.f1manager.demo.Personnel;

import com.f1manager.demo.Log.Log;
import com.f1manager.demo.Personnel.Mecanicien.Mecanicien;
import com.f1manager.demo.Personnel.Mecanicien.MecanicienService;
import com.f1manager.demo.Personnel.pilote.Pilote;
import com.f1manager.demo.Personnel.pilote.PiloteService;
import com.f1manager.demo.Utils.CalculStats;
import com.f1manager.demo.Utils.Niveaux;
import org.springframework.stereotype.Service;

@Service
public class PersonneService {

    private static  MecanicienService mecanicienService;
    private static PiloteService piloteService;

    public PersonneService(MecanicienService mecanicienService, PiloteService piloteService) {
        PersonneService.mecanicienService = mecanicienService;
        PersonneService.piloteService = piloteService;
    }

    public static void upgradePersonneLevel(Mecanicien mecanicien) {
        if (Niveaux.isAmeliorationPossible(mecanicien.getNiveauActuel())) {
            mecanicien.setNiveauActuel(mecanicien.getNiveauActuel() + 1);
            mecanicien.setVitesse(CalculStats.calculerVitesse(mecanicien));
            mecanicien.setPerformance(CalculStats.calculerPerformance(mecanicien));
            mecanicien.setCoefficient(mecanicienService.getMecanicienCoef(mecanicien.getId()));
            mecanicien.setPrice(Niveaux.getPrixNextUpdate(mecanicien.getNiveauActuel()));
            Log.traceLog("Le mecanicien a été mis à jour");
        }

    }

    public static void upgradePersonneLevel(Pilote pilote) {
        if (Niveaux.isAmeliorationPossible(pilote.getNiveauActuel())) {
            pilote.setNiveauActuel(pilote.getNiveauActuel() + 1);
            pilote.setForce(CalculStats.calculerForce(pilote));
            pilote.setEndurance(CalculStats.calculerEndurance(pilote));
            pilote.setCoefficient(piloteService.getPiloteCoef(pilote.getId()));
            pilote.setPrice(Niveaux.getPrixNextUpdate(pilote.getNiveauActuel()));
            Log.traceLog("Le pilote a été mis à jour");
        }
    }
}
