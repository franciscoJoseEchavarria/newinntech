package com.newinntech.newinntech.Mapper.Interface;

import com.newinntech.newinntech.Contract.Reponse.CandidateResponse;
import com.newinntech.newinntech.Contract.Request.CandidateRequest;
import com.newinntech.newinntech.Models.CandidateModel;

public interface CandidateInterface {

    CandidateResponse mapCandidateModelToCandidateResponse (CandidateModel candidateModel);

    CandidateModel mapToCandidateRequestToCandidateResponse (CandidateRequest candidateRequest);

}
