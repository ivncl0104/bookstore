package br.com.es3.facade;

import java.util.List;

import br.com.es3.model.Autor;

public interface AutorFacade {
	List<Autor> listarTodosAutores();
    Autor adicionarAutor(Autor novoAutor);
    boolean deletarAutor(Integer id);
    Autor buscarPorId(Integer id);
    Autor buscarPorNome(String nome);
    boolean existePorNome(String nome);
}
