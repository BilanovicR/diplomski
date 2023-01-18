package diplomski.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonView;

import diplomski.utils.View.ShowStudent;

@Entity
public class Korisnik {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(length=128, nullable = false)
	private String korisnickoIme;

	@Column(length=128, nullable = false)
	private String sifra;

	@Column(length=128, nullable = false)
	private String email;
	
	@Column(length=128, nullable = false)
	private String ime;
	
	@Column(length=128, nullable = false)
	private String prezime;

	@Column(length=128, nullable = false)
	private Long rolaID;
	
	@Column(length=128, nullable = false)
	private String status; // aktivan/deaktiviran
	
	@JsonView(ShowStudent.class)
	@OneToOne(fetch = FetchType.LAZY)
	Student student;	
	
	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public Long getRolaID() {
		return rolaID;
	}

	public void setRolaID(Long rolaID) {
		this.rolaID = rolaID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Korisnik() {}

	public Korisnik(Long id, String korisnickoIme, String sifra, String email, String ime, String prezime,
			Long rolaID, Student student, String status) {
		super();
		this.id = id;
		this.korisnickoIme = korisnickoIme;
		this.sifra = sifra;
		this.email = email;
		this.ime = ime;
		this.prezime = prezime;
		this.rolaID = rolaID;
		this.student = student;
		this.status = status;
	}

	public Long getId(){
		return id;
	}

	public void setId(Long id){
		this.id = id;
	}
	
	public String getKorisnickoIme(){
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme){
		this.korisnickoIme = korisnickoIme;
	}
	
	public String getSifra(){
		return sifra;
	}

	public void setSifra(String sifra){
		this.sifra = sifra;
	}
	
	public String getEmail(){
		return email;
	}

	public void setEmail(String email){
		this.email = email;
	}

}