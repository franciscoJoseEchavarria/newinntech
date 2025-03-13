package com.newinntech.newinntech.Mapper.Interface;

import com.newinntech.newinntech.Contract.Reponse.VoterResponse;
import com.newinntech.newinntech.Contract.Request.VoterRequest;
import com.newinntech.newinntech.Models.VoterModel;

public interface VoterInterface {

    VoterModel mapToVoterRequestToVoterModel (VoterRequest voterRequest);

    VoterResponse mapToVoterModelToVoterResponse (VoterModel voterModel);

}
