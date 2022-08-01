package gft.security.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import gft.exception.EntityNotFoundException;
import gft.security.entities.Perfil;
import gft.security.repository.PerfilRepository;

@Service
public class PerfilService {

	private final PerfilRepository perfilRepository;

	public PerfilService(PerfilRepository perfilRepository) {
		this.perfilRepository = perfilRepository;
	}

	public Perfil salvarPerfeil(Perfil perfil) {
		return perfilRepository.save(perfil);
	}

	public List<Perfil> listarOsPerfil() {
		return perfilRepository.findAll();
	}

	public Perfil buscarPorId(Long id) {
		Optional<Perfil> optional = perfilRepository.findById(id);
		return optional.orElseThrow(() -> new EntityNotFoundException("Não encontrado o perfil"));

	}

	public Perfil alterarPerfil(Perfil perfil, Long id) {
		Perfil original = buscarPorId(id);
		perfil.setId(original.getId());
		return perfilRepository.save(perfil);
	}

	public void excluirPorId(Long id) {
		Perfil perfil = buscarPorId(id);

		perfilRepository.delete(perfil);
	}

}
