package com.servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.dao.ExpenseDao;
import com.dao.UserDao;
import com.db.HibernateUtil;
import com.entity.User;

import jakarta.servlet.annotation.WebServlet;

/**
 * Servlet implementation class LoginServlet
 */

@WebServlet("/deleteExpense")
public class DeleteExpenseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		ExpenseDao dao = new ExpenseDao(HibernateUtil.getSessionFactory());
		boolean flag = dao.deleteExpense(id);
		
		HttpSession session = request.getSession();
		if(flag) {
			session.setAttribute("msg", "Expense deleted successfully");
			response.sendRedirect("user/view_expense.jsp");
		}
		else {
			session.setAttribute("msg","Something went wrong");			
			response.sendRedirect("user/view_expense.jsp");
		}		
	}

}
