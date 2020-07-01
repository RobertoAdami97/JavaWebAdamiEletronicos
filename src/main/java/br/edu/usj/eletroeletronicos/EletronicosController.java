package br.edu.usj.eletroeletronicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class EletronicosController {
    
    @Autowired
    EletronicosRepository eletronicosRepository;

    @GetMapping(value="/deleteAndAlterProduto")
    public ModelAndView getEletronico() {
        List<Eletronicos> listaEletronicos = eletronicosRepository.findAll();
        
        ModelAndView md = new ModelAndView("deleteAndAlterProduto");
        md.addObject("listarEletronicos", listaEletronicos);
        return md;
    }

    @GetMapping(value="/mostrarProduto/{id}")
    public ModelAndView getMostrar(@PathVariable Long id) {
        Eletronicos eletronicos = eletronicosRepository.findById(id).get();
        ModelAndView md = new ModelAndView("mostrarProduto");
        md.addObject("eletronicos", eletronicos);
        return md;
    }

    @GetMapping(value="/cadastrarProduto")
    public ModelAndView getCadastrar() {
        Eletronicos eletronicos = new Eletronicos();
        ModelAndView md = new ModelAndView("cadastrarProduto");
        md.addObject("eletronicos", eletronicos);
        return md;
    }
    
    @PostMapping(value="/cadastrarProduto")
    public ModelAndView postCadastrarProdutos(Eletronicos eletronicos) {
        Eletronicos cadastrarEletronicos = eletronicosRepository.save(eletronicos);

        ModelAndView md = new ModelAndView("cadastrarProduto");
        md.addObject("eletronicos", cadastrarEletronicos);
        return md;
    }

    @GetMapping(value="/deleteAndAlterProduto/{id}")
    public String getDeletar(@PathVariable Long id) {
        eletronicosRepository.deleteById(id);    
        return "redirect:/deleteAndAlterProduto";
    }

    @GetMapping(value="/cadastrarProduto/{id}")
    public ModelAndView getEditarProduto(@PathVariable Long id) {
        Eletronicos eletronicos = eletronicosRepository.findById(id).get();
        ModelAndView md = new ModelAndView("cadastrarProduto");
        md.addObject("eletronicos", eletronicos);
        return md;
    }
    
    
   
}