package gft.dto.pet;

import gft.entities.Cliente;

public class ConsultaPetDTO {

	private Long id;
	private String nome;
	private String cor;
	private String especie;
	private String sexo;
	private String pelugem;
	private Cliente cliente;

	public ConsultaPetDTO(Long id, String nome, String cor, String especie, String sexo, String pelugem,
			Cliente cliente) {
		this.id = id;
		this.nome = nome;
		this.cor = cor;
		this.especie = especie;
		this.sexo = sexo;
		this.pelugem = pelugem;
		this.cliente = cliente;
	}

	public ConsultaPetDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getPelugem() {
		return pelugem;
	}

	public void setPelugem(String pelugem) {
		this.pelugem = pelugem;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
