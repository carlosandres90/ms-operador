package com.actividad.operador.data;

import com.actividad.operador.model.db.Orden;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdenJpaRepository extends JpaRepository<Orden, Long> {
}
