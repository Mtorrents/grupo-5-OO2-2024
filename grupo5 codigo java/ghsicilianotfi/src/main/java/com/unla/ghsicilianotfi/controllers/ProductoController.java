package com.unla.ghsicilianotfi.controllers;

import com.unla.ghsicilianotfi.dtos.ProductoDTO;
import com.unla.ghsicilianotfi.entities.Producto;
import com.unla.ghsicilianotfi.helpers.ViewRouteHelper;
import com.unla.ghsicilianotfi.services.IProductoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/producto")
public class ProductoController {

    private final IProductoService productoService;
    private final ModelMapper modelMapper = new ModelMapper();

    public ProductoController(IProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("")
    public ModelAndView index() {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.PRODUCTO_INDEX);
        mAV.addObject("productos", productoService.getAll());
        return mAV;
    }

    @GetMapping("/new")
    public ModelAndView create() {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.PRODUCTO_NEW);
        mAV.addObject("producto", new ProductoDTO());
        return mAV;
    }

    @PostMapping("/create")
    public RedirectView create(@ModelAttribute("producto") ProductoDTO productoDTO) {
        Producto producto = modelMapper.map(productoDTO, Producto.class);
        productoService.insertOrUpdate(producto);
        return new RedirectView(ViewRouteHelper.PRODUCTO_ROOT);
    }

    @GetMapping("/{id}")
    public ModelAndView get(@PathVariable("id") int id) throws Exception {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.PRODUCTO_UPDATE);
        ProductoDTO productoDTO = modelMapper.map(productoService.findById(id).orElseThrow(() -> new Exception("Producto no encontrado")), ProductoDTO.class);
        mAV.addObject("producto", productoDTO);
        return mAV;
    }

    @PostMapping("/update")
    public RedirectView update(@ModelAttribute("producto") ProductoDTO productoDTO) throws Exception {
        Producto productoToUpdate = modelMapper.map(productoService.findById(productoDTO.getIdProducto()).orElseThrow(() -> new Exception("Producto no encontrado")), Producto.class);
        if (productoToUpdate != null) {
            productoToUpdate.setNombre(productoDTO.getNombre());
            productoToUpdate.setDescripcion(productoDTO.getDescripcion());
            productoToUpdate.setPrecio(productoDTO.getPrecio());
            productoService.insertOrUpdate(productoToUpdate);
        }
        return new RedirectView(ViewRouteHelper.PRODUCTO_ROOT);
    }

    @PostMapping("/delete/{id}")
    public RedirectView delete(@PathVariable("id") int id) {
        productoService.remove(id);
        return new RedirectView(ViewRouteHelper.PRODUCTO_ROOT);
    }
}


