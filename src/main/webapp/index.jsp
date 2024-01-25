<html>
	<head>
	</head>
	    <script>
        // Funzione chiamata quando si clicca sul primo bottone
        function redirectLoginPage() {
            window.location.href = "Login.jsp";
        }

        // Funzione chiamata quando si clicca sul secondo bottone
        function redirectSigninPage() {
            window.location.href = "Signin.jsp";
        }
    </script>
	<body>
		<h1>scegli una delle opzioni</h1>
    <button id="button1" onclick="redirectLoginPage()">Login</button>

    <button id="button2" onclick="redirectSigninPage()">Signin</button>
	</body>
	
</html>
