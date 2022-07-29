package gft.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import gft.entities.Pet;
import gft.exception.EntityNotFoundException;
import gft.repository.PetRepository;

@Service
public class PetService {

	private PetRepository petRepository;

	public PetService(PetRepository petRepository) {
		this.petRepository = petRepository;
	}

	public List<Pet> listarPets() {
		return petRepository.findAll();
	}

	public Pet adicionarPet(Pet pet) {
		return petRepository.save(pet);
	}

	public Pet pesquisarPorId(Long id) {
		Optional<Pet> optional = petRepository.findById(id);
		return optional.orElseThrow(() -> new EntityNotFoundException("Pet não encontrado"));
	}

	public Pet pesquisarPorEspecie(String especie) {
		Optional<Pet> optional = petRepository.findByEspecie(especie);
		return optional.orElseThrow(() -> new EntityNotFoundException("Pet não encontrado"));
	}

	public Pet alterarPorId(Pet pet, Long id) {
		Pet petOriginal = pesquisarPorId(id);
		pet.setId(petOriginal.getId());
		return petRepository.save(pet);
	}

	public void deletarPetPorId(Long id) {
		Pet pet = pesquisarPorId(id);

		petRepository.delete(pet);
	}

	public Pet listaDosPetsParaClientes(Long ids) {
			Optional<Pet> optional = petRepository.findById(ids);
		return optional.orElseThrow(() -> new EntityNotFoundException("Pet não encontrdo"));

	}

}
