package com.f1manager.demo;

import com.f1manager.demo.Formula1.Aileron.Ailerons;
import com.f1manager.demo.Formula1.Aileron.AileronsRepository;
import com.f1manager.demo.Formula1.Aileron.AileronsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AileronsServiceTest {

    @Mock
    private AileronsRepository aileronsRepository;

    @InjectMocks
    private AileronsService aileronsService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAileronsById() {
        Ailerons ailerons = new Ailerons(10.0, 1000, "image.png", 1);
        when(aileronsRepository.findById(anyInt())).thenReturn(Optional.of(ailerons));

        Ailerons result = aileronsService.getAileronsById(1);

        assertNotNull(result);
        assertEquals(ailerons, result);
    }

    @Test
    void testGetAileronsByIdNotFound() {
        when(aileronsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            aileronsService.getAileronsById(1);
        });

        String expectedMessage = "L'aileron n'est pas présent en base";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testSaveAileron() {
        Ailerons ailerons = new Ailerons(10.0, 1000, "image.png", 1);
        aileronsService.saveAileron(ailerons);
        verify(aileronsRepository, times(1)).save(ailerons);
    }

    @Test
    void testGetAllAilerons() {
        List<Ailerons> aileronsList = List.of(new Ailerons(10.0, 1000, "image.png", 1));
        when(aileronsRepository.findAll()).thenReturn(aileronsList);

        List<Ailerons> result = aileronsService.getAllAilerons();

        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    void testUpdatePoidsAileron() {
        Ailerons ailerons = new Ailerons(10.0, 1000, "image.png", 1);
        when(aileronsRepository.findById(anyInt())).thenReturn(Optional.of(ailerons));

        Ailerons result = aileronsService.updatePoidsAileron(1, 15.0);

        assertNotNull(result);
        assertEquals(15.0, result.getPoidsAileron());
        verify(aileronsRepository, times(1)).save(result);
    }

    @Test
    void testUpdatePrixAileron() {
        Ailerons ailerons = new Ailerons(10.0, 1000, "image.png", 1);
        when(aileronsRepository.findById(anyInt())).thenReturn(Optional.of(ailerons));

        Ailerons result = aileronsService.updatePrixAileron(1, 2000);

        assertNotNull(result);
        assertEquals(2000, result.getPrixAileron());
        verify(aileronsRepository, times(1)).save(result);
    }

}