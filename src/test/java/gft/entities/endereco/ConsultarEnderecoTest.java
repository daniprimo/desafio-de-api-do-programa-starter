package gft.entities.endereco;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import gft.dto.endereco.ConsultarEnderecoDTO;

@SpringBootTest
public class ConsultarEnderecoTest {

	@Test
	@DisplayName("Construtor do ConsultaEndereco")
	public void contrutorDoConsultarEndereco() {
		ConsultarEnderecoDTO dto = new ConsultarEnderecoDTO("06385820", "Rua ipixuna",null,null,null, 141, "A");
		assertEquals("06385820", dto.getCep());
		assertEquals("Rua ipixuna", dto.getLogradouro());
		assertEquals(141, dto.getNumero());
		assertEquals("A", dto.getComplemento());

	}
	
	@Test
	@DisplayName("GettrsAndSettrs do Uf")
	public void GettrsAndSettrsUf () {
		String test = "RJ";
		ConsultarEnderecoDTO endereco = new ConsultarEnderecoDTO();
		endereco.setUf(test);
		
		assertEquals(test, endereco.getUf());
		
	}
	
	@Test
	@DisplayName("GettrsAndSettrs do Localidade")
	public void GettrsAndSettrsLOCALIDADE () {
		String test = "Vila Menk";
		ConsultarEnderecoDTO endereco = new ConsultarEnderecoDTO();
		endereco.setLocalidade(test);
		
		assertEquals(test, endereco.getLocalidade());
		
	}
	
	@Test
	@DisplayName("GettrsAndSettrs do Bairro")
	public void GettrsAndSettrsBAIRRO () {
		String test = "Vila Menk";
		ConsultarEnderecoDTO endereco = new ConsultarEnderecoDTO();
		endereco.setBairro(test);
		
		assertEquals(test, endereco.getBairro());
		
	}
	
	
	@Test
	@DisplayName("GettrsAndSettrs do CEP")
	public void GettrsAndSettrsCEP () {
		String test = "06385820";
		ConsultarEnderecoDTO dto = new ConsultarEnderecoDTO();
		dto.setCep(test);
		
		assertEquals(test, dto.getCep());
		
	}
	
	@Test
	@DisplayName("GettrsAndSettrs do Logradouro")
	public void GettrsAndSettrsLOGRADOURO () {
		String test = "Rua ipixuna";
		ConsultarEnderecoDTO dto = new ConsultarEnderecoDTO();
		dto.setLogradouro(test);
		
		assertEquals(test, dto.getLogradouro());
		
	}
	
	@Test
	@DisplayName("GettrsAndSettrs do Numero")
	public void GettrsAndSettrsNUMERO () {
		Integer test = 141;
		ConsultarEnderecoDTO dto = new ConsultarEnderecoDTO();
		dto.setNumero(test);
		
		assertEquals(test, dto.getNumero());
		
	}
	
	@Test
	@DisplayName("GettrsAndSettrs do Complemento")
	public void GettrsAndSettrsComplemento () {
		String test = "A";
		ConsultarEnderecoDTO dto = new ConsultarEnderecoDTO();
		dto.setComplemento(test);
		
		assertEquals(test, dto.getComplemento());
		
	}

	
}
