package br.edu.usj.eletroeletronicos;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;




@Controller
public class ContatoController {
    

    @Autowired
    ContatoRepository contatoRepository;
    
    @GetMapping(value="/deleteAndAlterContato")
    public ModelAndView getContato() {
        List<Contato> listarContato = contatoRepository.findAll();
        
        ModelAndView md = new ModelAndView("deleteAndAlterContato");
        md.addObject("listarContato", listarContato);
        return md;
    }

    @GetMapping(value="/mostrarContato/{id}")
    public ModelAndView getMostrarContato(@PathVariable Long id) {
        Contato contato = contatoRepository.findById(id).get();
        ModelAndView md = new ModelAndView("mostrarContato");
        md.addObject("contato", contato);
        return md;
    }

    @GetMapping(value="/cadastrarContato")
    public ModelAndView getCadastrarContato() {
        Contato contato = new Contato();
        ModelAndView md = new ModelAndView("cadastrarContato");
        md.addObject("contato", contato);
        return md;
    }
    
    @PostMapping(value="/cadastrarContato")
    public ModelAndView postInserirClientes(Contato cadastrarContato) {
        Contato contato = contatoRepository.save(cadastrarContato);

        ModelAndView md = new ModelAndView("cadastrarContato");
        md.addObject("contato", contato);
        return md;
    }

    @GetMapping(value="/deleteAndAlterContato/{id}")
    public String getDeletarContato(@PathVariable Long id) {
        contatoRepository.deleteById(id);    
        return "redirect:/deleteAndAlterContato";
    }

    @GetMapping(value="/cadastrarContato/{id}")
    public ModelAndView getEditarContato(@PathVariable Long id) {
        Contato contato = contatoRepository.findById(id).get();
        ModelAndView md = new ModelAndView("cadastrarContato");
        md.addObject("contato", contato);
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