package gft.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gft.security.entities.Perfil;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {

}
