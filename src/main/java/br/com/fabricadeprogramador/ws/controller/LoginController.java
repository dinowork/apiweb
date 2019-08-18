package br.com.fabricadeprogramador.ws.controller;

import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fabricadeprogramador.model.Usuario;
import br.com.fabricadeprogramador.ws.service.UsuarioService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class LoginController {
		
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping(value = "/autenticar", consumes = MediaType.APPLICATION_JSON_VALUE)
	public LoginResponse autenticar(@RequestBody Usuario usuario) throws ServletException {
		
		if( usuario.getNome() == null || usuario.getSenha() == null) {
			throw new ServletException("Nome e senha é obrigatório");
		}
		
		Usuario usuarioAutenticado  = usuarioService.buscarPorNome(usuario.getNome());
		
		if( usuarioAutenticado == null) {
			throw new ServletException("usuario não encontrado");
		}
		
		if( !usuarioAutenticado.getSenha().equals(usuario.getSenha())) {
			throw new ServletException("Usuário invalido");
		}
		
		//token
 		String token = Jwts.builder()
 				.setSubject(usuarioAutenticado.getNome())
 				.signWith(SignatureAlgorithm.HS512,"banana")
 				.setExpiration(new Date(System.currentTimeMillis()+1*60*1000))
 				.compact();
		return new LoginResponse(token) ;
	}
	
	@SuppressWarnings("unused")
	private class LoginResponse{		
		private String token;		
	
		public LoginResponse(String token) {
			this.token = token;
		}

		
		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}
		
		
	}

}
 