package com.f1manager.demo.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseController {
    private final CourseService courseService;
    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    @GetMapping("/makeCourse/{idMecanicien1}/{idMecanicien2}/{idF11}/{idF12}/{idPilote1}/{idPilote2}/{tailleCourse}")
    public ResponseEntity<HashMap<String, List<String>>> makeCourse(@PathVariable int idMecanicien1, @PathVariable int idMecanicien2, @PathVariable int idF11, @PathVariable int idF12, @PathVariable int idPilote1, @PathVariable int idPilote2, @PathVariable int tailleCourse){
        return new ResponseEntity<>(courseService.course(idMecanicien1, idMecanicien2, idF11, idF12, idPilote1, idPilote2, tailleCourse), HttpStatus.OK);
    }
}
