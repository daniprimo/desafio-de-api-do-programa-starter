package gft.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_pet")
public class Pet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cor;
	private String especie;
	private String sexo;
	private String pelugem;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	public Pet(Long id, String nome, String cor, String especie, String sexo, String pelugem, Cliente cliente) {
		this.id = id;
		this.nome = nome;
		this.cor = cor;
		this.especie = especie;
		this.sexo = sexo;
		this.pelugem = pelugem;
		this.cliente = cliente;
	}

	public Pet(Long id, String nome, String cor, String especie, String sexo, String pelugem) {
		this.id = id;
		this.nome = nome;
		this.cor = cor;
		this.especie = especie;
		this.sexo = sexo;
		this.pelugem = pelugem;
	}

	public Pet() {
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
