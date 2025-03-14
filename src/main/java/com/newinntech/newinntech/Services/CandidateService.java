package com.newinntech.newinntech.Services;


import com.newinntech.newinntech.Entitys.CandidateEntity;

import com.newinntech.newinntech.Exception.AlreadyExistsException;
import com.newinntech.newinntech.Exception.ResourceNotFoundException;
import com.newinntech.newinntech.Mapper.Implementation.CandidateMapper;
import com.newinntech.newinntech.Models.CandidateModel;
import com.newinntech.newinntech.Repositorys.CandidateRepository;
import com.newinntech.newinntech.Repositorys.VoterRepository;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor

@Data
@Getter
@Setter
@Builder

@Service

public class CandidateService {

    private final CandidateRepository candidateRepository;
    private final CandidateMapper candidateMapper;
    private final VoterRepository voterRepository;


    public CandidateModel CreateCandidate(CandidateModel candidateModel) {


        CandidateEntity candidateEntity = candidateMapper.mapCandidateModelToCandidateEntity(candidateModel);

        candidateRepository.findByNameIgnoreCase(candidateEntity.getName().toLowerCase())
                .ifPresent(existing -> {
                    throw new AlreadyExistsException("Ya está registrado como candidato con el nombre: " + candidateEntity.getName());
                });
        voterRepository.findByNameIgnoreCase(candidateEntity.getName().toLowerCase())
                .ifPresent(existing -> {
                    throw new AlreadyExistsException("Ya está registrado como votante con el nombre: " + candidateEntity.getName());
                });

        return candidateMapper.mapToCandidateEntityToCandidateModel(candidateRepository.save(candidateEntity));
    }

    public List <CandidateModel> getCandidateList() {
        return candidateMapper.mapCandidateEntityListToCandidateModelList
                (candidateRepository.findAll());
    }


    public CandidateModel getCandidateById(Long id) {
        return candidateMapper.mapToCandidateEntityToCandidateModel(candidateRepository.findById(id).get()

        );
    }


    public CandidateModel deleteCandidate (Long id) {
        CandidateEntity candidateEntity = candidateRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("El candidato no se encuentre en la BD: " + id)
        );
            candidateRepository.deleteById(id);
        return candidateMapper.mapToCandidateEntityToCandidateModel(candidateEntity);
    }


}
