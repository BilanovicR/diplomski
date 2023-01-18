package diplomski.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import diplomski.DTO.StudentDTO;
import diplomski.DTO.StudentSV20;
import diplomski.mappers.StudentMapper;
import diplomski.models.Student;
import diplomski.models.StudentDetalji;
import diplomski.models.StudentSrednjaSkola;
import diplomski.repositories.StudentCustomRepositoryImpl;
import diplomski.repositories.StudentRepository;

@Service
public class StudentServis {
	
	@Autowired
    private StudentRepository studentRepo;
	
	@Autowired
    private StudentCustomRepositoryImpl studentCustomRepo;
	
	@Autowired
    StudentMapper studentMapper;
	
	@Autowired	
	private KorisnikServis korisnikServis;
	
	@Autowired
	private StudentDetaljiServis detaljiServis;
	
	@Autowired
	private StudentSrednjaSkolaServis skolaServis;
	
	private final String STUDENT_MAIL_FORMAT = "@student.fakultet.rs";
	
	public StudentSV20 addStudent(StudentSV20 student) {
		if (student == null) {
			return null;
		}
		
		student.getStudent().setEmail(String.join(".", student.getStudent().getIme(), student.getStudent().getPrezime(), student.getStudent().getBrojIndeksa()) + STUDENT_MAIL_FORMAT);
		student.getStudent().setStatus("upisan");
		Student st = studentRepo.save(student.getStudent());
		korisnikServis.addKorisnickiPodaci(st);
		skolaServis.addStudentSkolaForStudent(student.getSkola(), st);
		detaljiServis.addDetaljeForStudent(student.getDetalji(), st);
		return student;

    }
	
	public Iterable<Student> getStudenti(){
		return studentRepo.findAll();
	}
	public Optional<Student> getStudentByBrojIndeksa(String korIme) {
        return studentRepo.findByBrojIndeksa(korIme);
    }
	
	public Optional<Student> getStudentByID(Long id) {
        return studentRepo.findById(id);
    }

	public StudentSV20 updateStudent(Long ID, StudentSV20 student) {
		Optional<Student> Stu = studentRepo.findById(ID);
        
        if(student.getStudent() != null) {
        	
            student.getStudent().setId(Stu.get().getId());
            student.getStudent().setBrojIndeksa(Stu.get().getBrojIndeksa());
            student.getStudent().setEmail(Stu.get().getEmail());
            student.getStudent().setJmbg(Stu.get().getJmbg());
            
            student.getStudent().setAllUpisGodine(Stu.get().getUpisGodine());
            student.setStudent(studentRepo.save(student.getStudent()));

        }
        if(student.getSkola() != null) {
	        StudentSrednjaSkola skola = skolaServis.getSrednjuSkoluStudenta(ID);
	        student.getSkola().setId(skola.getId());
	        student.setSkola(skolaServis.addStudentSkolaForStudent(student.getSkola(), Stu.get()));
        }
        
        if(student.getDetalji()!= null) {
        	StudentDetalji detalji = detaljiServis.getDetaljeStudenta(ID);
        	student.getDetalji().setId(detalji.getId());
        	student.setDetalji(detaljiServis.addDetaljeForStudent(detalji, Stu.get()));        	
        }
        
        return student;
    }
	
	public Collection<StudentDTO> pretraziStudente(String ime, String prezime, String brojIndeksa){    	
    	Collection<Student> pronadjeniStudenti =  studentCustomRepo.pretraziStudente(ime, prezime, brojIndeksa);
    	if(pronadjeniStudenti.isEmpty()) {
    		return null;
    	}
    	return studentMapper.toDtoList(pronadjeniStudenti);
		
    }
	
	public Student obrisiStudenta(Long studentID) {
		Optional<Student> student = getStudentByID(studentID);		
		if(student.isPresent() && student.get().getJeDiplomirao()) {		
			detaljiServis.removeStudentDetalji(studentID);
			korisnikServis.removeKorisnik(studentID);		
		}
		return student.get();
	}


}
