package com.mobile.mobile.eao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mobile.mobile.entity.ItemPedido;

@Repository
public interface ItemPedidoEAO extends JpaRepository<ItemPedido, Long>{

	@Query("SELECT ip FROM ItemPedido ip WHERE ip.pedido.idPedido = :pedidoId")
    List<ItemPedido> findItensDoPedido(@Param("pedidoId") Long pedidoId);
}
