package com.sunbeam.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunbeam.entities.Category;
import com.sunbeam.entities.Product;
import com.sunbeam.utils.HibernateUtils;


public class ProductDaoImpl implements ProductDao {

	@Override
	public String addProduct(Long categoryId, Product newProduct) {
		String mseg="Product Not added";
		// 1. get session from SF (getCurrentSession)
				Session session=HibernateUtils.getFactory().getCurrentSession();
				//2. Begin a Tx
				Transaction tx=session.beginTransaction();
				try {
					//3. get category from it's id -
					Category category=session.get(Category.class, categoryId);
					if(category != null)
					{
						//valid category - persistent
						//4. establish bi-directional association between Category
						category.addProduct(newProduct); // state of the category(persistent) 
						mseg="Added the product";
					}
					tx.commit();
					// session.flush() -> dirty Checking -> category is modified -> new product entity added.
					//hibernate: add the product
				} catch (RuntimeException e) {
					if(tx != null)
						tx.rollback();
					//re throw the exc to the caller
					throw e;
				}
		return mseg;
	}
	
	@Override
	public List<Product> getAllProducts() {
		List<Product> products = null;
		String jpql = "select p from Product p";
		// 1. get session from SF (getCurrentSession)
		Session session = HibernateUtils.getFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			products = session.createQuery(jpql, Product.class).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exc to the caller
			throw e;
		}
		return products;
	}

	@Override
	public Product getProductDetails(Long productId) {
		Product product = null;
		// 1. get session from SF (getCurrentSession)
		Session session = HibernateUtils.getFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			product = session.get(Product.class, productId);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exc to the caller
			throw e;
		}
		return product;
	}

	@Override
	public String purchaseProduct(Long productId, int qty) {
		String mesg = "purchase product failed !";
		// 1. get session from SF (getCurrentSession)
		Session session = HibernateUtils.getFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			Product product = session.get(Product.class, productId);
			if (product != null && product.getAvailableQty() >= qty) {
				product.setAvailableQty(product.getAvailableQty() - qty);
				mesg = "product purchased!";
			}
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exc to the caller
			throw e;
		}
		return mesg;
	}


}
