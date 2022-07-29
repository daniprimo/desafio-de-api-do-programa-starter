package gft.dto.medico;

import gft.entities.MedicoVeterinario;

public class MedicoMappers {
	
	public static MedicoVeterinario fromDTO (RegistrarMedicoDTO dto) {
		return new MedicoVeterinario(null, dto.getRegistroCRMV(), dto.getNome(),dto.getEndereco());
	}
	
	public static ConsultaMedicoDTO ftomEntity (MedicoVeterinario medicoVeterinario) {
			return new ConsultaMedicoDTO(medicoVeterinario.getId(), medicoVeterinario.getRegistroCRMV(),
					medicoVeterinario.getNome());
	}
	
	
	

}