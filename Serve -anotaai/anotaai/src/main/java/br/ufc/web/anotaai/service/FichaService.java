package br.ufc.web.anotaai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.web.anotaai.model.Ficha;
import br.ufc.web.anotaai.repository.FichaRepository;


@Service
public class FichaService {
	@Autowired
	FichaRepository fichaRepo;
	
	public Ficha addFicha(int id_user, int id_cliente, String data) {
		Ficha ficha = new Ficha(id_user, id_cliente, data);
		return fichaRepo.save(ficha);
	}
	
	public List<Ficha> getFichas() {
		return fichaRepo.findAll();
	}
	
	public List<Ficha> getFichasByJoin() {
		return fichaRepo.fetchFichaInnerJoin();
	}

}
