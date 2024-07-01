package com.unla.grupo3.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.unla.grupo3.entities.Producto;
import com.unla.grupo3.repositories.ProductoRepository;

@Service("productoService")
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public Producto crearProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto modificarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public void eliminarProducto(int idProducto) {
        productoRepository.deleteById(idProducto);
    }

}
