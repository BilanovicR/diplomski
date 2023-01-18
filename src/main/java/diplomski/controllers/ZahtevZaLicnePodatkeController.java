package diplomski.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import diplomski.models.ZahtevZaLicnePodatke;
import diplomski.services.ZahtevZaLicnePodatkeServis;

@RestController
@RequestMapping("/zahtevi")
public class ZahtevZaLicnePodatkeController {
	
	@Autowired
	ZahtevZaLicnePodatkeServis servisZaZahteve;
	
    @RequestMapping(value="/svi", method=RequestMethod.GET)
    @PreAuthorize("hasAnyAuthority('administrator')")
    public ResponseEntity<Iterable<ZahtevZaLicnePodatke>> getZahteve() {
        return new ResponseEntity<Iterable<ZahtevZaLicnePodatke>>(servisZaZahteve.getZahtevi(), HttpStatus.OK);
    }
    
    @RequestMapping(value="/svi/korisnik/{korisnikId}", method=RequestMethod.GET)
    @PreAuthorize("hasAnyAuthority('administrator', 'student', 'profesor')")
    public ResponseEntity<Iterable<ZahtevZaLicnePodatke>> getZahteviByKorisnikID(@PathVariable Long korisnikId) {
    	//mozda ubaciti proveru da korisnik moze samo svoje zahteve da pregleda bez pristupa ostalima, u backendu, osim administratora
    	Iterable<ZahtevZaLicnePodatke> zahtevi = servisZaZahteve.getZahteviByKorisnik(korisnikId);
        return new ResponseEntity<Iterable<ZahtevZaLicnePodatke>>(zahtevi, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('administrator', 'student', 'profesor')")
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<ZahtevZaLicnePodatke> getZahtevById(@PathVariable Long id) {
        Optional<ZahtevZaLicnePodatke> zahtev = servisZaZahteve.getZahtevById(id);
        if(zahtev.isPresent()) {
            return new ResponseEntity<ZahtevZaLicnePodatke>(zahtev.get(), HttpStatus.OK);
        }
        return new ResponseEntity<ZahtevZaLicnePodatke>(HttpStatus.NOT_FOUND);
    }

    @PreAuthorize("hasAnyAuthority('administrator', 'student', 'profesor')")
    @RequestMapping(value="/add", method=RequestMethod.POST)
    public ResponseEntity<ZahtevZaLicnePodatke> addPost(@RequestBody ZahtevZaLicnePodatke zahtev) {
        servisZaZahteve.addZahtev(zahtev);
        return new ResponseEntity<ZahtevZaLicnePodatke>(zahtev, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyAuthority('administrator', 'student', 'profesor')")
    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<ZahtevZaLicnePodatke> updatePost(@PathVariable Long id, @RequestBody ZahtevZaLicnePodatke zahtev) {
    	servisZaZahteve.updateZahtev(id, zahtev);
        return new ResponseEntity<ZahtevZaLicnePodatke>(zahtev, HttpStatus.CREATED);
    }
	

}
