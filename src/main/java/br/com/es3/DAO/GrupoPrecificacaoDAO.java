package br.com.es3.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.es3.model.GrupoPrecificacao;

public interface GrupoPrecificacaoDAO extends CrudRepository<GrupoPrecificacao, Integer>{
	public List<GrupoPrecificacao> findAllByNomeContaining(String Keyword);
	public List<GrupoPrecificacao> findAll();
	public Optional<GrupoPrecificacao> findById(Integer ID);
	public Optional<GrupoPrecificacao> findByNome(String nome_GrupoPrecificacao);
	boolean existsByNome(String nome);
}
