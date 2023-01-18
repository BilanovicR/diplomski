package diplomski.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import diplomski.models.Student;
import diplomski.models.StudentDetalji;
import diplomski.repositories.StudentDetaljiRepository;

@Service
public class StudentDetaljiServis {
	
	@Autowired
	private StudentDetaljiRepository detaljiRepo;
	
	public StudentDetaljiServis() {}
	
	public StudentDetalji getDetaljeStudenta(Long studentID) {
        return detaljiRepo.findByStudentId(studentID);
    }

	public StudentDetalji addStudentDetalje(StudentDetalji detalji) {
		return detaljiRepo.save(detalji);
    }
	
	public StudentDetalji addDetaljeForStudent(StudentDetalji detalji, Student student) {
		detalji.setStudent(student);
		return detaljiRepo.save(detalji);
    }
	
	public void removeStudentDetalji(Long studentID) {
        StudentDetalji detalji = getDetaljeStudenta(studentID);
        detaljiRepo.delete(detalji);
    }
	
	public StudentDetalji updateStudentDetalji(Long id, StudentDetalji sd) {
		Optional<StudentDetalji> studDetalji = detaljiRepo.findById(id);
		if(studDetalji.isPresent()) {
			sd.setId(studDetalji.get().getId());
			detaljiRepo.save(sd);
			return sd;
		}
		return null;
	}
		
}
