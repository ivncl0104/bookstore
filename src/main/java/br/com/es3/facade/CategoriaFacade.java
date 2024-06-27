package br.com.es3.facade;

import java.util.List;

import br.com.es3.model.Categoria;

public interface CategoriaFacade {
	List<Categoria> listarCategorias();
    String adicionarCategoria(Categoria novaCategoria);
    void deletarCategoria(Integer id);
}
