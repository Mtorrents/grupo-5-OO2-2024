package com.unla.grupo3.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Registro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRegistro;
	private String nombre;
	private String descripcion; // Asegúrate de que este campo exista

	@OneToMany(mappedBy = "registro", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Producto> productos;
}
