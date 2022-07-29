package gft.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import gft.entities.Cliente;
import gft.exception.EntityNotFoundException;
import gft.repository.ClienteRepository;

@Service
public class ClienteService {
	
	private ClienteRepository clienteRepository;

	
	
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}



	public List<Cliente> listarCliente (){
		return clienteRepository.findAll();
	}
	
	public Cliente salvarCliente (Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public Cliente pesquisarClientePorId (Long id) {
		 Optional<Cliente> optional = clienteRepository.findById(id);
		 return optional.orElseThrow
				 (() -> new EntityNotFoundException("Cliente não encontrado"));
	}
	
	public Cliente pesquisarClientePorNome (String nome) {
		Optional<Cliente> optional = clienteRepository.findByNome(nome);
		return optional.orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
	}
	
	public Cliente pesquisarClientePorCpf (String cpf) {
		Optional<Cliente> optional = clienteRepository.findByCpf(cpf);
		return optional.orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
	}
	
	public Cliente alterarClientePorId (Cliente cliente, Long id) {
		Cliente clienteOriginal = pesquisarClientePorId(id);
		cliente.setId(clienteOriginal.getId());
		return clienteRepository.save(cliente);
	}
	
	public Cliente alterarClientePorCpf (Cliente cliente, String cpf) {
		Cliente clienteOriginal = pesquisarClientePorCpf(cpf);
		cliente.setId(clienteOriginal.getId());
		return clienteRepository.save(cliente);
	}
	
	public void deletarClientePorId (Long id) {
		Cliente cliente = pesquisarClientePorId(id);
		clienteRepository.delete(cliente);
	}
	
	public void deletarClientePorCpf (String cpf) {
		Cliente cliente = pesquisarClientePorCpf(cpf);
		clienteRepository.delete(cliente);
	}


}
