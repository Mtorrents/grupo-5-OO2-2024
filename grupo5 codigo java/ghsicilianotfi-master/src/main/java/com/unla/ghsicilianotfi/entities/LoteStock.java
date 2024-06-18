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
public class LoteStock {

	public LoteStock() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idLote;

	@Column(name = "descripcion", nullable = false, length = 45)
	private String descripcion;

	@Column(name = "cantidad", nullable = false, length = 60)
	private int cantidad;

	@Column(name = "fechaDeRecepcion", nullable = false, length = 60)
	private LocalDate fechaDeRecepcion;

	@Column(name = "proveedor", nullable = false, length = 60)
	private String proveedor;

	@Column(name = "precio", nullable = false, length = 60)
	private int precio;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "lotestock")
	private Producto producto;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "lotestock")
	private PedidoAprovisionamiento pedido;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "lotestock")
	private InformeProducto informe;

	public LoteStock(int idLote, String descripcion, int cantidad, LocalDate fechaDeRecepcion, String proveedor,
			int precio, Producto producto, PedidoAprovisionamiento pedido, InformeProducto informe) {
		super();
		this.idLote = idLote;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.fechaDeRecepcion = fechaDeRecepcion;
		this.proveedor = proveedor;
		this.precio = precio;
		this.producto = producto;
		this.pedido = pedido;
		this.informe = informe;
	}

}
