package com.newinntech.newinntech.Services;


import com.newinntech.newinntech.Entitys.VoterEntity;
import com.newinntech.newinntech.Exception.AlreadyExistsException;
import com.newinntech.newinntech.Exception.ResourceNotFoundException;

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

        voterRepository.findByEmailIgnoreCase(voterEntity.getEmail().toLowerCase())
                .ifPresent(existing -> {
                    throw new AlreadyExistsException("El votante ya está registrado con el email: " + voterEntity.getEmail());
                });

        voterRepository.findByNameIgnoreCase(voterEntity.getName().toLowerCase())
                .ifPresent(existing -> {
                    throw new AlreadyExistsException("El votante ya está registrado con el nombre: " + voterEntity.getName());
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
            throw new ResourceNotFoundException("No hay usuarios registrados");
        }
        return voterMapper.mapToVoterListToEntityToVoterModelList(voterEntity);
    }

    public VoterModel deteleVoterById(Long id) {
        VoterEntity voterEntity = voterRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("El votante no se encuentra en la BD: " + id)
        );
        voterRepository.deleteById(id);
        return voterMapper.mapToVoterEntityToVoterModel(voterEntity);
    }
}
