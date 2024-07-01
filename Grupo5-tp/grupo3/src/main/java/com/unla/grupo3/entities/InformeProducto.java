package com.unla.grupo3.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class InformeProducto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idInforme;
	private String detalle;
	private String responsable;
	private LocalDate fecha;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	@OneToMany(mappedBy = "informe", cascade = CascadeType.ALL)
	private List<LoteStock> loteStock;

}
