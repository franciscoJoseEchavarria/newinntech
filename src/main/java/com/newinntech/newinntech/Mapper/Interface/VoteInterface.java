package com.newinntech.newinntech.Mapper.Interface;

import com.newinntech.newinntech.Contract.Reponse.VoteResponse;
import com.newinntech.newinntech.Contract.Request.VoteRequest;
import com.newinntech.newinntech.Models.VoteModel;


public interface VoteInterface {

    VoteModel mapToVoterRequestToVoterModel (VoteRequest voteRequest);

    VoteResponse mapToVoterModelToVoterResponse (VoteModel voteModel);

}
