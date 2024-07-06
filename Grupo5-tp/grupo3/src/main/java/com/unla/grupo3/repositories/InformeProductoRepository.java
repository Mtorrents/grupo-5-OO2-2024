package com.unla.grupo3.repositories;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.unla.grupo3.entities.InformeProducto;

@Repository("informeProductoRepository")
public interface InformeProductoRepository extends JpaRepository<InformeProducto, Serializable> {

    @Query("SELECT i FROM InformeProducto i JOIN FETCH i.loteStock WHERE i.idInforme = (:idInforme)")
    public abstract InformeProducto findByIdAndFetchLoteStockEagerly(@Param("idInforme") int idInforme);
}
