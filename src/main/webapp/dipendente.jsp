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
		<h2 class="text-center text-danger py-3">Dettagli Dipendente</h2>
		
		<% UtenteBean utente=(UtenteBean)request.getAttribute("utente"); %>
		<% GruppoBean gruppoBean = (GruppoBean) request.getAttribute("gruppo"); %>

		<div class="card mx-auto" style="width: 18rem;">
			<div class="card-body">
				<h5 class="card-title"><%=utente.getIdUtente()%> - <%=utente.getNomeUtente()%> <%=utente.getCognomeUtente()%></h5>
				<div class="email">
					<span>Email: </span>
					<span><%=utente.getEmailUtente()%></span>
				</div>
				<div class="info py-4">
					<span>Informazioni Generali: </span>
					<span><%=utente.getInformazioniGeneraliUtente()%></span>
				</div>
				<% if (utente.getIdGruppo() == 0) { %>
					<div>
						<span>Non fai parte di un gruppo </span>
					</div>
				<% } else { %>
					<div>
						<span>Fai parte del gruppo: </span>
						<span><strong> <%= gruppoBean.getNomeGruppo() %> </strong></span>
					</div>
				<% } %>
				<div class="d-flex justify-content-between pt-4">
					<a class="btn btn-primary" href="index.jsp">Home Page</a>
					<form action="/val_training_test/PdfServlet" method="GET" novalidate>
						<input type="hidden" name="idUtente" value="<%=utente.getIdUtente()%>">
						<input type="hidden" name="idGruppo" value="<%=gruppoBean.getIdGruppo()%>">
						<button type="submit" class="btn btn-success">Scarica Pdf</button>
					</form>
				</div>
			</div>
		</div>				
	</div>
</body>
</html>