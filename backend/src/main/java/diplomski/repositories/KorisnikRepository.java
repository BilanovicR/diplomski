package diplomski.repositories;

import diplomski.models.Korisnik;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {
	
	@Query("SELECT k FROM Korisnik k WHERE k.student.brojIndeksa = ?1")
	Optional<Korisnik> findKorisnikByBrojIndeksa(String brojIndeksa);
	
	Optional<Korisnik> findByKorisnickoIme(String korisnickoIme);
	
	Optional<Korisnik> findById(Long id);
	
	Optional<Korisnik> findByEmail(String email);

}
