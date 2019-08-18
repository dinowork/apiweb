package br.com.fabricadeprogramador.ws.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fabricadeprogramador.model.Estado;
import br.com.fabricadeprogramador.ws.repository.EstadoRepository;

@Service
public class EstadoService {

	@Autowired
	EstadoRepository estadoRepository;

	public Estado cadastrar(Estado estado) {
		return estadoRepository.save(estado);
	}

	public Collection<Estado> buscarTodos() {
		return estadoRepository.findAll();
	}

	public void excluir(Estado estado) {
		estadoRepository.delete(estado);
	}

	public Estado buscarPorId(Integer id) {
		Optional<Estado> Estado = estadoRepository.findById(id);
		return Estado.get();
	}

	public Estado alterar(Estado estado) {
		return estadoRepository.save(estado);
	}

}
