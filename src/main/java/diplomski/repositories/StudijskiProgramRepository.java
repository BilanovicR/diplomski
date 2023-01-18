package diplomski.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import diplomski.models.StudijskiProgram;

@Repository
public interface StudijskiProgramRepository extends JpaRepository <StudijskiProgram, Long>{

	Optional<StudijskiProgram> findByNaziv(String nazivPrograma);
	
	@Query("SELECT sp FROM StudijskiProgram sp WHERE sp.fakultet.id = ?1")
	Iterable<StudijskiProgram> findByFakultetID(Long fakultetID);
}
