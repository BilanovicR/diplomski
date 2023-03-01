package diplomski.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import diplomski.models.StudentDetalji;

@Repository
public interface StudentDetaljiRepository extends JpaRepository<StudentDetalji, Long> {

	@Query("SELECT sd FROM StudentDetalji sd WHERE sd.student.id = ?1")
	StudentDetalji findByStudentId(Long studentId);
}
