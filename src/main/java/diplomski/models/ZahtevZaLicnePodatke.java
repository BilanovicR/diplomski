package diplomski.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ZahtevZaLicnePodatke {	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=128, nullable = false)
	private String vrstaZahteva;
	
	@Column(length=128, nullable = false)
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date datumPodnosenjaZahteva;
	
	@Column(length=128)
	@Temporal(value = TemporalType.DATE)
	private Date datumFinalizacijeZahteva;
	
	@Column(length=128)
	private String komentar;	
	
	@Column(length=128, nullable = false)
	private Long korisnikID;
	
	@Column(length=128, nullable = false)
	private Long podnosilacZahteva;
	
	@Column(length=128)
	private String dodaciURL;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVrstaZahteva() {
		return vrstaZahteva;
	}

	public void setVrstaZahteva(String vrstaZahteva) {
		this.vrstaZahteva = vrstaZahteva;
	}

	public Date getDatumPodnosenjaZahteva() {
		return datumPodnosenjaZahteva;
	}

	public void setDatumPodnosenjaZahteva(Date datumPodnosenjaZahteva) {
		this.datumPodnosenjaZahteva = datumPodnosenjaZahteva;
	}

	public Date getDatumFinalizacijeZahteva() {
		return datumFinalizacijeZahteva;
	}

	public void setDatumFinalizacijeZahteva(Date datumFinalizacijeZahteva) {
		this.datumFinalizacijeZahteva = datumFinalizacijeZahteva;
	}

	public String getKomentar() {
		return komentar;
	}

	public void setKomentar(String komentar) {
		this.komentar = komentar;
	}

	public Long getKorisnikID() {
		return korisnikID;
	}

	public void setKorisnikID(Long korisnikID) {
		this.korisnikID = korisnikID;
	}

	public String getDodaciURL() {
		return dodaciURL;
	}

	public void setDodaciURL(String dodaciURL) {
		this.dodaciURL = dodaciURL;
	}

	public Long getPodnosilacZahteva() {
		return podnosilacZahteva;
	}

	public void setPodnosilacZahteva(Long podnosilacZahteva) {
		this.podnosilacZahteva = podnosilacZahteva;
	}

	public ZahtevZaLicnePodatke(Long id, String vrstaZahteva, Date datumPodnosenjaZahteva,
			Date datumFinalizacijeZahteva, String komentar, Long korisnikID, Long podnosilacZahteva, String dodaciURL) {
		super();
		this.id = id;
		this.vrstaZahteva = vrstaZahteva;
		this.datumPodnosenjaZahteva = datumPodnosenjaZahteva;
		this.datumFinalizacijeZahteva = datumFinalizacijeZahteva;
		this.komentar = komentar;
		this.korisnikID = korisnikID;
		this.podnosilacZahteva = podnosilacZahteva;
		this.dodaciURL = dodaciURL;
	}

	public ZahtevZaLicnePodatke() {
		super();
	}	

}
