package gft.dto.cliente;

import gft.entities.Endereco;
import gft.entities.Pet;

public class ConsultaClienteDTO {

	private Long id;
	private String cpf;
	private String nome;
	private String telefone;
	private Endereco endereco;
	private Pet pets;


	public ConsultaClienteDTO(Long id, String cpf, String nome, String telefone, Endereco endereco) {
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	public ConsultaClienteDTO(Long id, String cpf, String nome, String telefone, Endereco endereco, Pet pets) {
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.pets = (pets);
	}

	public ConsultaClienteDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Pet getPets() {
		return pets;
	}

	public void setPets(Pet pets) {
		this.pets = pets;
	}

	
}
