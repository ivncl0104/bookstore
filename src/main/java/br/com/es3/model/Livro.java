package br.com.es3.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tbl_livro")
public class Livro extends EntidadeDominio{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "livro_id")
    private int id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "ano")
    private int ano;

    @Column(name = "edicao")
    private String edicao;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "numeroPaginas")
    private int numeroPaginas;

    @Column(name = "sinopse")
    private String sinopse;

    @Column(name = "dimensaoAltura_cm")
    private int dimensaoAltura_cm;

    @Column(name = "dimensaoLargura_cm")
    private int dimensaoLargura_cm;

    @Column(name = "dimensaoProfundidade_cm")
    private int dimensaoProfundidade_cm;

    @Column(name = "peso_gramas")
    private int peso_gramas;

    @Column(name = "codigoBarras")
    private String codigoBarras;

    @Column(name = "valorAquisicao")
    private double valorAquisicao;

	@Column(name = "status")
	private boolean ativo = true;
	
	@Column(name = "data_cadastro")
	private Date dataCadastro = new Date();
	
	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public double getValor_venda() {
		return valor_venda;
	}

	public void setValor_venda(double valor_venda) {
		this.valor_venda = valor_venda;
	}


    @ManyToMany()
    @JoinTable(
        name = "tbl_livro_autor",
        joinColumns = @JoinColumn(name = "livro_id"),
        inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    private List<Autor> autores;

    @ManyToOne
    @JoinColumn(name = "editora_id")
    private Editora editora;

    @ManyToMany
    @JoinTable(
        name = "tbl_livro_categoria",
        joinColumns = @JoinColumn(name = "livro_id"),
        inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private List<Categoria> categorias;

    @ManyToOne
    @JoinColumn(name = "grupoPrecificacao_id")
    private GrupoPrecificacao grupoPrecificacao;
    
    
    @Column(name = "valorVenda")
    private double valor_venda;
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getEdicao() {
		return edicao;
	}

	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public int getDimensaoAltura_cm() {
		return dimensaoAltura_cm;
	}

	public void setDimensaoAltura_cm(int dimensaoAltura_cm) {
		this.dimensaoAltura_cm = dimensaoAltura_cm;
	}

	public int getDimensaoLargura_cm() {
		return dimensaoLargura_cm;
	}

	public void setDimensaoLargura_cm(int dimensaoLargura_cm) {
		this.dimensaoLargura_cm = dimensaoLargura_cm;
	}

	public int getDimensaoProfundidade_cm() {
		return dimensaoProfundidade_cm;
	}

	public void setDimensaoProfundidade_cm(int dimensaoProfundidade_cm) {
		this.dimensaoProfundidade_cm = dimensaoProfundidade_cm;
	}

	public int getPeso_gramas() {
		return peso_gramas;
	}

	public void setPeso_gramas(int peso_gramas) {
		this.peso_gramas = peso_gramas;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public double getValorAquisicao() {
		return valorAquisicao;
	}

	public void setValorAquisicao(double valorAquisicao) {
		this.valorAquisicao = valorAquisicao;
	}



	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public GrupoPrecificacao getGrupoPrecificacao() {
		return grupoPrecificacao;
	}

	public void setGrupoPrecificacao(GrupoPrecificacao grupoPrecificacao) {
		this.grupoPrecificacao = grupoPrecificacao;
	}
    
    public double getValorVenda() {
        if (grupoPrecificacao != null) {
            double margemLucroDecimal = grupoPrecificacao.getMargemLucro() / 100.0;
            System.out.println(grupoPrecificacao.getMargemLucro());
            this.valor_venda = this.valorAquisicao * (1 + margemLucroDecimal);
        }
        return this.valor_venda;
    }
    public void setValorVenda(double valorVenda) {
        this.valor_venda = valorVenda;
    }
    
    
}
