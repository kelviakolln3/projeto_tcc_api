package com.mobile.mobile.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PedidoBean {

	private Long idPedido;

	private Long idCliente;

	private Long idUsuario;

	private Date dataCriacao;

	private String condicaoPagamento;

	private String formaPagamento;

	private BigDecimal total;

	private List<ItemPedidoBean> itemPedidoBeans = new ArrayList<ItemPedidoBean>();

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getCondicaoPagamento() {
		return condicaoPagamento;
	}

	public void setCondicaoPagamento(String condicaoPagamento) {
		this.condicaoPagamento = condicaoPagamento;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public List<ItemPedidoBean> getItemPedidoBeans() {
		return itemPedidoBeans;
	}

	public void setItemPedidoBeans(List<ItemPedidoBean> itemPedidoBeans) {
		this.itemPedidoBeans = itemPedidoBeans;
	}

}
