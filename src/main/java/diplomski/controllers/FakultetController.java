package diplomski.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import diplomski.models.Fakultet;
import diplomski.models.StudijskiProgram;
import diplomski.services.FakultetServis;
import diplomski.services.StudijskiProgramService;
import diplomski.utils.View.HideOptionalProperties;

@RestController
@RequestMapping("/fakultet")
public class FakultetController {
	
	@Autowired
	StudijskiProgramService programServis;
	
	@Autowired
	FakultetServis fakultetServis;
	
	
	@JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/svi", method=RequestMethod.GET)
    public ResponseEntity<Iterable<Fakultet>> getFakulteti() {
    	return new ResponseEntity<Iterable<Fakultet>>(fakultetServis.getFakulteti(), HttpStatus.OK);  
    }
	
	@JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/{fakultetID}", method=RequestMethod.GET)
    public ResponseEntity<Optional<Fakultet>> getFakultetByID(@PathVariable Long fakultetID) {
    	return new ResponseEntity<Optional<Fakultet>>(fakultetServis.getFakultetById(fakultetID), HttpStatus.OK);  
    }
	
	@JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/{fakultetID}/svi-programi", method=RequestMethod.GET)
    public ResponseEntity<Iterable<StudijskiProgram>> getAll(@PathVariable Long fakultetID) {
    	return new ResponseEntity<Iterable<StudijskiProgram>>(programServis.getStudijskiProgramByFakultetID(fakultetID), HttpStatus.OK);
    }
	
	@JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/svi/studijski-programi/{programId}", method=RequestMethod.GET)
    public ResponseEntity<StudijskiProgram> getStudijskiProgramByID(@PathVariable Long programId) {
		Optional<StudijskiProgram> program = programServis.getStudijskiProgramByID(programId);
		if(program.isPresent()) {
			return new ResponseEntity<StudijskiProgram>(program.get(), HttpStatus.OK);
		}
		return new ResponseEntity<StudijskiProgram>(HttpStatus.NOT_FOUND);
	}
	
	@JsonView(HideOptionalProperties.class)
	@PreAuthorize("hasAnyAuthority('administrator')")
    @RequestMapping(value="/{fakultetID}/studijski-programi/dodaj", method=RequestMethod.POST)
    public ResponseEntity<StudijskiProgram> dodajStudijskiProgram(@RequestBody StudijskiProgram sp, @PathVariable Long fakultetID) {
		StudijskiProgram program = programServis.addStudijskiProgram(sp, fakultetID);
		if (program!= null) {
			return new ResponseEntity<StudijskiProgram>(program,HttpStatus.OK);
		}
		return new ResponseEntity<StudijskiProgram>(HttpStatus.METHOD_NOT_ALLOWED);
    	  
    }
	
	@JsonView(HideOptionalProperties.class)
	@PreAuthorize("hasAnyAuthority('administrator')")
    @RequestMapping(value="/{fakultetID}/studijski-programi/izmeni/{programID}", method=RequestMethod.PUT)
    public ResponseEntity<StudijskiProgram> izmeniStudijskiProgram(@PathVariable Long fakultetID, @PathVariable Long programID, @RequestBody StudijskiProgram sp) {
    	StudijskiProgram izmenjenProgram = programServis.editStudijskiProgram(fakultetID, programID, sp);
		if(izmenjenProgram != null) {
			return new ResponseEntity<StudijskiProgram>(izmenjenProgram, HttpStatus.OK);
		}
    	return new ResponseEntity<StudijskiProgram>(HttpStatus.METHOD_NOT_ALLOWED);  
    }
	
	

}
