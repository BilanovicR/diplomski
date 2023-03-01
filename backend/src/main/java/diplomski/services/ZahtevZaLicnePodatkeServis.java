package diplomski.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import diplomski.models.ZahtevZaLicnePodatke;
import diplomski.repositories.ZahtevZaLicnePodatkeRepository;

@Service
public class ZahtevZaLicnePodatkeServis {
	
	@Autowired
    private ZahtevZaLicnePodatkeRepository zahtevRepo;

    public ZahtevZaLicnePodatkeServis() {
    }

    public Iterable<ZahtevZaLicnePodatke> getZahtevi() {
        return zahtevRepo.findAll();
    }

    public Optional<ZahtevZaLicnePodatke> getZahtevById(Long id) {
        return zahtevRepo.findById(id);
    }
    
    public Iterable<ZahtevZaLicnePodatke> getZahteviByKorisnik(Long korisnikId) {
        return zahtevRepo.findByKorisnikID(korisnikId);
    }
    
    public Iterable<ZahtevZaLicnePodatke> getZahteviByKorisnickoIme(String korisnickoIme) {
        return zahtevRepo.findByKorisnickoIme(korisnickoIme);
    }

    public void addZahtev(ZahtevZaLicnePodatke zahtev) {
    	zahtevRepo.save(zahtev);
    }

    public ZahtevZaLicnePodatke updateZahtev(Long id, ZahtevZaLicnePodatke zahtev) {
        Optional<ZahtevZaLicnePodatke> pronadjenZahtev = zahtevRepo.findById(id);
        if(pronadjenZahtev.isPresent()) {
            zahtev.setId(pronadjenZahtev.get().getId());
            zahtev.setDatumPodnosenjaZahteva(pronadjenZahtev.get().getDatumPodnosenjaZahteva());
            zahtev.setKorisnikID(pronadjenZahtev.get().getKorisnikID());
            zahtev.setPodnosilacZahteva(pronadjenZahtev.get().getPodnosilacZahteva());
            zahtev.setVrstaZahteva(pronadjenZahtev.get().getVrstaZahteva());
            return zahtevRepo.save(zahtev);
        }
        return zahtev;
    }

}
