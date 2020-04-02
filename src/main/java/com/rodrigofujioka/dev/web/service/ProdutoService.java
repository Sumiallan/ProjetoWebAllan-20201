package com.rodrigofujioka.dev.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rodrigofujioka.dev.web.domain.Produto;
import com.rodrigofujioka.dev.web.domain.Quarentena;
import com.rodrigofujioka.dev.web.repository.ProdutoRepository;
import com.rodrigofujioka.dev.web.service.dto.ProdutoNomeMarcaDTO;
import com.rodrigofujioka.dev.web.service.dto.QuarentenaNomeCidadeDTO;

import javassist.NotFoundException;

@Service
public class ProdutoService {

	
	private ProdutoRepository produtoRepository;
	
	
	public Produto salvar(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	public List<Produto> getProdutoByMarca(String marca) {
		return produtoRepository.findProdutoByMarca(marca);
	}
	
	public List<Produto> getProduto() {
		return produtoRepository.findAll();
	}
	
	public Produto getProdutoById(Long id) throws NotFoundException {
		Optional<Produto> produto = produtoRepository.findById(id);
		if (!produto.isPresent()) {
			throw new NotFoundException("Produto não localizado");
		}
		return produto.get();
	}
	
	public ProdutoNomeMarcaDTO getProdutoNomeMarcaById(Long id) throws NotFoundException {
		Optional<Produto> produto = produtoRepository.findById(id);
		if (!produto.isPresent()) {
			throw new NotFoundException("Produto não localizado");
		}
		return new ProdutoNomeMarcaDTO(produto.get());
	}
	
	public void deleteProdutoById(Long id) throws NotFoundException {
		Optional<Produto> produto = produtoRepository.findById(id);
		if (!produto.isPresent()) {
			throw new NotFoundException("Produto não localizado");
		}
		produtoRepository.delete(produto.get());
	}
	
}
