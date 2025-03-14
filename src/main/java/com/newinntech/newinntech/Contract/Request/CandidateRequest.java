package com.newinntech.newinntech.Contract.Request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data //getters, setters, equals, hashcode, tostring

@AllArgsConstructor //constructor con todos los argumentos
@Builder //patron de diseño builder


public class CandidateRequest {


    private Long id; // Identificador único del votante
    private String name;
    private String party;
    private int votes = 0;
}
