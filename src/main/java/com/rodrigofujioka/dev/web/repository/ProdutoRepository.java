package com.rodrigofujioka.dev.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rodrigofujioka.dev.web.domain.Disciplina;
import com.rodrigofujioka.dev.web.domain.Produto;
import com.rodrigofujioka.dev.web.domain.Quarentena;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	List<Produto> findProdutoByMarca(String marca);
	
	List<Produto> findProdutoByNomeAndMarca(String nome, String marca);

}
