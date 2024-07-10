package com.unla.grupo3.services.implementation;

import com.unla.grupo3.entities.PedidoAprovisionamiento;
import com.unla.grupo3.repositories.PedidoAprovisionamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoAprovisionamientoService {

	@Autowired
    private PedidoAprovisionamientoRepository repository;

    public List<PedidoAprovisionamiento> findAll() {
        return repository.findAll();
    }

    public PedidoAprovisionamiento findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void save(PedidoAprovisionamiento pedido) {
        repository.save(pedido);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
