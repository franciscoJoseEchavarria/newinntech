package com.newinntech.newinntech.Mapper.Interface;


import com.newinntech.newinntech.Contract.Reponse.VoteResponse;
import com.newinntech.newinntech.Contract.Request.VoteRequest;
import com.newinntech.newinntech.Models.VoteModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VoteInterface {

    @Mapping( target = "voter.id", source = "voter_id.id")   //sale voterRequest y entra voterModel
    @Mapping( target = "candidate.id" ,source = "candidate_id.id") //sale candidateRequest y entra candidateModel
    VoteModel voteRequestToVoteModel(VoteRequest voteRequest);

    @Mapping( target = "voter_id.id", source = "voter.id") //sale voterModel y entra voterResponse
    @Mapping(target = "candidate.id", source = "candidate_id.id" ) //sale candidateModel y entra candidateResponse
    VoteResponse voteModelToVoteResponse(VoteModel voteModel);




}
