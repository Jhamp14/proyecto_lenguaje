package com.proyecto.controller;

import com.proyecto.model.Departamento;
import com.proyecto.service.Departamentoservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/departamentos")
public class Departamentocontroller {

    private final Departamentoservice departamentoservice;

    @Autowired
    public Departamentocontroller(Departamentoservice departamentoservice) {
        this.departamentoservice = departamentoservice;
    }

    @GetMapping
    public String listarDepartamentos(Model model) {
        List<Departamento> departamentos = departamentoservice.listaDepartamento();
        model.addAttribute("departamentos", departamentos);
        return "departamentos"; 
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioDeRegistro(Model model) {
        model.addAttribute("departamento", new Departamento());
        return "Formulario_departamento"; 
    }
    
    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEdicion(@PathVariable Long id, Model model) {
        Departamento departamento = departamentoservice.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Departamento no encontrado: " + id));
        model.addAttribute("departamento", departamento);
        return "Formulario_departamento"; 
    }

    @PostMapping
    public String guardarDepartamento(@ModelAttribute("departamento") Departamento departamento) {
        departamentoservice.guardarDepartamento(departamento);
        return "redirect:/"; 
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarDepartamento(@PathVariable Long id) {
        departamentoservice.eliminarDepartamento(id);
        return "redirect:/"; 
    }

}

