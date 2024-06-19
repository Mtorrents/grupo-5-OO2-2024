package com.unla.ghsicilianotfi.entities;

import java.time.LocalDate;

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
public class InformeProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idInforme;

    private String detalle;
    private String responsable;
    private LocalDate fecha;

    @ManyToOne
	@JoinColumn(name = "id_lote")
	private LoteStock loteStock; // This should match the 'mappedBy' in LoteStock

    public InformeProducto() {
    }

    public InformeProducto(String detalle, String responsable, LocalDate fecha, LoteStock loteStock) {
        this.detalle = detalle;
        this.responsable = responsable;
        this.fecha = fecha;
        this.loteStock = loteStock;
    }
}