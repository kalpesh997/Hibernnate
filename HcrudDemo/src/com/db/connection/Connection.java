package com.db.connection;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Connection {
	
	private static SessionFactory sf;
	
	@SuppressWarnings("deprecation")
	public static SessionFactory getConnection()
	{
		try
		{
			sf = new Configuration().configure().buildSessionFactory();						
		}
		catch(Exception ex)
		{
			System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);			
		}
		return sf;
	}
}
