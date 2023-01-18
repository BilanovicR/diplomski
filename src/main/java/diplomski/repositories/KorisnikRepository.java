package diplomski.repositories;

import diplomski.models.Korisnik;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {
	
	Optional<Korisnik> findByKorisnickoIme(String korisnickoIme);
	
	Optional<Korisnik> findByEmail(String email);

}
