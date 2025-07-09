package com.enaait.repository;

import com.enaait.model.Competence;
import com.enaait.model.SousCompetence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;



@Repository
public interface CompetenceRepository extends JpaRepository<Competence, Long> {


    @Query(value = "SELECT * FROM sous_competence , nom right join competence on comptetence.id =  sous_competence.id; ",  nativeQuery = true)
    public List<SousCompetence> getSousCompetenceByCompetence(Long competenceId);

} 