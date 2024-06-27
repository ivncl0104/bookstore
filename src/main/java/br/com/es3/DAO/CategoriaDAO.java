package br.com.es3.DAO;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.es3.model.Categoria;


public interface CategoriaDAO extends CrudRepository<Categoria, Integer>{
	public List<Categoria> findAllByNomeContaining(String Keyword);
	public List<Categoria> findAll();
	public Optional<Categoria> findById(Integer ID);
	public Optional<Categoria> findByNome(String nome_autor);
	boolean existsByNome(String nome);
}
