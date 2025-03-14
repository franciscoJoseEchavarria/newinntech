package com.newinntech.newinntech.Repositorys;


import com.newinntech.newinntech.Entitys.CandidateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CandidateRepository extends JpaRepository<CandidateEntity, Long> {

    Optional<CandidateEntity> findByName(String name);
    boolean existsByName(String name);
}
