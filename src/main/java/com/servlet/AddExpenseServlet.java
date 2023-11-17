package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.dao.ExpenseDao;
import com.db.HibernateUtil;
import com.entity.Expense;
import com.entity.User;

@WebServlet("/addExpense")
public class AddExpenseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		String description = request.getParameter("description");
		String price = request.getParameter("price");
		
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		
		Expense e = new Expense(title, date, time, description, price, u);
		
		ExpenseDao dao = new ExpenseDao(HibernateUtil.getSessionFactory());
		boolean b = dao.saveExpense(e);
		
		HttpSession httpSession = request.getSession();
		if(b) {
			httpSession.setAttribute("msg", "Expense added successfully");
			response.sendRedirect("user/add_expense.jsp");
			
		}else {
			httpSession.setAttribute("msg", "Something went wrong");
			response.sendRedirect("user/add_expense.jsp");	
		}
		
	}

}
