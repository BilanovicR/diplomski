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
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date datumFinalizacijeZahteva;
	
	@Column(length=128)
	private String komentar;	
	
	@Column(length=128, nullable = false)
	private String korisnikID;//korisnickoIme
	
	@Column(length=128, nullable = false)
	private String podnosilacZahteva;

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

	public String getKorisnikID() {
		return korisnikID;
	}

	public void setKorisnikID(String korisnikID) {
		this.korisnikID = korisnikID;
	}

	public String getPodnosilacZahteva() {
		return podnosilacZahteva;
	}

	public void setPodnosilacZahteva(String podnosilacZahteva) {
		this.podnosilacZahteva = podnosilacZahteva;
	}

	public ZahtevZaLicnePodatke(Long id, String vrstaZahteva, Date datumPodnosenjaZahteva,
			Date datumFinalizacijeZahteva, String komentar, String korisnikID, String podnosilacZahteva) {
		super();
		this.id = id;
		this.vrstaZahteva = vrstaZahteva;
		this.datumPodnosenjaZahteva = datumPodnosenjaZahteva;
		this.datumFinalizacijeZahteva = datumFinalizacijeZahteva;
		this.komentar = komentar;
		this.korisnikID = korisnikID;
		this.podnosilacZahteva = podnosilacZahteva;
	}

	public ZahtevZaLicnePodatke() {
		super();
	}

	@Override
	public String toString() {
		return "ZahtevZaLicnePodatke [id=" + id + ", vrstaZahteva=" + vrstaZahteva + ", datumPodnosenjaZahteva="
				+ datumPodnosenjaZahteva + ", datumFinalizacijeZahteva=" + datumFinalizacijeZahteva + ", komentar="
				+ komentar + ", korisnikID=" + korisnikID + ", podnosilacZahteva=" + podnosilacZahteva + "]";
	}
	
	

}
