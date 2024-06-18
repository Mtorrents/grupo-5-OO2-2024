package com.unla.ghsicilianotfi.entities;

import java.util.HashSet;
import java.util.Set;

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
public class Registro {

	public Registro() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRegistro;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "registro")
	private Set<Producto> productos = new HashSet<>();

	public Registro(int idRegistro, Set<Producto> productos) {
		super();
		this.idRegistro = idRegistro;
		this.productos = productos;
	}

}
