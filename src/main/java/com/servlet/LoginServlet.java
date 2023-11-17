package com.servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.dao.UserDao;
import com.db.HibernateUtil;
import com.entity.User;

import jakarta.servlet.annotation.WebServlet;

/**
 * Servlet implementation class LoginServlet
 */

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserDao dao = new UserDao(HibernateUtil.getSessionFactory());
		User u = dao.login(email, password);
		
		HttpSession session = request.getSession();
		if(u == null) {
			session.setAttribute("msg", "Invalid username or password");
			response.sendRedirect("login.jsp");
		}
		else {
			session.setAttribute("user",u);
			response.sendRedirect("./user/home.jsp");			
		}
	}

}
