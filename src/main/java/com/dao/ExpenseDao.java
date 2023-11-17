package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.entity.Expense;
import com.entity.User;

public class ExpenseDao {
	private SessionFactory factory = null;
	private Session session = null;
	private Transaction tx = null;
	
	public ExpenseDao(SessionFactory factory) {
		super();
		this.factory = factory;
	}
	
	// Adding the Expense
	public boolean saveExpense(Expense e) {
		boolean flag = false;
		
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			
			session.save(e);
			tx.commit();
			flag = true;
		}
		catch(Exception ex) {
			if(tx!=null) {
				ex.printStackTrace();
			}
		}
		
		return flag;
	}
	
	// Updating the Expense
	public boolean updateExpense(Expense e) {
		boolean flag = false;
		
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			
			session.saveOrUpdate(e);
			tx.commit();
			flag = true;
		}
		catch(Exception ex) {
			if(tx!=null) {
				ex.printStackTrace();
			}
		}
		
		return flag;
	}
	
	// Deleting the Expense
	public boolean deleteExpense(int id){
		boolean flag = false;
		
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			
			Expense e = session.get(Expense.class, id);
			session.delete(e);
			tx.commit();
			flag = true;
		}
		catch(Exception ex) {
			if(tx!=null) {
				ex.printStackTrace();
			}
		}
		
		return flag;
	}
	
	
	// get all expenses
	public List<Expense> getAllExpenses(User u){
		List<Expense> lst = new ArrayList<Expense>();
		try {
			session = factory.openSession();
			Query q = session.createQuery("from Expense where user=:us");
			q.setParameter("us", u);
			lst = q.list();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return lst;
	}
	
	
	// get expense by Id
	public Expense getExpenseById(int id) {
		Expense e = null;
		try {
			session = factory.openSession();
			Query q = session.createQuery("from Expense where id=:id");
			q.setParameter("id", id);
			e = (Expense) q.uniqueResult();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return e;
	}
	
}



















