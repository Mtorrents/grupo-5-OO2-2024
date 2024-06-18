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
public class Producto {

	public Producto() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProducto;

	@Column(name = "descripcion", nullable = false, length = 45)
	private String descripcion;

	@Column(name = "precioVenta", nullable = false, length = 60)
	private int precioVenta;

	@Column(name = "cantidad", nullable = false, length = 60)
	private int cantidad;

	public Producto(int idProducto, String descripcion, int precioVenta, int cantidad) {
		super();
		this.idProducto = idProducto;
		this.descripcion = descripcion;
		this.precioVenta = precioVenta;
		this.cantidad = cantidad;
	}

	

}

