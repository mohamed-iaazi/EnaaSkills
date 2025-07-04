import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Optional;

import com.enaait.model.Competence;
import com.enaait.model.SousCompetence;
import com.enaait.repository.CompetenceRepository;
import com.enaait.repository.SousCompetenceRepository;
import com.enaait.service.CompetenceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

public class CompetenceServiceTest {

    @Mock
    private CompetenceRepository competenceRepository;

    @Mock
    private SousCompetenceRepository sousCompetenceRepository;

    @InjectMocks
    private CompetenceService competenceService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveCompetence_shouldSetCompetenceOnSousCompetencesAndSave() {
        // Préparation
        Competence competence = new Competence();
        competence.setSousCompetences(Arrays.asList(
                new SousCompetence(), new SousCompetence()
        ));

        when(competenceRepository.save(any(Competence.class))).thenAnswer(i -> i.getArgument(0));

        // Appel
        Competence saved = competenceService.saveCompetence(competence);

        // Vérifications
        assertNotNull(saved);
        for (SousCompetence sc : saved.getSousCompetences()) {
            assertEquals(saved, sc.getCompetence());
        }
        verify(competenceRepository, times(1)).save(saved);
    }

    @Test
    public void testValiderSousCompetence_shouldUpdateSousCompetenceAndCompetence() {
        // Préparation
        Competence competence = new Competence();
        competence.setSousCompetences(Arrays.asList());

        SousCompetence sc = new SousCompetence();
        sc.setId(1L);
        sc.setCompetence(competence);
        sc.setValide(false);

        when(sousCompetenceRepository.findById(1L)).thenReturn(Optional.of(sc));
        when(sousCompetenceRepository.save(any(SousCompetence.class))).thenAnswer(i -> i.getArgument(0));
        when(competenceRepository.save(any(Competence.class))).thenAnswer(i -> i.getArgument(0));

        // Appel
        competenceService.validerSousCompetence(1L, true);

        // Vérifications
        assertTrue(sc.isValide());
        verify(sousCompetenceRepository, times(1)).save(sc);
        verify(competenceRepository, times(1)).save(competence);
    }

    @Test
    public void testIsCompetenceValide_shouldReturnFalseIfOneSousCompetenceIsNotValid() {
        Competence competence = new Competence();

        SousCompetence sc1 = new SousCompetence();
        sc1.setValide(true);

        SousCompetence sc2 = new SousCompetence();
        sc2.setValide(false);

        competence.setSousCompetences(Arrays.asList(sc1, sc2));

        // Méthode privée, on teste indirectement via saveCompetence
        competenceService.saveCompetence(competence);

        // Le statut doit être false
        assertFalse(competence.isValide());
    }

    @Test
    public void testIsCompetenceValide_shouldReturnTrueIfAllSousCompetencesAreValid() {
        Competence competence = new Competence();

        SousCompetence sc1 = new SousCompetence();
        sc1.setValide(true);

        SousCompetence sc2 = new SousCompetence();
        sc2.setValide(true);

        competence.setSousCompetences(Arrays.asList(sc1, sc2));

        competenceService.saveCompetence(competence);

        assertTrue(competence.isValide());
    }
}
