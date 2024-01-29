<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.HashMap"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	<h2>Login</h2>
	<div class="container">
		<h2 class="text-center py-3">Login</h2>

	<form action="<%=request.getContextPath()%>/login" method="POST">
		<label for="email">Email:</label> <input type="email" id="email"
			name="email" placeholder="Inserisci l'email"><br> <label
			for="password">Password:</label> <input type="password" id="password"
			name="password" placeholder="Inserisci la password"><br>
		<%
		Map<String, String> errorMessages = (Map<String, String>) request.getAttribute("errorMessages");
		%>
		<%
		if (errorMessages == null) {
			errorMessages = new HashMap<>();
		}
		%>

		<button type="submit">Login</button>
	</form>
		<%
		String unregisteredUtenteError = errorMessages.get("unregisteredUtenteError");
		%>
		<%
		if (unregisteredUtenteError != null && !unregisteredUtenteError.isEmpty()) {
		%>
		<div class="alert alert-warning d-flex justify-content-between align-items-center" role="alert">
			<div><%=unregisteredUtenteError%></div>
			<div><a class="btn btn-warning" href="signin.jsp">Signin</a></div>
		</div>
		<%
		}
		%>

		<form action="/val_training_test/LoginServlet" method="POST"
			novalidate>
			<div class="mb-3">
				<label class="form-label" for="email">Email:</label> <input
					class="form-control" type="email" id="email" name="email"
					placeholder="Inserisci l'email"
					value="<%=request.getParameter("email") != null ? request.getParameter("email") : ""%>">
				<% String invalidEmailError = errorMessages.get("invalidEmailError"); %>
				<% if (invalidEmailError != null && !invalidEmailError.isEmpty()) { %>
					<small class="text-danger"><%=invalidEmailError%></small>
				<% } %>
			</div>

			<div class="mb-3">
				<label class="form-label" for="password">Password:</label> <input
					class="form-control" type="password" id="password" name="password"
					placeholder="Inserisci la password"
					value="<%=request.getParameter("password") != null ? request.getParameter("password") : ""%>">
				<%
				String invalidPasswordError = errorMessages.get("invalidPasswordError");
				%>
				<%
				if (invalidPasswordError != null && !invalidPasswordError.isEmpty()) {
				%>
				<small class="text-danger"><%=invalidPasswordError%></small>
				<%
				}
				%>
			</div>

			<div class="d-flex justify-content-between">
				<button class="btn btn-success" type="submit">Login</button>
				<a class="btn btn-primary" href="index.jsp">Home Page</a>
			</div>
		</form>
	</div>
</body>
</html>
