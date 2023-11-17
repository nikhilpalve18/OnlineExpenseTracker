package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.dao.UserDao;
import com.db.HibernateUtil;
import com.entity.User;

@WebServlet("/userRegister")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fullName = request.getParameter("fullName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String about = request.getParameter("about");
		
		User u = new User(fullName, email, password, about);
		System.out.println(u);
		
		UserDao dao = new UserDao(HibernateUtil.getSessionFactory());
		boolean b = dao.saveUser(u);
		
		HttpSession httpSession = request.getSession();
		if(b) {
			httpSession.setAttribute("msg", "Registeration successful");
			response.sendRedirect("register.jsp");
			
		}else {
			httpSession.setAttribute("msg", "Something went wrong");
			response.sendRedirect("register.jsp");	
		}
		
	}

}
