package com.f1manager.demo;

import com.f1manager.demo.Joueur.Joueur;
import com.f1manager.demo.Joueur.JoueurService;
import com.f1manager.demo.Personnel.pilote.Pilote;
import com.f1manager.demo.Personnel.pilote.PiloteRepository;
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
public class PiloteServiceTest {

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

}