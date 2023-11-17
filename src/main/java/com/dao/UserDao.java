package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.entity.User;

public class UserDao {
	private SessionFactory factory = null;
	private Session session = null;
	private Transaction tx = null;
	
	public UserDao(SessionFactory factory) {
		super();
		this.factory = factory;
	}
	
	
	// Registering the user
	public boolean saveUser(User u) {
		boolean flag = false;
		
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			
			session.save(u);
			tx.commit();
			flag = true;
		}
		catch(Exception e) {
			if(tx!=null) {
				e.printStackTrace();
			}
		}
		
		return flag;
	}
	
	// Login for user
	public User login(String email, String password) {
		User u = null;
		
		session = factory.openSession();
		Query q = session.createQuery("from User where email=:em and password=:ps");
		q.setParameter("em", email);
		q.setParameter("ps", password);
		
		u = (User) q.uniqueResult();
		
		return u;
	}
	
	
	
	
}
