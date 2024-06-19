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
public class PedidoAprovisionamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPedido;

    private String descripcion;
    private int cantidad;
    private LocalDate fechaPedido;

    @ManyToOne
   	@JoinColumn(name = "id_lote")
    private LoteStock loteStock; // This should match the 'mappedBy' in LoteStock

    public PedidoAprovisionamiento() {
    }

    public PedidoAprovisionamiento(String descripcion, int cantidad, LocalDate fechaPedido, LoteStock loteStock) {
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.fechaPedido = fechaPedido;
        this.loteStock = loteStock;
    }
}