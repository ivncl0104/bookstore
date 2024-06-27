package br.com.es3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.es3.DAO.GrupoPrecificacaoDAO;
import br.com.es3.model.Categoria;
import br.com.es3.model.GrupoPrecificacao;

@Component
public class GrupoPrecificacaoServiceImpl implements IService<GrupoPrecificacao> {

    @Autowired
    private GrupoPrecificacaoDAO dao;

    @Override
    public GrupoPrecificacao Adicionar(GrupoPrecificacao grupoPrecificacao) {
        if (!existePorNome(grupoPrecificacao.getNome())) {
        	System.out.println(grupoPrecificacao.toString());
            return dao.save(grupoPrecificacao);
        } else {
            throw new IllegalArgumentException("Grupo de Precificação com este nome já existe");
        }
    }

    @Override
    public GrupoPrecificacao Alterar(GrupoPrecificacao grupoPrecificacao) {
        if (grupoPrecificacao.getId() > 0 && dao.existsById(grupoPrecificacao.getId())) {
            return dao.save(grupoPrecificacao); 
        }
        return null;
    }

    @Override
    public void Remover(GrupoPrecificacao grupoPrecificacao) {
        if (grupoPrecificacao != null && grupoPrecificacao.getId() > 0) {
            dao.deleteById(grupoPrecificacao.getId());
        } else {
            throw new IllegalArgumentException("Grupo de Precificação inválido ou ID não fornecido para remoção.");
        }
    }

    @Override
    public List<GrupoPrecificacao> Listar_todos() {
        return dao.findAll();
    }

    @Override
    public List<GrupoPrecificacao> Listar_keyword(String key) {
        return dao.findAllByNomeContaining(key);
    }

    public GrupoPrecificacao buscarPorId(Integer id) {
        Optional<GrupoPrecificacao> grupo = dao.findById(id);
        return grupo.orElse(null);  
    }
    
    public GrupoPrecificacao buscarPorNome(String nomeGrupo) {
        Optional<GrupoPrecificacao> grupo = dao.findByNome(nomeGrupo);
        return grupo.orElse(null);  
    }
    
    public boolean existePorNome(String nome) {
        return dao.existsByNome(nome);
    }
    
    public void alterarStatus(Integer id) {
    	GrupoPrecificacao entidade = this.buscarPorId(id);
    	
    	
    	if (entidade.isAtivo()) {
    		entidade.setAtivo(false);
    	}
    	else {
    		entidade.setAtivo(true);
    	}	
    	dao.save(entidade);	
    	}
}
