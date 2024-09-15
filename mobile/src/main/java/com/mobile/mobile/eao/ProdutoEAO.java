package com.mobile.mobile.eao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobile.mobile.entity.Produto;

@Repository
public interface ProdutoEAO extends JpaRepository<Produto, Long>{

}
