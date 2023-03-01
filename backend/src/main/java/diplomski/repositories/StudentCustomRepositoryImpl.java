package diplomski.repositories;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import diplomski.models.Student;

@Repository
public class StudentCustomRepositoryImpl implements StudentCustomRepository {
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public Collection<Student> pretraziStudente(String ime, String prezime, String brojIndeksa) {

		Session session = entityManager.unwrap(Session.class);
		CriteriaBuilder builder = session.getCriteriaBuilder();

		CriteriaQuery<Student> criteria = builder.createQuery(Student.class);

		Root<Student> myObjectRoot = criteria.from(Student.class);
		ArrayList<Predicate> predicates = new ArrayList<Predicate>();

		if (ime != null && ime != "") {
			Predicate likeRestrictionFirstName = builder.and(builder.like(myObjectRoot.get("ime"), "%" + ime + "%"));
			predicates.add(likeRestrictionFirstName);
		};
		if (prezime != null && prezime != "") {
			Predicate likeRestrictionLastName = builder.and(builder.like(myObjectRoot.get("prezime"), "%" + prezime + "%"));
			predicates.add(likeRestrictionLastName);
		};
		if (brojIndeksa != null && brojIndeksa != "") {
			Predicate indexRestriction = builder.and(builder.like(myObjectRoot.get("brojIndeksa"), "%" + brojIndeksa + "%"));
			predicates.add(indexRestriction);
		};

		Collection<Student> results = entityManager.createQuery(criteria.where(predicates.toArray(new Predicate[0]))).getResultList();
		return results;

	}
}
