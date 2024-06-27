package com.sunbeam.dao;
import org.hibernate.*;
import java.io.Serializable;
import static com.sunbeam.utils.HibernateUtils.getFactory;
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

}
