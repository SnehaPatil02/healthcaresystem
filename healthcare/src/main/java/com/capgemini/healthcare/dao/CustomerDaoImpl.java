package com.capgemini.healthcare.dao;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;


import org.springframework.stereotype.Repository;
import com.capgemini.healthcare.dto.CustomerDto;
import com.capgemini.healthcare.exception.DiagnosticCenterException;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	
		@PersistenceUnit
		private EntityManagerFactory entityManagerFactory;
		@Override
		public boolean registerUser(CustomerDto dto) {
			EntityManager entityManager = null;
			EntityTransaction transaction = null;
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			try {
				entityManager = entityManagerFactory.createEntityManager();
				transaction = entityManager.getTransaction();
				transaction.begin();
				entityManager.persist(dto);
				transaction.commit();
				return true;
			}catch(Exception e) {
				System.out.println(e.getMessage());
				transaction.rollback();
				
			}
			entityManager.close();

			
			throw new DiagnosticCenterException("This User is not present");
		}

}
