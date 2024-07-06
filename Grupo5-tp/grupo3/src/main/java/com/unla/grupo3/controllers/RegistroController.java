package com.unla.grupo3.controllers;

import com.unla.grupo3.entities.Registro;
import com.unla.grupo3.services.implementation.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/registro")
public class RegistroController {

    @Autowired
    private RegistroService registroService;

    @GetMapping("/index")
    public String listRegistros(Model model) {
        List<Registro> registros = registroService.findAllRegistros();
        model.addAttribute("registros", registros);
        return "registro/index";
    }

    @GetMapping("/form")
    public String showForm(Model model) {
        Registro registro = new Registro();
        model.addAttribute("registro", registro);
        return "registro/form";
    }

    @PostMapping("/guardar")
    public String saveRegistro(@ModelAttribute("registro") Registro registro) {
        registroService.save(registro);
        return "redirect:/registro/index";
    }

    @GetMapping("/editar/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Registro registro = registroService.findRegistroById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid registro Id:" + id));
        model.addAttribute("registro", registro);
        return "registro/form";
    }

    @GetMapping("/eliminar/{id}")
    public String deleteRegistro(@PathVariable("id") int id) {
        Registro registro = registroService.findRegistroById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid registro Id:" + id));
        registroService.delete(registro);
        return "redirect:/registro/index";
    }
}
