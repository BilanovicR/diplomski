package diplomski.controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import diplomski.models.Korisnik;
import diplomski.services.LoginService;

@Controller
@RequestMapping("/login")
@CrossOrigin(origins={"http://localhost:4200"})
public class LoginController {
	
	@Autowired
	LoginService ls;
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<HashMap<String, String>> login(@RequestBody Korisnik korisnik) {		
		return ls.login(korisnik);
	}

}
