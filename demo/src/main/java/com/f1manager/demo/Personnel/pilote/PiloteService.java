package com.f1manager.demo.Personnel.pilote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PiloteService {

    @Autowired
    private PiloteRepository piloteRepository;

    public List<Pilote> getAllPilotes() {
        return piloteRepository.findAll();
    }

    public Pilote getPiloteById(Long id) {
        return piloteRepository.findById(id).orElse(null);
    }

    public Pilote createPilote(Pilote pilote) {
        return piloteRepository.save(pilote);
    }

    public void deletePilote(Long id) {
        piloteRepository.deleteById(id);
    }

    public void modifyNamePilote(Long id, String firstName, String lastName) {
        Pilote pilote = getPiloteById(id);
        if(pilote !=null) {
            pilote.setNom(firstName);
            pilote.setPrenom(lastName);
            piloteRepository.save(pilote);
        } else {
            System.out.println("Pilot Not Found ...");
        }
    }

    public void modifyNumberPilote(Long id, int newNumber) {
        Pilote pilote = getPiloteById(id);
        if(pilote !=null){
            pilote.setNumber(newNumber);
            piloteRepository.save(pilote);
        } else {
            System.out.println("Pilot Not Found");
        }
    }

    public void modifyPricePilote(Long id, int newPrice) {
        Pilote pilote = getPiloteById(id);
        if(pilote !=null){
        pilote.setPrice( newPrice);
        piloteRepository.save(pilote);
    } else {
        System.out.println("Pilot Not Found");
    }
}

    public void modifyForcePilote(Long id, int newForce) {
        Pilote pilote = getPiloteById(id);
        if(pilote !=null){
            pilote.setForce(newForce);
            piloteRepository.save(pilote);
        } else {
            System.out.println("Pilot Not Found");
        }
    }

    public void modifyEndurancePilote(Long id, int endurance) {
        Pilote pilote = getPiloteById(id);
        if(pilote !=null){
            pilote.setEndurance(endurance);
            piloteRepository.save(pilote);
        } else {
            System.out.println("Pilot Not Found");
        }
    }
}