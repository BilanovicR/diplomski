package diplomski.services;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import diplomski.models.Korisnik;
import diplomski.repositories.KorisnikRepository;
import diplomski.repositories.RolaRepository;
import diplomski.utils.TokenUtils;

@Service
public class LoginService {
	@Autowired
	KorisnikServis korisnickiServis;

	@Autowired
	KorisnikRepository korisnickiRepo;

	@Autowired
	RolaRepository rolaRepo;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private TokenUtils tokenUtils;
	
	public ResponseEntity<HashMap<String, String>> login(Korisnik korisnik) {
		try {

			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(korisnik.getKorisnickoIme(),
					korisnik.getSifra());

			Authentication authentication = authenticationManager.authenticate(token);
			SecurityContextHolder.getContext().setAuthentication(authentication);
			
			UserDetails details = userDetailsService.loadUserByUsername(korisnik.getKorisnickoIme());

			String userToken = tokenUtils.generateToken(details);
			
			HashMap<String, String> data = new HashMap<String, String>();
			data.put("token", userToken);
			
			return new ResponseEntity<HashMap<String, String>>(data, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<HashMap<String, String>>(HttpStatus.UNAUTHORIZED);
		}
	}
	
}
