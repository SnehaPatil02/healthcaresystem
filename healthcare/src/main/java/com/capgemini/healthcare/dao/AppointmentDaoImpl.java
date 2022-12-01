package com.capgemini.healthcare.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.healthcare.dto.AdminDto;
import com.capgemini.healthcare.dto.AppointmentDto;
import com.capgemini.healthcare.exception.AppointmentException;

@Repository
public class AppointmentDaoImpl implements AppointmentDao {
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	@Override
	public List<AppointmentDto> viewAllAppointments () {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;

		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		transaction.begin();
		try {
			String jpql = "from AppointmentDto";
			Query query = entityManager.createQuery(jpql);
			List<AppointmentDto> list = query.getResultList();
			return list;
		} catch (Exception e) {
			transaction.rollback();
		}
		entityManager.close();
		return null;
	}
	
	@Override
	public AppointmentDto getAppointment(String centerId, String dateTime) {
		
		EntityManager entityManager = null;
		EntityTransaction transaction = null;

		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		transaction.begin();
		try {
			String jpql = "from AppointmentDto where centerId=: centerId and dateTime=: dateTime";
			TypedQuery<AppointmentDto> query = entityManager.createQuery(jpql, AppointmentDto.class);
			query.setParameter("centerId", centerId);
	     	query.setParameter("dateTime", dateTime);
	     	AppointmentDto adto = query.getSingleResult();
	     	entityManager.close();
	     	return adto;
	}
	     catch (Exception e) {
	    	 return null;
	     }
		
	}

	@Override
	public AppointmentDto getAppointment(String appointmentId) {
		
		EntityManager entityManager = null;
		EntityTransaction transaction = null;

		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		transaction.begin();
		try {
			String jpql = "from AppointmentDto where appointmentId=: appointmentId";
			TypedQuery<AppointmentDto> query = entityManager.createQuery(jpql, AppointmentDto.class);
			query.setParameter("appointmentId", Integer.parseInt(appointmentId));
	     	AppointmentDto adto = query.getSingleResult();
	     	entityManager.close();
	     	return adto;
	}
	     catch (Exception e) {
	    	 System.out.println(e.getMessage());
	    	 return null;
	     }
		
	}

	@Override
	public AppointmentDto updateStatus(AppointmentDto aDto) {
		
		EntityManager entityManager=null;
		EntityTransaction transaction=null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.merge(aDto);
			transaction.commit();
			
			return aDto;
		}catch(Exception e) {
			transaction.rollback();
			
		}
		finally {
		entityManager.close();
		}
		return null;
		
	}

	

	
	
	@Override
	public boolean createAppointment(AppointmentDto aDto) {
		EntityManager entityManager=null;
		EntityTransaction transaction=null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(aDto);
			transaction.commit();
			
			return true;
		}catch(Exception e) {
			transaction.rollback();
			
		}
		finally {
		entityManager.close();
		}
		return false;

	}

}
