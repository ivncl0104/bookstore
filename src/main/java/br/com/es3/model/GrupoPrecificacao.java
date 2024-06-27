package br.com.es3.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_gprprecificacao")
public class GrupoPrecificacao extends EntidadeDominio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gpr_precificacao_id")
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "margem_lucro")
    private int margemLucro;
    
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

	public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMargemLucro() {
        return margemLucro;
    }

    public void setMargemLucro(int margemLucro) {
        this.margemLucro = margemLucro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "GrupoPrecificacao [id=" + id + ", nome=" + nome + ", margemLucro=" + margemLucro + "]";
    }
    
    
}
