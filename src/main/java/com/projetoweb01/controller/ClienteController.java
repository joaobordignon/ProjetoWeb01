package com.projetoweb01.controller;

import com.projetoweb01.entities.Cliente;
import com.projetoweb01.repositories.dal.ClienteRepository;
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
            Cliente cl = clienteRepository.findByEmail(cliente.getEmail());
            if (cl != null) {
                throw new Exception("o email ja se encontra cadastrado, tente novamente");
            }
            clienteRepository.create(cliente);
            map.addAttribute("msg_ok","Cliente cadastrado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            map.addAttribute("msg_erro",e.getMessage());
        }
        ModelAndView modelAndView = new ModelAndView("clientes/formulario-cliente", map);
        modelAndView.addObject("cliente", new Cliente());

        return modelAndView;
    }

    @RequestMapping("/listagem-clientes")
    public ModelAndView listagemCliente(ModelMap map) {
        ModelAndView modelAndView = new ModelAndView("clientes/listagem-clientes");
        try {
            modelAndView.addObject("clientes", clienteRepository.findAll());
            map.addAttribute("msg_ok","Acesso ao Banco OK");
        } catch (Exception e) {
            e.printStackTrace();
            map.addAttribute("msg_erro",e.getMessage());
        }
        return modelAndView;
    }

    @RequestMapping("/excluir-cliente")
    public ModelAndView excluirCliente(ModelMap map, Integer id) {
        ModelAndView modelAndView = new ModelAndView("clientes/listagem-clientes");
        try {
            Cliente cl = clienteRepository.findById(id);
            if (cl != null) {
                clienteRepository.delete(id);
                map.addAttribute("msg_ok","Item excluido com sucesso");
            }
            else{
                map.addAttribute("msg_erro","Cliente nao consta no banco de dados, tente novamente");
            }
            modelAndView.addObject("clientes", clienteRepository.findAll());
        } catch (Exception e) {
            e.printStackTrace();
            map.addAttribute("msg_erro",e.getMessage());
        }
        return modelAndView;
    }

    @RequestMapping("/edicao-cliente")
    public ModelAndView editarCliente(ModelMap map, Integer id){
        ModelAndView modelAndView = new ModelAndView("clientes/edicao-cliente");
        try {
            Cliente cl = clienteRepository.findById(id);
            if (cl != null) {
                modelAndView.addObject("cliente", cl);
            }
            else{
                map.addAttribute("msg_erro","Cliente nao consta no banco de dados");
                modelAndView.setViewName("clientes/listagem-clientes");
                modelAndView.addObject("clientes", clienteRepository.findAll());
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.addAttribute("msg_erro",e.getMessage());
        }
        return modelAndView;
    }

    @RequestMapping(value="/atualizar-cliente",method= RequestMethod.POST)
    public ModelAndView atualizarCliente(Cliente cliente, ModelMap map){
        ModelAndView modelAndView = new ModelAndView("clientes/edicao-cliente");
        try {
            Cliente cl = clienteRepository.findByEmail(cliente.getEmail());
            if (cl != null && !cl.getEmail().equals(cliente.getEmail())) {
                throw new Exception("o email ja se encontra cadastrado, tente novamente");
            }
            clienteRepository.update(cliente);
            map.addAttribute("msg_ok","Cliente atualizado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            map.addAttribute("msg_erro",e.getMessage());
        }
        modelAndView.addObject("cliente", cliente);
        return modelAndView;
    }
}
