package gft.security.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import gft.security.entities.Usuario;
import gft.security.repository.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService {

	private final UsuarioRepository usuarioRepository;

	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public Usuario buscarUsuarioPorEmail(String email) {
		Optional<Usuario> optional = usuarioRepository.findByEmail(email);

		return optional.orElseThrow(() -> new UsernameNotFoundException("Usuario não enontrado"));
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return buscarUsuarioPorEmail(username);
	}

	public Usuario buscarUsuarioPorId(Long idDoUsuario) {

		return usuarioRepository.findById(idDoUsuario).orElseThrow(() -> new UsernameNotFoundException("Erro ao buscar nome"));
	}

}
