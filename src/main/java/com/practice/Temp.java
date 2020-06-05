package com.practice;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.practice.model.Record;

public class Temp {
	SessionFactory factory;
	public Temp() {
		Configuration configuration = new Configuration();
		configuration.configure();
		configuration.addAnnotatedClass(Record.class);
		this.factory = configuration.buildSessionFactory(); 
	}
	public void insert(Record record) {
		
		Session session = factory.openSession();
		Transaction transaction = null;
		int id = 0;
		
		try {
			transaction = session.beginTransaction();
			id = (int)session.save(record);
			transaction.commit();
		} catch(Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	public void delete(int id) {
		Session session = factory.openSession();
		Transaction transaction = null;
		Record record = (Record)session.get(Record.class, id);
		try {
			transaction = session.beginTransaction();
			session.delete(record);
			transaction.commit();
		} catch(Exception e) {
			if(transaction!=null) {
			transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	public void update() {
		
	}
	public void list() {
		
	}
}
