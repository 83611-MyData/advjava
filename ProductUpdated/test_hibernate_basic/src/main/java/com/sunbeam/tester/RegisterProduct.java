package com.sunbeam.tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;
import com.sunbeam.entities.Category;
import com.sunbeam.entities.Product;
import com.sunbeam.utils.HibernateUtils;







public class RegisterProduct {

	public static void main(String[] args) {
		try (SessionFactory sf = HibernateUtils.getFactory();
				Scanner sc=new Scanner(System.in)
				) {
			//create dao instance
			ProductDao dao=new ProductDaoImpl();
			System.out.println("Enter Product details -category,product name,price ,available quantity");
			Product newProduct=new Product(Category.valueOf(sc.next().toUpperCase()),sc.next(), sc.nextDouble(), sc.nextInt()
					  
					);
			System.out.println(dao.registerProduct(newProduct));
		} //JVM : sc.close() , sf.close() -> DBCP will be cleaned up !
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
