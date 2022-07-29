package gft.dto.pet;

public class RegistrarPetDTO {

	private String nome;
	private String cor;
	private String especie;
	private String sexo;
	private String pelugem;
	private Long cliente;
	
	

	public RegistrarPetDTO(String nome, String cor, String especie, String sexo, String pelugem) {
		this.nome = nome;
		this.cor = cor;
		this.especie = especie;
		this.sexo = sexo;
		this.pelugem = pelugem;
	}

	public RegistrarPetDTO(String nome, String cor, String especie, String sexo, String pelugem, Long cliente) {
		this.nome = nome;
		this.cor = cor;
		this.especie = especie;
		this.sexo = sexo;
		this.pelugem = pelugem;
		this.cliente = cliente;
	}

	public RegistrarPetDTO() {
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

	public Long getCliente() {
		return cliente;
	}

	public void setCliente(Long cliente) {
		this.cliente = cliente;
	}

}
