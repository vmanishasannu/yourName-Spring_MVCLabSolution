package com.gl.lab;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CollegeServiceImpl implements CollegeServiceInf{

	private SessionFactory sessionFactory;

	// create session
	private Session session;
	
	@Autowired
	void CollegeServiceInf(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}


	}

	@Transactional
	public List<CollegeModel> findAll() {
		Transaction tx = session.beginTransaction();

		// find all the records from the database table
		//List<CollegeModel> college=session.createQuery("from college",CollegeModel.class).list();
		List<CollegeModel> college=session.createQuery("from CollegeModel", CollegeModel.class).list();
		tx.commit();

		return college;
	}

	@Transactional
	public void save(CollegeModel theCollege) {
		Transaction tx = session.beginTransaction();
		// save transaction
		session.saveOrUpdate(theCollege);


		tx.commit();
		
	}

	@Transactional
	public void UpdateById(CollegeModel college) {
		Transaction tx = session.beginTransaction();

		// get transaction
		CollegeModel mycollege = college;

		// Update record
		session.saveOrUpdate(mycollege);

		tx.commit();
		
	}

	@Transactional
	public void deleteById(int theId) {
		Transaction tx = session.beginTransaction();

		// get transaction
		CollegeModel college = session.get(CollegeModel.class, theId);

		// delete record
		session.delete(college);

		tx.commit();
		
	}

	@Override
	public CollegeModel findById(int id) {
		CollegeModel college = new CollegeModel();
		Transaction tx = session.beginTransaction();

		// find record with Id from the database table
		college = session.get(CollegeModel.class, id);

		tx.commit();


		return college;
	}
	
}

