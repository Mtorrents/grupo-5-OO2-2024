package com.unla.grupo3.controllers;

import com.unla.grupo3.entities.PedidoAprovisionamiento;
import com.unla.grupo3.services.implementation.LoteStockService;
import com.unla.grupo3.services.implementation.PedidoAprovisionamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pedidoaprovisionamiento")
public class PedidoAprovisionamientoController {

	@Autowired
    private PedidoAprovisionamientoService pedidoService;
	
	@Autowired
    private LoteStockService loteStockService;

    @GetMapping("/index")
    public String index(Model model) {
        List<PedidoAprovisionamiento> pedidos = pedidoService.findAll();
        model.addAttribute("pedidos", pedidos);
        return "indexPedidoAprovisionamiento";
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("pedido", new PedidoAprovisionamiento());
        model.addAttribute("lotes", loteStockService.listarTodos());
        return "formPedidoAprovisionamiento";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute PedidoAprovisionamiento pedido) {
        pedidoService.save(pedido);
        return "redirect:/pedidoaprovisionamiento/index";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        PedidoAprovisionamiento pedido = pedidoService.findById(id);
        model.addAttribute("pedido", pedido);
        model.addAttribute("lotes", loteStockService.listarTodos());
        return "formPedidoAprovisionamiento";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        pedidoService.deleteById(id);
        return "redirect:/pedidoaprovisionamiento/index";
    }

}
