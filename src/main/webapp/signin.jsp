<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Signin</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h2 class="text-center py-3">Signin</h2>

        <% Map<String, String> errorMessages = (Map<String, String>) request.getAttribute("errorMessages"); %>
        <% if (errorMessages == null) { errorMessages = new HashMap<>(); } %>

        <% String existingUtenteError = errorMessages.get("existingUtenteError"); %>
        <% if (existingUtenteError != null && !existingUtenteError.isEmpty()) { %>
            <div class="alert alert-warning" role="alert">
                <%= existingUtenteError %>
            </div>
        <% } %>

        <form action="/val_training_test/SigninServlet" method="POST" novalidate>
            <div class="mb-3">
                <label class="form-label" for="nome">Nome:</label>
                    <input class="form-control" type="text" id="nome" name="nome" placeholder="Scrivi il tuo nome..."
                    value="<%= request.getParameter("nome") != null ? request.getParameter("nome") : "" %>">

                <% String emptyNomeError = errorMessages.get("emptyNomeError"); %>
                <% if (emptyNomeError != null && !emptyNomeError.isEmpty()) { %>
                    <small class="text-danger"><%= emptyNomeError %></small>
                <% } %>
                <% String invalidNomeError = errorMessages.get("invalidNomeError"); %>
                <% if (invalidNomeError != null && !invalidNomeError.isEmpty()) { %>
                    <small class="text-danger"><%= invalidNomeError %></small>
                <% } %>
            </div>
        
            <div class="mb-3">
                <label class="form-label" for="cognome">Cognome:</label>
                <input class="form-control" type="text" id="cognome" name="cognome" placeholder="Scrivi il tuo cognome..."
                value="<%= request.getParameter("cognome") != null ? request.getParameter("cognome") : "" %>">

                <% String emptyCognomeError = errorMessages.get("emptyCognomeError"); %>
                <% if (emptyCognomeError != null && !emptyCognomeError.isEmpty()) { %>
                    <small class="text-danger"><%= emptyCognomeError %></small>
                <% } %>
                <% String invalidCognomeError = errorMessages.get("invalidCognomeError"); %>
                <% if (invalidCognomeError != null && !invalidCognomeError.isEmpty()) { %>
                    <small class="text-danger"><%= invalidCognomeError %></small>
                <% } %>
            </div>
            
            <div class="mb-3">
                <label class="form-label" for="email">Email:</label>
                <input class="form-control" type="email" id="email" name="email" placeholder="Inserisci l'email"
                value="<%= request.getParameter("email") != null ? request.getParameter("email") : "" %>">

                <% String invalidEmailError = errorMessages.get("invalidEmailError"); %>
                <% if (invalidEmailError != null && !invalidEmailError.isEmpty()) { %>
                    <small class="text-danger"><%= invalidEmailError %></small>
                <% } %>
            </div>
        
            <div class="mb-3">
                <label class="form-label" for="password">Password:</label>
                <input class="form-control" type="password" id="password" name="password" placeholder="Inserisci la password"
                value="<%= request.getParameter("password") != null ? request.getParameter("password") : "" %>">

                <% String invalidPasswordError = errorMessages.get("invalidPasswordError"); %>
                <% if (invalidPasswordError != null && !invalidPasswordError.isEmpty()) { %>
                    <small class="text-danger"><%= invalidPasswordError %></small>
                <% } %>
            </div>
        
            <div class="d-flex justify-content-between">
                <button class="btn btn-success" type="submit">Signin</button>
                <a class="btn btn-primary" href="index.jsp">Home Page</a>
            </div>
        </form>
    </div>
</body>
</html>
