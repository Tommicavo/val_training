<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.bean.UtenteBean" %>
<%@ page import="model.bean.GruppoBean" %>

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
		<% GruppoBean gruppoBean = (GruppoBean) request.getAttribute("gruppo"); %>

		<div class="card mx-auto" style="width: 18rem;">
			<div class="card-body">
				<h5 class="card-title"><%=utente.getIdUtente()%> - <%=utente.getNomeUtente()%> <%=utente.getCognomeUtente()%></h5>
				<div class="email py-3">
					<span>Email: </span>
					<span><%=utente.getEmailUtente()%></span>
				</div>
				<div class="info py-3">
					<span>Informazioni Generali: </span>
					<span><%=utente.getInformazioniGeneraliUtente()%></span>
				</div>
				<div class="responsabileTab py-3">
					<% if (utente.getIdGruppo() == 0) { %>
						<form action="/val_training_test/GruppoServlet" method="GET" novalidate>
							<input type="hidden" name="idResponsabile" value="<%=utente.getIdUtente()%>">
							<button type="submit" class="btn btn-success">Crea Gruppo</button>
						</form>
					<% } else { %>
						<div>
							<span>Fai parte del gruppo </span>
							<span> <%= gruppoBean.getNomeGruppo() %> </span>
						</div>
					<% } %>
				</div>
				<div class="d-flex justify-content-between">
					<a class="btn btn-primary" href="index.jsp">Home Page</a>
					<a class="btn btn-success" href="index.jsp">Scarica Pdf</a>
				</div>
			</div>
		</div>					
	</div>
</body>
</html>
