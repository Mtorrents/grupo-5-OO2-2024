package com.unla.grupo3.entities;

import java.sql.Date;
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
	private Long idLote;

	private String descripcion;
	private int cantidad;
	private LocalDate fechaDeRecepcion;
	private String proveedor;
	private double precio;
	private String nombre;

	@ManyToOne
	@JoinColumn(name = "producto_id")
	private Producto producto;

	@ManyToOne
	@JoinColumn(name = "informe_id")
	private InformeProducto informe;

	public String getNombre() {
		return nombre;
	}

	// Setter for nombre
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getIdLote() {
		return idLote;
	}

	public void setIdLote(Long idLote) {
		this.idLote = idLote;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public LocalDate getFechaDeRecepcion() {
		return fechaDeRecepcion;
	}

	public void setFechaDeRecepcion(LocalDate fechaDeRecepcion) {
		this.fechaDeRecepcion = fechaDeRecepcion;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public InformeProducto getInforme() {
		return informe;
	}

	public void setInforme(InformeProducto informe) {
		this.informe = informe;
	}
}