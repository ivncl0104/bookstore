package br.com.es3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.es3.DAO.CategoriaDAO;
import br.com.es3.model.Autor;
import br.com.es3.model.Categoria;

@Component
public class CategoriaServiceImpl implements IService<Categoria> {
    @Autowired
    private CategoriaDAO dao;

    @Override
    public Categoria Adicionar(Categoria categoria) {
        if (!existePorNome(categoria.getNome())) {
            return dao.save(categoria);
        } else {
            throw new IllegalArgumentException("Categoria com este nome já existe");
        }
    }

    @Override
    public Categoria Alterar(Categoria categoria) {
        if (categoria.getId() > 0 && dao.existsById(categoria.getId())) {
            return dao.save(categoria); 
        }
        return null;
    }

    @Override
    public void Remover(Categoria categoria) {
        if (categoria != null && categoria.getId() > 0) {
            dao.deleteById(categoria.getId());
        } else {
            throw new IllegalArgumentException("Categoria inválida ou ID não fornecido para remoção.");
        }
    }

    @Override
    public List<Categoria> Listar_todos() {
        return dao.findAll();
    }

    @Override
    public List<Categoria> Listar_keyword(String key) {
        return dao.findAllByNomeContaining(key);
    }

    public Categoria buscarPorId(Integer id) {
        Optional<Categoria> categoria = dao.findById(id);
        return categoria.orElse(null);  
    }
    
    public Categoria buscarPorNome(String nomeCategoria) {
        Optional<Categoria> categoria = dao.findByNome(nomeCategoria);
        return categoria.orElse(null); 
    }
    
    public boolean existePorNome(String nome) {
        return dao.existsByNome(nome);
    }
    
    public void alterarStatus(Integer id) {
    	Categoria entidade = this.buscarPorId(id);
    	
    	
    	if (entidade.isAtivo()) {
    		entidade.setAtivo(false);
    	}
    	else {
    		entidade.setAtivo(true);
    	}	
    	dao.save(entidade);	
    	}
}
