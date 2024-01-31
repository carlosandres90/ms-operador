package com.actividad.operador.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Pelicula {
    private Long id;
    private String titulo;
    private String director;
    private String anio;
    private String criticas;
    private String sinopsis;
    private String duracion;
    private String trailer;
    private String precioAlquiler;
    private String precioCompra;
    private Boolean disponibilidad;
}
