package com.example.aula.domain.onetomany;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Artigo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Integer codigoArtigo;
	
	private String titulo;
	
	private String conteudo;
	
	@ManyToOne
	@JoinColumn(name="autor_artigo")
	private Autor autor;

	// CONSTRUTOR
	public Artigo() {
		super();
	}

	public Artigo(Integer codigoArtigo, String titulo, String conteudo) {
		super();
		this.codigoArtigo = codigoArtigo;
		this.titulo = titulo;
		this.conteudo = conteudo;
	}
	
	// GET SET
	public Integer getCodigoArtigo() {
		return codigoArtigo;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public void setCodigoArtigo(Integer codigoArtigo) {
		this.codigoArtigo = codigoArtigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	
	

}
