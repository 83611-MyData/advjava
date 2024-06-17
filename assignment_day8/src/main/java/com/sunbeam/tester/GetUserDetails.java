package com.sunbeam.tester;
import static com.sunbeam.utils.HibernateUtils.getFactory;
import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoImpl;
import java.util.Scanner;

import org.hibernate.SessionFactory;
public class GetUserDetails {
	
	public static void main(String[] args) {
		try(SessionFactory sf = getFactory();
				Scanner sc = new Scanner(System.in))
		{
			UserDao dao = new UserDaoImpl();
			System.out.println("Enter User ID");
			
			System.out.println(dao.getUserDetailsById(sc.nextLong()));
			
			
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
