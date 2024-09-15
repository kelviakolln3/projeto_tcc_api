package com.mobile.mobile.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mobile.mobile.eao.ProdutoEAO;
import com.mobile.mobile.entity.Produto;

@Service
public class ProdutoService {

	ProdutoEAO produtoEAO;

	public ProdutoService(ProdutoEAO produtoEAO) {
		this.produtoEAO = produtoEAO;
	}
	
	public List<Produto> getAlll() {
		return produtoEAO.findAll();
	}

	public void deleteById(Long id) {
		produtoEAO.deleteById(id);
	}

	public Produto insertOrUpdate(Produto produto) {
		return produtoEAO.save(produto);
	}

	public Optional<Produto> findByID(Long id) {
		return produtoEAO.findById(id);
	}
	
}
