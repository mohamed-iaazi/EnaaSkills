package com.enaait.repository;

import com.enaait.model.SousCompetence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SousCompetenceRepository extends JpaRepository<SousCompetence, Long> {
} 