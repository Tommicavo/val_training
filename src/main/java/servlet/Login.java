package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exception.InvalidEmailException;
import exception.InvalidPasswordException;
import model.bean.UtenteBean;
import model.dto.UtenteDto;
import service.UtenteService;

@WebServlet("/login")
<<<<<<<< HEAD:src/main/java/servlet/LoginServlet.java
public class LoginServlet extends HttpServlet {
========
public class Login extends HttpServlet {
>>>>>>>> develop:src/main/java/servlet/Login.java

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UtenteDto utenteDto = new UtenteDto();
        utenteDto.setEmailUtente(email);
        utenteDto.setPasswordUtente(password);

        UtenteService utenteService = new UtenteService();
        UtenteBean utenteLoggato = null;
<<<<<<<< HEAD:src/main/java/servlet/LoginServlet.java
        try {
            utenteLoggato = utenteService.login(utenteDto);

            if(utenteLoggato != null) response.sendRedirect("login.jsp"); //redirect alla pagina
            else {
                response.sendRedirect("login.jsp");
            }

        } catch (InvalidEmailException | InvalidPasswordException e) {
            e.printStackTrace();
        }

========
		try {
			utenteLoggato = utenteService.login(utenteDto);
			
			if(utenteLoggato != null) response.sendRedirect("login.jsp"); //redirect alla pagina
			else {
				response.sendRedirect("login.jsp");
			}
			
		} catch (InvalidEmailException | InvalidPasswordException e) {
			e.printStackTrace();
		}
		
>>>>>>>> develop:src/main/java/servlet/Login.java
        System.out.println("Login Servlet: " + utenteLoggato);
    }
}