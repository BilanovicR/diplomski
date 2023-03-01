export class Korisnik {
    id :String;
	korisnickoIme:String;
	sifra:String;
	email:String;

	constructor(korisnickoIme : String){
		this.korisnickoIme = korisnickoIme;
		this.sifra = null;
		this.email = null;
	}

}