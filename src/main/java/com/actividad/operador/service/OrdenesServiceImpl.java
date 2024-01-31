package com.actividad.operador.service;

import com.actividad.operador.data.OrdenJpaRepository;
import com.actividad.operador.model.db.Orden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.actividad.operador.facade.PeliculasFacade;
import com.actividad.operador.model.Pelicula;
import com.actividad.operador.model.request.OrdenRequest;

@Service
public class OrdenesServiceImpl implements OrdenesService {

    @Autowired //Inyeccion por campo (field injection). Es la menos recomendada.
    private PeliculasFacade peliculasFacade;

    @Autowired //Inyeccion por campo (field injection). Es la menos recomendada.
    private OrdenJpaRepository repository;

    @Override
    public Orden createOrden(OrdenRequest request) {

        Pelicula pelicula = peliculasFacade.getPelicula(request.getPeliculaid());

        if(pelicula == null || !pelicula.getDisponibilidad()) {
            return null;
        } else {
            Orden order = Orden.builder().pelicula(pelicula.getId()).estado(request.getEstado()).build();
            repository.save(order);
            return order;
        }
    }

    @Override
    public Orden getOrden(String id) {
        return repository.findById(Long.valueOf(id)).orElse(null);
    }

    @Override
    public List<Orden> getOrdenes() {
        List<Orden> orders = repository.findAll();
        return orders.isEmpty() ? null : orders;
    }

}
