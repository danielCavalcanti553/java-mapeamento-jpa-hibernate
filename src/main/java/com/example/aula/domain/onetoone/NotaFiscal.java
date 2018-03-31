package com.example.aula.domain.onetoone;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class NotaFiscal implements Serializable{
	
	private static final long serialVersionUID = 1L;

	
	// ATRIBUTOS
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Integer codigoNota;

	private Date dataNota;
	private Long numeroNfe;
	
	
	// MAPEAMENTO
	@OneToOne
	@JoinColumn(name="pedido_codigo_pedido")
	private Pedido pedido;


	// CONSTRUTOR
	public NotaFiscal(Integer codigoNota, Date dataNota, Long numeroNfe, Pedido pedido) {
		super();
		this.codigoNota = codigoNota;
		this.dataNota = dataNota;
		this.numeroNfe = numeroNfe;
		this.pedido = pedido;
	}


	// GET SET
	public NotaFiscal() {
		super();
	}


	public Integer getCodigoNota() {
		return codigoNota;
	}


	public void setCodigoNota(Integer codigoNota) {
		this.codigoNota = codigoNota;
	}


	public Date getDataNota() {
		return dataNota;
	}


	public void setDataNota(Date dataNota) {
		this.dataNota = dataNota;
	}


	public Long getNumeroNfe() {
		return numeroNfe;
	}


	public void setNumeroNfe(Long numeroNfe) {
		this.numeroNfe = numeroNfe;
	}


	public Pedido getPedido() {
		return pedido;
	}


	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	
}
