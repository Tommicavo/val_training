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

@WebServlet("/signin")
public class Signin extends HttpServlet {

    private static final long serialVersionUID = 2L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
        UtenteBean nuovoUtente = null;
        String messaggio = null;

        try {
            nuovoUtente = utenteService.signin(utenteDto);
            messaggio = "Registrazione avvenuta con successo!";
        } catch (ExistingUtenteException | EmptyNomeException | InvalidNomeException | EmptyCognomeException
                | InvalidCognomeException | InvalidEmailException | InvalidPasswordException
                | InvalidDataCreazioneException | InvalidDataModificaException e) {
            e.printStackTrace();
            messaggio = "Errore durante la registrazione. Riprova.";
        }

        // Imposta l'attributo "messaggio" nella richiesta
        request.setAttribute("messaggio", messaggio);

        // Inoltra la richiesta alla pagina di destinazione
        request.getRequestDispatcher("Signin.jsp").forward(request, response);
    }
}

