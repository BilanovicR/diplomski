package diplomski.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import diplomski.models.Korisnik;
import diplomski.models.Rola;
import diplomski.models.Student;
import diplomski.repositories.KorisnikRepository;
import diplomski.repositories.RolaRepository;

@Service
public class KorisnikServis {
	
	@Autowired
    private KorisnikRepository korisnikRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
    private RolaRepository rolaRepo;
	
    public KorisnikServis() {
    }

    public Iterable<Korisnik> getKorisnik() {
        return korisnikRepo.findAll();
    }

    public Optional<Korisnik> getKorisnikById(Long id) {
        return korisnikRepo.findById(id);
    }
    
    public Optional<Korisnik> getKorisnikByKorisnickoIme(String korisnickoIme) {
        return korisnikRepo.findByKorisnickoIme(korisnickoIme);
    }

    public void addKorisnik(Korisnik korisnik) {
        korisnikRepo.save(korisnik);
    }

    public void removeKorisnik(String brojIndeksa) {
        Optional<Korisnik> korisnik = korisnikRepo.findKorisnikByBrojIndeksa(brojIndeksa);
        if(korisnik.isPresent()) {
        	korisnikRepo.delete(korisnik.get());
        }
    }

    public Korisnik updateKorisnik(String korisnickoIme, Korisnik korisnik) {
        Optional<Korisnik> pronadjenKorisnik = korisnikRepo.findByKorisnickoIme(korisnickoIme);
        if(pronadjenKorisnik.isPresent()) {
        	pronadjenKorisnik.get().setSifra(passwordEncoder.encode(korisnik.getSifra()));
            return korisnikRepo.save(pronadjenKorisnik.get());
        }
        return null;
    }
    
    public Korisnik addKorisnickiPodaci(Student student) {
		
		Korisnik noviKorisnik = new Korisnik();
		noviKorisnik.setEmail(student.getEmail());
		noviKorisnik.setIme(student.getIme());
		noviKorisnik.setPrezime(student.getPrezime());
		noviKorisnik.setKorisnickoIme(student.getBrojIndeksa());
		noviKorisnik.setSifra(passwordEncoder.encode(student.getBrojIndeksa()));
		noviKorisnik.setStatus("aktivan");
		Optional<Rola> studentskaRola = rolaRepo.getByNaziv("student");
		if (studentskaRola.isEmpty()) {
			return null;			
		}
		noviKorisnik.setRolaID(studentskaRola.get().getId());
		noviKorisnik.setStudent(student);
		korisnikRepo.save(noviKorisnik);
		
		return noviKorisnik;
	}

}
