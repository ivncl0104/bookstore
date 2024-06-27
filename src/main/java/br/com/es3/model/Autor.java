package br.com.es3.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
@Entity
@Table(name="tbl_autor")

public class Autor extends EntidadeDominio implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "autor_id")
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
