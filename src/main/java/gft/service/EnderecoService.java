package gft.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import gft.entities.Endereco;
import gft.exception.EntityNotFoundException;
import gft.repository.EnderecoRepository;

@Service
public class EnderecoService {

	private final EnderecoRepository enderecoRepository;

	public EnderecoService(EnderecoRepository enderecoRepository) {
		this.enderecoRepository = enderecoRepository;
	}

	public List<Endereco> listarEnderecos() {
		return enderecoRepository.findAll();
	}

	public Endereco salvarEndereco(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}

	public Endereco buscarEnderecoPeloCep(String id) {
		Optional<Endereco> optional = enderecoRepository.findByCep(id);
		return optional.orElseThrow(() -> new EntityNotFoundException("Cep inexistente em nossos registros"));
	}

	public Endereco alterarEndereco(Endereco endereco, String cep) {
		Endereco original = buscarEnderecoPeloCep(cep);
		endereco.setCep(original.getCep());
		return enderecoRepository.save(endereco);
	}

	public void excluirEndereco(String cep) {
		Endereco endereco = buscarEnderecoPeloCep(cep);
		enderecoRepository.delete(endereco);
	}
	
	

}
