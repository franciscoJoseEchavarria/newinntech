package com.newinntech.newinntech.Mapper.Implementation;


import com.newinntech.newinntech.Entitys.VoteEntity;
import com.newinntech.newinntech.Entitys.VoterEntity;
import com.newinntech.newinntech.Models.CandidateModel;
import com.newinntech.newinntech.Models.VoteModel;
import com.newinntech.newinntech.Models.VoterModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VoteMapper {

    // Mapea de VoteEntity a VoteModel (en caso de necesitar trabajar con modelos directamente)
    @Mapping( target = "voter.id", source = "voter.id") //sale voterEntity y entra voterModel
    @Mapping(source = "candidate.id", target = "candidate.id") //sale candidateEntity y entra candidateModel
    VoteModel voteEntityToVoteModel(VoteEntity voteEntity);

    // Mapea de VoteModel a VoteEntity
    @Mapping( target = "voter", source = "voter") //sale voterModel y entra voterEntity
    @Mapping( target = "candidate", source = "candidate" ) //sale candidateModel y entra candidateEntity
    VoteEntity voteModelToVoteEntity(VoteModel voteModel);

    List<VoteModel> voteEntityListToVoteModelList(List<VoteEntity> voteEntities);
    List<VoteEntity> voteModelListToVoteEntityList(List<VoteModel> voteModels);
}
