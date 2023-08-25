package dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entity.Student;
import jakarta.persistence.EntityManager;

@Repository
public class StudentDAOImpl implements StudentDAO {

	// define field for entity manager
	private EntityManager entityManager;

	// inject entity manager using constructor injection
	@Autowired
	public StudentDAOImpl(EntityManager entity) {
		entityManager = entity;
	}

	// implement the save method
	@Override
	@Transactional
	public void save(Student theStudent) {
		entityManager.persist(theStudent);
	}

}
