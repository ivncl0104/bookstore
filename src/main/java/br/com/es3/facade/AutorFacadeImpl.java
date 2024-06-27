package br.com.es3.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.es3.model.Autor;
import br.com.es3.services.AutorServiceImpl;

@Service
public class AutorFacadeImpl implements AutorFacade {

	@Autowired
	private AutorServiceImpl autorService;

	@Override
	public List<Autor> listarTodosAutores() {
		return autorService.Listar_todos();
	}

	@Override
	public Autor adicionarAutor(Autor novoAutor) {
		if (autorService.existePorNome(novoAutor.getNome())) {
			return null;
		} else {
			return autorService.Adicionar(novoAutor);
		}
	}

	@Override
	public boolean deletarAutor(Integer id) {
		Autor autor = autorService.buscarPorId(id);
		if (autor != null) {
			autorService.Remover(autor);
			return true;
		}
		return false;
	}

	@Override
	public Autor buscarPorId(Integer id) {
		return autorService.buscarPorId(id);
	}

	@Override
	public Autor buscarPorNome(String nome) {
		return autorService.buscarPorNome(nome);
	}

	@Override
	public boolean existePorNome(String nome) {
		return autorService.existePorNome(nome);
	}
}
