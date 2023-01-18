package diplomski.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import diplomski.models.StudentSrednjaSkola;

@Repository
public interface StudentSrednjaSkolaRepository extends JpaRepository <StudentSrednjaSkola, Long>{

	@Query("SELECT skola FROM StudentSrednjaSkola skola WHERE skola.student.id = ?1")
	StudentSrednjaSkola getByStudentID(Long studentID);
}
