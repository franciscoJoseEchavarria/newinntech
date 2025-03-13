package com.newinntech.newinntech.Entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Vote") // Define la clase como una entidad JPA y la mapea a la tabla 'userQuerysEntities'
@Data // Genera automáticamente los métodos getter, setter, equals, hashCode y toString
@NoArgsConstructor // Genera un constructor sin argumentos
@AllArgsConstructor // Genera un constructor con todos los argumentos
@Builder // Permite usar el patrón de diseño builder para crear instancias de la clase


public class VoteEntity {

    @Id // Indica que este campo es la clave primaria de la entidad
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identificador único del votante

    @ManyToOne
    @JoinColumn(name = "voter_id", nullable = false)
    private VoterEntity voter_id;

    @ManyToOne
    @JoinColumn(name = "candidate_id", nullable = false)
    private CandidateEntity candidate_id;
}
