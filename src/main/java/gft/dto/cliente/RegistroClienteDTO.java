package gft.dto.cliente;

import gft.dto.endereco.RegistrarEnderecoDTO;

public class RegistroClienteDTO {

	private String cpf;
	private String nome;
	private String telefone;
	private RegistrarEnderecoDTO endereco;
	private Long pets;

	public RegistroClienteDTO(String cpf, String nome, String telefone, RegistrarEnderecoDTO endereco, Long pets) {
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.pets = pets;
	}

	public RegistroClienteDTO() {
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public RegistrarEnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(RegistrarEnderecoDTO endereco) {
		this.endereco = endereco;
	}

	public Long getPets() {
		return pets;
	}

	public void setPets(Long pets) {
		this.pets = pets;
	}

	

}
