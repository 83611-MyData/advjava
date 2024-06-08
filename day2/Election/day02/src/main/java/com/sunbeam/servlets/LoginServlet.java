package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entity.User;

public class LoginServlet extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(req, resp);
	}

	private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = req.getParameter("email");
		String pwd = req.getParameter("pwd");
		try(UserDao userdao = new UserDaoImpl()) {
			
 			User user = userdao.findByEmail(email);
 			if(user != null && user.getPassword().equals(pwd)) {
 			
 				if(user.getRole().equals("voter")) {
 					resp.sendRedirect("candlist");
 		 				}
 				else {
 					resp.sendRedirect("result");
 				}
 				}
 			else {
 			
 				resp.setContentType("text/html");
 				PrintWriter out = resp.getWriter();
 				out.println("<html>");
 				out.println("<head>");
 				out.println("<title>login has failed</title>");
 				out.println("</head>");
 				out.println("<body>");
 				out.println("invalid email/password <br/><br/>");
 				out.println("<a href='index.html'>login again</a>");
 				out.println("</body>");
 				out.println("</html>");
 			}
 		}
 		catch (Exception e) {
 			e.printStackTrace();
 			throw new ServletException(e);
 					}
 	}


	}

