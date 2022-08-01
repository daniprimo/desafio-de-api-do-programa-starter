package gft.dto.medico;

import gft.entities.Endereco;

public class ConsultaMedicoDTO {

	private Long id;
	private String registroCRMV;
	private String nome;
	private Endereco endereco;

	public ConsultaMedicoDTO(Long id, String registroCRMV, String nome) {
		this.id = id;
		this.registroCRMV = registroCRMV;
		this.nome = nome;
	}

	public ConsultaMedicoDTO(Long id, String registroCRMV, String nome, Endereco endereco) {
		this.id = id;
		this.registroCRMV = registroCRMV;
		this.nome = nome;
		this.endereco = endereco;
	}

	public ConsultaMedicoDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

}
