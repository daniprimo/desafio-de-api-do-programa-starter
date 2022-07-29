package gft.dto.ConsumindoAPI.consumindoTheDog.entities;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class Raca {

	private String id;
	private String name;
	private String temperament;

	public Raca() {
	}

	public Raca(String id, String name, String temperament) {
		this.id = id;
		this.name = name;
		this.temperament = temperament;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTemperament() {
		return temperament;
	}

	public void setTemperament(String temperament) {
		this.temperament = temperament;
	}

}
