package diplomski.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonView;

import diplomski.utils.View.ShowUpisGodine;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=128, nullable = false)
	private String brojIndeksa;
	
	@Column(length=128, nullable = false)
	private String ime;
	
	@Column(length=128, nullable = false)
	private String prezime;
	
	@Column(length=128, nullable = false)
	private String imeRoditelja;
	
	@Column(length=128, nullable = false)
	private String email;
	
	@Column(length=128)
	private String jmbg;
	
	@Column(length=128, nullable = false)
	private String pol;
	
	@Column(length=128)
	private String fotografijaURL;
	
	@Column(length=128, nullable = false)
	@Type(type="date")
	private Date datumRodjenja;
	
	@Column(length=128, nullable = false)
	private String mestoRodjenja;
	
	@Column(length=128, nullable = false)
	private String brojTelefona;
	
	@Column(length=128)
	private String brojPasosa;
	
	@Column(length=128, nullable = false)
	private String prebivaliste;
	
	@Column(length=128, nullable = false)
	private String ulica;
	
	@Column(length=128, nullable = false)
	private String naselje;
	
	@Column(length=128, nullable = false)
	private String drzavljanstvo;
	
	@Column(length=128)
	private String nacionalnost;
	
	@Column(length=128, nullable = false)
	private String bracniStatus;
	
	@Column(length=128)
	private String prosecnaOcena;
	
	@Column(columnDefinition = "boolean default false")
	private Boolean jeDiplomirao;
	
	@Column(length=128)
	private String status; //upisan/ispisan/zamrznut?

	@JsonView(ShowUpisGodine.class)
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "student", orphanRemoval = true)
	private Set<UpisGodine> upisGodine = new HashSet<UpisGodine>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getBrojIndeksa() {
		return brojIndeksa;
	}

	public void setBrojIndeksa(String brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
	}

	public String getImeRoditelja() {
		return imeRoditelja;
	}

	public void setImeRoditelja(String imeRoditelja) {
		this.imeRoditelja = imeRoditelja;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getPol() {
		return pol;
	}

	public void setPol(String pol) {
		this.pol = pol;
	}

	public String getFotografijaURL() {
		return fotografijaURL;
	}

	public void setFotografijaURL(String fotografijaURL) {
		this.fotografijaURL = fotografijaURL;
	}

	public Date getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public String getMestoRodjenja() {
		return mestoRodjenja;
	}

	public void setMestoRodjenja(String mestoRodjenja) {
		this.mestoRodjenja = mestoRodjenja;
	}

	public String getBrojTelefona() {
		return brojTelefona;
	}

	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}

	public String getBrojPasosa() {
		return brojPasosa;
	}

	public void setBrojPasosa(String brojPasosa) {
		this.brojPasosa = brojPasosa;
	}

	public String getPrebivaliste() {
		return prebivaliste;
	}

	public void setPrebivaliste(String prebivaliste) {
		this.prebivaliste = prebivaliste;
	}

	public String getUlica() {
		return ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public String getNaselje() {
		return naselje;
	}

	public void setNaselje(String naselje) {
		this.naselje = naselje;
	}

	public String getDrzavljanstvo() {
		return drzavljanstvo;
	}

	public void setDrzavljanstvo(String drzavljanstvo) {
		this.drzavljanstvo = drzavljanstvo;
	}

	public String getNacionalnost() {
		return nacionalnost;
	}

	public void setNacionalnost(String nacionalnost) {
		this.nacionalnost = nacionalnost;
	}

	public String getBracniStatus() {
		return bracniStatus;
	}

	public void setBracniStatus(String bracniStatus) {
		this.bracniStatus = bracniStatus;
	}

	public String getProsecnaOcena() {
		return prosecnaOcena;
	}

	public void setProsecnaOcena(String prosecnaOcena) {
		this.prosecnaOcena = prosecnaOcena;
	}

	public Boolean getJeDiplomirao() {
		return jeDiplomirao;
	}

	public void setJeDiplomirao(Boolean jeDiplomirao) {
		this.jeDiplomirao = jeDiplomirao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<UpisGodine> getUpisGodine() {
		return upisGodine;
	}

	public void setUpisGodine(UpisGodine upisGodine) {
		this.upisGodine.add(upisGodine);
		upisGodine.setStudent(this);
	}
	public void setAllUpisGodine(Set<UpisGodine> upisiGodine) {
		this.upisGodine = upisiGodine;
	}
	
	public void removeUpisGodine(UpisGodine upisGodine) {
		this.upisGodine.remove(upisGodine);
		upisGodine.setStudent(null);
	}

	public Student(String brojIndeksa, String ime, String prezime, String imeRoditelja, String email, String jmbg,
			String pol, String fotografijaURL, Date datumRodjenja, String mestoRodjenja, String brojTelefona,
			String brojPasosa, String prebivaliste, String ulica, String naselje, String drzavljanstvo,
			String nacionalnost, String bracniStatus, String prosecnaOcena, Boolean jeDiplomirao, String status,
			 Set<UpisGodine> upisGodine) {
		super();
		this.brojIndeksa = brojIndeksa;
		this.ime = ime;
		this.prezime = prezime;
		this.imeRoditelja = imeRoditelja;
		this.email = email;
		this.jmbg = jmbg;
		this.pol = pol;
		this.fotografijaURL = fotografijaURL;
		this.datumRodjenja = datumRodjenja;
		this.mestoRodjenja = mestoRodjenja;
		this.brojTelefona = brojTelefona;
		this.brojPasosa = brojPasosa;
		this.prebivaliste = prebivaliste;
		this.ulica = ulica;
		this.naselje = naselje;
		this.drzavljanstvo = drzavljanstvo;
		this.nacionalnost = nacionalnost;
		this.bracniStatus = bracniStatus;
		this.prosecnaOcena = prosecnaOcena;
		this.jeDiplomirao = jeDiplomirao;
		this.status = status;
		this.upisGodine = upisGodine;
	}

	public Student(Long id, String brojIndeksa, String ime, String prezime, String imeRoditelja, String email,
			String jmbg, String pol, String fotografijaURL, Date datumRodjenja, String mestoRodjenja,
			String brojTelefona, String brojPasosa, String prebivaliste, String ulica, String naselje,
			String drzavljanstvo, String nacionalnost, String bracniStatus, String prosecnaOcena, Boolean jeDiplomirao,
			String status, Set<UpisGodine> upisGodine) {
		super();
		this.id = id;
		this.brojIndeksa = brojIndeksa;
		this.ime = ime;
		this.prezime = prezime;
		this.imeRoditelja = imeRoditelja;
		this.email = email;
		this.jmbg = jmbg;
		this.pol = pol;
		this.fotografijaURL = fotografijaURL;
		this.datumRodjenja = datumRodjenja;
		this.mestoRodjenja = mestoRodjenja;
		this.brojTelefona = brojTelefona;
		this.brojPasosa = brojPasosa;
		this.prebivaliste = prebivaliste;
		this.ulica = ulica;
		this.naselje = naselje;
		this.drzavljanstvo = drzavljanstvo;
		this.nacionalnost = nacionalnost;
		this.bracniStatus = bracniStatus;
		this.prosecnaOcena = prosecnaOcena;
		this.jeDiplomirao = jeDiplomirao;
		this.status = status;
		this.upisGodine = upisGodine;
	}

	public Student() {
		super();
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", brojIndeksa=" + brojIndeksa + ", ime=" + ime + ", prezime=" + prezime
				+ ", imeRoditelja=" + imeRoditelja + ", email=" + email + ", jmbg=" + jmbg + ", pol=" + pol
				+ ", fotografijaURL=" + fotografijaURL + ", datumRodjenja=" + datumRodjenja + ", mestoRodjenja="
				+ mestoRodjenja + ", brojTelefona=" + brojTelefona + ", brojPasosa=" + brojPasosa + ", prebivaliste="
				+ prebivaliste + ", ulica=" + ulica + ", naselje=" + naselje + ", drzavljanstvo=" + drzavljanstvo
				+ ", nacionalnost=" + nacionalnost + ", bracniStatus=" + bracniStatus + ", prosecnaOcena="
				+ prosecnaOcena + ", jeDiplomirao=" + jeDiplomirao + ", status=" + status + ", upisGodine=" + upisGodine
				+ "]";
	}

	
}
