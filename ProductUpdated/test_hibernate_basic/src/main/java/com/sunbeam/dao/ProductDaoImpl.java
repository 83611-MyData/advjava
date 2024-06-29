package com.sunbeam.dao;
import org.hibernate.*;
import java.io.Serializable;
import java.util.List;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import com.sunbeam.entities.Category;
import com.sunbeam.entities.Product;

public class ProductDaoImpl implements ProductDao{

	@Override
	public String registerProduct(Product product) {
		String mesg="product registration failed!!!!";
		
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			
			Serializable productId = session.save(product);
			
			tx.commit();
			mesg="product registered successfully , with ID"+productId;
		} catch (RuntimeException e) {
			
			if(tx != null)
				tx.rollback();
			
			throw e;
		}
		return mesg;
	}

	@Override
	public Product getProductDetails(Long productId) {
		
		Product product=null;
				Session session=getFactory().getCurrentSession();
	
		Transaction tx=session.beginTransaction();
		try {
		
			product=session.get(Product.class, productId);
			product=session.get(Product.class, productId);
			product=session.get(Product.class, productId);
			product=session.get(Product.class, productId);
			tx.commit();
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			
			throw e;
		}
		return product;
	}

	@Override
	public String applyDiscount(Category category,double discount) {
		String mesg = "applying discount failed !!!!";
		String jpql = "update Product p set p.price=p.price-:disc  where p.category =:pt";
		// 1. get Session from SessionFactory
		Session session = getFactory().getCurrentSession();
		// 2. begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			int rows = session.createQuery(jpql).setParameter("disc", discount).setParameter("pt",category).executeUpdate();
			tx.commit();
			mesg = "Applied discount to products - " + rows;
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the same exc to the caller
			throw e;
		}

		return mesg;

		
	}

	@Override
	public List<Product> getAllProducts() {
	
		String jpql = "select p from Product p";
		List<Product> product = null;
		
		Session session = getFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		try {
			product = session.createQuery(jpql, Product.class).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the same exc to the caller
			throw e;
		}
		return product;

	}

	@Override
	public List<Product> getUsersByDobAndRole(Category category, double Sprice,double Eprice) {
		String jpql = "select p from Product p where p.price between :start and :end and p.category=:pl";
		List<Product> product = null;
		// 1. get Session from SessionFactory
		Session session = getFactory().getCurrentSession();
		// 2. begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			product = session.createQuery(jpql, Product.class).setParameter("pl", category).setParameter("start", Sprice).setParameter("end", Eprice)
					.getResultList();
			// users - list of PERSISTENT entities
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the same exc to the caller
			throw e;
		}

		return product;
	}
	
	@Override
public String purchaseProduct(Long id, int reqquantity) {
		
		Product p=null;
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		String mess="Purchase Failed";
		
		try {
			p=session.get(Product.class, id);
			if(p.getAvailable_quantity()>0 && reqquantity <= p.getAvailable_quantity()) {
			
				int newquan= p.getAvailable_quantity()- reqquantity;
				p.setAvailable_quantity(newquan);
			tx.commit();
			mess="Item Purchased";
			}
			else {
				mess="Requested Quantity Not available";
			}
			
		}
		catch(RuntimeException e)
		{
			if(tx!=null)
				tx.rollback();
			
			throw e;
			
		}
		return mess;
	}

	@Override
	public String deleteProductDetails(Long id) {
		
		String mesg = "deletion failed";
		
		Session session = getFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		try {
			// get Product from it's id
			Product product = session.get(Product.class, id);
			// chk if it exists
			if (product != null) {
				
				session.delete(product);
				mesg = "product details deleted...";
			}
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			
			throw e;
		}

		return mesg;
	}
		
}
