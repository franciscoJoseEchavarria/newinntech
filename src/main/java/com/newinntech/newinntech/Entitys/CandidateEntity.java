package com.newinntech.newinntech.Entitys;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Candidate") // Define la clase como una entidad JPA y la mapea a la tabla 'userQuerysEntities'
@Data // Genera automáticamente los métodos getter, setter, equals, hashCode y toString
@NoArgsConstructor // Genera un constructor sin argumentos
@AllArgsConstructor // Genera un constructor con todos los argumentos
@Builder // Permite usar el patrón de diseño builder para crear instancias de la clase

public class CandidateEntity {

    @Id // Indica que este campo es la clave primaria de la entidad
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column(nullable = false,unique = true) // Indica que este campo no puede ser nulo en la base de datos
    private String name;
    // Indica que este campo no suede ser nulo en la base de datos
    private String party;

    private int votes = 0;

}
