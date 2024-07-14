package com.unla.grupo3.services.implementation;

import com.unla.grupo3.entities.Registro;
import com.unla.grupo3.repositories.RegistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistroService {

	@Autowired
	private RegistroRepository registroRepository;

	public List<Registro> findAllRegistros() {
		return registroRepository.findAll();
	}

	public Optional<Registro> findRegistroById(int id) {
		return registroRepository.findById(id);
	}

	public void save(Registro registro) {
		registroRepository.save(registro);
	}

	public void delete(Registro registro) {
		registroRepository.delete(registro);
	}
}
