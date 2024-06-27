package br.com.es3.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.es3.model.Livro;

public interface LivroDAO extends CrudRepository<Livro, Integer> {
    List<Livro> findAll();
    Optional<Livro> findById(Integer id);
    Optional<Livro> findByTitulo(String titulo);
    List<Livro> findAllByTituloContaining(String keyword);
    boolean existsByTitulo(String titulo);
}
