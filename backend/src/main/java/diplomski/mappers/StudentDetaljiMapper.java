package diplomski.mappers;
 
import diplomski.models.StudentDetalji;
import diplomski.DTO.StudentDetaljiDTO;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Component;
import org.xmlunit.util.Mapper;

@Component
public class StudentDetaljiMapper implements Mapper<StudentDetalji, StudentDetaljiDTO>{

	public StudentDetalji toEntity(StudentDetaljiDTO studentDTO) {
		if (studentDTO == null) {
	    	return null;
		}
		StudentDetalji retVal = new StudentDetalji();

		retVal.setMestoStanovanja(studentDTO.getMestoStanovanja());
		retVal.setTipSmestaja(studentDTO.getTipSmestaja());
		retVal.setIzvorSredstava(String.join(";", studentDTO.getIzvorSredstava()) );
		retVal.setGlavniIzvorSredstava(studentDTO.getGlavniIzvorSredstava());
		retVal.setJeZaposlen(studentDTO.getJeZaposlen());
		retVal.setIzdrzavaDrugaLica(String.join(";", studentDTO.getIzdrzavaDrugaLica()) );
		retVal.setIzdrzavalacJeZaposlen(studentDTO.getIzdrzavalacJeZaposlen());
		
		retVal.setZanimanjeIzdrzavaoca(studentDTO.getZanimanjeIzdrzavaoca());
		retVal.setSkolskaSpremaOca(studentDTO.getSkolskaSpremaOca());
		retVal.setSkolskaSpremaMajke(studentDTO.getSkolskaSpremaMajke());
		retVal.setPotrebanVidPodrske(String.join(";", studentDTO.getPotrebanVidPodrske()) );
		retVal.setNacinFinansiranja(studentDTO.getNacinFinansiranja());
		retVal.setIstaVrstaStudijaNaDrugomFakultetu(studentDTO.getIstaVrstaStudijaNaDrugomFakultetu());
		retVal.setDrugiFakultet(studentDTO.getDrugiFakultet());
		retVal.setGodinaZavrsetkaDrugogFakulteta(studentDTO.getGodinaZavrsetkaDrugogFakulteta());
		retVal.setDrzavaZavrsetkaDrugogFakulteta(studentDTO.getDrzavaZavrsetkaDrugogFakulteta());
		return retVal;
	}
	
	public Collection<StudentDetalji> toEntityList(Collection<StudentDetaljiDTO> dtoList) {
	    if ( dtoList == null ) {
	        return null;
	    }
	    Collection<StudentDetalji> collection = new ArrayList<StudentDetalji>(dtoList.size());
	    for (StudentDetaljiDTO student : dtoList) {
	        collection.add(toEntity(student));
	    }

	    return collection;
	}

	public StudentDetaljiDTO toDTO(StudentDetalji entity) {
		if (entity == null) {
		    return null;
		}

		StudentDetaljiDTO retVal = new StudentDetaljiDTO();

		retVal.setMestoStanovanja(entity.getMestoStanovanja());
		retVal.setTipSmestaja(entity.getTipSmestaja());
		retVal.setIzvorSredstava(entity.getIzvorSredstava().split(";"));
		retVal.setGlavniIzvorSredstava(entity.getGlavniIzvorSredstava());
		retVal.setJeZaposlen(entity.getJeZaposlen());
		retVal.setIzdrzavaDrugaLica(entity.getIzdrzavaDrugaLica().split(";"));
		retVal.setIzdrzavalacJeZaposlen(entity.getIzdrzavalacJeZaposlen());
		
		retVal.setZanimanjeIzdrzavaoca(entity.getZanimanjeIzdrzavaoca());
		retVal.setSkolskaSpremaOca(entity.getSkolskaSpremaOca());
		retVal.setSkolskaSpremaMajke(entity.getSkolskaSpremaMajke());
		retVal.setPotrebanVidPodrske(entity.getPotrebanVidPodrske().split(";"));
		retVal.setNacinFinansiranja(entity.getNacinFinansiranja());
		retVal.setIstaVrstaStudijaNaDrugomFakultetu(entity.getIstaVrstaStudijaNaDrugomFakultetu());
		retVal.setDrugiFakultet(entity.getDrugiFakultet());
		retVal.setGodinaZavrsetkaDrugogFakulteta(entity.getGodinaZavrsetkaDrugogFakulteta());
		retVal.setDrzavaZavrsetkaDrugogFakulteta(entity.getDrzavaZavrsetkaDrugogFakulteta());

		return retVal;
	}

	
	public Collection<StudentDetaljiDTO> toDtoList(Collection<StudentDetalji> entityList) {
	    if ( entityList == null ) {
	        return null;
	    }

	    Collection<StudentDetaljiDTO> collection = new ArrayList<StudentDetaljiDTO>(entityList.size());
	    for (StudentDetalji student : entityList) {
	        collection.add(toDTO(student));
	    }

	    return collection;
	}

	@Override
	public StudentDetaljiDTO apply(StudentDetalji from) {
		return null;
	}

}
