package com.unla.grupo3.repositories;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.unla.grupo3.entities.Producto;

@Repository("productoRepository")
public interface ProductoRepository extends JpaRepository<Producto, Serializable> {

	@Query("SELECT p FROM Producto p JOIN FETCH p.loteStock WHERE p.idProducto = (:idProducto)")
	public abstract Producto findByIdAndFetchLoteStockEagerly(@Param("idProducto") int idProducto);
}
