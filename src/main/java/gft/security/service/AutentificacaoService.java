package gft.security.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;

import gft.security.controllers.form.AutentificacaoForm;
import gft.security.dto.TokenDTO;
import gft.security.entities.Usuario;

@Service
public class AutentificacaoService {


	private final AuthenticationManager manager;
	
	@Lazy
	public AutentificacaoService(AuthenticationManager manager) {
		this.manager = manager;
	}

	@Value("${desafioAPI.jwt.expiration}")
	private String expiration;
	@Value("${desafioAPI.jwt.secret}")
	private String secret;
	@Value("${desafioAPI.jwt.issuer}")
	private String issuer;

	public TokenDTO autenticar(AutentificacaoForm form) throws AuthenticationException {

		
		 Authentication authentication = manager.authenticate(new
		 UsernamePasswordAuthenticationToken(form.getEmail(), form.getSenha()));
		 String token = gerarToken(authentication);
		
		//token = new BCryptPasswordEncoder().encode("1234"); --> geracao de token
		
		return new TokenDTO(token);
	}

	private Algorithm criarAlgoritmo() {
		return Algorithm.HMAC256(secret);
	}

	private String gerarToken(Authentication authentication) {
		 Usuario principal = (Usuario) authentication.getPrincipal();
		Date hoje = new Date();
		Date dataExpiricacao = new Date(hoje.getTime() + Long.parseLong(expiration));

		return JWT.create().withIssuer(issuer).withExpiresAt(dataExpiricacao).withSubject(principal.getId().toString())
				.sign(this.criarAlgoritmo());
	}
	
	public boolean verificacaoToken (String token) {
		try {
			if (token == null)
				return false;

			JWT.require(this.criarAlgoritmo()).withIssuer(issuer).build().verify(token);
			return true;
		} catch (JWTVerificationException e) {
			return false;	
		}
	}
	
	public Long retornaIdDoUsuario (String token) {
		String string = JWT.require(this.criarAlgoritmo()).withIssuer(issuer).build().verify(token).getSubject();
		return Long.parseLong(string);
		
	}

}
