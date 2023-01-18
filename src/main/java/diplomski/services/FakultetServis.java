package diplomski.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import diplomski.models.Fakultet;
import diplomski.repositories.FakultetRepository;

@Service
public class FakultetServis {	
	
	@Autowired
	private FakultetRepository fakultetRepo;
	
	public FakultetServis() {}
	
	public Iterable<Fakultet> getFakulteti() {
        return fakultetRepo.findAll();
    }

    public Optional<Fakultet> getFakultetById(Long id) {
        return fakultetRepo.findById(id);
    }
    
    public Optional<Fakultet> getFakultetByNaziv(String nazivFakulteta) {
        return fakultetRepo.findByNaziv(nazivFakulteta);
    }

    public void addFakultet(Fakultet fakultet) {
    	fakultetRepo.save(fakultet);
    }

}
