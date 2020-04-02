package com.rodrigofujioka.dev.web.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigofujioka.dev.web.domain.Produto;
import com.rodrigofujioka.dev.web.service.ProdutoService;
import com.rodrigofujioka.dev.web.service.dto.ProdutoNomeMarcaDTO;

@RestController
@RequestMapping("/api")
public class ProdutoRest {
	
	private ProdutoService produtoService;
	
	@GetMapping("/produto/{marca}")
	public ResponseEntity<List<Produto>> getProduto(@PathVariable String marca) {
		return ResponseEntity.ok(produtoService.getProdutoByMarca(marca));
	}
	
	@PostMapping("/produto")
	public ResponseEntity<Produto> salvar(@RequestBody @Valid Produto produto) {
		Produto produtoSalva = produtoService.salvar(produto);
		return ResponseEntity.ok().body(produtoSalva);
	}
	
	@GetMapping("/produto")
	public ResponseEntity<List<Produto>> getProduto() {
		return ResponseEntity.ok(produtoService.getProduto());
	}
	
	@GetMapping("/produto/{id}")
	public ResponseEntity<Produto> getProdutoById(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(produtoService.getProdutoById(id));
		} catch (Exception e) {
			// FIXME INCLUIR LOGS
			return ResponseEntity.notFound().build();
		}

	}
	@GetMapping("/produto/nome/marca/{id}")
	public ResponseEntity<ProdutoNomeMarcaDTO> getProdutoNomeMarcaById(@PathVariable Long id) {
		try {			
			return ResponseEntity.ok(produtoService.getProdutoNomeMarcaById(id));			
		} catch (Exception e) {
			// FIXME INCLUIR LOGS
			return ResponseEntity.notFound().build();
		}

	}
	
	@DeleteMapping("/produto/{id}")
	public ResponseEntity deleteById(@PathVariable Long id) {
		try {
			produtoService.deleteProdutoById(id);
		} catch (Exception e) {
			// FIXME INCLUIR LOGS
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().build();
	}

}
