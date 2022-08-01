package gft.dto.cliente;

import gft.dto.endereco.RegistrarEnderecoDTO;
import gft.security.controllers.form.AutentificacaoForm;

public class RegistroClienteDTO {

	private String cpf;
	private String nome;
	private String telefone;
	private RegistrarEnderecoDTO endereco;
	private Long pets;
	private AutentificacaoForm form;

	public RegistroClienteDTO(String cpf, String nome, String telefone, RegistrarEnderecoDTO endereco, Long pets,
			AutentificacaoForm form) {
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.pets = pets;
		this.form = form;
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

	public AutentificacaoForm getForm() {
		return form;
	}

	public void setForm(AutentificacaoForm form) {
		this.form = form;
	}

}
