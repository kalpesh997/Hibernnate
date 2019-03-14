package com.db.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.db.model.User;
import com.db.connection.Connection;

public class Dao 
{
	/*Configuration con = new Configuration();
	con.configure("hibernate.cfn.hbm");
	@SuppressWarnings("deprecation")
	SessionFactory sf = con.buildSessionFactory();*/
	
	SessionFactory sf = Connection.getConnection();
	Session s = sf.openSession();
	
	public void insert(User u)
	{			
		u.setFname(u.getFname());
		u.setLname(u.getLname());
		u.setDate(u.getDate());
		u.setEmail(u.getEmail());		
		Transaction tr = s.beginTransaction();
		s.save(u);		
		tr.commit();		
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getAlluser()
	{
		List<User> l = new ArrayList<User>();
		Transaction t = null;
		try
		{
			t = s.getTransaction();
			t.begin();
			l = s.createQuery("from User").list();
			t.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return l;
	}
	
	public void updateUser(User u1)
	{
		Transaction t1 = s.getTransaction();
		t1.begin();
		Query q = s.createQuery("update User set fname=:n1,lname=:n2,date=:n3,email=:n4  where id=:i ");
		q.setParameter("n1",u1.getFname());
		q.setParameter("n2",u1.getLname());
		q.setParameter("n3",u1.getDate());
		q.setParameter("n4",u1.getEmail());
		q.setParameter("i",u1.getId());
		q.executeUpdate();
		t1.commit();		
	}
	
	public void daleteUser(int id)
	{
		Transaction t2 = s.getTransaction();
		t2.begin();
		Query q1 = s.createQuery("delete from User where id=:i");
		q1.setParameter("i",id);
		q1.executeUpdate();
		t2.commit();
	}
	
	public User getByIduser(int id)
	{
		User u = new User();
		Transaction t3 = null;
		try
		{
			t3 = s.getTransaction();
			t3.begin();
			Query q3 = s.createQuery("from User where id="+id);
			u = (User)q3.uniqueResult();
			t3.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return u;
	}
}