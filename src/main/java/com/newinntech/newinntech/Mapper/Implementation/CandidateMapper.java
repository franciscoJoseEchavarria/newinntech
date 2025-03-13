package com.newinntech.newinntech.Mapper.Implementation;


import com.newinntech.newinntech.Entitys.CandidateEntity;
import com.newinntech.newinntech.Models.CandidateModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CandidateMapper {

    CandidateEntity mapCandidateModelToCandidateEntity (CandidateEntity candidateEntity);
    CandidateModel mapToCandidateEntityToCandidateModel (CandidateModel candidateModel);

}
