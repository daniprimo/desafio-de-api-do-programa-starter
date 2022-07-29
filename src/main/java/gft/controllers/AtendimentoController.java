package gft.controllers;

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

import gft.dto.atendimento.AtendimentoMappersDTO;
import gft.dto.atendimento.ConsultaAtendimentoDTO;
import gft.dto.atendimento.RegstraAtendimentoDTO;
import gft.entities.Atendimento;
import gft.exception.EntityNotFoundException;
import gft.service.AtendimentoService;
import gft.service.MedicoService;
import gft.service.PetService;

@Controller
@RequestMapping("v1/atendimento")
public class AtendimentoController {

	private final AtendimentoService atendimentoService;
	private final MedicoService medicoService;
	private final PetService petService;

	public AtendimentoController(AtendimentoService atendimentoService, MedicoService medicoService,
			PetService petService) {
		this.atendimentoService = atendimentoService;
		this.medicoService = medicoService;
		this.petService = petService;
	}

	@PostMapping
	public ResponseEntity<ConsultaAtendimentoDTO> registrarAtendimento(@RequestBody RegstraAtendimentoDTO dto) {
		Atendimento saidaDoDto = AtendimentoMappersDTO.fromDTO(dto);
		saidaDoDto.setPet(petService.pesquisarPorId(dto.getPet()));
		saidaDoDto.setVeterinario(medicoService.buscarMedicoPorId(dto.getVeterinario()));
		Atendimento petSalvo = atendimentoService.registrarOAtendimento(saidaDoDto);
		return ResponseEntity.ok(AtendimentoMappersDTO.fromEntity(petSalvo));
	}

	@GetMapping
	public ResponseEntity<List<ConsultaAtendimentoDTO>> listaDeAtendimentos() {
		try {
			return ResponseEntity.ok(atendimentoService.listarTodosatendiemnto().stream()
					.map(AtendimentoMappersDTO::fromEntity).collect(Collectors.toList()));
		} catch (Exception e) {
			throw new EntityNotFoundException("Não foi possivel listar atendimento");
		}
	}

	@GetMapping("{id}")
	public ResponseEntity<ConsultaAtendimentoDTO> pesquisarAtendimentoPorId(@PathVariable Long id) {
		try {
			Atendimento atendimento = atendimentoService.buscarAtendimentoPeloId(id);
			return ResponseEntity.ok(AtendimentoMappersDTO.fromEntity(atendimento));
		} catch (Exception e) {
			throw new EntityNotFoundException("Erro ao pesquisar o atendimento");
		}
	}

	@PutMapping("{id}")
	public ResponseEntity<ConsultaAtendimentoDTO> atualziarAtendimento(@RequestBody RegstraAtendimentoDTO dto,
			@PathVariable Long id) {
		try {
			Atendimento atendimento = atendimentoService.atualizarAtendimentoPeloId(AtendimentoMappersDTO.fromDTO(dto),
					id);
			atendimento.setPet(petService.pesquisarPorId(dto.getPet()));
			atendimento.setVeterinario(medicoService.buscarMedicoPorId(dto.getVeterinario()));
			return ResponseEntity.ok(AtendimentoMappersDTO.fromEntity(atendimento));
		} catch (Exception e) {
			throw new EntityNotFoundException("Erro ao Atualizar");
		}
	}

	@DeleteMapping("{id}")
	public ResponseEntity<ConsultaAtendimentoDTO> deletarAtendimento(@PathVariable Long id) {
		try {
			atendimentoService.excluirAtendimentoPorId(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			throw new EntityNotFoundException("Erro ao deletar");
		}
	}

}
