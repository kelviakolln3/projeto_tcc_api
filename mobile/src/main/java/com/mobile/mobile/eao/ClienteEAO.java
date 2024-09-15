package com.mobile.mobile.eao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobile.mobile.entity.Cliente;

@Repository
public interface ClienteEAO extends JpaRepository<Cliente, Long>{

}
