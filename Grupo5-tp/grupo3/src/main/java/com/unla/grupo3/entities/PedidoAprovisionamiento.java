package com.unla.grupo3.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter @Setter @NoArgsConstructor
public class PedidoAprovisionamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPedido;
    private String nombre;
    private String descripcion;
    private int cantidad;
    private LocalDate fechaPedido;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "loteStock_id")
    private LoteStock loteStock;
}

