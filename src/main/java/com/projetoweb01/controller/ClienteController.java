package com.projetoweb01.controller;

import com.projetoweb01.entities.Cliente;
import com.projetoweb01.repositories.interfaces.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClienteController {

    @Autowired
    private IClienteRepository clienteRepository;


    @RequestMapping("/formulario-cliente")
    public ModelAndView formularioCliente(){
        ModelAndView modelAndView = new ModelAndView("clientes/formulario-cliente");
        modelAndView.addObject("cliente", new Cliente());
        return modelAndView;
    }
    @RequestMapping(value="/cadastrar-cliente",method= RequestMethod.POST)
    public ModelAndView cadastrarCliente(Cliente cliente, ModelMap map){
        try {
            clienteRepository.create(cliente);
            map.addAttribute("msg_ok","Cliente cadastrado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            map.addAttribute("msg_erro","Tente novamente");
        }
        ModelAndView modelAndView = new ModelAndView("clientes/formulario-cliente", map);
        modelAndView.addObject("cliente", new Cliente());

        return modelAndView;
    }

}
