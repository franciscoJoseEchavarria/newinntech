package com.newinntech.newinntech.Services;


import com.newinntech.newinntech.Entitys.VoterEntity;
import com.newinntech.newinntech.Exception.Vote.ResourceNotFoundException;
import com.newinntech.newinntech.Exception.Vote.VoterAlreadyCandidateException;
import com.newinntech.newinntech.Exception.Vote.VoterAlreadyExistsException;
import com.newinntech.newinntech.Mapper.Implementation.VoterMapper;
import com.newinntech.newinntech.Models.VoterModel;
import com.newinntech.newinntech.Repositorys.VoterRepository;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor

@Data
@Getter
@Setter
@Builder

@Service
public class VoterService {

    private final VoterRepository voterRepository;
    private final VoterMapper voterMapper;

    /**
     * Crea un nuevo votante.
     * @param voterModel Objeto votante a guardar.
     * @return voterModel objeto guardado.
     * @throws Exception Si el votante ya está registrado como candidato.
     */

    public VoterModel CreateVoter(VoterModel voterModel) {

        VoterEntity voterEntity = voterMapper.mapVoterModelToVoterEntity(voterModel);

        voterRepository.findByEmail(voterEntity.getEmail())
                .ifPresent(existing -> {
                    throw new VoterAlreadyExistsException("El votante ya está registrado con el email: " + voterEntity.getEmail());
                });
        return voterMapper.mapToVoterEntityToVoterModel(voterRepository.save(voterEntity));

    }

    public  VoterModel getVoterById(Long id) {
        Optional <VoterEntity> voterEntity = voterRepository.findById(id);

        if (voterEntity.isEmpty()) {
            throw new ResourceNotFoundException(" el id no tiene asignación de usuario" );
        }
        return voterMapper.mapToVoterEntityToVoterModel(voterEntity.get());
    }

    public List <VoterModel> getVoterAll() {

        List <VoterEntity> voterEntity = voterRepository.findAll();

        if (voterEntity.isEmpty()) {
            System.out.println("No hay usuarios registrados");
        }

        return voterMapper.mapToVoterListToEntityToVoterModelList(voterEntity);
    }

    public VoterModel deteleVoterById(Long id) {
        Optional <VoterEntity> voterEntity = voterRepository.findById(id);
        if (voterEntity.isEmpty()) {
            System.out.println(" el id no tiene asignación de usuario" );
        }
        voterRepository.deleteById(id);
        return voterMapper.mapToVoterEntityToVoterModel(voterEntity.get());
    }
}
