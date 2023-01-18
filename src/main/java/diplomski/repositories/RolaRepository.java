package diplomski.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import diplomski.models.Rola;

@Repository
public interface RolaRepository extends JpaRepository <Rola, Long> {
	
	Optional<Rola> getByNaziv(String string);

}
