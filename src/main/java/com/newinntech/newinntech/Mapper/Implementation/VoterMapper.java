package com.newinntech.newinntech.Mapper.Implementation;


import com.newinntech.newinntech.Entitys.VoterEntity;
import com.newinntech.newinntech.Models.VoterModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VoterMapper {

    VoterEntity mapVoterModelToVoterEntity (VoterModel voterModel);

    VoterModel mapToVoterEntityToVoterModel (VoterEntity voterEntity);

    List<VoterModel> mapToVoterListToEntityToVoterModelList (List<VoterEntity> voterEntity);

    List<VoterEntity> mapVoterModelToVoterEntity (List<VoterModel> voterModel);

}
