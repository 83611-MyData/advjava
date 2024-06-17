package com.sunbeam.tester;
import static com.sunbeam.utils.HibernateUtils.getFactory;


import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoImpl;
import com.sunbeam.entity.Role;
import com.sunbeam.entity.User;


public class RegisterUser {

	public static void main(String[] args) {
		try(SessionFactory sf = getFactory();
				Scanner sc = new Scanner(System.in);
				) 
		{
			UserDao dao= new UserDaoImpl();
			System.out.println("Enter User Details Firstname, String lastName, \n" + "String email, String Password, LocalDate Dob, double regAmount, \n" + "Role role");
			
			User newUser=new User(sc.next(), sc.next(), sc.next(), sc.next(),
					LocalDate.parse(sc.next()), sc.nextDouble(), 
					Role.valueOf(sc.next().toUpperCase()));
			System.out.println(dao.signUp(newUser));
			}
		catch (Exception e)
		{e.printStackTrace();}
	}
	
}
