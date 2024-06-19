package com.unla.ghsicilianotfi.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoDTO {
    private int idProducto;
    private String nombre;
    private String descripcion;
    private double precio;
    private int idLote;
    private int idRegistro;
}
