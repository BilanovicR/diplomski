package diplomski.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import diplomski.DTO.StudentSV20;
import diplomski.DTO.UpisGodineDTO;
import diplomski.models.StudentDetalji;
import diplomski.models.StudentSrednjaSkola;
import diplomski.models.UpisGodine;
import diplomski.repositories.UpisGodineRepository;

@Service
public class UpisGodineServis {
	
	@Autowired
	private UpisGodineRepository upisRepo;
	
	public UpisGodineServis() {}
	
	public ArrayList<UpisGodineDTO> getUpisaneStudentePoGodini(String godinaUpisa){		
		ArrayList<Object[]> upisaniStudenti = upisRepo.findAllByGodinaUpisa(godinaUpisa);
		ArrayList<UpisGodineDTO> upisi = mapToDTO(upisaniStudenti);
		return upisi;
	}
	
	public ArrayList<UpisGodineDTO> getUpisaneStudentePoGodiniIStudijskomProgramu(String godinaUpisa, String studijskiProgram){
		ArrayList<Object[]> upisaniStudenti = upisRepo.findByGodinaUpisaAndStudijskiProgram(godinaUpisa, studijskiProgram);
		ArrayList<UpisGodineDTO> upisi = mapToDTO(upisaniStudenti);
		return upisi;
	}
	
	public ArrayList<UpisGodine> getByGodinaUpisaAndStudijskiProgram(String godinaUpisa, String studijskiProgram){
		return upisRepo.getByGodinaUpisaAndStudijskiProgram(godinaUpisa, studijskiProgram);
	}
	
	public UpisGodine addUpisGodine(UpisGodine upis) {
		return upisRepo.save(upis);		
	}
	
	public UpisGodine updateUpisGodine(Long id, UpisGodine noviUpisGodine) {
		Optional<UpisGodine> upis = upisRepo.findById(id);
		if (upis.isPresent()) {
			noviUpisGodine.setId(upis.get().getId());
			return upisRepo.save(noviUpisGodine);			
		}
		return null;
	}
	
	private ArrayList<UpisGodineDTO> mapToDTO(ArrayList<Object[]> upisaniStudenti){
		ArrayList<UpisGodineDTO> upisi = new ArrayList<UpisGodineDTO>();
		
		try {
			if (upisaniStudenti != null && upisaniStudenti.size() >0) {
				for (int i = 0; i < upisaniStudenti.size(); i++) {
					UpisGodineDTO upisDTO = new UpisGodineDTO();
					UpisGodine ug = (UpisGodine) upisaniStudenti.get(i)[0];
					upisDTO.setEspbStecenoUkupno(ug.getEspbStecenoUkupno());
					upisDTO.setGodinaUpisa(ug.getGodinaUpisa());
					upisDTO.setStudijskiProgram(ug.getStudijskiProgram());
					upisDTO.setStudentSV20(new StudentSV20(ug.getStudent(),
											(StudentSrednjaSkola) upisaniStudenti.get(i)[2],
											(StudentDetalji) upisaniStudenti.get(i)[1]));					
					upisi.add(upisDTO);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return upisi;
	}

}
