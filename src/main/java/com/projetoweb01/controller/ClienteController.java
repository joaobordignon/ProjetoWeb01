package com.projetoweb01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ClienteController {
    @RequestMapping("/formulario-cliente")
    public String formularioCliente(){
        return "clientes/formulario-cliente";
    }
}
