package br.com.fabricadeprogramador.ws.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fabricadeprogramador.model.Usuario;
import br.com.fabricadeprogramador.ws.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {	
	
	@Autowired
	UsuarioService usuarioService; 
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario) {		
		Usuario usuarioCadastrado = null;
		if(usuario.getId() == null ) {
			usuarioCadastrado = usuarioService.cadastrar(usuario);	
		}else {
			usuarioCadastrado = usuarioService.alterar(usuario);
		}
		return new ResponseEntity<Usuario>(usuarioCadastrado , HttpStatus.CREATED) ;
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Usuario>> buscarTodosUsuario() {	
		Collection<Usuario> usuariosBuscados = usuarioService.buscarTodos();
		return new ResponseEntity<>(usuariosBuscados, HttpStatus.OK) ;
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Usuario> excluirUsuario(@PathVariable Integer id) {
		Usuario usuarioEncontrado = usuarioService.buscarPorId(id);
		if(usuarioEncontrado ==  null) 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);	
		usuarioService.excluir(usuarioEncontrado);
		return new ResponseEntity<>(usuarioEncontrado , HttpStatus.OK);
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> alterarUsuario(@RequestBody Usuario usuario) {
		Usuario usuarioCadastrado = usuarioService.alterar(usuario);				
		return new ResponseEntity<Usuario>(usuarioCadastrado , HttpStatus.OK) ;
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable Integer id) {
		Usuario usuarioEncontrado = usuarioService.buscarPorId(id);
		if(usuarioEncontrado ==  null) 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);			
		return new ResponseEntity<>(usuarioEncontrado , HttpStatus.OK);
	}
	
}
 