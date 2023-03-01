package diplomski.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import diplomski.models.Fakultet;
import diplomski.models.StudijskiProgram;
import diplomski.repositories.StudijskiProgramRepository;

@Service
public class StudijskiProgramService {
	
	@Autowired
	private StudijskiProgramRepository programRepo;
	
	@Autowired
	private FakultetServis fakultetServis;
	
	public StudijskiProgramService() {}
	
	public Optional<StudijskiProgram> getStudijskiProgramByID(Long programId){
		return programRepo.findById(programId);
	}
	
	public Iterable<StudijskiProgram> getStudijskiProgramByFakultetID(Long fakultetId){
		return programRepo.findByFakultetID(fakultetId);
	}
	
	public Optional<StudijskiProgram> getStudijskiProgramByNaziv(String nazivPrograma){
		return programRepo.findByNaziv(nazivPrograma);
	}
	
	public Iterable<StudijskiProgram> getAllStudijskiProgrami(){
		return programRepo.findAll();
	}
	
	public StudijskiProgram addStudijskiProgram(StudijskiProgram sp, Long fakultetID){
		Optional<Fakultet> fakultet = fakultetServis.getFakultetById(fakultetID);
		if(fakultet.isPresent()) {
			sp.setFakultet(fakultet.get());
			sp = programRepo.save(sp);
			fakultet.get().setStudijskiProgram(sp);
			fakultetServis.addFakultet(fakultet.get());
			return sp;
		}
		return null;
	}
	
	public StudijskiProgram editStudijskiProgram(Long fakuletID, Long programId, StudijskiProgram sp){
		Optional<Fakultet> fakultet = fakultetServis.getFakultetById(fakuletID);
		Optional<StudijskiProgram> program = getStudijskiProgramByID(programId);
		if(fakultet.isPresent() && program.isPresent()) {
			sp.setId(program.get().getId());
			sp.setFakultet(fakultet.get());
			return programRepo.save(sp);
		}
		return null;
	}

}
