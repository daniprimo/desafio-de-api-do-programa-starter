package gft.entities.endereco;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import gft.dto.endereco.EnderecoMappers;
import gft.dto.endereco.RegistrarEnderecoDTO;
import gft.entities.Endereco;

@SpringBootTest
@DisplayName("Test do Endereco Mappers")
public class EnderecoMappersTest {
	
	
	private final String cep = DadosDosObjetos.CEP.getDescricao();
	private final String logradouro = DadosDosObjetos.LOGRADOUR.getDescricao();
	private final Integer numero = DadosDosObjetos.NUMERO.getNumero();
	private final String complemento = DadosDosObjetos.COMPLEMENTO.getDescricao();
	
	@Test
	@DisplayName("Test dos metodos staticos do mappers registro")
	public void testandoOsMetodosMappersQueRealizaInversaoDeObjetoRegistro () {
	RegistrarEnderecoDTO dto = new RegistrarEnderecoDTO(logradouro,numero, complemento);
	
	assertEquals(logradouro, EnderecoMappers.fromDTO(dto).getLogradouro());
	assertEquals(numero, EnderecoMappers.fromDTO(dto).getNumero());
	assertEquals(complemento, EnderecoMappers.fromDTO(dto).getComplemento());
	
		
	}
	
	@Test
	@DisplayName("Test dos metodos staticos do mappers consulta")
	public void testandoOsMetodosMappersQueRealizaInversaoDeObjetoConsulta () {
	Endereco endereco = new Endereco(cep, logradouro, numero, complemento);	
	
	assertEquals(logradouro, EnderecoMappers.fromEntity(endereco).getLogradouro());
	assertEquals(numero, EnderecoMappers.fromEntity(endereco).getNumero());
	assertEquals(complemento, EnderecoMappers.fromEntity(endereco).getComplemento());
	
		
	}
	

}
