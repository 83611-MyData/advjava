package com.sunbeam.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.io.Serializable;

import com.sunbeam.entity.User;

public class UserDaoImpl implements UserDao {

	@Override
	public String signUp(User user) {
		String mesg="user registration failed";
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			Serializable userId = session.save(user);
			tx.commit();
			mesg="user successfully registered with Id,"+userId;
		} catch (RuntimeException e) 
		{
			if(tx !=null)
				tx.rollback();
			throw e;
		}
		// TODO Auto-generated method stub
		return mesg;
	}

	@Override
	public User getUserDetailsById(Long userId) {
		User user = null;
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			user=session.get(User.class, userId);
			
			tx.commit();
			
		} catch (RuntimeException e) {
			if(tx!= null)
				tx.rollback();
			throw e;
		}
		// TODO Auto-generated method stub
		return user;
	}

	
	
	
}
