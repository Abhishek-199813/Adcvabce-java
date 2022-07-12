package webprojectday09a;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class GenericDao {
	public void save(Object obj)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-Hibernate");
		try {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		em.merge(obj);
		tx.commit();
		
		}
		finally {
			emf.close();
			
		}
		
	}

	public Object fetchById(Class clazz,Object pk) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-Hibernate");
		
		try{
		EntityManager em = emf.createEntityManager();
		Object obj = em.find(clazz, pk);
		return obj;	
		}
		finally {
			emf.close();
		}
			
	}
	
	
	public void Delete(Class clazz, Object pk) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-Hibernate");
		try {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Object obj = em.find(clazz, pk);
		em.remove(obj);
		tx.commit();
		
		}
		finally {
			emf.close();
		}
	}
	
	/*
	public List<Song> fetchDetails(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-Hibernate");
		try {
			EntityManager em = emf.createEntityManager();
		
			List<Song>  list = em.createQuery("SELECT a FROM Song a", Song.class).getResultList();
			
			System.out.println(list);
		}
		finally {
			emf.close();
		}
		return null;
	}
	*/
	
	
}
