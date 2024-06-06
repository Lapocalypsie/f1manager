package com.f1manager.demo;

import com.f1manager.demo.Joueur.Joueur;
import com.f1manager.demo.Joueur.JoueurService;
import com.f1manager.demo.Personnel.pilote.Pilote;
import com.f1manager.demo.Personnel.pilote.PiloteRepository;
import com.f1manager.demo.Utils.CalculStats;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PiloteService {

    @Mock
    private PiloteRepository piloteRepository;

    @Mock
    private JoueurService joueurService;

    @InjectMocks
    private com.f1manager.demo.Personnel.pilote.PiloteService piloteService;

    private Pilote pilote;
    private Joueur joueur;

    @BeforeEach
    public void setup() {
        pilote = new Pilote("Cena", "John", 66, 150_000, 98, 85,false, "image.png", 1);
        joueur = new Joueur("Clement","Savonnet",1,1,600_000);
    }

    @Test
    public void testGetAllPilotes() {
        when(piloteRepository.findAll()).thenReturn(List.of(pilote));
        assertEquals(1, piloteService.getAllPilotes().size());
    }

    @Test
    public void testCreatePilote() {
        when(piloteRepository.save(any(Pilote.class))).thenReturn(pilote);
        Pilote createdPilote = piloteService.createPilote("John", "Doe", 1, 10, 1000.0, 80.0, 70.0, "image.png");
        assertNotNull(createdPilote);
        assertEquals("John", createdPilote.getNom());
    }

    @Test
    public void testDeletePilote() {
        doNothing().when(piloteRepository).deleteById(anyInt());
        piloteService.deletePilote(1);
        verify(piloteRepository, times(1)).deleteById(1);
    }

    @Test
    public void testGetPiloteById() {
        when(piloteRepository.findById(anyInt())).thenReturn(Optional.of(pilote));
        Pilote foundPilote = piloteService.getPiloteById(1);
        assertNotNull(foundPilote);
    }

    @Test
    public void testModifyNamePilote() {
        when(piloteRepository.findById(anyInt())).thenReturn(Optional.of(pilote));
        doAnswer(invocation -> {
            Pilote p = invocation.getArgument(0);
            assertEquals("Jane", p.getNom());
            assertEquals("Smith", p.getPrenom());
            return null;
        }).when(piloteRepository).save(any(Pilote.class));
        piloteService.modifyNamePilote(1, "Jane", "Smith");
    }

    @Test
    public void testModifyNumberPilote() {
        when(piloteRepository.findById(anyInt())).thenReturn(Optional.of(pilote));
        doAnswer(invocation -> {
            Pilote p = invocation.getArgument(0);
            assertEquals(20, p.getNumber());
            return null;
        }).when(piloteRepository).save(any(Pilote.class));
        piloteService.modifyNumberPilote(1, 20);
    }

    @Test
    public void testModifyPricePilote() {
        when(piloteRepository.findById(anyInt())).thenReturn(Optional.of(pilote));
        doAnswer(invocation -> {
            Pilote p = invocation.getArgument(0);
            assertEquals(2000.0, p.getPrice());
            return null;
        }).when(piloteRepository).save(any(Pilote.class));
        piloteService.modifyPricePilote(1, 2000);
    }

    @Test
    public void testModifyForcePilote() {
        when(piloteRepository.findById(anyInt())).thenReturn(Optional.of(pilote));
        doAnswer(invocation -> {
            Pilote p = invocation.getArgument(0);
            assertEquals(90.0, p.getForce());
            return null;
        }).when(piloteRepository).save(any(Pilote.class));
        piloteService.modifyForcePilote(1, 90);
    }

    @Test
    public void testModifyEndurancePilote() {
        when(piloteRepository.findById(anyInt())).thenReturn(Optional.of(pilote));
        doAnswer(invocation -> {
            Pilote p = invocation.getArgument(0);
            assertEquals(80.0, p.getEndurance());
            return null;
        }).when(piloteRepository).save(any(Pilote.class));
        piloteService.modifyEndurancePilote(1, 80);
    }

    @Test
    public void testUpgradePilote() {
        when(piloteRepository.findById(anyInt())).thenReturn(Optional.of(pilote));
        doAnswer(invocation -> {
            Pilote p = invocation.getArgument(0);
            assertTrue(p.getNiveauActuel() > 1);
            return null;
        }).when(piloteRepository).save(any(Pilote.class));
        piloteService.upgradePilote(1);
    }

    @Test
    public void testGetPiloteCoef() {
        when(piloteRepository.findById(anyInt())).thenReturn(Optional.of(pilote));
        when(CalculStats.calculerCoefficientPilote(any(Pilote.class))).thenReturn(1.5);
        double coef = piloteService.getPiloteCoef(1);
        assertEquals(1.5, coef);
    }

    @Test
    public void testBuyPilote() {
        when(piloteRepository.findById(anyInt())).thenReturn(Optional.of(pilote));
        when(joueurService.getJoueurById(anyInt())).thenReturn(joueur);
        doNothing().when(joueurService).saveJoueur(any(Joueur.class));
        double remainingMoney = piloteService.buyPilote(1, 1);
        assertEquals(4000.0, remainingMoney);
    }

    @Test
    public void testSellPilote() {
        when(piloteRepository.findById(anyInt())).thenReturn(Optional.of(pilote));
        when(joueurService.getJoueurById(anyInt())).thenReturn(joueur);
        doNothing().when(joueurService).saveJoueur(any(Joueur.class));
        double remainingMoney = piloteService.sellPilote(1, 1);
        assertEquals(6000.0, remainingMoney);
    }
}