package com.tienda_v2.controller;

import com.tienda_v2.domain.Categoria;
import com.tienda_v2.service.CategoriaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class CategoriaController {
    @Autowired
    CategoriaService categoriaService;
    
    @GetMapping("/categoria/listado")
    public String inicio(Model model) {
        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categorias", categorias);
        return "/categoria/listado";    
    }
    
    @GetMapping("/categoria/nuevo")
    public String nuevoCategoria(Categoria categoria) {
        return "/categoria/modificar";
    }
    
    @PostMapping("/categoria/guardar")
    public String guardaCategoria(Categoria categoria) {
        categoriaService.save(categoria);
        return "redirect:/categoria/listado";
    }
    
    
    @GetMapping("/categoria/eliminar/{idCategoria}")
    public String eliminaCategoria(Categoria categoria) {
        categoriaService.delete(categoria);
        return "redirect:/categoria/listado";
    }
    
    @GetMapping("/categoria/modificar/{idCategoria}")
    public String modificaCategoria(Categoria categoria, Model model) {
        categoria = categoriaService.getCategoria(categoria);
        model.addAttribute("categoria",categoria);
        return "redirect:/categoria/listado";
    }
}
