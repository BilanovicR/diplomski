package diplomski.DTO;

import diplomski.models.Student;
import diplomski.models.StudentDetalji;
import diplomski.models.StudentSrednjaSkola;

public class StudentSV20 {
	
//	@JsonView(ShowStudent.class)
	private Student student;
	
//	@JsonView(ShowStudentSrednjaSkola.class)
	private StudentSrednjaSkola skola;
	
//	@JsonView(ShowStudentDetalji.class)
	private StudentDetalji detalji;
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public StudentSrednjaSkola getSkola() {
		return skola;
	}
	public void setSkola(StudentSrednjaSkola skola) {
		this.skola = skola;
	}
	public StudentDetalji getDetalji() {
		return detalji;
	}
	public void setDetalji(StudentDetalji detalji) {
		this.detalji = detalji;
	}
	public StudentSV20(Student student, StudentSrednjaSkola skola, StudentDetalji detalji) {
		super();
		this.student = student;
		this.skola = skola;
		this.detalji = detalji;
	}
	public StudentSV20() {
		super();
	}
	
	

}
