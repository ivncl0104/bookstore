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

import br.com.es3.facade.CategoriaFacadeImpl;
import br.com.es3.model.Categoria;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaFacadeImpl categoriaFacade;

    @GetMapping
    public String listarCategorias(Model model) {
        List<Categoria> categorias = categoriaFacade.listarCategorias();
        model.addAttribute("categorias", categorias);
        return "categorias";
    }

    @PostMapping
    public String adicionarCategoria(@ModelAttribute Categoria novaCategoria, Model model) {
        String erro = categoriaFacade.adicionarCategoria(novaCategoria);
        if (erro != null) {
            model.addAttribute("erro", erro);
        }
        return listarCategorias(model);
    }

    @GetMapping("/delete/{id}")
    public String deletarCategoria(@PathVariable("id") Integer id) {
        categoriaFacade.deletarCategoria(id);
        return "redirect:/categorias";
    }
}
