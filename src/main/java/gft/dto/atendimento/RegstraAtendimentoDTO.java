package gft.dto.atendimento;

public class RegstraAtendimentoDTO {

	private Long pet;
	private String peso;
	private Long veterinario;

	public RegstraAtendimentoDTO(Long pet, String peso, Long veterinario) {
		this.pet = pet;
		this.peso = peso;
		this.veterinario = veterinario;
	}

	public RegstraAtendimentoDTO() {
	}

	public Long getPet() {
		return pet;
	}

	public void setPet(Long pet) {
		this.pet = pet;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public Long getVeterinario() {
		return veterinario;
	}

	public void setVeterinario(Long veterinario) {
		this.veterinario = veterinario;
	}

}
