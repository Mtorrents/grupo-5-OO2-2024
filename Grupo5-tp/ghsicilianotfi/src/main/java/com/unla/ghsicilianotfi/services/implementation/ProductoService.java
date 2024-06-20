package com.unla.ghsicilianotfi.services.implementation;

import com.unla.ghsicilianotfi.entities.Producto;
import com.unla.ghsicilianotfi.repositories.IProductRepository;
import com.unla.ghsicilianotfi.services.IProductoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService implements IProductoService {

    private final IProductRepository productoRepository;

    public ProductoService(IProductRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public List<Producto> getAll() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<Producto> findById(int id) {
        return productoRepository.findById(id);
    }

    @Override
    public Producto insertOrUpdate(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public boolean remove(int id) {
        try {
            productoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
