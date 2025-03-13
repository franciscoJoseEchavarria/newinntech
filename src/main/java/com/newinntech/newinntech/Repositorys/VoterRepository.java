package com.newinntech.newinntech.Repositorys;


import com.newinntech.newinntech.Entitys.VoterEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoterRepository extends JpaRepository<VoterEntity, Long>
{

    Optional <VoterEntity> findByEmail(String email);
    // Para contar los votantes que ya han votado:
    int countByHasVotedTrue();
    // Para validar si existe un votante con un nombre dado (en caso de controlar conflicto con candidato)
    boolean existsByName(String name);

}
