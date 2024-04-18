package com.f1manager.demo.Personnel;

import org.springframework.beans.factory.annotation.Autowired;
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
}