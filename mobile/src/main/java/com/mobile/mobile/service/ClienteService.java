package com.mobile.mobile.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mobile.mobile.eao.ClienteEAO;
import com.mobile.mobile.entity.Cliente;

@Service
public class ClienteService {
	
	ClienteEAO clienteEAO;

	public ClienteService(ClienteEAO clienteEAO) {
		this.clienteEAO = clienteEAO;
	}
	
	public List<Cliente> getAlll() {
		return clienteEAO.findAll();
	}

	public void deleteById(Long id) {
		clienteEAO.deleteById(id);
	}

	public Cliente insertOrUpdate(Cliente cliente) {
		return clienteEAO.save(cliente);
	}

	public Optional<Cliente> findByID(Long id) {
		return clienteEAO.findById(id);
	}

}
