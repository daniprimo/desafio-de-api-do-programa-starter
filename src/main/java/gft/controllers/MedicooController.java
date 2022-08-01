package gft.controllers;

import java.io.IOException;
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

import gft.dto.medico.ConsultaMedicoDTO;
import gft.dto.medico.MedicoMappers;
import gft.dto.medico.RegistrarMedicoDTO;
import gft.entities.MedicoVeterinario;
import gft.security.dto.UsuarioMappers;
import gft.security.entities.Usuario;
import gft.security.service.PerfilService;
import gft.security.service.UsuarioService;
import gft.service.MedicoService;

@Controller
@RequestMapping("v1/veterinario")
public class MedicooController {

	private final MedicoService medicoService;
	private final PerfilService perfilService;
	private final UsuarioService usuarioService;

	public MedicooController(MedicoService medicoService, PerfilService perfilService, UsuarioService usuarioService) {
		this.medicoService = medicoService;
		this.perfilService = perfilService;
		this.usuarioService = usuarioService;
	}

	@GetMapping
	@PreAuthorize("hasAuthority('Admin')")
	public ResponseEntity<List<ConsultaMedicoDTO>> buscarTodosMedicos() {
		return ResponseEntity
				.ok(medicoService.listarMedicos().stream().map(MedicoMappers::ftomEntity).collect(Collectors.toList()));
	}

	@PostMapping
	public ResponseEntity<ConsultaMedicoDTO> registrarMedico(@RequestBody RegistrarMedicoDTO dto) throws IOException {
		ConsultaMedicoDTO entity = MedicoMappers.ftomEntity(medicoService.salvarMedico(MedicoMappers.fromDTO(dto)));

		Usuario usuario = UsuarioMappers.fromDTO(dto.getUsuario());
		usuario.setPerfil(perfilService.buscarPorId(1l));
		usuarioService.salvarusuario(usuario);

		return ResponseEntity.ok(entity);
	}

	@GetMapping("{id}")
	public ResponseEntity<ConsultaMedicoDTO> pesquisarMedico(@PathVariable Long id) {
		MedicoVeterinario medico = medicoService.buscarMedicoPorId(id);
		return ResponseEntity.ok(MedicoMappers.ftomEntity(medico));
	}

	@PutMapping("{id}")
	public ResponseEntity<ConsultaMedicoDTO> alterarMedico(@RequestBody RegistrarMedicoDTO dto, @PathVariable Long id)
			throws IOException {
		MedicoVeterinario veterinario = medicoService.alterarMedicoCadastarado(MedicoMappers.fromDTO(dto), id);
		return ResponseEntity.ok(MedicoMappers.ftomEntity(veterinario));
	}

	@DeleteMapping("{id}")
	public ResponseEntity<ConsultaMedicoDTO> excluirMedico(@PathVariable Long id) {
		medicoService.excluirMedico(id);
		return ResponseEntity.ok().build();
	}

}
