package gft.dto.pet;

import gft.entities.Pet;

public class PetMappersDTO {
	
	public static Pet fromDTO(RegistrarPetDTO dto) {
		return new Pet(null, dto.getNome(), dto.getCor(), dto.getSexo(), dto.getSexo(), dto.getPelugem());
	}

	public static ConsultaPetDTO fromEntity(Pet pet) {
		return new ConsultaPetDTO(pet.getId(), pet.getNome(), pet.getCor(), pet.getEspecie(), pet.getSexo(),
				pet.getPelugem(), pet.getCliente());
	}
	
	
	

}
