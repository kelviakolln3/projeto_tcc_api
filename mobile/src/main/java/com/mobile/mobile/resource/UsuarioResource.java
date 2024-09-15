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

import com.mobile.mobile.dto.UsuarioDTO;
import com.mobile.mobile.entity.Usuario;
import com.mobile.mobile.service.UsuarioService;

@RestController
public class UsuarioResource {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/usuario")
	public List<Usuario> getAll(){
		return usuarioService.getAlll();
	}
	
	@GetMapping("/usuario/{idUsuario}")
	public Optional<Usuario> findById(@PathVariable Long idUsuario){
		return usuarioService.findByID(idUsuario);
	}
	
	@DeleteMapping("/usuario/{idUsuario}")
	public void deleteById(@PathVariable Long idUsuario) {
		usuarioService.deleteById(idUsuario);
	}
	
	@PostMapping("/usuario")
	public ResponseEntity<Usuario> insert(@RequestBody Usuario usuario) {
		Usuario insertOrUpdate = usuarioService.insertOrUpdate(usuario);
		
		return new ResponseEntity<Usuario>(insertOrUpdate, HttpStatus.CREATED);
	}
	
	@PutMapping("/usuario/{idUsuario}")
	public ResponseEntity<Usuario> update(@PathVariable Long idUsuario, @RequestBody Usuario usuario) {
		if(idUsuario != null) {
			Optional<Usuario> findByID = usuarioService.findByID(idUsuario);
			if (findByID != null) {
				Usuario insertOrUpdate = usuarioService.insertOrUpdate(usuario);		
				return new ResponseEntity<Usuario>(insertOrUpdate, HttpStatus.OK);
			}
		}
		
		return new ResponseEntity<Usuario>(new Usuario(), HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Optional<Usuario>> login(@RequestBody UsuarioDTO usuario){
		Optional<Usuario> login = usuarioService.login(usuario.getLogin(), usuario.getSenha());
		if(login != null) {
			return new ResponseEntity<Optional<Usuario>>(login, HttpStatus.OK);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

}
