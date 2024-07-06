package com.unla.grupo3.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class LoteStock {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idLote;
	private String descripcion;
	private int cantidad;
	private LocalDate fechaDeRecepcion;
	private String proveedor;
	private int precio;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	@ManyToOne
	@JoinColumn(name = "producto_id")
	private Producto producto;

	@OneToMany(mappedBy = "loteStock", cascade = CascadeType.ALL)
	private List<PedidoAprovisionamiento> pedidos;

	@ManyToOne
	@JoinColumn(name = "informe_id")
	private InformeProducto informe;
}
