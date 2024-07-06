package com.unla.grupo3.controllers;

import com.unla.grupo3.entities.Producto;
import com.unla.grupo3.services.implementation.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/producto")
public class ProductoController {

	@Autowired
	private ProductoService productoService;

	@GetMapping("/index")
	public String listProductos(Model model) {
		List<Producto> productos = productoService.findAllProductos();
		model.addAttribute("productos", productos);
		return "producto/index";
	}

	@GetMapping("/form")
	public String showForm(Model model) {
		Producto producto = new Producto();
		model.addAttribute("producto", producto);
		return "producto/form";
	}

	@PostMapping("/guardar")
	public String saveProducto(@ModelAttribute("producto") Producto producto) {
		productoService.save(producto);
		return "redirect:/producto/index";
	}

	@GetMapping("/eliminar/{id}")
	public String deleteProducto(@PathVariable("id") int id) {
		Producto producto = productoService.findProductoById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid producto Id:" + id));
		productoService.delete(producto);
		return "redirect:/producto/index";
	}

	@GetMapping("/editar/{id}")
	public String showUpdateForm(@PathVariable("id") int id, Model model) {
		Producto producto = productoService.findProductoById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid producto Id:" + id));
		model.addAttribute("producto", producto);
		return "producto/form";
	}

}
