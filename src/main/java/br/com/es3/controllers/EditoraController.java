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

import br.com.es3.facade.EditoraFacadeImpl;
import br.com.es3.model.Editora;

@Controller
@RequestMapping("/editoras")
public class EditoraController {

	@Autowired
	private EditoraFacadeImpl editoraFacade;

	@GetMapping("")
	public String listarEditoras(Model model) {
		List<Editora> editoras = editoraFacade.listarTodasEditoras();
		model.addAttribute("editoras", editoras);
		return "editoras";
	}

	@PostMapping("")
	public String adicionarEditora(@ModelAttribute Editora novaEditora, Model model) {
		if (editoraFacade.existeEditoraPorNome(novaEditora.getNome())) {
			model.addAttribute("erro", "Editora já cadastrada.");
		} else {
			editoraFacade.adicionarEditora(novaEditora);
		}
		return listarEditoras(model);
	}

	@GetMapping("/delete/{id}")
	public String deletarEditora(@PathVariable("id") Integer id) {
		Editora editora = editoraFacade.buscarEditoraPorId(id);
		if (editora != null) {
			editoraFacade.removerEditora(editora);
		} else {
			throw new IllegalArgumentException("Editora com ID " + id + " não encontrada");
		}
		return "redirect:/editoras";
	}
}
