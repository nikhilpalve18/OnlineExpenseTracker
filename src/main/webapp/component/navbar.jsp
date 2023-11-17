<%@page import="com.entity.User"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-success">
	<div class="container-fluid">
		<a class="navbar-brand" href="#">Online Expense Tracker</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">

			<%
			User u = (User) session.getAttribute("user");
			if (u == null) {
			%>
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="index.jsp"><i
						class="fa-solid fa-house"></i> Home</a></li>
			</ul>
			<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					href="login.jsp"><i class="fa-solid fa-right-to-bracket"></i>
						Login</a></li>

				<li class="nav-item"><a class="nav-link active"
					href="register.jsp"><i class="fa-solid fa-user-plus"></i>
						Register</a></li>
			</ul>
			<%
			} else {
			%>
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="home.jsp"><i
						class="fa-solid fa-house"></i> Home</a></li>
				<li class="nav-item"><a class="nav-link active"
					href="add_expense.jsp"><i class="fa-solid fa-plus"></i> Add
						Expenses</a></li>
				<li class="nav-item"><a class="nav-link active"
					href="view_expense.jsp"><i class="fa-solid fa-list"></i> View
						Expenses</a></li>
			</ul>
			<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					href="login.jsp"><i class="fa-solid fa-user"></i> Welcome <strong
						style="margin-top: 5px; font-size: large;"><%=u.getEmail()%></strong></a></li>

				<li class="nav-item"><a class="nav-link active"
					href="../logout"><i class="fa-solid fa-right-from-bracket"></i>
						Logout</a></li>
			</ul>
			<%
			}
			%>

		</div>
	</div>
</nav>