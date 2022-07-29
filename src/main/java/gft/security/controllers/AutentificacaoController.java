package gft.security.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gft.security.controllers.form.AutentificacaoForm;
import gft.security.dto.TokenDTO;
import gft.security.service.AutentificacaoService;

@RestController
@RequestMapping("v1/auth")
public class AutentificacaoController {

	private final AutentificacaoService autentificacaoService;

	public AutentificacaoController(AutentificacaoService autentificacaoService) {
		this.autentificacaoService = autentificacaoService;
	}

	@PostMapping
	public ResponseEntity<TokenDTO> autenticar(@RequestBody AutentificacaoForm form) {

		try {
			
			return ResponseEntity.ok(autentificacaoService.autenticar(form));

		} catch (AuthenticationException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}

	}

}
