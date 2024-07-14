package com.unla.grupo3.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.grupo3.entities.LoteStock;
import com.unla.grupo3.repositories.LoteStockRepository;

import java.util.List;

@Service
public class LoteStockService {

	@Autowired
	private LoteStockRepository loteStockRepository;

	public List<LoteStock> listarTodos() {
		return loteStockRepository.findAll();
	}

	public void guardar(LoteStock loteStock) {
		loteStockRepository.save(loteStock);
	}

	public LoteStock obtenerPorId(Long id) {
		return loteStockRepository.findById(id).orElse(null);
	}

	public void eliminar(Long id) {
		loteStockRepository.deleteById(id);
	}
}
