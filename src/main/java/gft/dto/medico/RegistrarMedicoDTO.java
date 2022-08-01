package gft.dto.medico;

import gft.dto.endereco.RegistrarEnderecoDTO;
import gft.security.controllers.form.AutentificacaoForm;

public class RegistrarMedicoDTO {

	private String registroCRMV;
	private String nome;
	private RegistrarEnderecoDTO endereco;
	private AutentificacaoForm usuario;

	public RegistrarMedicoDTO() {
	}

	public RegistrarMedicoDTO(String registroCRMV, String nome, RegistrarEnderecoDTO endereco,
			AutentificacaoForm usuario) {
		this.registroCRMV = registroCRMV;
		this.nome = nome;
		this.endereco = endereco;
		this.usuario = usuario;
	}

	public String getRegistroCRMV() {
		return registroCRMV;
	}

	public void setRegistroCRMV(String registroCRMV) {
		this.registroCRMV = registroCRMV;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public RegistrarEnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(RegistrarEnderecoDTO endereco) {
		this.endereco = endereco;
	}

	public AutentificacaoForm getUsuario() {
		return usuario;
	}

	public void setUsuario(AutentificacaoForm usuario) {
		this.usuario = usuario;
	}

}
