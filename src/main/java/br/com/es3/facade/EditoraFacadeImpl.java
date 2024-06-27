package br.com.es3.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.es3.model.Editora;
import br.com.es3.services.EditoraServiceImpl;

@Service
public class EditoraFacadeImpl implements EditoraFacade {
	
	@Autowired
	private EditoraServiceImpl editoraService;

	@Override
	public Editora adicionarEditora(Editora editora) {
		return editoraService.Adicionar(editora);
	}

	@Override
	public Editora alterarEditora(Editora editora) {
		return editoraService.Alterar(editora);
	}

	@Override
	public void removerEditora(Editora editora) {
		editoraService.Remover(editora);
	}

	@Override
	public List<Editora> listarTodasEditoras() {
		return editoraService.Listar_todos();
	}

	@Override
	public List<Editora> listarEditorasPorKeyword(String key) {
		return editoraService.Listar_keyword(key);
	}

	@Override
	public Editora buscarEditoraPorId(Integer id) {
		return editoraService.buscarPorId(id);
	}

	@Override
	public Editora buscarEditoraPorNome(String nome) {
		return editoraService.buscarPorNome(nome);
	}

	@Override
	public boolean existeEditoraPorNome(String nome) {
		return editoraService.existePorNome(nome);
	}
}
