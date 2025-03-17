package com.newinntech.newinntech.Contract.Reponse;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data //getters, setters, equals, hashcode, tostring
@AllArgsConstructor //constructor con todos los argumentos
@Builder //patron de diseño builder

public class VoteStaticaReponse {
    private List<CandidateStaticResponse> candidateStatistics;
    private Long totalVoters;
}
