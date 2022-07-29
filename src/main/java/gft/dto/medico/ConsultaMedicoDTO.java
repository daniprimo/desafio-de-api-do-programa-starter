package gft.dto.medico;

public class ConsultaMedicoDTO {

	private Long id;
	private String registroCRMV;
	private String nome;
	private String cep;
	private String logradouro;
	private String localidade;
	private String uf;
	private String complemento;

	public ConsultaMedicoDTO(Long id, String registroCRMV, String nome) {
		this.id = id;
		this.registroCRMV = registroCRMV;
		this.nome = nome;
	}

	public ConsultaMedicoDTO(Long id, String registroCRMV, String nome, String cep, String logradouro,
			String localidade, String uf, String complemento) {
		this.id = id;
		this.registroCRMV = registroCRMV;
		this.nome = nome;
		this.cep = cep;
		this.logradouro = logradouro;
		this.localidade = localidade;
		this.uf = uf;
		this.complemento = complemento;
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

}
