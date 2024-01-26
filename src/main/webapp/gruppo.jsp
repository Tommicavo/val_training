<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.bean.UtenteBean" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.HashMap"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Crea un nuovo gruppo</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h2 class="text-center text-danger py-3">Crea un nuovo gruppo</h2>

        <% String idResponsabile = (String) request.getAttribute("idResponsabile"); %>
        <% List<UtenteBean> utentiSenzaGruppo = (List<UtenteBean>) request.getAttribute("utentiSenzaGruppo"); %>
		<% Map<String, String> errorMessages = (Map<String, String>) request.getAttribute("errorMessages"); %>
		<%
			if (errorMessages == null) {
				errorMessages = new HashMap<>();
			}
		%>

        <form action="/val_training_test/GruppoServlet" method="POST" novalidate>
            
			<input type="hidden" name="idResponsabile" value="<%=idResponsabile%>">

			<div class="mb-3">
                <label for="nomeGruppo">Nome Gruppo:</label>
                <input class="form-control" type="text" id="nomeGruppo" name="nomeGruppo" placeholder="Inserisci il nome del gruppo"
				value="<%=request.getParameter("nomeGruppo") != null ? request.getParameter("nomeGruppo") : ""%>">
				<% String existingNomeError = errorMessages.get("existingNomeError"); %>
				<% if (existingNomeError != null && !existingNomeError.isEmpty()) { %>
					<small class="text-danger"><%=existingNomeError%></small>
				<% } %>
				<% String emptyNomeError = errorMessages.get("emptyNomeError"); %>
				<% if (emptyNomeError != null && !emptyNomeError.isEmpty()) { %>
					<small class="text-danger"><%=emptyNomeError%></small>
				<% } %>
            </div>

            <% if (utentiSenzaGruppo != null) { %>
                <% for (UtenteBean utente : utentiSenzaGruppo) { %>
                    <div class="mb-3">
                        <label>
                            <input type="checkbox" name="utentiDaAggiungere" value="<%=utente.getIdUtente()%>">
                            <%=utente.getNomeUtente()%> <%=utente.getCognomeUtente()%>
                        </label>
                    </div>
                <% } %>
            <% } else { %>
                <p>Nessun utente senza gruppo...</p>
            <% } %>

            <%-- Submit button --%>
            <div class="d-flex justify-content-between">
                <button class="btn btn-success" type="submit">Crea Gruppo</button>
                <a class="btn btn-primary" href="index.jsp">Home Page</a>
            </div>
        </form>
    </div>
</body>
</html>
