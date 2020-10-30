package br.ufc.web.anotaai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ufc.web.anotaai.model.Ficha;
import br.ufc.web.anotaai.service.FichaService;


@RestController
@CrossOrigin
@RequestMapping(path = "/api/fichas")
public class FichaController {
	
	@Autowired
	FichaService fichaService;
	
	 @RequestMapping(method = RequestMethod.GET)
	    public ResponseEntity<List<Ficha>> getFichas() {
	        return new ResponseEntity<List<Ficha>>(fichaService.getFichas(), HttpStatus.OK);
	    }
	
	@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Ficha> fichaService(@RequestBody Ficha ficha) {
        return new ResponseEntity<Ficha>(fichaService.addFicha(ficha.getId_cliente(), ficha.getId_user(), ficha.getData()), HttpStatus.OK);
    }

}
