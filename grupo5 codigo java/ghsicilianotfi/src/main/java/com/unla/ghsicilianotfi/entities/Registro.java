package com.unla.ghsicilianotfi.entities;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Registro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRegistro;

    private String nombre;
    private String descripcion;

    @ManyToOne
   	@JoinColumn(name = "id_productos")
    private Producto productos;

    public Registro() {
    }

    public Registro(String nombre, String descripcion, Producto productos) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.productos = productos;
    }
}
