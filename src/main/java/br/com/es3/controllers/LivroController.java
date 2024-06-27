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

import br.com.es3.model.Livro;
import br.com.es3.services.AutorServiceImpl;
import br.com.es3.services.CategoriaServiceImpl;
import br.com.es3.services.EditoraServiceImpl;
import br.com.es3.services.GrupoPrecificacaoServiceImpl;
import br.com.es3.services.LivroServiceImpl;

@Controller
@RequestMapping("/livros")
public class LivroController {
    
    @Autowired
    private LivroServiceImpl livroService;
    
    @Autowired
    private AutorServiceImpl autorService;
    
    @Autowired
    private CategoriaServiceImpl categoriaService;
    
    @Autowired
    private EditoraServiceImpl editoraService;
    
    @Autowired
    private GrupoPrecificacaoServiceImpl grupoPrecificacaoService;

    @GetMapping("/novo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("livro", new Livro());
        model.addAttribute("autores", autorService.Listar_todos());
        model.addAttribute("categorias", categoriaService.Listar_todos());
        model.addAttribute("editoras", editoraService.Listar_todos());
        model.addAttribute("gruposPrecificacao", grupoPrecificacaoService.Listar_todos());
        return "livros";
    }

    @PostMapping("/salvar")
    public String salvarLivro(@ModelAttribute Livro livro) {
        if (livro.getId() > 0) {
            livroService.Alterar(livro);
        } else {
            livroService.Adicionar(livro);
        }
        return "redirect:/livros/livros_view";
    }

    @GetMapping("/editar/{id}")
    public String editarLivro(@PathVariable("id") Integer id, Model model) {
        Livro livro = livroService.buscarPorId(id);
        if (livro != null) {
            model.addAttribute("livro", livro);
            model.addAttribute("autores", autorService.Listar_todos());
            model.addAttribute("categorias", categoriaService.Listar_todos());
            model.addAttribute("editoras", editoraService.Listar_todos());
            model.addAttribute("gruposPrecificacao", grupoPrecificacaoService.Listar_todos());
            return "livros";
        } else {
            return "redirect:/livros/livros_view";
        }
    }

    @GetMapping("/livros_view")
    public String listarTodos(Model model) {
        List<Livro> livros = livroService.Listar_todos();
        model.addAttribute("livros", livros);
        return "livros_view"; 
    }
}
