package com.actividad.operador.model.request;

import com.actividad.operador.model.Pelicula;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrdenRequest {

    @NotNull(message = "`peliculaid` cannot be null")
    @NotEmpty(message = "`peliculaid` cannot be empty")
    private String peliculaid;

    @NotNull(message = "`estado` cannot be null")
    @NotEmpty(message = "`estado` cannot be empty")
    private String estado;
}
