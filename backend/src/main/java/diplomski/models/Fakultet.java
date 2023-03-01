package diplomski.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import diplomski.utils.View.ShowStudijskiProgram;

@Entity
public class Fakultet {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(length=128, nullable=false)
	private String naziv;
	
	@Column(length=128, nullable=false)
	private String opstina;
	
	@JsonIgnore
	@JsonView(ShowStudijskiProgram.class)
	@OneToMany(mappedBy = "fakultet", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<StudijskiProgram> studijskiProgrami = new HashSet<StudijskiProgram>();

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

	public Set<StudijskiProgram> getStudijskiProgrami() {
		return studijskiProgrami;
	}

	public void setStudijskiProgram(StudijskiProgram studijskiProgram) {
		studijskiProgram.setFakultet(this);
		this.studijskiProgrami.add(studijskiProgram);
	}
	
	public void removeStudijskiProgram(StudijskiProgram studijskiProgram) {
		studijskiProgram.setFakultet(null);
		this.studijskiProgrami.remove(studijskiProgram);
	}

	public Fakultet(String naziv, String opstina, Set<StudijskiProgram> studijskiProgrami) {
		super();
		this.naziv = naziv;
		this.opstina = opstina;
		this.studijskiProgrami = studijskiProgrami;
	}

	public Fakultet() {
		super();
	}
	
	

}
