package com.unla.grupo3.services.implementation;

import com.unla.grupo3.entities.Producto;
import com.unla.grupo3.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

	@Autowired
	private ProductoRepository productoRepository;

	public List<Producto> findAll() {
		return productoRepository.findAll();
	}

	public List<Producto> obtenerTodosLosProductos() {
		return productoRepository.findAll();
	}

	public Optional<Producto> findProductoById(int id) {
		return productoRepository.findById(id);
	}

	public void save(Producto producto) {
		productoRepository.save(producto);
	}

	public void delete(Producto producto) {
		productoRepository.delete(producto);
	}
}
