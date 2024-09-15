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

import com.mobile.mobile.entity.Produto;
import com.mobile.mobile.service.ProdutoService;

@RestController
public class ProdutoResource {
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping("/produto")
	public List<Produto> getAll(){
		return produtoService.getAlll();
	}
	
	@GetMapping("/produto/{idProduto}")
	public Optional<Produto> findById(@PathVariable Long idProduto){
		return produtoService.findByID(idProduto);
	}
	
	@DeleteMapping("/produto/{idProduto}")
	public void deleteById(@PathVariable Long idProduto) {
		produtoService.deleteById(idProduto);
	}
	
	@PostMapping("/produto")
	public ResponseEntity<Produto> insert(@RequestBody Produto produto) {
		Produto insertOrUpdate = produtoService.insertOrUpdate(produto);
		
		return new ResponseEntity<Produto>(insertOrUpdate, HttpStatus.OK);
	}
	
	@PutMapping("/produto/{idProduto}")
	public ResponseEntity<Produto> update(@PathVariable Long idProduto, @RequestBody Produto produto) {
		if(idProduto != null) {
			Optional<Produto> findByID = produtoService.findByID(idProduto);
			if (findByID != null) {
				Produto insertOrUpdate = produtoService.insertOrUpdate(produto);		
				return new ResponseEntity<Produto>(insertOrUpdate, HttpStatus.OK);
			}
		}
		
		return new ResponseEntity<Produto>(new Produto(), HttpStatus.OK);
	}

}
