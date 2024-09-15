package com.mobile.mobile.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mobile.mobile.eao.FornecedorEAO;
import com.mobile.mobile.entity.Fornecedor;

@Service
public class FornecedorService {

	FornecedorEAO fornecedorEAO;

	public FornecedorService(FornecedorEAO fornecedorEAO) {
		this.fornecedorEAO = fornecedorEAO;
	}
	
	public List<Fornecedor> getAlll() {
		return fornecedorEAO.findAll();
	}

	public void deleteById(Long id) {
		fornecedorEAO.deleteById(id);
	}

	public Fornecedor insertOrUpdate(Fornecedor fornecedor) {
		return fornecedorEAO.save(fornecedor);
	}

	public Optional<Fornecedor> findByID(Long id) {
		return fornecedorEAO.findById(id);
	}

}
