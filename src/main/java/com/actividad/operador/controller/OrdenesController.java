package com.actividad.operador.controller;

import com.actividad.operador.model.db.Orden;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.actividad.operador.model.request.OrdenRequest;
import com.actividad.operador.service.OrdenesService;

import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class OrdenesController {

    private final OrdenesService service;

    @PostMapping("/ordenes")
    public ResponseEntity<Orden> createOrden(@RequestBody @Valid OrdenRequest request){

        log.info("Creating orden...");
        Orden created = service.createOrden(request);

        if (created != null) {
            return ResponseEntity.ok(created);
        } else {
            return ResponseEntity.badRequest().build();
        }

    }

    @GetMapping("/ordenes")
    public ResponseEntity<List<Orden>> getOrdenes() {

        List<Orden> orders = service.getOrdenes();
        if (orders != null) {
            return ResponseEntity.ok(orders);
        } else {
            return ResponseEntity.ok(Collections.emptyList());
        }
    }

    @GetMapping("/ordenes/{id}")
    public ResponseEntity<Orden> getOrder(@PathVariable String id) {

        Orden order = service.getOrden(id);
        if (order != null) {
            return ResponseEntity.ok(order);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
