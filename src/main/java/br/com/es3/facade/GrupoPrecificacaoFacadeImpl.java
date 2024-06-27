package br.com.es3.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.es3.model.GrupoPrecificacao;
import br.com.es3.services.GrupoPrecificacaoServiceImpl;

@Service
public class GrupoPrecificacaoFacadeImpl implements GrupoPrecificacaoFacade {
	
	@Autowired
    private GrupoPrecificacaoServiceImpl service;

    @Override
    public List<GrupoPrecificacao> listarTodos() {
        return service.Listar_todos();
    }

    @Override
    public void adicionarGrupo(GrupoPrecificacao novoGrupo) throws IllegalArgumentException {
        if (service.existePorNome(novoGrupo.getNome())) {
            throw new IllegalArgumentException("Grupo de Precificação já cadastrado.");
        } else {
            service.Adicionar(novoGrupo);
        }
    }

    @Override
    public void deletarGrupo(Integer id) throws IllegalArgumentException {
        GrupoPrecificacao grupo = service.buscarPorId(id);
        if (grupo != null) {
            service.Remover(grupo);
        } else {
            throw new IllegalArgumentException("Grupo de Precificação com ID " + id + " não encontrado");
        }
    }

    @Override
    public boolean existePorNome(String nome) {
        return service.existePorNome(nome);
    }

    @Override
    public GrupoPrecificacao buscarPorId(Integer id) {
        return service.buscarPorId(id);
    }

    @Override
    public GrupoPrecificacao buscarPorNome(String nome) {
        return service.buscarPorNome(nome);
    }
}
