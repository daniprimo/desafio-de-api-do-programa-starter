package gft.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

import gft.dto.ConsumindoAPI.ViaCep;
import gft.dto.endereco.ConsultarEnderecoDTO;
import gft.dto.endereco.EnderecoMappers;
import gft.dto.endereco.RegistrarEnderecoDTO;
import gft.entities.Endereco;
import gft.exception.EntityNotFoundException;
import gft.service.EnderecoService;

@Controller
@RequestMapping("v1/endereco")
public class EnderecoController {

	private final EnderecoService enderecoService;

	public EnderecoController(EnderecoService enderecoService) {
		this.enderecoService = enderecoService;
	}
	
	@GetMapping
	public ResponseEntity<List<ConsultarEnderecoDTO>> buscarTodosOsEndereco () {
		return ResponseEntity.ok(
				enderecoService.listarEnderecos().stream().map(EnderecoMappers::fromEntity)
				.collect(Collectors.toList()));
	}
	
	@PostMapping
	public ResponseEntity<ConsultarEnderecoDTO> salvarEndereco (@RequestBody RegistrarEnderecoDTO endereco) throws IOException{
			
		try {
			ViaCep cep = new ViaCep(endereco.getCep());
			
			if (endereco.getLogradouro() == null || endereco.getLogradouro() != cep.getLogradouro()) {
				endereco.setLogradouro(cep.getLogradouro());
			}
			Endereco enderecosalvo = EnderecoMappers.fromDTO(endereco);
			enderecosalvo.setBairro(cep.getBairro());
			enderecosalvo.setLocalidade(cep.getLocalidade());
			enderecosalvo.setUf(cep.getUf());
			enderecoService.salvarEndereco(enderecosalvo);
			
			return ResponseEntity.ok(EnderecoMappers.fromEntity(enderecosalvo));
		} catch (EntityNotFoundException e) {
				throw new EntityNotFoundException("Impossivel encontrar o cep");
		}
	}
	
	@GetMapping("{cep}")
	public ResponseEntity<ConsultarEnderecoDTO> pesquisarEnderecoPeloCep (@PathVariable String cep) throws Exception{
		Endereco enderecoPesquisa = enderecoService.buscarEnderecoPeloCep(cep);
		return ResponseEntity.ok(EnderecoMappers.fromEntity(enderecoPesquisa));
	}
	
	@PutMapping("{cep}")
	public ResponseEntity<Endereco> atualizarEndereco (@RequestBody RegistrarEnderecoDTO dto,
			 @PathVariable String cep){
		try {
			Endereco enderecoAtual = EnderecoMappers.fromDTO(dto);
			
			URL url = new URL("http://viacep.com.br/ws/"+cep+"/json/");
			URLConnection connection = url.openConnection(); 
			InputStream is = connection.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
				
			String cepString = "";
			StringBuilder jsonCep = new StringBuilder();
			
			while ((cepString = br.readLine()) !=  null) {
				
				jsonCep.append(cepString);
			}
			
			Endereco enderecoAux = new Gson().fromJson(jsonCep.toString(), Endereco.class);
			
			enderecoAtual.setBairro(enderecoAux.getBairro());
			enderecoAtual.setLocalidade(enderecoAux.getLocalidade());
			enderecoAtual.setUf(enderecoAux.getUf());
			
			
			Endereco original = enderecoService.alterarEndereco(enderecoAtual, cep);
			return ResponseEntity.ok(original);
		} catch (Exception e) {
			throw new EntityNotFoundException("Endereco não cencontrado");
		}
	}
	
	@DeleteMapping("{cep}")
	public ResponseEntity<Endereco> excluirEndereco (@PathVariable String cep){
		try {
			enderecoService.excluirEndereco(cep);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	
	
	
	
}
