package com.produtos.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produtos.apirest.produto.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
	Produto findById(int id);
}
