package com.proyecto.controller;

import com.proyecto.model.Empleado;
import com.proyecto.model.Departamento;
import com.proyecto.service.Empleadoservice;
import com.proyecto.service.Departamentoservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/empleados")
public class Empleadocontroller {

    private final Empleadoservice empleadoservice;
    private final Departamentoservice departamentoservice;

    @Autowired
    public Empleadocontroller(Empleadoservice empleadoservice, Departamentoservice departamentoservice) {
        this.empleadoservice = empleadoservice;
        this.departamentoservice = departamentoservice;
    }

    @GetMapping
    public String listarEmpleados(Model model) {
        model.addAttribute("empleados", empleadoservice.listarEmpleados());
        return "index"; 
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioDeRegistro(Model model) {
        model.addAttribute("empleado", new Empleado());
        model.addAttribute("departamentos", departamentoservice.listaDepartamento());
        return "Formulario_empleados"; 
    }
   
    
    @PostMapping
    public String guardarEmpleado(@ModelAttribute("empleado") Empleado empleado) {
        empleadoservice.guardarEmpleados(empleado); 
        return "redirect:/"; 
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEdicion(@PathVariable Long id, Model model) {
        Optional<Empleado> empleadoOpt = empleadoservice.findById(id);
        if (empleadoOpt.isPresent()) {
            model.addAttribute("empleado", empleadoOpt.get());
            model.addAttribute("departamentos", departamentoservice.listaDepartamento());
            return "Formulario_empleados"; 
        }
        return "redirect:/"; 
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarEmpleado(@PathVariable Long id) {
        empleadoservice.eliminarEmpleado(id); 
        return "redirect:/"; 
    }
}
