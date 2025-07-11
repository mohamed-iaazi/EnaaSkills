package com.medo.competencemicroservice.repository;

import com.medo.competencemicroservice.model.Competence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetenceRepository extends JpaRepository<Competence,String> {

}
