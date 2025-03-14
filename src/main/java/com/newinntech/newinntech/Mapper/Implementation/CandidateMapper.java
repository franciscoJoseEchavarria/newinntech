package com.newinntech.newinntech.Mapper.Implementation;


import com.newinntech.newinntech.Entitys.CandidateEntity;
import com.newinntech.newinntech.Models.CandidateModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CandidateMapper {

    CandidateEntity mapCandidateModelToCandidateEntity (CandidateModel candidateModel);
    CandidateModel mapToCandidateEntityToCandidateModel (CandidateEntity candidateEntity);

    List <CandidateEntity> mapCandidateModelListToCandidateEntityList (List<CandidateModel> candidateModel);
    List <CandidateModel> mapCandidateEntityListToCandidateModelList (List<CandidateEntity> candidateEntity);


}
