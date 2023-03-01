package diplomski.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonView;

import diplomski.utils.View.ShowStudent;

import javax.persistence.FetchType;

@Entity
public class StudentSrednjaSkola {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(length=128, nullable = false)
	private String naziv;
	
	@Column(length=128, nullable = false)
	private String vrstaSkole;

	@Column(length=128, nullable = false)
	private String opstina;

	@Column(length=128, nullable = false)
	private String grad;
	
	@Column(length=128, nullable = false)
	private String drzava;
	
	@Column(length=128, nullable = false)
	private String godinaZavrsetka;
	
	@JsonView(ShowStudent.class)
	@OneToOne(fetch = FetchType.LAZY)
	private Student student;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getOpstina() {
		return opstina;
	}

	public void setOpstina(String opstina) {
		this.opstina = opstina;
	}

	public String getGrad() {
		return grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}

	public String getDrzava() {
		return drzava;
	}

	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}

	public String getGodinaZavrsetka() {
		return godinaZavrsetka;
	}

	public void setGodinaZavrsetka(String godinaZavrsetka) {
		this.godinaZavrsetka = godinaZavrsetka;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getVrstaSkole() {
		return vrstaSkole;
	}

	public void setVrstaSkole(String vrstaSkole) {
		this.vrstaSkole = vrstaSkole;
	}

	public StudentSrednjaSkola(Long id, String naziv, String opstina, String grad, String drzava,
			String godinaZavrsetka, Student student, String vrstaSkole) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.opstina = opstina;
		this.grad = grad;
		this.drzava = drzava;
		this.godinaZavrsetka = godinaZavrsetka;
		this.student = student;
		this.vrstaSkole = vrstaSkole;
	}

	public StudentSrednjaSkola() {
		super();
	}	

}
