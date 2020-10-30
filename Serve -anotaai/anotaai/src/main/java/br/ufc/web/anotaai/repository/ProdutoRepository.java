package br.ufc.web.anotaai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ufc.web.anotaai.model.Produto;


public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
	@Query(value = "SELECT * FROM produtos LIMIT ?1", nativeQuery = true)
	List<Produto> findByQtd(int qtd);
}
