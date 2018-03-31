package com.example.aula.domain.manytomany;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Produto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	// ATRIBUTOS
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigoProduto;
	private String nomeProduto;
	private Integer quantidadeEstoque;
	private Double preco;

	
	// MAPEAMENTO
	@ManyToMany
	@JoinTable(
			name="PRODUTO_CATEGORIA",
			joinColumns=@JoinColumn(name="produto_id"),
			inverseJoinColumns=@JoinColumn(name="categoria_id")
			)
	private List<Categoria> categorias = new ArrayList<Categoria>();

	
	// CONSTRUTOR
	public Produto() {
	}

	public Produto(Integer codigoProduto, String nomeProduto, Integer quantidadeEstoque, Double preco) {
		super();
		this.codigoProduto = codigoProduto;
		this.nomeProduto = nomeProduto;
		this.quantidadeEstoque = quantidadeEstoque;
		this.preco = preco;
	}
	

	//GET SET
	public Integer getCodigoProduto() {
		return codigoProduto;
	}
	public void setCodigoProduto(Integer codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}
	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public List<Categoria> getCategorias() {
		return categorias;
	}
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}	
	
}