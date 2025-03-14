package com.newinntech.newinntech.Repositorys;


import com.newinntech.newinntech.Entitys.VoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoteRepository extends JpaRepository<VoteEntity, Long> {

    Optional <VoteEntity> findById(Long id);
    Optional <VoteEntity> findByVoterId(Long voterId);
    Optional <VoteEntity> findByCandidateId(Long candidateId);
    boolean existsByVoterId(Long voterId);
    boolean existsByCandidateId(Long candidateId);
}
