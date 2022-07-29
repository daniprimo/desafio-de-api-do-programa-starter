package gft.dto.cliente;

import java.io.IOException;

import gft.dto.endereco.EnderecoMappers;
import gft.entities.Cliente;

public class ClienteMappersDTO {

	public static Cliente fromDTO(RegistroClienteDTO dto) throws IOException {
		return new Cliente(null, dto.getCpf(), dto.getNome(), dto.getTelefone(),
				EnderecoMappers.fromDTO(dto.getEndereco()));
	}

	public static ConsultaClienteDTO fromEntity(Cliente cliente) {
		return new ConsultaClienteDTO(cliente.getId(), cliente.getCpf(), cliente.getNome(), cliente.getTelefone(),
				cliente.getEndereco(),cliente.getPets());
	}

}
