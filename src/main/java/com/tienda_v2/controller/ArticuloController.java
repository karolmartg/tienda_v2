package com.tienda_v2.controller;

import com.tienda_v2.domain.Articulo;
import com.tienda_v2.service.ArticuloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ArticuloController {
    @Autowired
    ArticuloService articuloService;
    
    @GetMapping("/articulo/listado")
    public String inicio(Model model) {
        var articulos = articuloService.getArticulos(false);
        model.addAttribute("articulos", articulos);
        return "/articulo/listado";    
    }
    
    @GetMapping("/articulo/nuevo")
    public String nuevoArticulo(Articulo articulo) {
        return "/articulo/modificar";
    }
    
    @PostMapping("/articulo/guardar")
    public String guardaCategoria(Articulo articulo) {
        articuloService.save(articulo);
        return "redirect:/articulo/listado";
    }
    
    
    @GetMapping("/articulo/eliminar/{idArticulo}")
    public String eliminaCategoria(Articulo articulo) {
        articuloService.delete(articulo);
        return "redirect:/articulo/listado";
    }
    
    @GetMapping("/articulo/modificar/{idArticulo}")
    public String modificaCategoria(Articulo articulo, Model model) {
        articulo = articuloService.getArticulo(articulo);
        model.addAttribute("articulo",articulo);
        return "redirect:/articulo/listado";
    }
}
