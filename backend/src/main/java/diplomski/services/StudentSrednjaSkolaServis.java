package diplomski.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import diplomski.models.Student;
import diplomski.models.StudentSrednjaSkola;
import diplomski.repositories.StudentSrednjaSkolaRepository;

@Service
public class StudentSrednjaSkolaServis {
	
	@Autowired
	private StudentSrednjaSkolaRepository skolaRepo;
	
	public StudentSrednjaSkolaServis() {}

	public StudentSrednjaSkola getSrednjuSkoluStudenta(Long studentID) {
        return skolaRepo.getByStudentID(studentID);
    }

	public StudentSrednjaSkola addStudentSkola(StudentSrednjaSkola skola) {
		return skolaRepo.save(skola);
    }
	
	public StudentSrednjaSkola addStudentSkolaForStudent(StudentSrednjaSkola skola, Student student) {
		skola.setStudent(student);
		return skolaRepo.save(skola);
    }
	
	public void removeStudentSrednjaSkola(Long studentID) {
        StudentSrednjaSkola skola = getSrednjuSkoluStudenta(studentID);
        skolaRepo.delete(skola);
    }
	
	public StudentSrednjaSkola updateStudentDetalji(Long id, StudentSrednjaSkola ss) {
		Optional<StudentSrednjaSkola> skola = skolaRepo.findById(id);
		if(skola.isPresent()) {
			ss.setId(skola.get().getId());
			 return skolaRepo.save(ss);
		}
		return null;
	}


}
