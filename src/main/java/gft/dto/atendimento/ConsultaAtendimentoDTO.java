package gft.dto.atendimento;

import java.util.Date;

import gft.entities.MedicoVeterinario;
import gft.entities.Pet;

public class ConsultaAtendimentoDTO {

	private Long id;
	private Pet pet;
	private String peso;
	private MedicoVeterinario veterinario;
	private Date dataDoAtendimento;
	private Date hora;

	public ConsultaAtendimentoDTO(Long id, Pet pet, String peso, MedicoVeterinario veterinario, Date dataDoAtendimento,
			Date hora) {
		this.id = id;
		this.pet = pet;
		this.peso = peso;
		this.veterinario = veterinario;
		this.dataDoAtendimento = dataDoAtendimento;
		this.hora = hora;
	}

	public ConsultaAtendimentoDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public MedicoVeterinario getVeterinario() {
		return veterinario;
	}

	public void setVeterinario(MedicoVeterinario veterinario) {
		this.veterinario = veterinario;
	}

	public Date getDataDoAtendimento() {
		return dataDoAtendimento;
	}

	public void setDataDoAtendimento(Date dataDoAtendimento) {
		this.dataDoAtendimento = dataDoAtendimento;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

}
