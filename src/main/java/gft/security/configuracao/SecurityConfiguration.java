package gft.security.configuracao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import gft.security.filtroDeRequisicoes.FiltroDeAutenticacao;
import gft.security.service.AutentificacaoService;
import gft.security.service.UsuarioService;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private UsuarioService usuarioService;
	private AutentificacaoService autentificacaoService;

	public SecurityConfiguration(UsuarioService usuarioService, AutentificacaoService autentificacaoService) {
		this.usuarioService = usuarioService;
		this.autentificacaoService = autentificacaoService;
	}

	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usuarioService).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		super.configure(web);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// http.csrf().disable().authorizeHttpRequests().anyRequest().permitAll();

		http.authorizeRequests().antMatchers(HttpMethod.POST, "/v1/auth").permitAll().anyRequest().authenticated().and()
				.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.addFilterBefore(new FiltroDeAutenticacao(autentificacaoService, usuarioService),
						UsernamePasswordAuthenticationFilter.class);
 
	}

}
