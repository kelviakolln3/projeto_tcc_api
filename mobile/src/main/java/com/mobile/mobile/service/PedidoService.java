package com.mobile.mobile.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mobile.mobile.bean.ItemPedidoBean;
import com.mobile.mobile.bean.PedidoBean;
import com.mobile.mobile.eao.ClienteEAO;
import com.mobile.mobile.eao.ItemPedidoEAO;
import com.mobile.mobile.eao.PedidoEAO;
import com.mobile.mobile.eao.ProdutoEAO;
import com.mobile.mobile.eao.UsuarioEAO;
import com.mobile.mobile.entity.ItemPedido;
import com.mobile.mobile.entity.Pedido;

@Service
public class PedidoService {

	PedidoEAO pedidoEAO;

	ClienteEAO clienteEAO;

	UsuarioEAO usuarioEAO;

	ProdutoEAO produtoEAO;

	ItemPedidoEAO itemPedidoEAO;

	public PedidoService(PedidoEAO pedidoEAO, ClienteEAO clienteEAO, UsuarioEAO usuarioEAO, ProdutoEAO produtoEAO, ItemPedidoEAO itemPedidoEAO) {
		this.pedidoEAO = pedidoEAO;
		this.clienteEAO = clienteEAO;
		this.usuarioEAO = usuarioEAO;
		this.produtoEAO = produtoEAO;
		this.itemPedidoEAO = itemPedidoEAO;
	}

	public List<Pedido> getAlll() {
		return pedidoEAO.findAll();
	}

	public void deleteById(Long id) {
		pedidoEAO.deleteById(id);
	}

	public Pedido insertOrUpdate(Pedido pedido) {
		return pedidoEAO.save(pedido);
	}

	public Optional<Pedido> findByID(Long id) {
		return pedidoEAO.findById(id);
	}

	public PedidoBean inserirPedido(PedidoBean pedidoBean) {
		Pedido pedido = new Pedido();
		pedido.setIdPedido(pedidoBean.getIdPedido());
		pedido.setCliente(clienteEAO.findById(pedidoBean.getIdCliente()).get());
		pedido.setUsuario(usuarioEAO.findById(pedidoBean.getIdUsuario()).get());
		pedido.setDataCriacao(pedidoBean.getDataCriacao());
		pedido.setCondicaoPagamento(pedidoBean.getCondicaoPagamento());
		pedido.setFormaPagamento(pedidoBean.getFormaPagamento());
		pedido.setTotal(pedidoBean.getTotal());
		Pedido pedidoSalvo = pedidoEAO.save(pedido);
		
		PedidoBean pedidoBeanRetorno = new PedidoBean();
		
		buildPedidoBean(pedidoSalvo, pedidoBeanRetorno);
		
		for (ItemPedidoBean itemPedidoBean : pedidoBean.getItemPedidoBeans()) {
			ItemPedido itemPedido = new ItemPedido();
			itemPedido.setIdItemPedido(itemPedidoBean.getIdItemPedido());
			itemPedido.setPedido(pedidoSalvo);
			itemPedido.setProduto(produtoEAO.findById(itemPedidoBean.getIdProduto()).get());
			itemPedido.setQuantidade(itemPedidoBean.getQuantidade());
			itemPedido.setValorProduto(itemPedidoBean.getValorUnitario());
			
			ItemPedido itemPedidoSalvo = itemPedidoEAO.save(itemPedido);
			ItemPedidoBean itemPedidoBeanRetorno = new ItemPedidoBean();
			
			builItemPedido(itemPedidoSalvo, itemPedidoBeanRetorno);
			pedidoBeanRetorno.getItemPedidoBeans().add(itemPedidoBeanRetorno);
		}
		
		return pedidoBeanRetorno;
	}

	private void builItemPedido(ItemPedido itemPedidoSalvo, ItemPedidoBean itemPedidoBeanRetorno) {
		itemPedidoBeanRetorno.setIdItemPedido(itemPedidoSalvo.getIdItemPedido());
		if (itemPedidoSalvo.getProduto() != null) 
			itemPedidoBeanRetorno.setIdProduto(itemPedidoSalvo.getProduto().getIdProduto());
		
		itemPedidoBeanRetorno.setQuantidade(itemPedidoSalvo.getQuantidade());
		itemPedidoBeanRetorno.setValorUnitario(itemPedidoSalvo.getValorProduto());
	}

	private void buildPedidoBean(Pedido pedidoSalvo, PedidoBean pedidoBeanRetorno) {
		pedidoBeanRetorno.setIdPedido(pedidoSalvo.getIdPedido());
		if (pedidoSalvo.getCliente() != null) 
			pedidoBeanRetorno.setIdCliente(pedidoSalvo.getCliente().getIdCliente());
		
		if (pedidoSalvo.getUsuario() != null) 
			pedidoBeanRetorno.setIdUsuario(pedidoSalvo.getUsuario().getIdUsuario());
		
		pedidoBeanRetorno.setDataCriacao(pedidoSalvo.getDataCriacao());
		pedidoBeanRetorno.setCondicaoPagamento(pedidoSalvo.getCondicaoPagamento());
		pedidoBeanRetorno.setFormaPagamento(pedidoSalvo.getFormaPagamento());
		pedidoBeanRetorno.setTotal(pedidoSalvo.getTotal());
	}

	public List<PedidoBean> getAllBean() {
		List<PedidoBean> pedidosBean = new ArrayList<PedidoBean>();
		List<Pedido> findAll = pedidoEAO.findAll();
		for (Pedido pedido : findAll) {
			PedidoBean pedidoBean = new PedidoBean();
			buildPedidoBean(pedido, pedidoBean);
			
			List<ItemPedido> findItensDoPedido = itemPedidoEAO.findItensDoPedido(pedido.getIdPedido());
			for (ItemPedido itemPedido : findItensDoPedido) {
				ItemPedidoBean itemPedidoBean = new ItemPedidoBean();
				builItemPedido(itemPedido, itemPedidoBean);
				pedidoBean.getItemPedidoBeans().add(itemPedidoBean);
			}
			
			pedidosBean.add(pedidoBean);
		}
		return pedidosBean;
	}
	
	public PedidoBean getBeanById(Long id) {
	    Optional<Pedido> pedidoOptional = pedidoEAO.findById(id);
	    
	    if (pedidoOptional.isPresent()) {
	        Pedido pedido = pedidoOptional.get();
	        PedidoBean pedidoBean = new PedidoBean();
	        
	        buildPedidoBean(pedido, pedidoBean);
	        List<ItemPedido> findItensDoPedido = itemPedidoEAO.findItensDoPedido(pedido.getIdPedido());
	        
	        for (ItemPedido itemPedido : findItensDoPedido) {
	            ItemPedidoBean itemPedidoBean = new ItemPedidoBean();
	            builItemPedido(itemPedido, itemPedidoBean);
	            pedidoBean.getItemPedidoBeans().add(itemPedidoBean);
	        }

	        return pedidoBean;
	    } else {
	        return null;
	    }
	}

}
