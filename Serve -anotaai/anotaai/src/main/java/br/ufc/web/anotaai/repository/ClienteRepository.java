package br.ufc.web.anotaai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufc.web.anotaai.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
