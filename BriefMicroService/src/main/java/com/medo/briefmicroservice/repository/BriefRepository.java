package com.medo.briefmicroservice.repository;

import com.medo.briefmicroservice.model.Brief;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BriefRepository extends JpaRepository<Brief,Long> {

}
