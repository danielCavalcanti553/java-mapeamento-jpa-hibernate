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
public class Pagamento implements Serializable{
	
	private static final long serialVersionUID = 1L;

	// ATRIBUTOS
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)		
	private Integer codigoPagamento;
	
	private Date dataPagamento;
	
	private String numeroCartao;
	
	private double valor;
	
	
	// MAPEAMENTO
	@OneToOne
	@JoinColumn(name="pedido_codigo_pedido")
	private Pedido pedido;

	
	// CONSTRUTOR
	public Pagamento() {
		super();
	}

	public Pagamento(Integer codigoPagamento, Date dataPagamento, String numeroCartao, double valor, Pedido pedido) {
		super();
		this.codigoPagamento = codigoPagamento;
		this.dataPagamento = dataPagamento;
		this.numeroCartao = numeroCartao;
		this.valor = valor;
		this.pedido = pedido;
	}	
	
	

	// GET SET
	public Integer getCodigoPagamento() {
		return codigoPagamento;
	}

	public void setCodigoPagamento(Integer codigoPagamento) {
		this.codigoPagamento = codigoPagamento;
	}


	public Date getDataPagamento() {
		return dataPagamento;
	}


	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}


	public String getNumeroCartao() {
		return numeroCartao;
	}
	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
}
