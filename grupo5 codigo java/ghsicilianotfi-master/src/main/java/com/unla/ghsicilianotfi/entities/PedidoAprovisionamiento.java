package com.unla.ghsicilianotfi.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PedidoAprovisionamiento {

	public PedidoAprovisionamiento() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPedidoAprovisionamiento;

	@Column(name = "cantidadSolicitada", nullable = false, length = 45)
	private int cantidadSolicitada;

	@Column(name = "fechaDeSolicitud", nullable = false, length = 60)
	private LocalDate fechaDeSolicitud;

	@Column(name = "estado", nullable = false, length = 60)
	private boolean estado;

	public PedidoAprovisionamiento(int idPedidoAprovisionamiento, int cantidadSolicitada, LocalDate fechaDeSolicitud,
			boolean estado) {
		super();
		this.idPedidoAprovisionamiento = idPedidoAprovisionamiento;
		this.cantidadSolicitada = cantidadSolicitada;
		this.fechaDeSolicitud = fechaDeSolicitud;
		this.estado = estado;
	}

}
