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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UtenteDto utenteDto = new UtenteDto();
        utenteDto.setEmailUtente(email);
        utenteDto.setPasswordUtente(password);

        UtenteService utenteService = new UtenteService();
        UtenteBean utenteLoggato = null;
		try {
			utenteLoggato = utenteService.login(utenteDto);
		} catch (InvalidEmailException | InvalidPasswordException e) {
			e.printStackTrace();
		}
		
		System.out.println("LoginServlet: " + utenteLoggato);

		response.sendRedirect(request.getContextPath() + "/ShowServlet?id=" + utenteLoggato.getIdUtente());
    }
}
