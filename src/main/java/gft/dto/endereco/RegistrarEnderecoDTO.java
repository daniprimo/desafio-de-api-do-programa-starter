package gft.dto.endereco;

public class RegistrarEnderecoDTO {

	private String cep;
	private String logradouro;
	private Integer numero;
	private String complemento;

	public RegistrarEnderecoDTO(String cep, String logradouro, Integer numero, String complemento) {
		this.cep = cep;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
	}

	public RegistrarEnderecoDTO(String logradouro, Integer numero, String complemento) {
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
	}

	public RegistrarEnderecoDTO() {
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

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

}
