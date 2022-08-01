package gft.security.dto;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import gft.security.controllers.form.AutentificacaoForm;
import gft.security.entities.Usuario;

public class UsuarioMappers {
	
	
	public static Usuario fromDTO (AutentificacaoForm dto) {
		return new Usuario(null, dto.getEmail(), new BCryptPasswordEncoder().encode(dto.getSenha()), null);
	}

}
