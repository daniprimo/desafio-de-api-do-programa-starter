package gft.dto.ConsumindoAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;

public class ViaCep {

	private String cep;
	private String logradouro;
	private String bairro;
	private String localidade;
	private String uf;
	private String ibge;
	private String ddd;

	public ViaCep(String cep) throws IOException {
		
		
		URL url = new URL("http://viacep.com.br/ws/"+cep+"/json/");
		URLConnection connection = url.openConnection(); 
		InputStream is = connection.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
			
		String string = "";
		StringBuilder jsonCep = new StringBuilder();
		
		while ((string = br.readLine()) !=  null) {
			
			jsonCep.append(string);
		}

		ViaCep enderecoAux = new Gson().fromJson(jsonCep.toString(), ViaCep.class);
		
		this.cep = enderecoAux.getCep();
		this.logradouro = enderecoAux.getLogradouro();
		this.bairro = enderecoAux.getBairro();
		this.localidade = enderecoAux.getLocalidade();
		this.uf = enderecoAux.getUf();
		this.ibge = enderecoAux.getIbge();
		this.ddd = enderecoAux.getDdd();
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

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
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

	public String getIbge() {
		return ibge;
	}

	public void setIbge(String ibge) {
		this.ibge = ibge;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

}
