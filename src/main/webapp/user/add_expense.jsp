<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Expense Tracker</title>
<%@include file="../component/all_css.jsp"%>
<style type="text/css">
.card-sh {
	box-shadow: 0 0 6px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body class="bg-light">
	<%@include file="../component/navbar.jsp"%>
	<%if(u == null){
		response.sendRedirect("../login.jsp");	
	}
	%>
	<div class="container p-4">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card card-sh">
					<div class="card-header">
						<p class="text-center fs-3">Add Expense</p>
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
						<form action="../addExpense" method="post">
							<div class="mb-3">
								<label>Title</label> <input type="text" name="title"
									class="form-control" required>
							</div>

							<div class="mb-3">
								<label>Date</label> <input type="date" name="date"
									class="form-control" required>
							</div>

							<div class="mb-3">
								<label>Time</label> <input type="time" name="time"
									class="form-control" required>
							</div>

							<div class="mb-3">
								<label>Description</label> <input type="text" name="description"
									class="form-control" required>
							</div>

							<div class="mb-3">
								<label>Price</label> <input type="text" name="price"
									class="form-control" required>
							</div>

							<button class="btn btn-success col-md-4 offset-md-4">Add</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>