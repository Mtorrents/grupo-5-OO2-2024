package com.unla.grupo3.repositories;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.unla.grupo3.entities.LoteStock;

@Repository("loteStockRepository")
public interface LoteStockRepository extends JpaRepository<LoteStock, Serializable> {

	@Query("SELECT l FROM LoteStock l JOIN FETCH l.producto WHERE l.idLote = (:idLote)")
	public abstract LoteStock findByIdAndFetchProductoEagerly(@Param("idLote") int idLote);
}
