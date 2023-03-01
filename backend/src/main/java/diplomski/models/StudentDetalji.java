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
public class StudentDetalji {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=128, nullable = false)
	private String mestoStanovanja;
	
	@Column(length=128, nullable = false)
	private String tipSmestaja;
	
	@Column(length=128, nullable = false)
	private String izvorSredstava;
	
	@Column(length=128, nullable = false)
	private String glavniIzvorSredstava;
	
	@Column(columnDefinition = "boolean default false")
	private Boolean jeZaposlen;
	
	@Column(length=128, nullable = false)
	private String izdrzavaDrugaLica;
	
	@Column(columnDefinition = "boolean default false")
	private Boolean izdrzavalacJeZaposlen;
	
	@Column(length=128, nullable = false)
	private String zanimanjeIzdrzavaoca;
	
	@Column(length=128, nullable = false)
	private String skolskaSpremaOca;
	
	@Column(length=128, nullable = false)
	private String skolskaSpremaMajke;
	
	@Column(length=128, nullable = false)
	private String potrebanVidPodrske;
	
	@Column(length=128, nullable = false)
	private String nacinFinansiranja;
	
	@Column(columnDefinition = "boolean default false")
	private Boolean istaVrstaStudijaNaDrugomFakultetu;
	
	@Column(length=128)
	private String drugiFakultet;
	
	@Column(length=128)
	private String godinaZavrsetkaDrugogFakulteta;
	
	@Column(length=128)
	private String drzavaZavrsetkaDrugogFakulteta;
	
	@JsonView(ShowStudent.class)
	@OneToOne(fetch = FetchType.LAZY)
	private Student student;

	public String getMestoStanovanja() {
		return mestoStanovanja;
	}

	public void setMestoStanovanja(String mestoStanovanja) {
		this.mestoStanovanja = mestoStanovanja;
	}

	public String getTipSmestaja() {
		return tipSmestaja;
	}

	public void setTipSmestaja(String tipSmestaja) {
		this.tipSmestaja = tipSmestaja;
	}

	public String getIzvorSredstava() {
		return izvorSredstava;
	}

	public void setIzvorSredstava(String izvorSredstava) {
		this.izvorSredstava = izvorSredstava;
	}

	public String getGlavniIzvorSredstava() {
		return glavniIzvorSredstava;
	}

	public void setGlavniIzvorSredstava(String glavniIzvorSredstava) {
		this.glavniIzvorSredstava = glavniIzvorSredstava;
	}

	public Boolean getJeZaposlen() {
		return jeZaposlen;
	}

	public void setJeZaposlen(Boolean jeZaposlen) {
		this.jeZaposlen = jeZaposlen;
	}

	public String getIzdrzavaDrugaLica() {
		return izdrzavaDrugaLica;
	}

	public void setIzdrzavaDrugaLica(String izdrzavaDrugaLica) {
		this.izdrzavaDrugaLica = izdrzavaDrugaLica;
	}

	public Boolean getIzdrzavalacJeZaposlen() {
		return izdrzavalacJeZaposlen;
	}

	public void setIzdrzavalacJeZaposlen(Boolean izdrzavalacJeZaposlen) {
		this.izdrzavalacJeZaposlen = izdrzavalacJeZaposlen;
	}

	public String getZanimanjeIzdrzavaoca() {
		return zanimanjeIzdrzavaoca;
	}

	public void setZanimanjeIzdrzavaoca(String zanimanjeIzdrzavaoca) {
		this.zanimanjeIzdrzavaoca = zanimanjeIzdrzavaoca;
	}

	public String getSkolskaSpremaOca() {
		return skolskaSpremaOca;
	}

	public void setSkolskaSpremaOca(String skolskaSpremaOca) {
		this.skolskaSpremaOca = skolskaSpremaOca;
	}

	public String getSkolskaSpremaMajke() {
		return skolskaSpremaMajke;
	}

	public void setSkolskaSpremaMajke(String skolskaSpremaMajke) {
		this.skolskaSpremaMajke = skolskaSpremaMajke;
	}

	public String getPotrebanVidPodrske() {
		return potrebanVidPodrske;
	}

	public void setPotrebanVidPodrske(String potrebanVidPodrske) {
		this.potrebanVidPodrske = potrebanVidPodrske;
	}

	public String getNacinFinansiranja() {
		return nacinFinansiranja;
	}

	public void setNacinFinansiranja(String nacinFinansiranja) {
		this.nacinFinansiranja = nacinFinansiranja;
	}

	public Boolean getIstaVrstaStudijaNaDrugomFakultetu() {
		return istaVrstaStudijaNaDrugomFakultetu;
	}

	public void setIstaVrstaStudijaNaDrugomFakultetu(Boolean istaVrstaStudijaNaDrugomFakultetu) {
		this.istaVrstaStudijaNaDrugomFakultetu = istaVrstaStudijaNaDrugomFakultetu;
	}

	public String getDrugiFakultet() {
		return drugiFakultet;
	}

	public void setDrugiFakultet(String drugiFakultet) {
		this.drugiFakultet = drugiFakultet;
	}

	public String getGodinaZavrsetkaDrugogFakulteta() {
		return godinaZavrsetkaDrugogFakulteta;
	}

	public void setGodinaZavrsetkaDrugogFakulteta(String godinaZavrsetkaDrugogFakulteta) {
		this.godinaZavrsetkaDrugogFakulteta = godinaZavrsetkaDrugogFakulteta;
	}

	public String getDrzavaZavrsetkaDrugogFakulteta() {
		return drzavaZavrsetkaDrugogFakulteta;
	}

	public void setDrzavaZavrsetkaDrugogFakulteta(String drzavaZavrsetkaDrugogFakulteta) {
		this.drzavaZavrsetkaDrugogFakulteta = drzavaZavrsetkaDrugogFakulteta;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public StudentDetalji(Long id, String mestoStanovanja, String tipSmestaja, String izvorSredstava,
			String glavniIzvorSredstava, Boolean jeZaposlen, String izdrzavaDrugaLica, Boolean izdrzavalacJeZaposlen,
			String zanimanjeIzdrzavaoca, String skolskaSpremaOca, String skolskaSpremaMajke, String potrebanVidPodrske,
			String nacinFinansiranja, Boolean istaVrstaStudijaNaDrugomFakultetu, String drugiFakultet,
			String godinaZavrsetkaDrugogFakulteta, String drzavaZavrsetkaDrugogFakulteta, Student student) {
		super();
		this.id = id;
		this.mestoStanovanja = mestoStanovanja;
		this.tipSmestaja = tipSmestaja;
		this.izvorSredstava = izvorSredstava;
		this.glavniIzvorSredstava = glavniIzvorSredstava;
		this.jeZaposlen = jeZaposlen;
		this.izdrzavaDrugaLica = izdrzavaDrugaLica;
		this.izdrzavalacJeZaposlen = izdrzavalacJeZaposlen;
		this.zanimanjeIzdrzavaoca = zanimanjeIzdrzavaoca;
		this.skolskaSpremaOca = skolskaSpremaOca;
		this.skolskaSpremaMajke = skolskaSpremaMajke;
		this.potrebanVidPodrske = potrebanVidPodrske;
		this.nacinFinansiranja = nacinFinansiranja;
		this.istaVrstaStudijaNaDrugomFakultetu = istaVrstaStudijaNaDrugomFakultetu;
		this.drugiFakultet = drugiFakultet;
		this.godinaZavrsetkaDrugogFakulteta = godinaZavrsetkaDrugogFakulteta;
		this.drzavaZavrsetkaDrugogFakulteta = drzavaZavrsetkaDrugogFakulteta;
		this.student = student;
	}

	public StudentDetalji() {
		super();
	}

	@Override
	public String toString() {
		return "StudentDetalji [id=" + id + ", mestoStanovanja=" + mestoStanovanja + ", tipSmestaja=" + tipSmestaja
				+ ", izvorSredstava=" + izvorSredstava + ", glavniIzvorSredstava=" + glavniIzvorSredstava
				+ ", jeZaposlen=" + jeZaposlen + ", izdrzavaDrugaLica=" + izdrzavaDrugaLica + ", izdrzavalacJeZaposlen="
				+ izdrzavalacJeZaposlen + ", zanimanjeIzdrzavaoca=" + zanimanjeIzdrzavaoca + ", skolskaSpremaOca="
				+ skolskaSpremaOca + ", skolskaSpremaMajke=" + skolskaSpremaMajke + ", potrebanVidPodrske="
				+ potrebanVidPodrske + ", nacinFinansiranja=" + nacinFinansiranja
				+ ", istaVrstaStudijaNaDrugomFakultetu=" + istaVrstaStudijaNaDrugomFakultetu + ", drugiFakultet="
				+ drugiFakultet + ", godinaZavrsetkaDrugogFakulteta=" + godinaZavrsetkaDrugogFakulteta
				+ ", drzavaZavrsetkaDrugogFakulteta=" + drzavaZavrsetkaDrugogFakulteta + ", student=" + student + "]";
	}	
	
	

}
