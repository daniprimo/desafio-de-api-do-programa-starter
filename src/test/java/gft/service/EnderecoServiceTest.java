package gft.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import gft.entities.Endereco;
import gft.repository.EnderecoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@DisplayName("Testes do Service de Endereco")
public class EnderecoServiceTest {
	@Autowired
	private EnderecoService enderecoService;
	
	@MockBean
	private EnderecoRepository enderecoRepository;
	
	@Test
	@DisplayName("Salvar no Banco de dados")
	public void salvarEnderecoTest () {
		when(enderecoRepository.findAll()).thenReturn(Stream
				.of(new Endereco("06385820", "Rua Ipixuna", 141, "A"), new Endereco("0635454", "Rua Ibi", 141, "A"))
				.collect(Collectors.toList()));
		
		assertEquals(2, enderecoService.listarEnderecos().size());
	}
	
	@Test
	@DisplayName("Buscar registro pelo cep")
	public void buscarNoBancoPeloCep () throws Exception {
		String cep = "06385820";
		when(enderecoRepository.findByCep(cep)).thenReturn(Stream
				.of(new Endereco("06385820", "Rua Ipixuna", 141, "A"))
				.findFirst());
	
		assertEquals("Rua Ipixuna", enderecoService.buscarEnderecoPeloCep(cep).getLogradouro());
	}
	
	@Test
	@DisplayName("Salvar um novo registro ao Banco")
	public void criarUmNovoCadastro () {
		Endereco endereco = new Endereco("06385820", "Rua Ipixuna", 141, "A");
		when(enderecoRepository.save(endereco)).thenReturn(endereco);
		assertEquals(endereco, enderecoService.salvarEndereco(endereco));
	}
	
	public void excluirCadastro () throws Exception {
		Endereco endereco = new Endereco("06385820", "Rua Ipixuna", 141, "A");
		enderecoService.excluirEndereco("06385820");
		verify(enderecoRepository,times(1)).delete(endereco);
	}

	
}
