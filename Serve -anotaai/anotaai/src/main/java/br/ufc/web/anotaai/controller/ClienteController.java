package br.ufc.web.anotaai.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.ufc.web.anotaai.model.Cliente;
import br.ufc.web.anotaai.repository.ClienteRepository;
import br.ufc.web.anotaai.service.ClienteService;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/clientes")
public class ClienteController {

	ClienteService clienteService;
	ClienteRepository clienteRepo;

	public ClienteController(ClienteService clienteService, ClienteRepository clienteRepo) {
		this.clienteService = clienteService;
		this.clienteRepo = clienteRepo;
	}
	
	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Cliente>> getClientes() {
        return new ResponseEntity<List<Cliente>>(clienteService.getClientes(), HttpStatus.OK);
    }

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> createOrganization(@RequestBody Cliente cliente) {
		return clienteService.addCliente(cliente);

	}
}
