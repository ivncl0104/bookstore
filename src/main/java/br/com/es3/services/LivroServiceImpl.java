 package br.com.es3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.es3.DAO.LivroDAO;
import br.com.es3.model.Livro;
import jakarta.transaction.Transactional;
@Transactional
@Service
public class LivroServiceImpl implements IService<Livro> {
    
    @Autowired
    private LivroDAO dao;

    @Override
    public Livro Adicionar(Livro livro) {
        return dao.save(livro);
    }


    @Override
    public void Remover(Livro livro) {
        if (livro != null && livro.getId() > 0) {
            dao.deleteById(livro.getId());
        } else {
            throw new IllegalArgumentException("Livro inválido ou ID não fornecido para remoção.");
        }
    }

    @Override
    public List<Livro> Listar_todos() {
        return (List<Livro>) dao.findAll();
    }

    @Override
    public List<Livro> Listar_keyword(String key) {
        return dao.findAllByTituloContaining(key);
    }

    public Livro buscarPorId(Integer id) {
        Optional<Livro> livro = dao.findById(id);
        return livro.orElse(null);
    }
    
    public Livro buscarPorTitulo(String titulo) {
        Optional<Livro> livro = dao.findByTitulo(titulo);
        return livro.orElse(null);
    }
    
    public boolean existePorTitulo(String titulo) {
        return dao.existsByTitulo(titulo);
    }

    @Override
    public Livro Alterar(Livro livro) {
        Optional<Livro> existingLivroOpt = dao.findById(livro.getId());
        System.out.println(livro.getId());
        if (existingLivroOpt.isPresent()) {
            Livro existingLivro = existingLivroOpt.get();
            existingLivro.setId(livro.getId());
            existingLivro.setTitulo(livro.getTitulo());
            existingLivro.setAno(livro.getAno());
            existingLivro.setEdicao(livro.getEdicao());
            existingLivro.setIsbn(livro.getIsbn());
            existingLivro.setNumeroPaginas(livro.getNumeroPaginas());
            existingLivro.setSinopse(livro.getSinopse());
            existingLivro.setDimensaoAltura_cm(livro.getDimensaoAltura_cm());
            existingLivro.setDimensaoLargura_cm(livro.getDimensaoLargura_cm());
            existingLivro.setDimensaoProfundidade_cm(livro.getDimensaoProfundidade_cm());
            existingLivro.setPeso_gramas(livro.getPeso_gramas());
            existingLivro.setCodigoBarras(livro.getCodigoBarras());
            existingLivro.setValorAquisicao(livro.getValorAquisicao());
            existingLivro.setAtivo(livro.isAtivo());
            existingLivro.setAutores(livro.getAutores());
            existingLivro.setEditora(livro.getEditora());
            existingLivro.setCategorias(livro.getCategorias());
            existingLivro.setGrupoPrecificacao(livro.getGrupoPrecificacao());
            existingLivro.setValorVenda(livro.getValorVenda());
            return dao.save(existingLivro);
        } else {
            return null;
        }
    }

}
