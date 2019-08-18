package br.com.fabricadeprogramador.ws.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fabricadeprogramador.model.Estado;
import br.com.fabricadeprogramador.ws.service.EstadoService;

@RestController
public class EstadoController {	
	
	@Autowired
	EstadoService estadoService; 
		
	//end point
	@RequestMapping(method = RequestMethod.POST, value = "/estados", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Estado> cadastrarEstado(@RequestBody Estado estado) {		
		Estado estadoEncontrado = null;
		if(estado.getId() == null ) {
			estadoEncontrado = estadoService.cadastrar(estado);	
		}else {
			estadoEncontrado = estadoService.cadastrar(estado);
		}
		return new ResponseEntity<Estado>(estadoEncontrado , HttpStatus.CREATED) ;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/estados", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Estado>> buscarTodosEstado() {	
		Collection<Estado> estadosBuscados = estadoService.buscarTodos();
		return new ResponseEntity<>(estadosBuscados, HttpStatus.OK) ;
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/estados/{id}")
	public ResponseEntity<Estado> excluirEstado(@PathVariable Integer id) {
		Estado estadoEncontrado = estadoService.buscarPorId(id);
		if(estadoEncontrado ==  null) 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);	
		estadoService.excluir(estadoEncontrado);
		return new ResponseEntity<>(estadoEncontrado , HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/estados", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Estado> alterarEstado(@RequestBody Estado estado) {
		Estado estadoEncontrado = estadoService.alterar(estado);				
		return new ResponseEntity<Estado>(estadoEncontrado , HttpStatus.OK) ;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/estados/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Estado> buscarEstadoPorId(@PathVariable Integer id) {
		Estado estadoEncontrado = estadoService.buscarPorId(id);
		if(estadoEncontrado ==  null) 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);			
		return new ResponseEntity<>(estadoEncontrado , HttpStatus.OK);
	}

	
	
}
 