package com.mobile.mobile.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mobile.mobile.entity.ItemPedido;
import com.mobile.mobile.service.ItemPedidoService;

@RestController
public class ItemPedidoResource {
	
	@Autowired
	private ItemPedidoService itemPedidoService;
	
	@GetMapping("/item-pedido")
	public List<ItemPedido> getAll(){
		return itemPedidoService.getAlll();
	}
	
	@GetMapping("/item-pedido/{idItemPedido}")
	public Optional<ItemPedido> findById(@PathVariable Long idItemPedido){
		return itemPedidoService.findByID(idItemPedido);
	}
	
	@DeleteMapping("/item-pedido/{idItemPedido}")
	public void deleteById(@PathVariable Long idItemPedido) {
		itemPedidoService.deleteById(idItemPedido);
	}
	
	@PostMapping("/item-pedido")
	public ResponseEntity<ItemPedido> insert(@RequestBody ItemPedido itemPedido) {
		ItemPedido insertOrUpdate = itemPedidoService.insertOrUpdate(itemPedido);
		
		return new ResponseEntity<ItemPedido>(insertOrUpdate, HttpStatus.OK);
	}
	
	@PutMapping("/item-pedido/{idItemPedido}")
	public ResponseEntity<ItemPedido> update(@PathVariable Long idItemPedido, @RequestBody ItemPedido itemPedido) {
		if(idItemPedido != null) {
			Optional<ItemPedido> findByID = itemPedidoService.findByID(idItemPedido);
			if (findByID != null) {
				ItemPedido insertOrUpdate = itemPedidoService.insertOrUpdate(itemPedido);		
				return new ResponseEntity<ItemPedido>(insertOrUpdate, HttpStatus.OK);
			}
		}
		
		return new ResponseEntity<ItemPedido>(new ItemPedido(), HttpStatus.OK);
	}

}
