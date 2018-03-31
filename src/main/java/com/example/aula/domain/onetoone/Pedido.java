package com.example.aula.domain.onetoone;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Pedido implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	// ATRIBUTOS
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Integer codigoPedido;
	
	private Date dataPedido;
	
	
	// MAPEAMENTO
	@OneToOne(cascade=CascadeType.ALL, mappedBy="pedido")
	private Pagamento pagamento;
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="pedido")
	private NotaFiscal notaFiscal;

	
	// CONSTRUTOR
	public Pedido() {
		super();
	}

	public Pedido(Integer codigoPedido, Date dataPedido) {
		super();
		this.codigoPedido = codigoPedido;
		this.dataPedido = dataPedido;

	}

	
	// GET SET
	public Integer getCodigoPedido() {
		return codigoPedido;
	}

	public void setCodigoPedido(Integer codigoPedido) {
		this.codigoPedido = codigoPedido;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public NotaFiscal getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(NotaFiscal notaFiscal) {
		this.notaFiscal = notaFiscal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoPedido == null) ? 0 : codigoPedido.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (codigoPedido == null) {
			if (other.codigoPedido != null)
				return false;
		} else if (!codigoPedido.equals(other.codigoPedido))
			return false;
		return true;
	}


}
