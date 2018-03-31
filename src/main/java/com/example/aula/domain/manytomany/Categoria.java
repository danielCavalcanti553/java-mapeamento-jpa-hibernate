package com.example.aula.domain.manytomany;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Categoria implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	// ATRIBUTOS
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigoCategoria;
	private String nomeCategoria;
	
	
	// MAPEAMENTO
	@ManyToMany(mappedBy="categorias")
	private List<Produto> produtos = new ArrayList<>();
	
	
	// CONSTRUTOR
	public Categoria(Integer codigoCategoria, String nomeCategoria) {
		super();
		this.codigoCategoria = codigoCategoria;
		this.nomeCategoria = nomeCategoria;
	}
	public Categoria() {
	
	}
	
	
	//GET SET
	public Integer getCodigoCategoria() {
		return codigoCategoria;
	}
	public void setCodigoCategoria(Integer codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}
	public String getNomeCategoria() {
		return nomeCategoria;
	}
	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

}