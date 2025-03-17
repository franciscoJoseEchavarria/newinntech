package com.newinntech.newinntech.Entitys;

import com.newinntech.newinntech.Models.CandidateModel;
import com.newinntech.newinntech.Models.VoterModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Vote") // Define la clase como una entidad JPA y la mapea a la tabla 'userQuerysEntities'
@Data // Genera automáticamente los métodos getter, setter, equals, hashCode y toString
@NoArgsConstructor // Genera un constructor sin argumentos
@AllArgsConstructor // Genera un constructor con todos los argumentos
@Builder // Permi

public class VoteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) // Un votante puede votar una vez
    @JoinColumn(name = "voter_id", nullable = false, unique = true)
    private VoterEntity voter;

    @ManyToOne(fetch = FetchType.LAZY) // Un candidato puede recibir muchos votos
    @JoinColumn(name = "candidate_id", nullable = false)
    private CandidateEntity candidate;
}

