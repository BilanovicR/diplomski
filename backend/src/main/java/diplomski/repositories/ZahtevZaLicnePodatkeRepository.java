package diplomski.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import diplomski.models.ZahtevZaLicnePodatke;

@Repository
public interface ZahtevZaLicnePodatkeRepository  extends JpaRepository <ZahtevZaLicnePodatke, Long> {

	Optional<ZahtevZaLicnePodatke> findByVrstaZahteva(String vrstaZahteva);
	
	Iterable<ZahtevZaLicnePodatke> findByKorisnikID(Long korisnikID);
	
	Optional<ZahtevZaLicnePodatke> findByPodnosilacZahteva(Long podnosilacZahtevaID);
	
	@Query("SELECT k FROM ZahtevZaLicnePodatke k WHERE k.korisnikID = ?1")
	Iterable<ZahtevZaLicnePodatke> findByKorisnickoIme(String korisnickoIme);
	
}




