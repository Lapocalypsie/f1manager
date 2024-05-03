package com.f1manager.demo.Joueur;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoueurService {
    private JoueurRepository joueurRepository;
}
