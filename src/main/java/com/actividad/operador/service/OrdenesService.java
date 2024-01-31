package com.actividad.operador.service;


import com.actividad.operador.model.db.Orden;
import com.actividad.operador.model.request.OrdenRequest;

import java.util.List;

public interface OrdenesService {

    Orden createOrden(OrdenRequest request);

    Orden getOrden(String id);

    List<Orden> getOrdenes();
}
