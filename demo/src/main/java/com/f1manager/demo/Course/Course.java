package com.f1manager.demo.Course;

import com.f1manager.demo.Formula1.F1;
import com.f1manager.demo.Formula1.F1Service;
import com.f1manager.demo.Personnel.Mecanicien.Mecanicien;
import com.f1manager.demo.Personnel.pilote.Pilote;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Entity
@Getter
@Setter
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany
    private List<F1> f1List;

    @OneToMany
    private List<Pilote> piList;

    @OneToMany
    private List<Mecanicien> mecanoList;

    public Course(int id, List<F1> f1List, List<Pilote> piList, List<Mecanicien> mecanoList) {
        this.id = id;
        this.f1List = f1List;
        this.piList = piList;
        this.mecanoList = mecanoList;
    }

    public Course() {

    }
    /*
    public Course(int idPremiereF1, int idDeuxiemeF1, int idPremierPilote, int idDeuxiemePilote, int idPremierMecanicien, int idDeuxiemeMecanicien, int tailleCourse) {
        this.f1Service = f1Service;
        List<F1> f1List = CourseService.fillF1List(idPremiereF1, idDeuxiemeF1, tailleCourse);
        List<Pilote> piList = CourseService.fillPiList(idPremierPilote, idDeuxiemePilote, tailleCourse);
        List<Mecanicien> mecanoList = CourseService.fillMecanoList(idPremierMecanicien, idDeuxiemeMecanicien, tailleCourse);

    }
     */
}
