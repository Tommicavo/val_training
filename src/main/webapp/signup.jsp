<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Signin</title>
</head>
<body>
    <h2>Signin</h2>
    
    <form action="SigninServlet.jsp" method="POST">
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" placeholder="Scrivi il tuo nome..."><br>
    
        <label for="cognome">Cognome:</label>
        <input type="text" id="cognome" name="cognome" placeholder="Scrivi il tuo cognome..."><br>
    
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" placeholder="Inserisci l'email"><br>
    
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" placeholder="Inserisci la password"><br>
    
        <button type="submit">Signin</button>
    </form>
    </body>
</html>
