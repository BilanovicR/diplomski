package diplomski.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;

import diplomski.utils.View.ShowFakultet;
import diplomski.utils.View.ShowUpisGodine;

@Entity
public class StudijskiProgram {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=128, nullable = false)
	private String vrstaStudija;
	
	@Column(length=128, nullable = false)
	private String stepenStudija;
	
	@Column(length=128, nullable = false)
	private String departman;
	
	@Column(length=128, nullable = false)
	private String godina;
	
	@Column(length=128, nullable = false)
	private String naziv;
	
	@JsonView(ShowFakultet.class)
	@ManyToOne(fetch = FetchType.LAZY)
	private Fakultet fakultet;
	
	@JsonView(ShowUpisGodine.class)
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "studijskiProgram", orphanRemoval = true)
	private Set<UpisGodine> upisGodine = new HashSet<UpisGodine>();

	public String getVrstaStudija() {
		return vrstaStudija;
	}

	public void setVrstaStudija(String vrstaStudija) {
		this.vrstaStudija = vrstaStudija;
	}

	public String getStepenStudija() {
		return stepenStudija;
	}

	public void setStepenStudija(String stepenStudija) {
		this.stepenStudija = stepenStudija;
	}

	public String getDepartman() {
		return departman;
	}

	public void setDepartman(String departman) {
		this.departman = departman;
	}

	public String getGodina() {
		return godina;
	}

	public void setGodina(String godina) {
		this.godina = godina;
	}

	public Fakultet getFakultet() {
		return fakultet;
	}

	public void setFakultet(Fakultet fakultet) {
		this.fakultet = fakultet;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<UpisGodine> getUpisGodine() {
		return upisGodine;
	}

	public void setUpisGodine(UpisGodine upisGodine) {
		this.upisGodine.add(upisGodine);
		upisGodine.setStudijskiProgram(this);
	}
	
	public void removeUpisGodine(UpisGodine upisGodine) {
		this.upisGodine.remove(upisGodine);
		upisGodine.setStudijskiProgram(null);
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public StudijskiProgram(String vrstaStudija, String stepenStudija, String departman, String godina,
			Fakultet fakultet, String naziv) {
		super();
		this.vrstaStudija = vrstaStudija;
		this.stepenStudija = stepenStudija;
		this.departman = departman;
		this.godina = godina;
		this.fakultet = fakultet;
		this.naziv = naziv;
	}

	public StudijskiProgram() {
		super();
	}
	
}
