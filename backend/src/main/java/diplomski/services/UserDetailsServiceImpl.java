package diplomski.services;


import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import diplomski.models.Korisnik;

import diplomski.models.Rola;
import diplomski.repositories.RolaRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	KorisnikServis korServis;
	
	@Autowired
	RolaRepository rolaRepo;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Korisnik> korisnik = korServis.getKorisnikByKorisnickoIme(username);
		if(korisnik.isPresent()) {
			ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
			Rola rola = rolaRepo.findById(korisnik.get().getRolaID()).get();
			grantedAuthorities.add(new SimpleGrantedAuthority(rola.getNaziv()));			
			return new org.springframework.security.core.userdetails.User(korisnik.get().getKorisnickoIme(), korisnik.get().getSifra(), grantedAuthorities);
		}		
		return null;
	}
}
