package com.unla.ghsicilianotfi.services;

import com.unla.ghsicilianotfi.entities.Producto;
import java.util.List;
import java.util.Optional;

public interface IProductoService {
    List<Producto> getAll();
    Optional<Producto> findById(int id);
    Producto insertOrUpdate(Producto producto);
    boolean remove(int id);
}