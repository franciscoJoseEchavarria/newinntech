package com.newinntech.newinntech.Mapper.Implementation;


import com.newinntech.newinntech.Entitys.VoteEntity;
import com.newinntech.newinntech.Models.VoteModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VoteMapper {

    // Mapea de VoteEntity a VoteModel (en caso de necesitar trabajar con modelos directamente)
    @Mapping( target = "voter.id", source = "voter.id") //sale voterEntity y entra voterModel
    @Mapping(source = "candidate.id", target = "candidate.id") //sale candidateEntity y entra candidateModel
    VoteModel mapVoteEntityToVoteModel(VoteEntity voteEntity);

    // Mapea de VoteModel a VoteEntity
    @Mapping( target = "voter.id", source = "voter.id") //sale voterModel y entra voterEntity
    @Mapping( target = "candidate.id", source = "candidate.id" ) //sale candidateModel y entra candidateEntity
    VoteEntity mapVoteModelToVoteEntity(VoteModel voteModel);

    List<VoteModel> mapVoteEntityListToVoteModelList(List<VoteEntity> voteEntities);
    List<VoteEntity> mapVoteModelListToVoteEntityList(List<VoteModel> voteModels);
}
