package com.unla.grupo3.services.implementation;

import com.unla.grupo3.entities.InformeProducto;
import com.unla.grupo3.repositories.InformeProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InformeProductoService {

	@Autowired
	private InformeProductoRepository informeProductoRepository;

	public List<InformeProducto> findAll() {
		return informeProductoRepository.findAll();
	}

	public List<InformeProducto> obtenerTodosLosInformes() {
		return informeProductoRepository.findAll();
	}

	public Optional<InformeProducto> findInformeById(int id) {
		return informeProductoRepository.findById(id);
	}

	public InformeProducto save(InformeProducto informe) {
		return informeProductoRepository.save(informe);
	}

	public void delete(InformeProducto informe) {
		informeProductoRepository.delete(informe);
	}
}
