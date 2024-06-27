package br.com.es3.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.es3.model.Editora;

public interface EditoraDAO extends CrudRepository<Editora, Integer>{
	public List<Editora> findAllByNomeContaining(String Keyword);
	public List<Editora> findAll();
	public Optional<Editora> findById(Integer ID);
	public Optional<Editora> findByNome(String nome_Editora);
	boolean existsByNome(String nome);
}
