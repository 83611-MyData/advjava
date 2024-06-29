package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;
import com.sunbeam.entities.Category;

public class GetProductsByCategoryAndPrice {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory();
				Scanner sc=new Scanner(System.in);
				) {
			
			ProductDao dao = new ProductDaoImpl();
			System.out.println("Enter Category And Price range");
			dao.getUsersByDobAndRole( Category.valueOf(sc.next().toUpperCase()),sc.nextDouble(),sc.nextDouble())
			.forEach(System.out::println);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
