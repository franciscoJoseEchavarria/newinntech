package com.newinntech.newinntech.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //getters, setters, equals, hashcode, tostring
@NoArgsConstructor //constructor sin argumentos
@AllArgsConstructor //constructor con todos los argumentos
@Builder //patron de diseño builder

@Table(name = "Vote") //nombre de la tabla en la base de datos
public class Vote {

    private Long id; // Identificador único del votante

    private Voter voter_id;

    private Candidate candidate_id;


}
