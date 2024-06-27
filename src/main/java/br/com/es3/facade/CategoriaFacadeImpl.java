package br.com.es3.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.es3.model.Categoria;
import br.com.es3.services.CategoriaServiceImpl;

@Service
public class CategoriaFacadeImpl implements CategoriaFacade {
	
	@Autowired
    private CategoriaServiceImpl categoriaService;

    @Override
    public List<Categoria> listarCategorias() {
        return categoriaService.Listar_todos();
    }

    @Override
    public String adicionarCategoria(Categoria novaCategoria) {
        if (categoriaService.existePorNome(novaCategoria.getNome())) {
            return "Categoria já cadastrada.";
        } else {
            categoriaService.Adicionar(novaCategoria);
            return null;
        }
    }

    @Override
    public void deletarCategoria(Integer id) {
        Categoria categoria = categoriaService.buscarPorId(id);
        if (categoria != null) {
            categoriaService.Remover(categoria);
        } else {
            throw new IllegalArgumentException("Categoria com ID " + id + " não encontrada");
        }
    }
}