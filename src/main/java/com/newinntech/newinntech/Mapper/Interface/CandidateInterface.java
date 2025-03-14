package com.newinntech.newinntech.Mapper.Interface;

import com.newinntech.newinntech.Contract.Reponse.CandidateResponse;
import com.newinntech.newinntech.Contract.Request.CandidateRequest;
import com.newinntech.newinntech.Models.CandidateModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CandidateInterface {

    CandidateModel mapToCandidateRequestToCandidateModel(CandidateRequest candidateRequest);

    CandidateResponse mapToCandidateModelToCandidateResponse(CandidateModel candidateModel);

    List <CandidateResponse> mapToCandidateListToCandidateResponseList(List<CandidateModel> candidateModelList);
}
