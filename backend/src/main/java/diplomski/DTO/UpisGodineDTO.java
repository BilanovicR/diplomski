package diplomski.DTO;

import diplomski.models.StudijskiProgram;

public class UpisGodineDTO {
	
	private StudentSV20 studentSV20;
	private String godinaUpisa;
	private String espbStecenoUkupno;
	private StudijskiProgram studijskiProgram;
	private Long studentID;
	private Long studijskiProgramID;

	public UpisGodineDTO() {
		super();
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
	public StudentSV20 getStudentSV20() {
		return studentSV20;
	}
	public void setStudentSV20(StudentSV20 studentSV20) {
		this.studentSV20 = studentSV20;
	}
	public Long getStudentID() {
		return studentID;
	}
	public void setStudentID(Long studentID) {
		this.studentID = studentID;
	}
	public Long getStudijskiProgramID() {
		return studijskiProgramID;
	}
	public void setStudijskiProgramID(Long studijskiProgramID) {
		this.studijskiProgramID = studijskiProgramID;
	}

}
