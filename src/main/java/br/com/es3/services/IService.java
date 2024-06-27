package br.com.es3.services;

import java.util.List;

import br.com.es3.model.EntidadeDominio;

public interface IService<Entidade> {
	public EntidadeDominio Adicionar(Entidade EntidadeDominio);
	public EntidadeDominio Alterar(Entidade EntidadeDominio);
	public void Remover(Entidade EntidadeDominio);
	public List<Entidade> Listar_todos();
	public List<Entidade> Listar_keyword(String key);
	
}
