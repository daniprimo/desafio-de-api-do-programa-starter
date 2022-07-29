package gft.entities.endereco;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import gft.dto.endereco.RegistrarEnderecoDTO;

@SpringBootTest
public class RegistrarEnderecoDTOTest {

	@Test
	@DisplayName("Construtor do RegistroEndereco")
	public void contrutorDoRegistroEndereco() {
		RegistrarEnderecoDTO dto = new RegistrarEnderecoDTO("06385820", "Rua ipixuna", 141, "A");
		assertEquals("06385820", dto.getCep());
		assertEquals("Rua ipixuna", dto.getLogradouro());
		assertEquals(141, dto.getNumero());
		assertEquals("A", dto.getComplemento());

	}

	@Test
	@DisplayName("GettrsAndSettrs do CEP")
	public void GettrsAndSettrsCEP () {
		String test = "06385820";
		RegistrarEnderecoDTO dto = new RegistrarEnderecoDTO();
		dto.setCep(test);
		
		assertEquals(test, dto.getCep());
		
	}
	
	@Test
	@DisplayName("GettrsAndSettrs do Logradouro")
	public void GettrsAndSettrsLOGRADOURO () {
		String test = "Rua ipixuna";
		RegistrarEnderecoDTO dto = new RegistrarEnderecoDTO();
		dto.setLogradouro(test);
		
		assertEquals(test, dto.getLogradouro());
		
	}
	
	@Test
	@DisplayName("GettrsAndSettrs do Numero")
	public void GettrsAndSettrsNUMERO () {
		Integer test = 141;
		RegistrarEnderecoDTO dto = new RegistrarEnderecoDTO();
		dto.setNumero(test);
		
		assertEquals(test, dto.getNumero());
		
	}
	
	@Test
	@DisplayName("GettrsAndSettrs do Complemento")
	public void GettrsAndSettrsComplemento () {
		String test = "A";
		RegistrarEnderecoDTO dto = new RegistrarEnderecoDTO();
		dto.setComplemento(test);
		
		assertEquals(test, dto.getComplemento());
		
	}


}
