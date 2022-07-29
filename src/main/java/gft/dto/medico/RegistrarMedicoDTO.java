package gft.dto.medico;

import gft.entities.Endereco;

public class RegistrarMedicoDTO {

	private String registroCRMV;
	private String nome;
	private String logradouro;
	private String cep;
	private Endereco endereco;

	public RegistrarMedicoDTO() {
	}

	public RegistrarMedicoDTO(String registroCRMV, String nome, String logradouro, String cep, Endereco endereco) {
		this.registroCRMV = registroCRMV;
		this.nome = nome;
		this.logradouro = logradouro;
		this.cep = cep;
		this.endereco = endereco;
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

}
