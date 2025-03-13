package com.newinntech.newinntech.Entitys;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Voter") // Define la clase como una entidad JPA y la mapea a la tabla 'userQuerysEntities'
@Data // Genera automáticamente los métodos getter, setter, equals, hashCode y toString
@NoArgsConstructor // Genera un constructor sin argumentos
@AllArgsConstructor // Genera un constructor con todos los argumentos
@Builder // Permite usar el patrón de diseño builder para crear instancias de la clase


public class VoterEntity {
    @Id // Indica que este campo es la clave primaria de la entidad
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identificador único del votante

    private String name;

    private String email;

    private boolean has_voted = false;



}
