package com.unla.grupo3.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.unla.grupo3.entities.LoteStock;
import com.unla.grupo3.repositories.LoteStockRepository;

@Service("loteStockService")
public class LoteStockService {

    @Autowired
    private LoteStockRepository loteStockRepository;

    public LoteStock agregarLoteStock(LoteStock loteStock) {
        return loteStockRepository.save(loteStock);
    }

    public LoteStock modificarLoteStock(LoteStock loteStock) {
        return loteStockRepository.save(loteStock);
    }

    public void eliminarLoteStock(int idLote) {
        loteStockRepository.deleteById(idLote);
    }

}
