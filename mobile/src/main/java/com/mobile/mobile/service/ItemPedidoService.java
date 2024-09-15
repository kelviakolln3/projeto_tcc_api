package com.mobile.mobile.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mobile.mobile.eao.ItemPedidoEAO;
import com.mobile.mobile.entity.ItemPedido;

@Service
public class ItemPedidoService {

	ItemPedidoEAO itemPedidoEAO;

	public ItemPedidoService(ItemPedidoEAO itemPedidoEAO) {
		this.itemPedidoEAO = itemPedidoEAO;
	}
	
	public List<ItemPedido> getAlll() {
		return itemPedidoEAO.findAll();
	}

	public void deleteById(Long id) {
		itemPedidoEAO.deleteById(id);
	}

	public ItemPedido insertOrUpdate(ItemPedido itemPedido) {
		return itemPedidoEAO.save(itemPedido);
	}

	public Optional<ItemPedido> findByID(Long id) {
		return itemPedidoEAO.findById(id);
	}
	
	
}
