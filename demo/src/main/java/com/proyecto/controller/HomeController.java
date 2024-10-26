package com.proyecto.controller;

import com.proyecto.model.Departamento;
import com.proyecto.model.Empleado;
import com.proyecto.service.Departamentoservice;
import com.proyecto.service.Empleadoservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final Departamentoservice departamentoservice;
    private final Empleadoservice empleadoservice;

    @Autowired
    public HomeController(Departamentoservice departamentoservice, Empleadoservice empleadoservice) {
        this.departamentoservice = departamentoservice;
        this.empleadoservice = empleadoservice;
    }
    
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("empleados", empleadoservice.listarEmpleados());
        model.addAttribute("departamentos", departamentoservice.listaDepartamento()); 
        return "index";
    }

    
}
