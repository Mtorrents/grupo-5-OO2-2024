package com.unla.grupo3.controllers;

import com.unla.grupo3.entities.InformeProducto;
import com.unla.grupo3.services.implementation.InformeProductoService;
import com.unla.grupo3.services.implementation.LoteStockService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/informe")
public class InformeProductoController {

	@Autowired
	private InformeProductoService informeProductoService;

	@Autowired
	private LoteStockService loteStockService;

	@GetMapping("/index")
	public String listInformes(Model model) {
		List<InformeProducto> informes = informeProductoService.findAll();
		model.addAttribute("informes", informes);
		return "informe/index";
	}

	@GetMapping("/form")
	public String showForm(Model model) {
		InformeProducto informe = new InformeProducto();
		model.addAttribute("informe", informe);
		model.addAttribute("lotes", loteStockService.listarTodos());
		return "informe/form";
	}

	@PostMapping("/guardar")
	public String saveInforme(@ModelAttribute("informe") InformeProducto informe) {
		informeProductoService.save(informe);
		return "redirect:/informe/index";
	}

	@GetMapping("/eliminar/{id}")
	public String deleteInforme(@PathVariable("id") int id) {
		InformeProducto informe = informeProductoService.findInformeById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid informe Id:" + id));
		informeProductoService.delete(informe);
		return "redirect:/informe/index";
	}

	@GetMapping("/editar/{id}")
	public String showUpdateForm(@PathVariable("id") int id, Model model) {
		InformeProducto informe = informeProductoService.findInformeById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid informe Id:" + id));
		model.addAttribute("lotes", loteStockService.listarTodos());
		model.addAttribute("informe", informe);
		return "informe/form";
	}

}
