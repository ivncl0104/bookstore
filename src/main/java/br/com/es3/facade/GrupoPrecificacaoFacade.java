package br.com.es3.facade;

import java.util.List;

import br.com.es3.model.GrupoPrecificacao;

public interface GrupoPrecificacaoFacade {
	List<GrupoPrecificacao> listarTodos();
    void adicionarGrupo(GrupoPrecificacao novoGrupo) throws IllegalArgumentException;
    void deletarGrupo(Integer id) throws IllegalArgumentException;
    boolean existePorNome(String nome);
    GrupoPrecificacao buscarPorId(Integer id);
    GrupoPrecificacao buscarPorNome(String nome);
}
