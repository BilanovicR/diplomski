package diplomski.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import diplomski.models.UpisGodine;

@Repository
public interface UpisGodineRepository extends JpaRepository <UpisGodine, Long> {
	
	@Query("SELECT upis, sd, sss FROM UpisGodine upis, StudentDetalji sd, StudentSrednjaSkola sss WHERE upis.godinaUpisa = ?1 AND upis.studijskiProgram.naziv = ?2 and sd.student = upis.student and sss.student= upis.student")
	ArrayList<Object[]> findByGodinaUpisaAndStudijskiProgram(String godinaUpisa, String nazivStudijskogPrograma);
	
	@Query("SELECT upis FROM UpisGodine upis WHERE upis.godinaUpisa = ?1 AND upis.studijskiProgram.naziv = ?2")
	ArrayList<UpisGodine> getByGodinaUpisaAndStudijskiProgram(String godinaUpisa, String nazivStudijskogPrograma);

	@Query("SELECT upis, sd, sss FROM UpisGodine upis, StudentDetalji sd, StudentSrednjaSkola sss WHERE upis.godinaUpisa = ?1 and sd.student = upis.student and sss.student= upis.student")
	ArrayList<Object[]> findAllByGodinaUpisa(String godinaUpisa);

}
