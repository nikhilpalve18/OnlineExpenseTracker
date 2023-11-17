<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="component/all_css.jsp"%>
<style type="text/css">
.card-sh {
	box-shadow: 0 0 6px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body class="bg-light">
	<%@include file="component/navbar.jsp"%>
	<div class="container p-4">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card card-sh">
					<div class="card-header">
						<p class="text-center fs-3">Login here</p>
						<%
						String message = (String) session.getAttribute("msg");
						if (message != null) {
						%>
						<strong style="margin-top: 5px; font-size: large; color: red"><%=message%></strong>
						<%
						session.removeAttribute("msg");
						}
						%>
					</div>

					<div class="card-body">
						<form action="login" method="post">


							<div class="mb-3">
								<label>Email</label> <input type="email" name="email"
									class="form-control" required>
							</div>

							<div class="mb-3">
								<label>Password</label> <input type="password" name="password"
									class="form-control" required>
							</div>



							<button class="btn btn-success col-md-4 offset-md-4">Login</button>
							<div class="text-center mt-2">
								Don't have an account <a href="register.jsp"
									class="text-decoration-none">Create one?</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>