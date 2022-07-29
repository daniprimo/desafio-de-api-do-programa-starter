package gft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gft.entities.MedicoVeterinario;

@Repository
public interface MedicoRepository extends JpaRepository<MedicoVeterinario, Long> {

}
