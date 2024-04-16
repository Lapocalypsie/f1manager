package com.f1manager.demo.Formula1.Moteurs;

public class MoteursService {
    public Double getConsommationEscenceCoef(Moteurs moteur){
        double consommationEscenceCoef = 0.1;
        if (moteur.getConsommationEssence() < 0) {
            throw new IllegalArgumentException("La consommation du moteur ne peut pas être négative");
        } else if (moteur.getConsommationEssence() < 40.0) {
            consommationEscenceCoef = 1.0;
        } else if (moteur.getConsommationEssence() < 42.0) {
            consommationEscenceCoef = 0.8;
        }else if (moteur.getConsommationEssence() < 45.0) {
            consommationEscenceCoef = 0.6;
        }
        else if (moteur.getConsommationEssence() < 50.0){
            consommationEscenceCoef = 0.4;
        }else if (moteur.getConsommationEssence() < 55.0){
            consommationEscenceCoef = 0.2;
        }
        return consommationEscenceCoef;
    }
    public Double getPuissanceCoef(Moteurs moteur){
        double puissanceCoef = 0.1;
        if (moteur.getPuissance() < 0){
            throw new IllegalArgumentException("La puissance du moteur ne peut pas être négative");
        }else if (moteur.getPuissance() < 750 ){
            puissanceCoef = 0.2;
        } else if (moteur.getPuissance() < 850) {
            puissanceCoef = 0.4;
        } else if (moteur.getPuissance() < 900) {
            puissanceCoef = 0.6;
        } else if ((moteur.getPuissance() < 1000)) {
            puissanceCoef = 0.8;
        } else if (moteur.getPuissance() >= 1000) {
            puissanceCoef = 1.0;
        }
        return puissanceCoef;
    }
    public Double getCoefMoteur(Moteurs moteurs){
        return (getPuissanceCoef(moteurs)+ getConsommationEscenceCoef(moteurs))/2;
    }
}
