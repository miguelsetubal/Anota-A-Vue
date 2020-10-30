package br.ufc.web.anotaai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ufc.web.anotaai.model.Ficha;

public interface FichaRepository extends JpaRepository<Ficha, Integer>{
	
	@Query(value = "select * from ficha inner join clientes on ficha.id_cliente = clientes.id", nativeQuery = true)
	List<Ficha> fetchFichaInnerJoin();
}
