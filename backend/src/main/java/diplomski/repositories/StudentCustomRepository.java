package diplomski.repositories;

import java.util.Collection;

import diplomski.models.Student;

public interface StudentCustomRepository {

	Collection<Student> pretraziStudente(String ime, String prezime, String brojIndeksa);
}
