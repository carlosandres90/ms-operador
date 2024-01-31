package com.actividad.operador.model.db;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ordenes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Orden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pelicula")
    private Long pelicula;

    @Column(name = "estado")
    private String estado;

}
