package com.practice.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.practice.model.Record;

public class Operations {
	private SessionFactory factory;
	public Operations() {
		Configuration configuration = new Configuration();
		configuration.configure();
		configuration.addAnnotatedClass(Record.class);
		this.factory = configuration.buildSessionFactory();
	}

	public int insert(Record record) {
		Session session = factory.openSession();
		Transaction transaction = null;
		int id = 0;

		try {
			transaction = session.beginTransaction();
			id = (int) session.save(record); 
			transaction.commit();
		} catch (Exception e) {
			if (transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}

		return id;
	}
	public void update(int id,String name){
		Session session = factory.openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			Record record = (Record)session.get(Record.class, id); 
			record.setName(name);
			session.update(record); 
			transaction.commit();
		} catch (Exception e) {
			if (transaction!=null) transaction.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
	}
	public void delete(int id){
		Session session = factory.openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			Record record = (Record)session.get(Record.class, id); 
			session.delete(record); 
			transaction.commit();
		} catch (Exception e) {
			if (transaction!=null) transaction.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
	}
	public List<Record> list() {
		Session session = factory.openSession();
		try {
			return session.createCriteria(Record.class).list();
		} catch (Exception e) {
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
		
		return new ArrayList<Record>();
	}
}
