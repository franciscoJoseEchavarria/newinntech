package com.newinntech.newinntech.Mapper.Implementation;


import com.newinntech.newinntech.Entitys.VoterEntity;
import com.newinntech.newinntech.Models.VoterModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VoterMapper {

    VoterEntity mapVoterModelToVoterEntity (VoterModel voterModel);

    VoterModel mapToVoterEntityToVoterModel (VoterEntity voterEntity);

}
