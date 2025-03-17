package com.newinntech.newinntech.Services;


import com.newinntech.newinntech.Contract.Reponse.CandidateStaticResponse;
import com.newinntech.newinntech.Contract.Reponse.VoteStaticaReponse;
import com.newinntech.newinntech.Entitys.CandidateEntity;
import com.newinntech.newinntech.Entitys.VoteEntity;
import com.newinntech.newinntech.Entitys.VoterEntity;
import com.newinntech.newinntech.Exception.ResourceNotFoundException;
import com.newinntech.newinntech.Exception.VotoEmitido;
import com.newinntech.newinntech.Mapper.Implementation.CandidateMapper;
import com.newinntech.newinntech.Mapper.Implementation.VoteMapper;
import com.newinntech.newinntech.Models.VoteModel;
import com.newinntech.newinntech.Repositorys.CandidateRepository;
import com.newinntech.newinntech.Repositorys.VoteRepository;
import com.newinntech.newinntech.Repositorys.VoterRepository;
import com.newinntech.newinntech.Repositorys.projection.CandidateVoteCount;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor

@Data
@Getter
@Setter
@Builder

@Service
public class VoteService {

    private final VoteRepository voteRepository;
    private final VoteMapper voteMapper;
    private final VoterRepository voterRepository;
    private final CandidateMapper candidateMapper;
    private final CandidateRepository candidateRepository;

    public VoteModel createVote(VoteModel voteModel) {
        VoteEntity voteEntity = voteMapper.mapVoteModelToVoteEntity(voteModel);
        VoterEntity voterEntity = voterRepository.findById(voteEntity.getVoter().getId())
                .orElseThrow(() -> new ResourceNotFoundException("El votante con ID" + voteEntity.getVoter().getId() + " no existe"));
        if (voterEntity.isHasVoted()) {
            throw new VotoEmitido("El votante ya ha emitido su voto");
        }
        CandidateEntity candidateEntity = candidateRepository.findById(voteEntity.getCandidate().getId())
                .orElseThrow(() -> new ResourceNotFoundException("El candidato con ID" + voteEntity.getCandidate().getId() + " no existe"));
        // Asignar las entidades completas al voteEntity para conservar la integridad de las relaciones
        voteEntity.setVoter(voterEntity);
        voteEntity.setCandidate(candidateEntity);
        // Persistir el voto en la base de datos
        VoteEntity savedVoteEntity = voteRepository.save(voteEntity);
        // Actualizar la bandera del votante para indicar que ha votado
        voterEntity.setHasVoted(true);
        voterRepository.save(voterEntity);
        // Incrementar el conteo de votos del candidato
        candidateEntity.setVotes(candidateEntity.getVotes() + 1);
        candidateRepository.save(candidateEntity);
        // Convertir el VoteEntity guardado a VoteModel
        return voteMapper.mapVoteEntityToVoteModel(savedVoteEntity);
    }



    public VoteModel getVoteById(Long id) {
        return voteMapper.mapVoteEntityToVoteModel(voteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("El voto con ID" + id + " no existe")));
    }

    public List <VoteModel> getVoteAll() {
       List <VoteEntity> voteEntity = voteRepository.findAll();
       if(voteEntity.isEmpty()){
           throw new ResourceNotFoundException("No hay votos en la BD");
       }
        return voteMapper.mapVoteEntityListToVoteModelList(voteEntity);
    }

    public VoteModel deleteVoteById(Long id) {
        VoteEntity voteEntity = voteRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("El voto no se encuentra en la BD: " + id)
        );
        voteRepository.deleteById(id);
        return voteMapper.mapVoteEntityToVoteModel(voteEntity);
    }


    public VoteStaticaReponse getVoteStatistics() {
        // 1. Obtener el conteo de votos agrupados por candidato mediante la proyección.
        List<CandidateVoteCount> candidateVoteCounts = voteRepository.countVotesByCandidate();
        // 2. Calcular el total de votos (total de votantes, asumiendo 1 voto por votante).
        Long totalVotes = candidateVoteCounts.stream()
                .mapToLong(CandidateVoteCount::getTotalVotes)
                .sum();
        //3. Construir las lista de estadisticas para cada candidato
        List<CandidateStaticResponse> candidateStaticResponses = new ArrayList<>();
        for (CandidateVoteCount count : candidateVoteCounts){
           CandidateEntity candidateEntity = candidateRepository.findById(count.getCandidateId()).orElse(null);
           double percentage = totalVotes > 0 ? ((double) (count.getTotalVotes() * 100) /totalVotes) : 0 ;
           candidateStaticResponses.add(new CandidateStaticResponse (count.getCandidateId(), candidateEntity.getName(), candidateEntity.getVotes(),percentage));
        }
        return new VoteStaticaReponse(candidateStaticResponses, totalVotes);
    }




}
