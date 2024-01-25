package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import exception.EmptyCognomeException;
import exception.EmptyNomeException;
import exception.ExistingUtenteException;
import exception.InvalidCognomeException;
import exception.InvalidDataCreazioneException;
import exception.InvalidDataModificaException;
import exception.InvalidEmailException;
import exception.InvalidNomeException;
import exception.InvalidPasswordException;
import model.bean.UtenteBean;
import model.dto.UtenteDto;
import service.UtenteService;

@WebServlet("/SigninServlet")
public class SigninServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        String nome = request.getParameter("nome");
        String cognome = request.getParameter("cognome");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String informazioniGenerali = request.getParameter("informazioni_generali");

        UtenteDto utenteDto = new UtenteDto();
        utenteDto.setNomeUtente(nome);
        utenteDto.setCognomeUtente(cognome);
        utenteDto.setEmailUtente(email);
        utenteDto.setPasswordUtente(password);
        utenteDto.setInformazioniGeneraliUtente(informazioniGenerali);

        UtenteService utenteService = new UtenteService();
        UtenteBean nuovoUtente = null;
		try {
			nuovoUtente = utenteService.signin(utenteDto);
			if(nuovoUtente != null) response.sendRedirect("index.jsp"); //redirect alla pagina
			else {
				response.sendRedirect("signup.jsp");
			}
		} catch (ExistingUtenteException | EmptyNomeException | InvalidNomeException | EmptyCognomeException
				| InvalidCognomeException | InvalidEmailException | InvalidPasswordException
				| InvalidDataCreazioneException | InvalidDataModificaException e) {
			e.printStackTrace();
		}

        System.out.println("SigninServlet: " + nuovoUtente);
        
        response.sendRedirect(request.getContextPath() + "/ShowServlet?id=" + nuovoUtente.getIdUtente());
    }
}
