package br.com.es3.facade;

import java.util.List;

import br.com.es3.model.Autor;
import br.com.es3.model.Categoria;
import br.com.es3.model.Editora;
import br.com.es3.model.GrupoPrecificacao;
import br.com.es3.model.Livro;

public interface LivroFacade {
	Livro createLivro(Livro livro);
    List<Autor> getAllAutores();
    List<Categoria> getAllCategorias();
    List<Editora> getAllEditoras();
    List<GrupoPrecificacao> getAllGruposPrecificacao();
    List<Livro> getAllLivros();
}
