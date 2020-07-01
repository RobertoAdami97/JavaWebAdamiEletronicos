package br.edu.usj.eletroeletronicos;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;




@Controller
public class ClientesController {
    

    @Autowired
    ClientesRepository clientesRepository;
    
    @GetMapping(value="/deleteAndAlterCliente")
    public ModelAndView getClientes() {
        List<Clientes> listarClientes = clientesRepository.findAll();
        
        ModelAndView md = new ModelAndView("deleteAndAlterCliente");
        md.addObject("listarClientes", listarClientes);
        return md;
    }

    @GetMapping(value="/mostrarCliente/{id}")
    public ModelAndView getMostrarClientes(@PathVariable Long id) {
        Clientes clientes = clientesRepository.findById(id).get();
        ModelAndView md = new ModelAndView("mostrarCliente");
        md.addObject("clientes", clientes);
        return md;
    }

    @GetMapping(value="/cadastrarCliente")
    public ModelAndView getCadastraClientes() {
        Clientes clientes = new Clientes();
        ModelAndView md = new ModelAndView("cadastrarCliente");
        md.addObject("clientes", clientes);
        return md;
    }
    
    @PostMapping(value="/cadastrarCliente")
    public ModelAndView postInserirClientes(Clientes clientes) {
        Clientes cadastrar = clientesRepository.save(clientes);

        ModelAndView md = new ModelAndView("cadastrarCliente");
        md.addObject("clientes", cadastrar);
        return md;
    }

    @GetMapping(value="/deleteAndAlterCliente/{id}")
    public String getDeletarClientes(@PathVariable Long id) {
        clientesRepository.deleteById(id);    
        return "redirect:/deleteAndAlterCliente";
    }

    @GetMapping(value="/cadastrarCliente/{id}")
    public ModelAndView getEditarClientes(@PathVariable Long id) {
        Clientes clientes = clientesRepository.findById(id).get();
        ModelAndView md = new ModelAndView("cadastrarCliente");
        md.addObject("clientes", clientes);
        return md;
    }

    // @PostMapping(value="/cadastrarCliente")
    // public ModelAndView postLimparCampos(Clientes clientes) {
    //     clientes.nome = "";
    //     clientes.email = "";
    //     clientes.telefone = "";
    //     clientes.endereco = "";
    //     clientes.cep = "";
        
    //     return "redirect:/cadastrarCliente";
    // }
    
    
}