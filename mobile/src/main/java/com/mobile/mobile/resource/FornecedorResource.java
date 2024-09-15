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

import com.mobile.mobile.entity.Fornecedor;
import com.mobile.mobile.service.FornecedorService;

@RestController
public class FornecedorResource {

	@Autowired
	private FornecedorService fornecedorService;
	
	@GetMapping("/fornecedor")
	public List<Fornecedor> getAll(){
		return fornecedorService.getAlll();
	}
	
	@GetMapping("/fornecedor/{idFornecedor}")
	public Optional<Fornecedor> findById(@PathVariable Long idFornecedor){
		return fornecedorService.findByID(idFornecedor);
	}
	
	@DeleteMapping("/fornecedor/{idFornecedor}")
	public void deleteById(@PathVariable Long idFornecedor) {
		fornecedorService.deleteById(idFornecedor);
	}
	
	@PostMapping("/fornecedor")
	public ResponseEntity<Fornecedor> insert(@RequestBody Fornecedor fornecedor) {
		Fornecedor insertOrUpdate = fornecedorService.insertOrUpdate(fornecedor);
		
		return new ResponseEntity<Fornecedor>(insertOrUpdate, HttpStatus.OK);
	}
	
	@PutMapping("/fornecedor/{idFornecedor}")
	public ResponseEntity<Fornecedor> update(@PathVariable Long idFornecedor, @RequestBody Fornecedor fornecedor) {
		if(idFornecedor != null) {
			Optional<Fornecedor> findByID = fornecedorService.findByID(idFornecedor);
			if (findByID != null) {
				Fornecedor insertOrUpdate = fornecedorService.insertOrUpdate(fornecedor);		
				return new ResponseEntity<Fornecedor>(insertOrUpdate, HttpStatus.OK);
			}
		}
		
		return new ResponseEntity<Fornecedor>(new Fornecedor(), HttpStatus.OK);
	}
}
