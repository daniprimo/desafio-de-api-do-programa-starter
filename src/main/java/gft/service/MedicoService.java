package gft.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import gft.entities.MedicoVeterinario;
import gft.exception.EntityNotFoundException;
import gft.repository.MedicoRepository;

@Service
public class MedicoService {

	private MedicoRepository medicoRepository;

	public MedicoService(MedicoRepository medicoRepository) {
		this.medicoRepository = medicoRepository;
	}

	public List<MedicoVeterinario> listarMedicos() {
		return medicoRepository.findAll();
	}

	public MedicoVeterinario salvarMedico(MedicoVeterinario medicoVeterinario) {
		return medicoRepository.save(medicoVeterinario);
	}

	public MedicoVeterinario buscarMedicoPorId(Long id) {
		Optional<MedicoVeterinario> optional = medicoRepository.findById(id);
		return optional.orElseThrow(() -> new EntityNotFoundException("Medico não encontrado"));
	}

	public MedicoVeterinario alterarMedicoCadastarado(MedicoVeterinario medicoVeterinario, Long id) {
		MedicoVeterinario original = buscarMedicoPorId(id);
		medicoVeterinario.setId(original.getId());
		return medicoRepository.save(medicoVeterinario);
	}

	public void excluirMedico(Long id) {
		MedicoVeterinario veterinario = buscarMedicoPorId(id);

		medicoRepository.delete(veterinario);
	}

}
