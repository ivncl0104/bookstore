package br.com.es3.model;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name="tbl_editora")
public class Editora extends EntidadeDominio {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "editora_id")
	private int id;
    @Column(name = "nome")
    private String nome;
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

	public int getId() {
		return id;
	}
   
    
}
