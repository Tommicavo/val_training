<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h2 class="text-center py-3">Login</h2>
        <form action="/val_training_test/LoginServlet" method="POST">    
            <div class="mb-3">
                <label class="form-label" for="email">Email:</label>
                <input class="form-control" type="email" id="email" name="email" placeholder="Inserisci l'email">
            </div>
        
            <div class="mb-3">
                <label class="form-label" for="password">Password:</label>
                <input class="form-control" type="password" id="password" name="password" placeholder="Inserisci la password">
            </div>
        
            <div class="d-flex justify-content-between">
                <button class="btn btn-success" type="submit">Login</button>
                <a class="btn btn-primary" href="index.jsp">Home Page</a>
            </div>
        </form>
    </div>
</body>
</html>
