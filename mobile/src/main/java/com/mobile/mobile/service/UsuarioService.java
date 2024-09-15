package com.mobile.mobile.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.mobile.mobile.eao.UsuarioEAO;
import com.mobile.mobile.entity.Usuario;

@Service
public class UsuarioService {

	UsuarioEAO usuarioEAO;

	public UsuarioService(UsuarioEAO usuarioEAO) {
		this.usuarioEAO = usuarioEAO;
	}

	public List<Usuario> getAlll() {
		return usuarioEAO.findAll();
	}

	public void deleteById(Long id) {
		usuarioEAO.deleteById(id);
	}

	public Usuario insertOrUpdate(Usuario usuario) {
		return usuarioEAO.save(usuario);
	}

	public Optional<Usuario> findByID(Long id) {
		return usuarioEAO.findById(id);
	}
	
	public Optional<Usuario> login(String login, String senha) {
		Usuario usuarioExemplo = new Usuario();
        usuarioExemplo.setLogin(login);
        usuarioExemplo.setSenha(senha);

        Example<Usuario> example = Example.of(usuarioExemplo);
		return usuarioEAO.findOne(example);
	}

}
