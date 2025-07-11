package com.medo.briefmicroservice.repository;

import com.medo.briefmicroservice.dto.Competence;
import com.medo.briefmicroservice.model.BriefCompetances;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompetenceRepository extends JpaRepository<BriefCompetances, Long> {
}
