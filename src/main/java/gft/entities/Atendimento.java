package gft.entities;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import gft.utils.DataUtils;

@Entity
@Table(name = "tb_atendimento")
public class Atendimento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "pet_id")
	private Pet pet;
	private String peso;
	@ManyToOne
	@JoinColumn(name = "veterinario_id")
	private MedicoVeterinario veterinario;
	@JoinColumn(name = "data_do_Atendimento")
	@JsonIgnore
	private Date data;
	private Date hora;
	
	public Atendimento(Long id, String peso, Date data,
			Date hora) {
		this.id = id;
		this.peso = peso;
		this.data= data;
		this.hora = hora;
	}

	public Atendimento(Long id, Pet pet, String peso, MedicoVeterinario veterinario) {
		this.id = id;
		this.pet = pet;
		this.peso = peso;
		this.veterinario = veterinario;
		this.data = DataUtils.obterData(LocalDateTime.now().getDayOfYear(),
				LocalDateTime.now().getMonthValue(), LocalDateTime.now().getYear());
		this.hora = Calendar.getInstance().getTime();
	}
	
	public Atendimento(Long id, String peso) {
		this.id = id;
		this.peso = peso;
		this.data = DataUtils.obterData(LocalDateTime.now().getDayOfYear(),
				LocalDateTime.now().getMonthValue(), LocalDateTime.now().getYear());
		this.hora = Calendar.getInstance().getTime();
	}

	public Atendimento() {
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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

}
