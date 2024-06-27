package br.com.es3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.es3.DAO.AutorDAO;
import br.com.es3.model.Autor;

@Component
public class AutorServiceImpl implements IService<Autor> {
    @Autowired
    private AutorDAO dao;

    @Override
    public Autor Adicionar(Autor autor) {
        return dao.save(autor);
    }

    @Override
    public Autor Alterar(Autor autor) {

        if (autor.getId()>0&& dao.existsById(autor.getId())) {
            return dao.save(autor); 
        }
        return null; 
    }


    @Override
    public void Remover(Autor autor) {
        if (autor != null && autor.getId() > 0) {
            dao.deleteById(autor.getId());
        } else {
            throw new IllegalArgumentException("Autor inválido ou ID não fornecido para remoção.");
        }
    }


    @Override
    public List<Autor> Listar_todos() {
        return (List<Autor>) dao.findAll();
    }

    @Override
    public List<Autor> Listar_keyword(String key) {
        return (List<Autor>) dao.findAllByNomeContaining(key);
    }

    public Autor buscarPorId(Integer id) {
        Optional<Autor> autor = dao.findById(id);
        return autor.orElse(null); 
    }
    
    public Autor buscarPorNome(String nome_autor) {
        Optional<Autor> autor = dao.findByNome(nome_autor);
        return autor.orElse(null);  
    }
    
    public boolean existePorNome(String nome) {
        return dao.existsByNome(nome);
    }
    
    public Autor alterarStatus(Integer id) {
    	Autor autor = this.buscarPorId(id);
    	
    	if (autor.isAtivo()) {
    		autor.setAtivo(false);
    	}
    	else {
    		autor.setAtivo(true);
    	}	
    	return dao.save(autor);	
    	}
        
    }


