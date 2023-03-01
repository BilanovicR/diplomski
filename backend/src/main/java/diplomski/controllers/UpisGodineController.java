package diplomski.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import diplomski.DTO.NoviUpisGodineDTO;
import diplomski.DTO.UpisGodineDTO;
import diplomski.models.StudijskiProgram;
import diplomski.models.UpisGodine;
import diplomski.services.StudijskiProgramService;
import diplomski.services.UpisGodineServis;
import diplomski.utils.View.HideOptionalProperties;

@RestController
@RequestMapping("/upis")
@CrossOrigin(origins={"http://localhost:4200"})
public class UpisGodineController {
	
	@Autowired
	UpisGodineServis upisServis;
	
	@Autowired
	StudijskiProgramService programServis;

    @JsonView(HideOptionalProperties.class)
    @PreAuthorize("hasAnyAuthority('api_korisnik')")
    @RequestMapping(value="/api/godina/{godinaUpisa}", method=RequestMethod.GET)
    public ResponseEntity<Iterable<UpisGodineDTO>> getUpisiPoGodini(@PathVariable String godinaUpisa) {
        return new ResponseEntity<Iterable<UpisGodineDTO>>(upisServis.getUpisaneStudentePoGodini(godinaUpisa), HttpStatus.OK);
    }

    @JsonView(HideOptionalProperties.class)
    @PreAuthorize("hasAnyAuthority('api_korisnik')")
    @RequestMapping(value="/api/studijskiProgram/{studijskiProgram}/godina/{godinaUpisa}", method=RequestMethod.GET)
    public ResponseEntity<Iterable<UpisGodineDTO>> getUpisiPoGodiniIStudijskomProgramu_API(@PathVariable String godinaUpisa, @PathVariable String studijskiProgram) {
    	Iterable<UpisGodineDTO> upisi = upisServis.getUpisaneStudentePoGodiniIStudijskomProgramu(godinaUpisa, studijskiProgram);
        return new ResponseEntity<Iterable<UpisGodineDTO>>(upisi, HttpStatus.OK);
    }
    
    @JsonView(HideOptionalProperties.class)
    @PreAuthorize("hasAnyAuthority('administrator','profesor')")
    @RequestMapping(value="/studijskiProgram/{studijskiProgram}/godina/{godinaUpisa}", method=RequestMethod.GET)
    public ResponseEntity<Iterable<UpisGodine>> getUpisiPoGodiniIStudijskomProgramu(@PathVariable String godinaUpisa, @PathVariable String studijskiProgram) {
    	Iterable<UpisGodine> upisi = upisServis.getByGodinaUpisaAndStudijskiProgram(godinaUpisa, studijskiProgram);
        return new ResponseEntity<Iterable<UpisGodine>>(upisi, HttpStatus.OK);
    }
    
    @JsonView(HideOptionalProperties.class)
   @PreAuthorize("hasAnyAuthority('administrator')")
    @RequestMapping(value="/studijskiProgram/{studijskiProgram}/godina/{godinaUpisa}/upisiStudenta", method=RequestMethod.POST)
    public ResponseEntity<UpisGodine> upisiStudenta(@PathVariable Long studijskiProgram, @PathVariable String godinaUpisa, @RequestBody UpisGodine upis) {
    	StudijskiProgram sp = programServis.getStudijskiProgramByID(studijskiProgram).get();
    	upis.setGodinaUpisa(godinaUpisa);
    	upis.setStudijskiProgram(sp);
    	upis.getStudent().setStatus("upisan");
    	upis = upisServis.addUpisGodine(upis);
    	
        return new ResponseEntity<UpisGodine>(upis, HttpStatus.OK);
    }
    
    @JsonView(HideOptionalProperties.class)
    @PreAuthorize("hasAnyAuthority('administrator')")
    @RequestMapping(value="/add", method=RequestMethod.POST)
    public ResponseEntity<UpisGodine> addUpis(@RequestBody NoviUpisGodineDTO upis) {
        return new ResponseEntity<UpisGodine>(upisServis.addNoviUpis(upis), HttpStatus.OK);
    }
    
    @JsonView(HideOptionalProperties.class)
    @PreAuthorize("hasAnyAuthority('student')")
    @RequestMapping(value="/sviUpisi/{studentIndeks}", method=RequestMethod.GET)
    public ResponseEntity<Iterable<UpisGodine>> getUpisiPoStudentu(@PathVariable String studentIndeks) {
    	Iterable<UpisGodine> upisi = upisServis.getUpisiByStudent(studentIndeks);
        return new ResponseEntity<Iterable<UpisGodine>>(upisi, HttpStatus.OK);
    }

}
