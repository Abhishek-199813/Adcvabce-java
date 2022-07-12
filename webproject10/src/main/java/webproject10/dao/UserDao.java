package webproject10.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import webproject10.entity.User;

@Component
public class UserDao {
	@PersistenceContext
	private EntityManager entitymanager;
	
	@Transactional
	public void add(User user)
	{
		entitymanager.persist(user);
	}
}
