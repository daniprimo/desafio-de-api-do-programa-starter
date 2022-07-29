package gft.controllers;

import java.io.IOException;
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

import gft.dto.cliente.ClienteMappersDTO;
import gft.dto.cliente.ConsultaClienteDTO;
import gft.dto.cliente.RegistroClienteDTO;
import gft.entities.Cliente;
import gft.service.ClienteService;
import gft.service.PetService;

@Controller
@RequestMapping("v1/cliente")
public class ClienteController {

	private final ClienteService clienteService;
	private final PetService petService;

	public ClienteController(ClienteService clienteService, PetService petService) {
		this.clienteService = clienteService;
		this.petService = petService;
	}

	@PostMapping
	public ResponseEntity<ConsultaClienteDTO> registrarCliente(@RequestBody RegistroClienteDTO dto) throws IOException {
		Cliente cliente = ClienteMappersDTO.fromDTO(dto);
		cliente.setPets(petService.listaDosPetsParaClientes(dto.getPets()));
		clienteService.salvarCliente(cliente);
		return ResponseEntity.ok(ClienteMappersDTO.fromEntity(cliente));
	}

	@GetMapping
	public ResponseEntity<List<ConsultaClienteDTO>> buscarTodosClientes() {
		return ResponseEntity.ok(clienteService.listarCliente().stream().map(ClienteMappersDTO::fromEntity)
				.collect(Collectors.toList()));
	}

	@GetMapping("{id}")
	public ResponseEntity<ConsultaClienteDTO> pesquisarClienteorId(@PathVariable Long id) {
		Cliente cliente = clienteService.pesquisarClientePorId(id);
		return ResponseEntity.ok(ClienteMappersDTO.fromEntity(cliente));
	}

	@PutMapping("{id}")
	public ResponseEntity<ConsultaClienteDTO> alterarCliente(@RequestBody RegistroClienteDTO dto,
			@PathVariable Long id) throws IOException {
		Cliente clienteOrigin = clienteService.alterarClientePorId(ClienteMappersDTO.fromDTO(dto),id);
		clienteOrigin.setPets(petService.listaDosPetsParaClientes(dto.getPets()));
		ConsultaClienteDTO clienteDTO = ClienteMappersDTO.fromEntity(clienteOrigin);
		return ResponseEntity.ok(clienteDTO);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<ConsultaClienteDTO> deletarCliente(@PathVariable Long id) {
		clienteService.deletarClientePorId(id);
		return ResponseEntity.ok().build();
	}
}
