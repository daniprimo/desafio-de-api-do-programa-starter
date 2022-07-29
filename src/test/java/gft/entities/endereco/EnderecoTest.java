package gft.entities.endereco;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import gft.entities.Endereco;

@SpringBootTest
public class EnderecoTest {

	@Test
	@DisplayName("Construtor de Endereco")
	public void contrutorDeEndereco() {
		Endereco endereco = new Endereco("06385820", "Rua ipixuna", 141, "A");
		assertEquals("06385820", endereco.getCep());
		assertEquals("Rua ipixuna", endereco.getLogradouro());
		assertEquals(141, endereco.getNumero());
		assertEquals("A", endereco.getComplemento());

	}
	
	
	@Test
	@DisplayName("Construtor de Endereco com todos os Atributos")
	public void contrutorDeEnderecoCompleto() {
		Endereco endereco = new Endereco("06385820", "Rua ipixuna","Vila Menk","Carapicuiba","RJ", 141, "A");
		assertEquals("06385820", endereco.getCep());
		assertEquals("Rua ipixuna", endereco.getLogradouro());
		assertEquals("Vila Menk", endereco.getBairro());
		assertEquals("Carapicuiba", endereco.getLocalidade());
		assertEquals("RJ", endereco.getUf());
		assertEquals(141, endereco.getNumero());
		assertEquals("A", endereco.getComplemento());

	}
	
	@Test
	@DisplayName("GettrsAndSettrs do Uf")
	public void GettrsAndSettrsUf () {
		String test = "RJ";
		Endereco endereco = new Endereco();
		endereco.setUf(test);
		
		assertEquals(test, endereco.getUf());
		
	}
	
	@Test
	@DisplayName("GettrsAndSettrs do Localidade")
	public void GettrsAndSettrsLOCALIDADE () {
		String test = "Vila Menk";
		Endereco endereco = new Endereco();
		endereco.setLocalidade(test);
		
		assertEquals(test, endereco.getLocalidade());
		
	}
	
	@Test
	@DisplayName("GettrsAndSettrs do Bairro")
	public void GettrsAndSettrsBAIRRO () {
		String test = "Vila Menk";
		Endereco endereco = new Endereco();
		endereco.setBairro(test);
		
		assertEquals(test, endereco.getBairro());
		
	}
	
	@Test
	@DisplayName("GettrsAndSettrs do CEP")
	public void GettrsAndSettrsCEP () {
		String test = "06385820";
		Endereco endereco = new Endereco();
		endereco.setCep(test);
		
		assertEquals(test, endereco.getCep());
		
	}
	
	@Test
	@DisplayName("GettrsAndSettrs do Logradouro")
	public void GettrsAndSettrsLOGRADOURO () {
		String test = "Rua ipixuna";
		Endereco endereco = new Endereco();
		endereco.setLogradouro(test);
		
		assertEquals(test, endereco.getLogradouro());
		
	}
	
	@Test
	@DisplayName("GettrsAndSettrs do Numero")
	public void GettrsAndSettrsNUMERO () {
		Integer test = 141;
		Endereco endereco = new Endereco();
		endereco.setNumero(test);
		
		assertEquals(test, endereco.getNumero());
		
	}
	
	@Test
	@DisplayName("GettrsAndSettrs do Complemento")
	public void GettrsAndSettrsComplemento () {
		String test = "A";
		Endereco endereco = new Endereco();
		endereco.setComplemento(test);
		
		assertEquals(test, endereco.getComplemento());
		
	}
	
	

}
