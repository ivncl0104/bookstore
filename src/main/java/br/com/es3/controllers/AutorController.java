package br.com.es3.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.es3.facade.AutorFacadeImpl;
import br.com.es3.model.Autor;
import br.com.es3.services.AutorServiceImpl;

@Controller
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorFacadeImpl autorFacade;
    
    @Autowired
    private AutorServiceImpl autorService;
    
    @GetMapping()
    public String listarAutores(Model model) {
        List<Autor> autores = autorFacade.listarTodosAutores();
        model.addAttribute("autores", autores);
        return "autores";
    }

    @PostMapping()
    public String adicionarAutor(@ModelAttribute Autor novoAutor, Model model) {
        Autor autorAdicionado = autorFacade.adicionarAutor(novoAutor);
        if (autorAdicionado == null) {
            model.addAttribute("erro", "Autor já cadastrado.");
        }
        return listarAutores(model);
    }

    @GetMapping("/delete/{id}")
    public String deletarAutor(@PathVariable("id") Integer id, Model model) {
        if (!autorFacade.deletarAutor(id)) {
            model.addAttribute("erro", "Autor com ID " + id + " não encontrado.");
        }
        return "redirect:/autores";
    }
    
    @GetMapping("/alterar_status/{id}")
    public String alterarStatus(@PathVariable("id") Integer id, Model model) {
        if (autorService.alterarStatus(id) != null) {
            model.addAttribute("erro", "Autor com ID " + id + " não encontrado.");
        }
        return "redirect:/autores";
    }
    
}
