package com.f1manager.demo.Course;


import com.f1manager.demo.Formula1.F1;
import com.f1manager.demo.Formula1.F1Service;
import com.f1manager.demo.Personnel.Mecanicien.Mecanicien;
import com.f1manager.demo.Personnel.Mecanicien.MecanicienService;
import com.f1manager.demo.Personnel.pilote.Pilote;
import com.f1manager.demo.Personnel.pilote.PiloteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.apache.commons.lang3.ArrayUtils.removeElement;

@Service
@RequiredArgsConstructor
public class CourseService {
    @Autowired
    private final F1Service f1Service;
    private final MecanicienService mecanicienService;
    private final PiloteService piloteService;
    private CourseRepoitory courseRepository;

    public List<F1> fillF1List(int id1, int id2, int tailleCourse){
        List<F1> result = new ArrayList<>();
        result.add(f1Service.getF1ById(id1));
        result.add(f1Service.getF1ById(id2));
        List<Integer> allF1 = f1Service.getAllF1Ids();
        allF1.remove(id1);
        allF1.remove(id2);
        for (int i = 2; i <= tailleCourse; i++) {
            result.add(f1Service.getF1ById(getRandomElement(allF1)));
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
        for (int i = 2; i <= tailleCourse; i++) {
            result.add(mecanicienService.getMecanicienById(getRandomElement(allMecano)));
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
        for (int i = 2; i <= tailleCourse; i++) {
            result.add(piloteService.getPiloteById(getRandomElement(allPil)));
        }
        return result;
    }

    public int getRandomElement(List<Integer> list) {
        Random random = new Random();
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}
