package com.newinntech.newinntech.Mapper.Implementation;


import com.newinntech.newinntech.Entitys.VoteEntity;
import com.newinntech.newinntech.Entitys.VoterEntity;
import com.newinntech.newinntech.Models.VoteModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VoteMapper {

    VoteEntity mapToVoteEntityToVoteModel (VoteEntity voterEntity);

    VoteModel mapVoteModelToVoteEntity (VoteModel voteModel);

}
