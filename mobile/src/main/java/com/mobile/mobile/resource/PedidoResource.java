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

import com.mobile.mobile.bean.PedidoBean;
import com.mobile.mobile.entity.Pedido;
import com.mobile.mobile.service.PedidoService;

@RestController
public class PedidoResource {
	
	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping("/pedido")
	public List<Pedido> getAll(){
		return pedidoService.getAlll();
	}
	
	@GetMapping("/pedido/{idPedido}")
	public Optional<Pedido> findById(@PathVariable Long idPedido){
		return pedidoService.findByID(idPedido);
	}
	
	@DeleteMapping("/pedido/{idPedido}")
	public void deleteById(@PathVariable Long idPedido) {
		pedidoService.deleteById(idPedido);
	}
	
	@PostMapping("/pedido")
	public ResponseEntity<Pedido> insert(@RequestBody Pedido pedido) {
		Pedido insertOrUpdate = pedidoService.insertOrUpdate(pedido);
		
		return new ResponseEntity<Pedido>(insertOrUpdate, HttpStatus.OK);
	}
	
	@PutMapping("/pedido/{idPedido}")
	public ResponseEntity<Pedido> update(@PathVariable Long idPedido, @RequestBody Pedido pedido) {
		if(idPedido != null) {
			Optional<Pedido> findByID = pedidoService.findByID(idPedido);
			if (findByID != null) {
				Pedido insertOrUpdate = pedidoService.insertOrUpdate(pedido);		
				return new ResponseEntity<Pedido>(insertOrUpdate, HttpStatus.OK);
			}
		}
		
		return new ResponseEntity<Pedido>(new Pedido(), HttpStatus.OK);
	}
	
	@PostMapping("/pedido/inserir-pedido")
	public ResponseEntity<PedidoBean> inserirPedido(@RequestBody PedidoBean pedidoBean){
		PedidoBean insertOrUpdate = pedidoService.inserirPedido(pedidoBean);
		return new ResponseEntity<PedidoBean>(insertOrUpdate, HttpStatus.OK);
	}
	
	@GetMapping("/pedido/get-all-bean")
	public List<PedidoBean> getAllBean(){
		return pedidoService.getAllBean();
	}
	@GetMapping("/pedido/get-all-bean/{idPedido}")
	public PedidoBean getBeanById(@PathVariable Long idPedido){
		return pedidoService.getBeanById(idPedido);
	}

}
