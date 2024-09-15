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

import com.mobile.mobile.entity.Cliente;
import com.mobile.mobile.service.ClienteService;

@RestController
public class ClienteResource {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/cliente")
	public List<Cliente> getAll(){
		return clienteService.getAlll();
	}
	
	@GetMapping("/cliente/{idCliente}")
	public Optional<Cliente> findById(@PathVariable Long idCliente){
		return clienteService.findByID(idCliente);
	}
	
	@DeleteMapping("/cliente/{idCliente}")
	public void deleteById(@PathVariable Long idCliente) {
		clienteService.deleteById(idCliente);
	}
	
	@PostMapping("/cliente")
	public ResponseEntity<Cliente> insert(@RequestBody Cliente cliente) {
		Cliente insertOrUpdate = clienteService.insertOrUpdate(cliente);
		
		return new ResponseEntity<Cliente>(insertOrUpdate, HttpStatus.OK);
	}
	
	@PutMapping("/cliente/{idCliente}")
	public ResponseEntity<Cliente> update(@PathVariable Long idCliente, @RequestBody Cliente cliente) {
		if(idCliente != null) {
			Optional<Cliente> findByID = clienteService.findByID(idCliente);
			if (findByID != null) {
				Cliente insertOrUpdate = clienteService.insertOrUpdate(cliente);		
				return new ResponseEntity<Cliente>(insertOrUpdate, HttpStatus.OK);
			}
		}
		
		return new ResponseEntity<Cliente>(new Cliente(), HttpStatus.OK);
	}
}
