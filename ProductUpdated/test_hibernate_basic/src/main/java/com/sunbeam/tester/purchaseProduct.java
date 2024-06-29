package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;

public class purchaseProduct {

	public static void main(String[] args) {
		try(SessionFactory sf=getFactory()){
			Scanner sc = new Scanner(System.in);
			ProductDao prod=new ProductDaoImpl();
			System.out.println("Enter product id ,Quantity");
			
			System.out.println(prod.purchaseProduct(sc.nextLong(),sc.nextInt()));
			
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}		

	}

}
