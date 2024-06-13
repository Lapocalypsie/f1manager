package com.f1manager.demo.Course;


import com.f1manager.demo.ErrorHandling.throwException;
import com.f1manager.demo.Formula1.F1;
import com.f1manager.demo.Formula1.F1Service;
import com.f1manager.demo.Personnel.Mecanicien.Mecanicien;
import com.f1manager.demo.Personnel.Mecanicien.MecanicienService;
import com.f1manager.demo.Personnel.pilote.Pilote;
import com.f1manager.demo.Personnel.pilote.PiloteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class CourseService {
    @Autowired
    private final F1Service f1Service;
    private final MecanicienService mecanicienService;
    private final PiloteService piloteService;

    public List<F1> fillF1List(int id1, int id2, int tailleCourse){
        List<F1> result = new ArrayList<>();
        result.add(f1Service.getF1ById(id1));
        result.add(f1Service.getF1ById(id2));
        List<Integer> allF1 = f1Service.getAllF1Ids();
        allF1.remove(id1);
        allF1.remove(id2);
        System.out.println(allF1);
        for (int i = 2; i < tailleCourse; i++) {
            System.out.println(i);
            int elem = getRandomElement(allF1);
            result.add(f1Service.getF1ById(elem));
            allF1.remove(trouveElemDansListe(allF1,elem));
        }
        return result;
    }
    public List<Mecanicien> fillMecanoList(int id1, int id2, int tailleCourse){
        List<Mecanicien> result = new ArrayList<>();
        result.add(mecanicienService.getMecanicienById(id1));
        result.add(mecanicienService.getMecanicienById(id2));
        List<Integer> allMecano = mecanicienService.getAllMecanoIds();
        allMecano.remove(id1);
        allMecano.remove(id2);
        for (int i = 2; i < tailleCourse; i++) {
            int elem = getRandomElement(allMecano);
            result.add(mecanicienService.getMecanicienById(elem));
            allMecano.remove(trouveElemDansListe(allMecano,elem));
        }
        return result;
    }
    public List<Pilote> fillPiloteList(int id1, int id2, int tailleCourse){
        List<Pilote> result = new ArrayList<>();
        result.add(piloteService.getPiloteById(id1));
        result.add(piloteService.getPiloteById(id2));
        List<Integer> allPil = piloteService.getAllPilotesIds();
        allPil.remove(id1);
        allPil.remove(id2);
        for (int i = 2; i < tailleCourse; i++) {
            int elem = getRandomElement(allPil);
            result.add(piloteService.getPiloteById(elem));
            allPil.remove(trouveElemDansListe(allPil,elem));
        }
        return result;
    }
    public List<Double> getMoyenneCoefF1List(List<F1> liste){
        List<Double> result = new ArrayList<>();
        for (F1 f1 : liste) {
            result.add(f1Service.f1MoyenneCoef(f1));
        }
        return result;
    }
    public List<Double> getCoefMecanoList(List<Mecanicien> liste){
        List<Double> result = new ArrayList<>();
        for (Mecanicien mecanicien : liste) {
            result.add(mecanicienService.getMecanicienCoef(mecanicien));
        }
        return result;
    }
    public List<Double> getCoefPiloteList(List<Pilote> liste){
        List<Double> result = new ArrayList<>();
        for (Pilote pilote : liste) {
            result.add(piloteService.getPiloteCoef(pilote));
        }
        return result;
    }
    public List<Double> getMoyenneListe(List<Double> listeMecanicien, List<Double> listePilote, List<Double> listeF1){
        if (listeMecanicien.size() != listePilote.size() || listeF1.size() != listeMecanicien.size()){
            throwException.throwIllegalArgumentException("Les listes ne font pas la même taille");
        }
        List<Double> result = new ArrayList<>();
        for (int i = 0; i<listeF1.size(); i++){
            result.add((listePilote.get(i) + listeMecanicien.get(i) + listeF1.get(i))/3);
        }
        return result;
    }
    public HashMap<String, List<Object>> calculOrdreCourse(List<Double> moyenneListe, List<Pilote> piloteListe, List<Mecanicien> mecanicienListe, List<F1> f1List){
        HashMap<String, List<Object>> result = new HashMap<>();
        if (mecanicienListe.size() != piloteListe.size() || mecanicienListe.size() != f1List.size() || moyenneListe.size() != mecanicienListe.size()){
            throwException.throwIllegalArgumentException("Les listes ne font pas la même taille");
        }
        List<Pilote> piloteResult = new ArrayList<>();
        List<Mecanicien> mecanicienResult= new ArrayList<>();
        List<F1> f1Result = new ArrayList<>();
        List<Double> moyenneResult = new ArrayList<>();
        System.out.println(moyenneListe);
        while (! moyenneListe.isEmpty()){
            int index = getMaxIndex(moyenneListe);
            System.out.println("indice = " + index);
            System.out.println("indice valeur = " + moyenneListe.get(index));
            System.out.println("moyenne liste = " + moyenneListe);
            System.out.println();
            //création du classement
            piloteResult.add(piloteListe.get(index));
            mecanicienResult.add(mecanicienListe.get(index));
            f1Result.add(f1List.get(index));
            moyenneResult.add(moyenneListe.get(index));
            //suppression des éléments déjà trouvés
            piloteListe.remove(index);
            mecanicienListe.remove(index);
            f1List.remove(index);
            moyenneListe.remove(index);
        }
        result.put("Pilote", Collections.singletonList(piloteResult));
        result.put("Mecanicien", Collections.singletonList(mecanicienResult));
        result.put("F1", Collections.singletonList(f1Result));
        result.put("Coef", Collections.singletonList(moyenneResult));
        return result;
    }
    public void course(int idMecano1, int idMecano2, int idF11, int idF12, int idPilote1, int idPilote2, int tailleCourse){
        List<F1> f1Liste =  fillF1List(idF11, idF12, tailleCourse);
        List<Mecanicien> mecanicienListe = fillMecanoList(idMecano1, idMecano2, tailleCourse);
        List<Pilote> pilotesListe = fillPiloteList(idPilote1, idPilote2, tailleCourse);
        List<Double> f1CoefListe = getMoyenneCoefF1List(f1Liste);
        List<Double> mecanoCoefListe = getCoefMecanoList(mecanicienListe);
        List<Double> piloteCoefListe = getCoefPiloteList(pilotesListe);
        List<Double> moyenneListe = getMoyenneListe(mecanoCoefListe, piloteCoefListe, f1CoefListe);
        HashMap<String, List<Object>> ordreCourse =  calculOrdreCourse(moyenneListe, pilotesListe, mecanicienListe, f1Liste);
        System.out.println("on passe là");
        System.out.println(ordreCourse.toString());
        System.out.println(ordreCourse.get("Pilote").toString());
        System.out.println(ordreCourse.get("Mecanicien").toString());
        System.out.println(ordreCourse.get("F1").toString());
        System.out.println(ordreCourse.get("Coef").toString());
    }
    private int getRandomElement(List<Integer> list) {
        Random random = new Random();
        int index = random.nextInt(list.size());
        return list.get(index);
    }
    private int getMaxIndex(List<Double> list){
        Double max = list.getFirst();
        int index = 0;
        for (int i = 1; i<list.size(); i++){
            if (list.get(i) > max){
                max = list.get(i);
                index = i;
            }
        }
        return index;
    }
    public Integer trouveElemDansListe(List<Integer> liste, int i){
        for (int j = 0; j < liste.size(); j++){
            if (liste.get(j) == i){
                return i;
            }
        }
        throwException.throwIllegalArgumentException("l'élément n'est pas présent dans la liste");
        return null;
    }
}
