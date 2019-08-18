package br.com.fabricadeprogramador.ws.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fabricadeprogramador.model.Usuario;
import br.com.fabricadeprogramador.ws.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	public Usuario cadastrar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public Collection<Usuario> buscarTodos() {
		return usuarioRepository.findAll();
	}

	public void excluir(Usuario usuario) {
		usuarioRepository.delete(usuario);
	}

	public Usuario buscarPorId(Integer id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return usuario.get();
	}
	
	public Usuario buscarPorNome(String nome) {
		Usuario usuario = usuarioRepository.buscarPorNome(nome);
		return usuario;
	}
	
	public Usuario alterar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

}
