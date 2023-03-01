package diplomski.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class UpisGodine {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=128, nullable = false)
	private String godinaUpisa;
	
	@Column(length=128, nullable = false)
	private String espbStecenoUkupno;
	
//	@JsonView(ShowStudijskiProgram.class)
	@ManyToOne(fetch = FetchType.EAGER)
	private StudijskiProgram studijskiProgram;
	
//	@JsonView(ShowStudent.class)
	@ManyToOne(fetch = FetchType.EAGER)
	private Student student;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGodinaUpisa() {
		return godinaUpisa;
	}

	public void setGodinaUpisa(String godinaUpisa) {
		this.godinaUpisa = godinaUpisa;
	}

	public String getEspbStecenoUkupno() {
		return espbStecenoUkupno;
	}

	public void setEspbStecenoUkupno(String espbStecenoUkupno) {
		this.espbStecenoUkupno = espbStecenoUkupno;
	}

	public StudijskiProgram getStudijskiProgram() {
		return studijskiProgram;
	}

	public void setStudijskiProgram(StudijskiProgram studijskiProgram) {
		this.studijskiProgram = studijskiProgram;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public UpisGodine(Long id, String godinaUpisa, String espbStecenoUkupno, StudijskiProgram studijskiProgram,
			Student student) {
		super();
		this.id = id;
		this.godinaUpisa = godinaUpisa;
		this.espbStecenoUkupno = espbStecenoUkupno;
		this.studijskiProgram = studijskiProgram;
		this.student = student;
	}

	public UpisGodine() {
		super();
	}

	@Override
	public String toString() {
		return "UpisGodine [id=" + id + ", godinaUpisa=" + godinaUpisa + ", espbStecenoUkupno=" + espbStecenoUkupno
				+ ", studijskiProgram=" + studijskiProgram + ", student=" + student + "]";
	}
	
	
}
