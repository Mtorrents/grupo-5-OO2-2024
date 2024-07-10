package com.unla.grupo3.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.unla.grupo3.entities.LoteStock;
import com.unla.grupo3.services.implementation.LoteStockService;
import com.unla.grupo3.services.implementation.ProductoService;

import java.util.List;

@Controller
@RequestMapping("/lotestock")
public class LoteStockController {

    @Autowired
    private LoteStockService loteStockService;
    
    @Autowired
    private ProductoService productoService;

    @GetMapping("/index")
    public String listarLotes(Model model) {
        List<LoteStock> lotes = loteStockService.listarTodos();
        model.addAttribute("lotes", lotes);
        return "lotestock/indexLoteStock"; // Nombre del archivo de la vista para listar lotes
    }
    
    public String getLoteStock(Model model) {
        List<LoteStock> lotes = loteStockService.listarTodos();
        model.addAttribute("lotes", lotes);
        return "lotestock/indexLoteStock";
    }

    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        model.addAttribute("loteStock", new LoteStock());
        model.addAttribute("productos", productoService.findAll());
        return "lotestock/formLoteStock"; // Nombre del archivo de la vista para el formulario
    }

    @PostMapping("/guardar")
    public String guardarLote(@ModelAttribute LoteStock loteStock) {
        loteStockService.guardar(loteStock);
        return "redirect:/lotestock/index";
    }

    @GetMapping("/editar/{id}")
    public String editarLote(@PathVariable("id") Long id, Model model) {
        LoteStock loteStock = loteStockService.obtenerPorId(id);
        model.addAttribute("loteStock", loteStock);
        model.addAttribute("productos", productoService.findAll());
        return "lotestock/formLoteStock"; // Nombre del archivo de la vista para el formulario
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarLote(@PathVariable("id") Long id) {
        loteStockService.eliminar(id);
        return "redirect:/lotestock/index";
    }
}
