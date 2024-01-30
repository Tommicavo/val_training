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
	<div class="container">
		<h2 class="text-center text-danger py-3">Dettagli Responsabile</h2>
		
		<% UtenteBean utente=(UtenteBean)request.getAttribute("utente"); %>

		<div class="card mx-auto" style="width: 18rem;">
			<div class="card-body">
				<h5 class="card-title"><%=utente.getIdUtente()%> - <%=utente.getNomeUtente()%> <%=utente.getCognomeUtente()%></h5>
				<p class="card-text"><%=utente.getInformazioniGeneraliUtente()%></p>
				<a class="btn btn-primary" href="index.jsp">Home Page</a>
			</div>
		</div>				
	</div>
</body>
</html>