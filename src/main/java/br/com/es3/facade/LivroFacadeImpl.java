package br.com.es3.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.es3.model.Autor;
import br.com.es3.model.Categoria;
import br.com.es3.model.Editora;
import br.com.es3.model.GrupoPrecificacao;
import br.com.es3.model.Livro;
import br.com.es3.services.AutorServiceImpl;
import br.com.es3.services.CategoriaServiceImpl;
import br.com.es3.services.EditoraServiceImpl;
import br.com.es3.services.GrupoPrecificacaoServiceImpl;
import br.com.es3.services.LivroServiceImpl;

@Service
public class LivroFacadeImpl implements LivroFacade {

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

	@Override
	public Livro createLivro(Livro livro) {
		return livroService.Adicionar(livro);
	}

	@Override
	public List<Autor> getAllAutores() {
		return autorService.Listar_todos();
	}

	@Override
	public List<Categoria> getAllCategorias() {
		return categoriaService.Listar_todos();
	}

	@Override
	public List<Editora> getAllEditoras() {
		return editoraService.Listar_todos();
	}

	@Override
	public List<GrupoPrecificacao> getAllGruposPrecificacao() {
		return grupoPrecificacaoService.Listar_todos();
	}

	@Override
	public List<Livro> getAllLivros() {
		return livroService.Listar_todos();
	}

}
