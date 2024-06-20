package com.unla.ghsicilianotfi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducto;

    private String nombre;
    private String descripcion;
    private double precio;

    @ManyToOne
   	@JoinColumn(name = "id_lote")
    private LoteStock loteStock; // This should match the 'mappedBy' in LoteStock

    @ManyToOne
   	@JoinColumn(name = "id_registro")
    private Registro registro; // This should match the 'mappedBy' in Registro

    public Producto() {
    }

    public Producto(String nombre, String descripcion, double precio, LoteStock loteStock, Registro registro) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.loteStock = loteStock;
        this.registro = registro;
    }
}

