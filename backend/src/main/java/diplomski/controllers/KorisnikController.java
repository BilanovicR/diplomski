package diplomski.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import diplomski.DTO.KorisnikDTO;
import diplomski.models.Korisnik;
import diplomski.services.KorisnikServis;
import diplomski.utils.View.HideOptionalProperties;

@RestController
@RequestMapping("/korisnik")
@CrossOrigin(origins={"http://localhost:4200"})
public class KorisnikController {
	
	@Autowired
	KorisnikServis korServis;
	
	@PreAuthorize("hasAnyAuthority('administrator', 'profesor', 'student')")
    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/{korisnickoIme}", method=RequestMethod.GET)
    public ResponseEntity<KorisnikDTO> getKorisnikById(@PathVariable String korisnickoIme) {
    	Optional<Korisnik> korisnik = korServis.getKorisnikByKorisnickoIme(korisnickoIme);
    	if (korisnik.isPresent()) {
    		return new ResponseEntity<KorisnikDTO>(new KorisnikDTO(korisnik.get()), HttpStatus.OK);
    	}    	
        return new ResponseEntity<KorisnikDTO>(HttpStatus.NOT_FOUND);
    }
	
	@JsonView(HideOptionalProperties.class)
	@PreAuthorize("hasAnyAuthority('administrator', 'profesor', 'student')")
    @RequestMapping(value="/izmeni/{korisnickoIme}", method=RequestMethod.PUT)
    public ResponseEntity<String> izmeniSifruKorisnika(@PathVariable String korisnickoIme, @RequestBody Korisnik korisnik) {
		Korisnik izmenjenKorisnik = korServis.updateKorisnik(korisnickoIme, korisnik);
		if(izmenjenKorisnik != null) {
			return new ResponseEntity<String>(HttpStatus.OK);
		}
    	return new ResponseEntity<String>(HttpStatus.METHOD_NOT_ALLOWED);  
    }

}
