<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="com.entity.Expense"%>
<%@page import="java.util.List"%>
<%@page import="com.db.HibernateUtil"%>
<%@page import="com.dao.ExpenseDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="../component/all_css.jsp"%>
</head>
<body>
	<%@include file="../component/navbar.jsp"%>
	<%
	if (u == null) {
		response.sendRedirect("../login.jsp");
	}
	%>
	<div class="container">
		<div class="row">
			<div class="col-md-8 offset-md-2">
				<div class="card">
					<div class="card-header text-center">
						<p class="fs-3">All Expenses</p>
						<%
						String message = (String) session.getAttribute("msg");
						if (message != null) {
						%>
						<strong style="margin-top: 5px; font-size: large; color: green"><%=message%></strong>
						<%
						session.removeAttribute("msg");
						}
						%>
					</div>
					<div class="card-body">
						<table class="table">
							<thead>
								<tr>
									<th scope="col">Title</th>
									<th scope="col">Description</th>
									<th scope="col">Date</th>
									<th scope="col">Time</th>
									<th scope="col">Price</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>
								<%
								ExpenseDao dao = new ExpenseDao(HibernateUtil.getSessionFactory());
								List<Expense> lst = dao.getAllExpenses(u);
								for (Expense e : lst) {
								%>
								<tr>
									<td><%=e.getTitle()%></td>
									<td><%=e.getDescription()%></td>
									<td><%=e.getDate()%></td>
									<td><%=e.getTime()%></td>
									<td><%=e.getPrice()%></td>
									<td><a href="edit_expense.jsp?id=<%=e.getId()%>"
										class="btn btn-sm btn-primary me-1">Edit</a> <a href="../deleteExpense?id=<%=e.getId()%>"
										class="btn btn-sm btn-danger me-1">Delete</a></td>
								</tr>
								<%
								}
								%>

							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>