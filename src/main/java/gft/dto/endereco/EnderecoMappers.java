package gft.dto.endereco;

import java.io.IOException;

import gft.dto.ConsumindoAPI.ViaCep;
import gft.entities.Endereco;

public class EnderecoMappers {

	public static Endereco fromDTO (RegistrarEnderecoDTO dto) throws IOException {
		ViaCep cep = new ViaCep(dto.getCep());
		if(dto.getLogradouro() == null || dto.getLogradouro() != cep.getLogradouro()) {
			dto.setLogradouro(cep.getLogradouro());
		}
		
		
		return new Endereco(null,dto.getCep(),dto.getLogradouro(), cep.getBairro(), cep.getLocalidade(),
				cep.getUf(), dto.getNumero(), dto.getComplemento());
	}
	
	
	
	public static ConsultarEnderecoDTO fromEntity (Endereco endereco) {
		
		return new ConsultarEnderecoDTO(endereco.getId(),endereco.getCep(),
				endereco.getLogradouro(),
				endereco.getBairro(), endereco.getLocalidade(), endereco.getUf(), endereco.getNumero(), endereco.getComplemento());
	}
	
}
