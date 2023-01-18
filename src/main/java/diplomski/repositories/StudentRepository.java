package diplomski.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import diplomski.models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
	Optional<Student> findById(Long id);

	Optional<Student> findByBrojIndeksa(String brojIndeksa);

}
