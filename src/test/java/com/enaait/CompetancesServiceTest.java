package com.enaait;

import com.enaait.model.Competence;
import com.enaait.model.SousCompetence;
import com.enaait.repository.CompetenceRepository;
import com.enaait.repository.SousCompetenceRepository;
import com.enaait.service.CompetenceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CompetenceServiceTest {

    private CompetenceRepository competenceRepository;
    private SousCompetenceRepository sousCompetenceRepository;
    private CompetenceService competenceService;

    @BeforeEach
    void setUp() {
        competenceRepository = mock(CompetenceRepository.class);
        sousCompetenceRepository = mock(SousCompetenceRepository.class);
        competenceService = new CompetenceService(competenceRepository, sousCompetenceRepository);
    }

    @Test
    void testSaveCompetence() {
        Competence competence = new Competence();
        competence.setNom("Test");

        when(competenceRepository.save(competence)).thenReturn(competence);

        Competence saved = competenceService.saveCompetence(competence);

        assertNotNull(saved);
        assertEquals("Test", saved.getNom());
        verify(competenceRepository, times(1)).save(competence);
    }

    @Test
    void testGetAllCompetences() {
        when(competenceRepository.findAll()).thenReturn(Arrays.asList(new Competence(), new Competence()));

        assertEquals(2, competenceService.getAllCompetences().size());
        verify(competenceRepository, times(1)).findAll();
    }

    @Test
    void testValiderSousCompetence() {
        SousCompetence sc = new SousCompetence();
        sc.setId(1L);
        sc.setValide(false);

        when(sousCompetenceRepository.findById(1L)).thenReturn(Optional.of(sc));
        when(sousCompetenceRepository.save(any(SousCompetence.class))).thenReturn(sc);

        competenceService.validerSousCompetence(1L, true);

        assertTrue(sc.isValide());
        verify(sousCompetenceRepository, times(1)).save(sc);
    }

    @Test
    void testDeleteCompetence() {
        competenceService.deleteCompetence(5L);
        verify(competenceRepository, times(1)).deleteById(5L);
    }
}

