package br.ufc.web.anotaai.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.ufc.web.anotaai.model.Cliente;
import br.ufc.web.anotaai.repository.ClienteRepository;
import br.ufc.web.anotaai.repository.UserRepository;

@Service
public class ClienteService {

	ClienteRepository clienteRepo;
	UserRepository userRepo;

	ClienteService(ClienteRepository clienteRepo, UserRepository userRepo) {
		this.clienteRepo = clienteRepo;
		this.userRepo = userRepo;
	}

	@Transactional
	public ResponseEntity<Object> addCliente(Cliente cliente) {
		Cliente cli = new Cliente();
		cli.setCurso(cliente.getCurso());
		cli.setMatricula(cliente.getMatricula());
		cli.setPeriodo(cliente.getPeriodo());
		cli.setTelefone(cliente.getTelefone());
		cli.setUser(cliente.getUser());
		Cliente savedCli = clienteRepo.save(cli);
		if (clienteRepo.findById(savedCli.getId()).isPresent())
			return ResponseEntity.ok().body("Cliente created successfully.");

		else
			return ResponseEntity.unprocessableEntity().body("Failed to create the Cliente specified.");

	}



	public List<Cliente> getClientes() {
		return clienteRepo.findAll();
	}

}
