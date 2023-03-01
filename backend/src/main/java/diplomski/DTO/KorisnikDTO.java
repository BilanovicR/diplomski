package diplomski.DTO;

import diplomski.models.Korisnik;

public class KorisnikDTO {
	
	private String email;
	private String ime;
	private String prezime;
	private String korisnickoIme;
		
	public String getEmail() {
		return email;
	}

	public String getIme() {
		return ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public KorisnikDTO(Korisnik k) {
		this.email = k.getEmail();
		this.ime = k.getIme();
		this.prezime = k.getPrezime();
		this.korisnickoIme = k.getKorisnickoIme();
	}	

}
