package com.unla.grupo3.repositories;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.unla.grupo3.entities.PedidoAprovisionamiento;

@Repository("pedidoAprovisionamientoRepository")
public interface PedidoAprovisionamientoRepository extends JpaRepository<PedidoAprovisionamiento, Serializable> {

	@Query("SELECT p FROM PedidoAprovisionamiento p JOIN FETCH p.loteStock WHERE p.idPedido = (:idPedido)")
	public abstract PedidoAprovisionamiento findByIdAndFetchLoteStockEagerly(@Param("idPedido") int idPedido);
}
