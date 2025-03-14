package com.newinntech.newinntech.Repositorys;


import com.newinntech.newinntech.Entitys.VoterEntity;
import com.newinntech.newinntech.Models.VoterModel;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VoterRepository extends JpaRepository<VoterEntity, Long>
{


    Optional <VoterEntity> findById(Long id);
    Optional <VoterEntity> findByEmail(String email);
    Optional <VoterEntity> findByName(String name);
    boolean existsByName(String name);
    // Para contar los votantes que ya han votado:
    int countByHasVotedTrue();
    // Para validar si existe un votante con un nombre dado (en caso de controlar conflicto con candidato)
}
