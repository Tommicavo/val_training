package servlet;

import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import exception.InvalidEmailException;
import exception.InvalidPasswordException;
import model.bean.UtenteBean;
import model.dto.UtenteDto;
import service.UtenteService;

@WebServlet("/login")
public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        String email = request.getParameter("email");
        String password = request.getParameter("password");

         Logger logger = Logger.getLogger(Login.class.getName());
         
         
        
        UtenteDto utenteDto = new UtenteDto();
        utenteDto.setEmailUtente(email);
        utenteDto.setPasswordUtente(password);

        UtenteService utenteService = new UtenteService();
        UtenteBean utenteLoggato = null;
		try {
			utenteLoggato = utenteService.login(utenteDto);
			
			if(utenteLoggato != null) 

				logger.info("sei già loggato"); //redirect alla pagina
			else {
				response.sendRedirect("Signin.jsp");
			}
			
		} catch (InvalidEmailException | InvalidPasswordException e) {
			e.printStackTrace();
		}
		
        System.out.println("Login Servlet: " + utenteLoggato);
    }
}
