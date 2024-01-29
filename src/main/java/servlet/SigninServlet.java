package servlet;

import java.io.IOException;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.UtenteBean;
import model.dto.UtenteDto;
import service.UtenteService;
import utils.AuthResult;

@WebServlet("/SigninServlet")
public class SigninServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String cognome = request.getParameter("cognome");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UtenteDto utenteDto = new UtenteDto();
        utenteDto.setNomeUtente(nome);
        utenteDto.setCognomeUtente(cognome);
        utenteDto.setEmailUtente(email);
        utenteDto.setPasswordUtente(password);

        UtenteService utenteService = new UtenteService();
        AuthResult authResult = utenteService.signin(utenteDto);

        if (authResult.getUtenteBean() != null) {
        	UtenteBean nuovoUtente = authResult.getUtenteBean();
        	System.out.println("SigninServlet: " + nuovoUtente);
        	Map<String, String> successMessage = authResult.getMessages();
        	System.out.println(successMessage);
            response.sendRedirect(request.getContextPath() + "/ShowServlet?id=" + nuovoUtente.getIdUtente());
        } else {
        	Map<String, String> errorMessages = authResult.getMessages();        	
        	System.out.println("errorMessages: " + errorMessages);
            request.setAttribute("errorMessages", errorMessages);
            RequestDispatcher rd = request.getRequestDispatcher("/signin.jsp");
            rd.forward(request, response);
        }
    }
}
