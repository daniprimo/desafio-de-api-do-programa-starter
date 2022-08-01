package gft.dto.medico;

import java.io.IOException;

import gft.dto.endereco.EnderecoMappers;
import gft.entities.MedicoVeterinario;

public class MedicoMappers {

	public static MedicoVeterinario fromDTO(RegistrarMedicoDTO dto) throws IOException {
		return new MedicoVeterinario(null, dto.getRegistroCRMV(), dto.getNome(),
				EnderecoMappers.fromDTO(dto.getEndereco()));
	}

	public static ConsultaMedicoDTO ftomEntity(MedicoVeterinario medicoVeterinario) {
		return new ConsultaMedicoDTO(medicoVeterinario.getId(), medicoVeterinario.getRegistroCRMV(),
				medicoVeterinario.getNome(),medicoVeterinario.getEndereco());
	}

}