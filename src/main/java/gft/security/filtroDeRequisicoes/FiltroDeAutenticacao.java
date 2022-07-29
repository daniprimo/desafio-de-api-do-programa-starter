package gft.security.filtroDeRequisicoes;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import gft.security.entities.Usuario;
import gft.security.service.AutentificacaoService;
import gft.security.service.UsuarioService;

public class FiltroDeAutenticacao extends OncePerRequestFilter {

	
	private final AutentificacaoService autentificacaoService;
	private final UsuarioService usuarioService;

	public FiltroDeAutenticacao(AutentificacaoService autentificacaoService, UsuarioService usuarioService) {
		this.autentificacaoService = autentificacaoService;
		this.usuarioService = usuarioService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String header = request.getHeader("Authorization");
		String token = null;
		if (header != null && header.startsWith("Bearer ")) {
			token = header.substring(7, header.length());
		}

		if (autentificacaoService.verificacaoToken(token)) {
			Long idDoUsuario = autentificacaoService.retornaIdDoUsuario(token);
			Usuario usuario = usuarioService.buscarUsuarioPorId(idDoUsuario);
			SecurityContextHolder.getContext().setAuthentication(
					new UsernamePasswordAuthenticationToken(usuario,null, usuario.getAuthorities()));
			
		}

		filterChain.doFilter(request, response);

	}

}
