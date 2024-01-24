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
            
            <form action="/val_training_test/SigninServlet" method="POST">    
                <div class="mb-3">
                    <label class="form-label" for="nome">Nome:</label>
                    <input class="form-control" type="text" id="nome" name="nome" placeholder="Scrivi il tuo nome...">
                </div>
            
                <div class="mb-3">
                    <label class="form-label" for="cognome">Cognome:</label>
                    <input class="form-control" type="text" id="cognome" name="cognome" placeholder="Scrivi il tuo cognome...">
                </div>
                
                <div class="mb-3">
                    <label class="form-label" for="email">Email:</label>
                    <input class="form-control" type="email" id="email" name="email" placeholder="Inserisci l'email">
                </div>
            
                <div class="mb-3">
                    <label class="form-label" for="password">Password:</label>
                    <input class="form-control" type="password" id="password" name="password" placeholder="Inserisci la password">
                </div>
            
                <button class="btn btn-primary" type="submit">Signin</button>
            </form>
        </div>
    </body>
</html>
