package br.ufc.web.anotaai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.ufc.web.anotaai.model.Produto;
import br.ufc.web.anotaai.repository.ProdutoRepository;


@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository produtoRepo;

	public Produto addProduto(String descricao, float valor) {
		if(descricao.length() <3 || valor <0) {
			return null;
		}else {
		Produto produto = new Produto(descricao, valor);
		return produtoRepo.save(produto);
		}
	}
	
	public Produto updateProduto(Integer id, String descricao, float valor) {
		Produto produtoAux = produtoRepo.findById(id).get();
		if(descricao.length() <3 || valor <0) {
			return null;
		}else {
		if(produtoAux != null) {
			produtoAux.setDescricao(descricao);
			produtoAux.setValor(valor);
			produtoRepo.save(produtoAux);
			
		}
		return produtoAux;
		}
	}
	
	public boolean removeProduto(Integer id) {
		if (produtoRepo.existsById(id)) {
			produtoRepo.deleteById(id);
			return true;
		}

		return false;
	}
	
	public List<Produto> getProdutos() {
		return produtoRepo.findAll();
	}
	
	public Produto getProduto(Integer id) {
		return produtoRepo.findById(id).get();
	}
	
	public List<Produto> getProdutoByQtd(Integer qtd) {
		 List<Produto> produtos = produtoRepo.findByQtd(qtd);
		 return produtos;
	 }

}
