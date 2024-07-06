package com.unla.grupo3.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.unla.grupo3.entities.InformeProducto;
import com.unla.grupo3.repositories.InformeProductoRepository;

@Service("informeProductoService")
public class InformeProductoService {

    @Autowired
    private InformeProductoRepository informeProductoRepository;

    public InformeProducto generarInforme(InformeProducto informe) {
        return informeProductoRepository.save(informe);
    }

    public InformeProducto modificarInforme(InformeProducto informe) {
        return informeProductoRepository.save(informe);
    }

    public void eliminarInforme(int idInforme) {
        informeProductoRepository.deleteById(idInforme);
    }
}
