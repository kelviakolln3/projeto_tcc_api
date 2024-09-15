package com.mobile.mobile.eao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobile.mobile.entity.Pedido;

@Repository
public interface PedidoEAO extends JpaRepository<Pedido, Long>{

}
