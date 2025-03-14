package com.newinntech.newinntech.Contract.Request;


import com.newinntech.newinntech.Models.CandidateModel;
import com.newinntech.newinntech.Models.VoterModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data //getters, setters, equals, hashcode, tostring

@AllArgsConstructor //constructor con todos los argumentos
@Builder //patron de diseño builder
public class VoteRequest {

    private VoterModel voter_id;
    private CandidateModel candidate_id;
}
