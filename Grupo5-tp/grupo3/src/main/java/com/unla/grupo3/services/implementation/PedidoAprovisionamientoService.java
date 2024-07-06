package com.unla.grupo3.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.unla.grupo3.entities.PedidoAprovisionamiento;
import com.unla.grupo3.repositories.PedidoAprovisionamientoRepository;

@Service("pedidoAprovisionamientoService")
public class PedidoAprovisionamientoService {

    @Autowired
    private PedidoAprovisionamientoRepository pedidoAprovisionamientoRepository;

    public PedidoAprovisionamiento crearPedido(PedidoAprovisionamiento pedido) {
        return pedidoAprovisionamientoRepository.save(pedido);
    }

    public PedidoAprovisionamiento modificarPedido(PedidoAprovisionamiento pedido) {
        return pedidoAprovisionamientoRepository.save(pedido);
    }

    public void eliminarPedido(int idPedido) {
        pedidoAprovisionamientoRepository.deleteById(idPedido);
    }
}
