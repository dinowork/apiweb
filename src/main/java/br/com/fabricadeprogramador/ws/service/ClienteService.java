package br.com.fabricadeprogramador.ws.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fabricadeprogramador.model.Cliente;
import br.com.fabricadeprogramador.ws.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;
			
	public Cliente cadastrar(Cliente cliente) {												
		return clienteRepository.save(cliente);
	}
	
	public Collection<Cliente> buscarTodos(){
		return clienteRepository.findAll();	
	}
	
	public void excluir(Cliente cliente){
		clienteRepository.delete(cliente);	
	}
	
	public Cliente buscarPorId(Integer id) {		
		Optional<Cliente> cliente  = clienteRepository.findById(id);
		return cliente.get();
	}
	
	public Cliente alterar(Cliente cliente){
		return clienteRepository.save(cliente);
	}
	
}
 