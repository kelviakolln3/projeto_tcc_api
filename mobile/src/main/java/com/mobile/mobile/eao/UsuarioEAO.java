package com.mobile.mobile.eao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobile.mobile.entity.Usuario;

@Repository
public interface UsuarioEAO extends JpaRepository<Usuario, Long>{

}
