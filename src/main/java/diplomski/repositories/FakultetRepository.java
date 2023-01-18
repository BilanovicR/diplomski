package diplomski.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import diplomski.models.Fakultet;

@Repository
public interface FakultetRepository extends JpaRepository <Fakultet, Long>{
	
	Optional<Fakultet> findByNaziv(String nazivFakulteta);
	
	Optional<Fakultet> findById(Long id);
}
