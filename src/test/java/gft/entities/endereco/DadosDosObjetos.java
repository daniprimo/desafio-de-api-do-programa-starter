package gft.entities.endereco;

public enum DadosDosObjetos {

	CEP("06382820"),
	LOGRADOUR("Rua Ipixuna"),
	NUMERO(141),
	COMPLEMENTO("AB");
	
	private String descricao;
	private Integer numero;
	
	

	private DadosDosObjetos(Integer numero) {
		this.numero = numero;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	private DadosDosObjetos(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
	
	
}
