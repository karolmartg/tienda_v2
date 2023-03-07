package com.tienda_v2.controller;

import com.tienda_v2.domain.Cliente;
import com.tienda_v2.service.ClienteService;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClienteController {
    
    @Autowired
    ClienteService clienteService;
    
    @GetMapping("/")
    public String inicio(Model model) {
        var clientes = clienteService.getClientes();
        model.addAttribute("clientes", clientes);
        return "index";    
    }
    
    @GetMapping("/cliente/nuevo")
    public String nuevoCliente(Cliente cliente) {
        return "modificaCliente";
    }
    
    @PostMapping("/cliente/guardarCliente")
    public String guardaCliente(Cliente cliente) {
        clienteService.saveCliente(cliente);
        return "redirect:/";
    }
    
    
    @GetMapping("/cliente/eliminar/{idCliente}")
    public String eliminaCliente(Cliente cliente) {
        clienteService.deleteCliente(cliente);
        return "redirect:/";
    }
    
    @GetMapping("/cliente/modificar/{idCliente}")
    public String modificaCliente(Cliente cliente, Model model) {
        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente",cliente);
        return "modificaCliente";
    }
    
}
