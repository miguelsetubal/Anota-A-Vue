package br.ufc.web.anotaai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.ufc.web.anotaai.model.Produto;
import br.ufc.web.anotaai.service.ProdutoService;


 

 
@RestController
@CrossOrigin
@RequestMapping(path = "/api/produtos")
public class ProdutoController {
	
	@Autowired
	ProdutoService produtoService;
	
	 @RequestMapping(method = RequestMethod.GET)
	    public ResponseEntity<List<Produto>> getProdutos() {
	        return new ResponseEntity<List<Produto>>(produtoService.getProdutos(), HttpStatus.OK);
	    }
	 @RequestMapping(method = RequestMethod.GET, value = "{id}")
		public ResponseEntity<Produto> getProduto(@PathVariable("id") Integer id) {
			return new ResponseEntity<Produto>(produtoService.getProduto(id), HttpStatus.OK);
		}
	 @RequestMapping(method = RequestMethod.GET, value = "/search2")
		public ResponseEntity<List<Produto>> getProdutoByQtd(@RequestParam("qtd") Integer qtd) {
			return new ResponseEntity<List<Produto>>(produtoService.getProdutoByQtd(qtd), HttpStatus.OK);
		}
	 
	 @RequestMapping(method = RequestMethod.POST)
	    public ResponseEntity<Produto> produtoService(@RequestBody Produto produto) {
	        return new ResponseEntity<Produto>(produtoService.addProduto(produto.getDescricao(), produto.getValor()), HttpStatus.OK);
	    }
	 
	 @RequestMapping(method = RequestMethod.PUT, value = "{id}")
		public ResponseEntity<Produto> updateProduto(@PathVariable("id") Integer id, @RequestBody Produto prod) {
			return new ResponseEntity<Produto>(
					produtoService.updateProduto(id, prod.getDescricao(), prod.getValor()),HttpStatus.OK);
		}
	 
	 @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	    public ResponseEntity<Void> deleteProduto(@PathVariable("id") Integer id) {
	        if (produtoService.removeProduto(id)) {
	            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	        }
	 
	        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	    }

}
