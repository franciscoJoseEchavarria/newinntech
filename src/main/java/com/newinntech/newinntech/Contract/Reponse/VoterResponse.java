package com.newinntech.newinntech.Contract.Reponse;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data //getters, setters, equals, hashcode, tostring

@AllArgsConstructor //constructor con todos los argumentos
@Builder //patron de diseño builder


public class VoterResponse {

    private Long id;
    private String name;
    private String email;
    private boolean hasVoted;


}
