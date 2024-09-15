package com.mobile.mobile.eao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobile.mobile.entity.Fornecedor;

@Repository
public interface FornecedorEAO extends JpaRepository<Fornecedor, Long>{

}
