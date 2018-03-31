package com.example.aula.domain.onetomany;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Autor implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Integer codigoAutor;
	
	private String nome;
	
	@OneToMany(mappedBy="autor")
	private List<Artigo> artigos = new ArrayList<>();
	
	
	// CONSTRUTOR
	public Autor(Integer codigoAutor, String nome) {
		super();
		this.codigoAutor = codigoAutor;
		this.nome = nome;
	}

	public Autor() {
		super();
	}

	
	// GET SET
	public Integer getCodigoAutor() {
		return codigoAutor;
	}

	public void setCodigoAutor(Integer codigoAutor) {
		this.codigoAutor = codigoAutor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
