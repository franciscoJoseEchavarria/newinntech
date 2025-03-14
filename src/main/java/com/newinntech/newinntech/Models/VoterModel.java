package com.newinntech.newinntech.Models;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //getters, setters, equals, hashcode, tostring
@NoArgsConstructor //constructor sin argumentos
@AllArgsConstructor //constructor con todos los argumentos
@Builder //patron de diseño builder


public class VoterModel {

    private Long id; // Identificador único del votante
    private String name;
    private String email;
    private boolean hasVoted;


}
