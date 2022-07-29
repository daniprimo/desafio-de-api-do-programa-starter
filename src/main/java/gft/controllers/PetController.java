package gft.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import gft.dto.ConsumindoAPI.consumindoTheDog.webclient.RacaService;
import gft.dto.pet.ConsultaPetDTO;
import gft.dto.pet.PetMappersDTO;
import gft.dto.pet.RegistrarPetDTO;
import gft.entities.Pet;
import gft.service.ClienteService;
import gft.service.PetService;

@Controller
@RequestMapping("v1/pet")
public class PetController {

	private final ClienteService clienteService;
	private final PetService petService;
	private final RacaService racaService;

	public PetController(ClienteService clienteService, PetService petService, RacaService racaService) {
		this.clienteService = clienteService;
		this.petService = petService;
		this.racaService = racaService;
	}

	@PostMapping
	public ResponseEntity<ConsultaPetDTO> registrarPet(@RequestBody RegistrarPetDTO dto) {

		Pet fromDTO = PetMappersDTO.fromDTO(dto);
		fromDTO.setCliente(clienteService.pesquisarClientePorId(dto.getCliente()));
		fromDTO.setEspecie(racaService.buscarRacaPorId(dto.getEspecie()).block().getName());
		Pet pet = petService.adicionarPet(fromDTO);
		return ResponseEntity.ok(PetMappersDTO.fromEntity(pet));
	}

	@GetMapping
	@PreAuthorize("hasAuthority('Admin')")
	public ResponseEntity<List<ConsultaPetDTO>> buscarTodosOsPets() {
		return ResponseEntity
				.ok(petService.listarPets().stream().map(PetMappersDTO::fromEntity).collect(Collectors.toList()));
	}

	@GetMapping("{id}")
	public ResponseEntity<ConsultaPetDTO> pesquisarPetsPorId(@PathVariable Long id) {
		Pet pet = petService.pesquisarPorId(id);
		return ResponseEntity.ok(PetMappersDTO.fromEntity(pet));
	}

	@PutMapping("{id}")
	public ResponseEntity<ConsultaPetDTO> alterarPet(@RequestBody RegistrarPetDTO dto, @PathVariable Long id) {
		Pet pet = petService.alterarPorId(PetMappersDTO.fromDTO(dto), id);
		pet.setCliente(clienteService.pesquisarClientePorId(dto.getCliente()));
		pet.setEspecie(racaService.buscarRacaPorId(dto.getEspecie()).block().getName());
		return ResponseEntity.ok(PetMappersDTO.fromEntity(pet));
	}

	@DeleteMapping("{id}")
	public ResponseEntity<ConsultaPetDTO> deletarPet(@PathVariable Long id) {
		petService.deletarPetPorId(id);
		return ResponseEntity.ok().build();
	}

}
