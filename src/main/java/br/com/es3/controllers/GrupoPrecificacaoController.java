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

import br.com.es3.model.GrupoPrecificacao;
import br.com.es3.services.GrupoPrecificacaoServiceImpl;

@Controller
@RequestMapping("/grupo-precificacao")
public class GrupoPrecificacaoController {

    @Autowired
    private GrupoPrecificacaoServiceImpl service;

    @GetMapping("")
    public String listarGrupos(Model model) {
        List<GrupoPrecificacao> grupos = service.Listar_todos();
        model.addAttribute("grupos", grupos);
        return "grupo-precificacao";
    }

    @PostMapping("")
    public String adicionarGrupo(@ModelAttribute GrupoPrecificacao novoGrupo, Model model) {
        if (service.existePorNome(novoGrupo.getNome())) {
            model.addAttribute("erro", "Grupo de Precificação já cadastrado.");
        } else {
            service.Adicionar(novoGrupo);
        }
        return listarGrupos(model); 
    }

    @GetMapping("/delete/{id}")
    public String deletarGrupo(@PathVariable("id") Integer id) {
        GrupoPrecificacao grupo = service.buscarPorId(id);
        if (grupo != null) {
            service.Remover(grupo);
        } else {
            throw new IllegalArgumentException("Grupo de Precificação com ID " + id + " não encontrado");
        }
        return "redirect:/grupo-precificacao";
    }
}
