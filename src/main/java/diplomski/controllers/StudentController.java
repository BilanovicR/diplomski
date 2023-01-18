package diplomski.controllers;

import java.io.IOException;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.ObjectMapper;

import diplomski.DTO.StudentDTO;
import diplomski.DTO.StudentSV20;
import diplomski.models.Student;
import diplomski.models.StudentDetalji;
import diplomski.models.StudentSrednjaSkola;
import diplomski.services.FileService;
import diplomski.services.StudentDetaljiServis;
import diplomski.services.StudentServis;
import diplomski.services.StudentSrednjaSkolaServis;
import diplomski.utils.View.HideOptionalProperties;


@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
    StudentServis studentServis;
	
	@Autowired
    StudentDetaljiServis studentDetaljiServis;
	
	@Autowired
    StudentSrednjaSkolaServis studentSkolaServis;
	
	@Autowired
	FileService fileService;

	@PreAuthorize("hasAnyAuthority('administrator', 'profesor', 'student', 'api_korisnik')")
    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
		//provera ako student pristupa da moze iskljuciov njegov profil da vidi a ne i ostale studente?
		//ako je profesor, onda limitirani prikaz studenta bez ostatka licnih podataka
    	Optional<Student> student = studentServis.getStudentByID(id);
    	if (student.isPresent()) {
    		return new ResponseEntity<Student>(student.get(), HttpStatus.OK);
    	}    	
        return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
    }
    
    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/indeks/{indeks}", method=RequestMethod.GET)
    @PreAuthorize("hasAnyAuthority('administrator', 'profesor', 'api_korisnik')")
    public ResponseEntity<Student> getStudentByBrojIndeksa(@PathVariable String indeks) {
        Optional<Student> student = studentServis.getStudentByBrojIndeksa(indeks);
        if(student.isPresent()) {
            return new ResponseEntity<Student>(student.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
    }
    
    @Transactional
    @JsonView(HideOptionalProperties.class)
    @PreAuthorize("hasAnyAuthority('administrator')")
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<StudentSV20> addStudent(
			@RequestPart("studentImage") Optional<MultipartFile> file, 
			@RequestPart String student) throws IOException {
    	StudentSV20 studentSV20 = new ObjectMapper().readValue(student, StudentSV20.class);

    	if(studentSV20.getStudent().getFotografijaURL() == null 
       		 || studentSV20.getStudent().getFotografijaURL().contains("default.png")) {
    		
    		if(file.isPresent()) {
        		studentSV20.getStudent().setFotografijaURL(fileService.saveProfileImage(file.get(), "student_" + studentSV20.getStudent().getBrojIndeksa(), studentSV20.getStudent()));
    		} else {
    			studentSV20.getStudent().setFotografijaURL(fileService.defaultStudentImageURL);
    		}    		
    	}

		studentServis.addStudent(studentSV20);
		return new ResponseEntity<StudentSV20>(studentSV20, HttpStatus.CREATED);
	}
	
    @Transactional
	@JsonView(HideOptionalProperties.class)
	@RequestMapping(value="/update/{ID}", method=RequestMethod.PUT, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@PreAuthorize("hasAnyAuthority('administrator','student')")
	public ResponseEntity<StudentSV20> updateStudent(
				@PathVariable Long ID,
	    		@RequestPart("studentImage") Optional<MultipartFile> file, 
	    		@RequestPart("student") String student) throws IOException {
    	StudentSV20 studentSV20 = new ObjectMapper().readValue(student, StudentSV20.class);

    	if(studentSV20.getStudent().getFotografijaURL() == null 
          		 || studentSV20.getStudent().getFotografijaURL().contains("default.png")) {
       		
       		if(file.isPresent()) {
           		studentSV20.getStudent().setFotografijaURL(fileService.saveProfileImage(file.get(), "student_" + studentSV20.getStudent().getBrojIndeksa(), studentSV20.getStudent()));
       		} else {
       			studentSV20.getStudent().setFotografijaURL(fileService.defaultStudentImageURL);
       		}
    	}    	
    	StudentSV20 stud = studentServis.updateStudent(ID, studentSV20);
    	if (stud != null) {
    		return new ResponseEntity<StudentSV20>(stud, HttpStatus.OK);
    	} return new ResponseEntity<StudentSV20>(HttpStatus.NOT_FOUND);   
    }
	
	@JsonView(HideOptionalProperties.class)
	@RequestMapping(value = "/search/", method = RequestMethod.GET)
	@PreAuthorize("hasAnyAuthority('administrator','profesor')")
	public ResponseEntity<Collection<StudentDTO>> pretraziStudente(@RequestParam(required = false) String ime,
			@RequestParam(required = false) String prezime, @RequestParam(required = false) String brojIndeksa) {

		Collection<StudentDTO> students = studentServis.pretraziStudente(ime, prezime, brojIndeksa);
		if(!students.isEmpty()) {
			return new ResponseEntity<Collection<StudentDTO>>(students, HttpStatus.OK);
		}
		else return new ResponseEntity<Collection<StudentDTO>>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value="/xml/{studentID}", method=RequestMethod.GET, produces=MediaType.APPLICATION_XML_VALUE)
	@JsonView(HideOptionalProperties.class)
	@PreAuthorize("hasAnyAuthority('administrator', 'student', 'api_korisnik')")
    public @ResponseBody StudentSV20 getStudentXMLId(@PathVariable Long studentID) {		
		Optional<Student> student = studentServis.getStudentByID(studentID);
		if(!student.isPresent()) {
			return null;
		}
		StudentDetalji detalji = studentDetaljiServis.getDetaljeStudenta(studentID);
		StudentSrednjaSkola skola = studentSkolaServis.getSrednjuSkoluStudenta(studentID);
		
        return new StudentSV20(student.get(), skola, detalji);
    }
	
	@Transactional
	@JsonView(HideOptionalProperties.class)
	@RequestMapping(value = "/obrisi/{studentID}", method = RequestMethod.DELETE)
	@PreAuthorize("hasAnyAuthority('administrator')")
	public ResponseEntity<Student> obrisiStudenta(@PathVariable Long studentID) {
		try {
            studentServis.obrisiStudenta(studentID);
        }catch (Exception e) {
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Student>(HttpStatus.OK);
	}
}
