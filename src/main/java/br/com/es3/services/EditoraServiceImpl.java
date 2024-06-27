package br.com.es3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.es3.DAO.EditoraDAO;
import br.com.es3.model.Categoria;
import br.com.es3.model.Editora;

@Component
public class EditoraServiceImpl implements IService<Editora> {
    @Autowired
    private EditoraDAO dao;

    @Override
    public Editora Adicionar(Editora editora) {
        if (!existePorNome(editora.getNome())) {
            return dao.save(editora);
        } else {
            throw new IllegalArgumentException("Editora com este nome já existe");
        }
    }

    @Override
    public Editora Alterar(Editora editora) {
        if (editora.getId() > 0 && dao.existsById(editora.getId())) {
            return dao.save(editora);
        }
        return null;
    }

    @Override
    public void Remover(Editora editora) {
        if (editora != null && editora.getId() > 0) {
            dao.deleteById(editora.getId());
        } else {
            throw new IllegalArgumentException("Editora inválida ou ID não fornecido para remoção.");
        }
    }

    @Override
    public List<Editora> Listar_todos() {
        return dao.findAll();
    }

    @Override
    public List<Editora> Listar_keyword(String key) {
        return dao.findAllByNomeContaining(key);
    }

    public Editora buscarPorId(Integer id) {
        Optional<Editora> editora = dao.findById(id);
        return editora.orElse(null);  
    }
    
    public Editora buscarPorNome(String nomeEditora) {
        Optional<Editora> editora = dao.findByNome(nomeEditora);
        return editora.orElse(null);  
    }
    
    public boolean existePorNome(String nome) {
        return dao.existsByNome(nome);
    }
    public void alterarStatus(Integer id) {
    	Editora entidade = this.buscarPorId(id);
    	
    	
    	if (entidade.isAtivo()) {
    		entidade.setAtivo(false);
    	}
    	else {
    		entidade.setAtivo(true);
    	}	
    	dao.save(entidade);	
    	}
}
