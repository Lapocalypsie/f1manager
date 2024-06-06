package com.f1manager.demo;


import com.f1manager.demo.Joueur.Joueur;
import com.f1manager.demo.Joueur.JoueurService;
import com.f1manager.demo.Log.Log;
import com.f1manager.demo.Utils.CalculStats;
import com.f1manager.demo.systemeco.Achat;
import com.f1manager.demo.systemeco.Vente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@PrepareForTest({CalculStats.class, Log.class, Achat.class, Vente.class})
public class MecanicienServiceTest {

    @Mock
    private MecanicienRepository mecanicienRepository;

    @Mock
    private JoueurService joueurService;

    @InjectMocks
    private MecanicienService mecanicienService;

    private Mecanicien mecanicien;
    private Joueur joueur;

    @BeforeEach
    public void setup() {
        mecanicien = new Mecanicien("John", "Doe", 1, 10.0, 9.0, 1000.0, false);
        joueur = new Joueur("Player1", 5000.0);
    }

    @Test
    public void testGetVitesseMecanicienbyId() {
        when(mecanicienRepository.findById(1)).thenReturn(Optional.of(mecanicien));

        double vitesse = mecanicienService.getVitesseMecanicienbyId(1);

        assertEquals(10.0, vitesse);
        verify(mecanicienRepository).findById(1);
    }

    @Test
    public void testGetPerformanceMecanicienbyId() {
        when(mecanicienRepository.findById(1)).thenReturn(Optional.of(mecanicien));

        double performance = mecanicienService.getPerformanceMecanicienbyId(1);

        assertEquals(9.0, performance);
        verify(mecanicienRepository).findById(1);
    }

    @Test
    public void testCreerMecanicien() {
        PowerMockito.mockStatic(CalculStats.class);
        when(CalculStats.calculerCoefficientMecanicien(any(Mecanicien.class))).thenReturn(1.5);

        Mecanicien newMecanicien = mecanicienService.creerMecanicien("John", "Doe", 1, 10.0, 9.0, 1000.0);

        assertEquals("John", newMecanicien.getNom());
        assertEquals("Doe", newMecanicien.getPrenom());
        assertEquals(1.5, newMecanicien.getCoefficient());
        verify(mecanicienRepository).save(any(Mecanicien.class));
    }

    @Test
    public void testGetMecanicienCoef() {
        PowerMockito.mockStatic(CalculStats.class);
        when(mecanicienRepository.findById(1)).thenReturn(Optional.of(mecanicien));
        when(CalculStats.calculerCoefficientMecanicien(any(Mecanicien.class))).thenReturn(1.5);

        double coefficient = mecanicienService.getMecanicienCoef(1);

        assertEquals(1.5, coefficient);
        verify(mecanicienRepository).findById(1);
    }

    @Test
    public void testBuyMecanicien() {
        PowerMockito.mockStatic(Achat.class);
        when(mecanicienRepository.findById(1)).thenReturn(Optional.of(mecanicien));
        when(joueurService.getJoueurById(1)).thenReturn(joueur);

        double remainingMoney = mecanicienService.buyMecanicien(1, 1);

        verify(mecanicienRepository).findById(1);
        verify(joueurService).getJoueurById(1);
        verify(joueurService).saveJoueur(joueur);
        verify(mecanicienRepository).save(mecanicien);
        assertEquals(joueur.getArgent(), remainingMoney);
    }

    @Test
    public void testSellMecanicien() {
        PowerMockito.mockStatic(Vente.class);
        when(mecanicienRepository.findById(1)).thenReturn(Optional.of(mecanicien));
        when(joueurService.getJoueurById(1)).thenReturn(joueur);

        double remainingMoney = mecanicienService.sellMecanicien(1, 1);

        verify(mecanicienRepository).findById(1);
        verify(joueurService).getJoueurById(1);
        verify(joueurService).saveJoueur(joueur);
        verify(mecanicienRepository).save(mecanicien);
        assertEquals(joueur.getArgent(), remainingMoney);
    }

    @Test
    public void testDeleteMecanicien() {
        mecanicienService.deleteMecanicien(1);

        verify(mecanicienRepository).deleteById(1);
    }
}