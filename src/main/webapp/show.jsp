<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ page import="model.bean.UtenteBean" %>

		<!DOCTYPE html>
		<html lang="en">

		<head>
			<meta charset="UTF-8">
			<meta name="viewport" content="width=device-width, initial-scale=1.0">
			<title>Show User Info</title>
			<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
		</head>

		<body>
			<h2 class="text-center text-danger">Dettagli Utente</h2>

			<% UtenteBean utente=(UtenteBean)request.getAttribute("utente"); %>

				<p>
					ID:
					<%=utente.getIdUtente()%>
				</p>
				<p>
					Name:
					<%=utente.getNomeUtente()%>
				</p>
				<p>
					Email:
					<%=utente.getEmailUtente()%>
				</p>

		</body>

		</html>