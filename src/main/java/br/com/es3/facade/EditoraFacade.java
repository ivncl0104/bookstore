package br.com.es3.facade;

import java.util.List;

import br.com.es3.model.Editora;

public interface EditoraFacade {
	Editora adicionarEditora(Editora editora);
	Editora alterarEditora(Editora editora);
	void removerEditora(Editora editora);
	List<Editora> listarTodasEditoras();
	List<Editora> listarEditorasPorKeyword(String key);
	Editora buscarEditoraPorId(Integer id);
	Editora buscarEditoraPorNome(String nome);
	boolean existeEditoraPorNome(String nome);
}
