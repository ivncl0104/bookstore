package br.com.es3.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.es3.model.Autor;



public interface AutorDAO extends CrudRepository<Autor, Integer>{
	public List<Autor> findAllByNomeContaining(String Keyword);
	public List<Autor> findAll();
	public Optional<Autor> findById(Integer ID);
	public Optional<Autor> findByNome(String nome_autor);
	boolean existsByNome(String nome);
}
