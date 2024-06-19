package com.unla.ghsicilianotfi.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
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
public class LoteStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLote;

    @Column(name = "descripcion", nullable = false, length = 45)
    private String descripcion;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @Column(name = "fechaDeRecepcion", nullable = false)
    private LocalDate fechaDeRecepcion;

    @Column(name = "proveedor", nullable = false, length = 60)
    private String proveedor;

    @Column(name = "precio", nullable = false)
    private int precio;

    @ManyToOne
   	@JoinColumn(name = "id_producto")
   	private Producto producto;

    @ManyToOne
   	@JoinColumn(name = "id_pedido")
    private PedidoAprovisionamiento pedido;

    @ManyToOne
   	@JoinColumn(name = "id_informe")
    private InformeProducto informe;

    public LoteStock() {
    }

    public LoteStock(int idLote, String descripcion, int cantidad, LocalDate fechaDeRecepcion, String proveedor,
            int precio, Producto producto, PedidoAprovisionamiento pedido, InformeProducto informe) {
        this.idLote = idLote;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.fechaDeRecepcion = fechaDeRecepcion;
        this.proveedor = proveedor;
        this.precio = precio;
        this.producto = producto;
        this.pedido = pedido;
        this.informe = informe;
    }
}
