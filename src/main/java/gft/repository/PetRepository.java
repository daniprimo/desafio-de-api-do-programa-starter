package gft.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gft.entities.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

	Optional<Pet> findByNome(String nome);
	
	Optional<Pet> findByEspecie(String especia);

	
}
