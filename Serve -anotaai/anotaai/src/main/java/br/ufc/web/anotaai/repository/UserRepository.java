package br.ufc.web.anotaai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ufc.web.anotaai.model.User;


public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByEmailAndSenha (String email, String senha);
	
	@Query(value = "SELECT * FROM users WHERE acesso = 1", nativeQuery = true)
	List<User> findByTipo();
	
	@Query(value = "SELECT * FROM users WHERE cpf = ?1", nativeQuery = true)
	List<User> findByCPF(String cpf);
}
