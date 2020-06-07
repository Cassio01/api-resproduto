package com.produtos.apirest.resources;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.produto.Produto;
import com.produtos.apirest.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API Rest Produtos")
public class ProdutoResource {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping("/produtos")
	@ApiOperation(value = "Retorna uma lista de produtos")
	public Collection<Produto> getAllProdutos(){
		return produtoRepository.findAll();
		
	}
	
	@GetMapping("/produto/{id}")
	@ApiOperation(value = "Retorna um produto por id")
	public Produto getProduto(@PathVariable(value ="id") int id) {
		return produtoRepository.findById(id);
	}
	@PostMapping("/produto")
	@ApiOperation(value = "Salva um produto")
	public Produto saveProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	@PutMapping("/produto/{id}")
	@ApiOperation(value = "Atualiza um produto por id")
	public Produto updateProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	@DeleteMapping("/produto/{id}")
	@ApiOperation(value = "Exclui um produto por id")
	public void deleteProduto(@PathVariable(value ="id") int id) {
		 produtoRepository.deleteById(id);
	}
}
