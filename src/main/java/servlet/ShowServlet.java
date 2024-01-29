package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.GruppoBean;
import model.bean.UtenteBean;
import model.dao.GruppoDao;
import model.dao.UtenteDao;

@WebServlet("/ShowServlet")
public class ShowServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String stringUtenteId = request.getParameter("id");

        if (stringUtenteId != null && !stringUtenteId.isEmpty()) {
            Long utenteId = Long.parseLong(stringUtenteId);

            UtenteDao utenteDao = new UtenteDao();
            UtenteBean utenteBean = utenteDao.findById(utenteId);
            System.out.println("ShowServlet: " + utenteBean);

            if (utenteBean != null) {
                request.setAttribute("utente", utenteBean);

                Long idRuolo = utenteBean.getIdRuolo();
                if (idRuolo != null) {
                    Long idRuoloValue = idRuolo.longValue();

                    if (idRuoloValue == 1L) {
                        RequestDispatcher rd = request.getRequestDispatcher("/dipendente.jsp");
                        rd.forward(request, response);
                    } else {
                        RequestDispatcher rd = request.getRequestDispatcher("/responsabile.jsp");
                        rd.forward(request, response);
                    }
                } else {
                    // Gestisci il caso in cui idRuolo è null
                    response.getWriter().println("<div>Dettagli utente non disponibili</div>");
                }
            
            if (utenteBean.getIdGruppo() != null) {
            	GruppoDao gruppoDao = new GruppoDao();
            	GruppoBean gruppoBean = gruppoDao.findById(utenteBean.getIdGruppo());
            	System.out.println("Gruppo: " + gruppoBean);
            	request.setAttribute("gruppo", gruppoBean);
            }
            
            request.setAttribute("utente", utenteBean);
            
            if (utenteBean.getIdRuolo() == 1L) {
                RequestDispatcher rd = request.getRequestDispatcher("/dipendente.jsp");
                rd.forward(request, response);
            } else {
                // Gestisci il caso in cui utenteBean è null
                response.getWriter().println("<div>Utente non trovato</div>");
            }
        } else {
            response.getWriter().println("<div>Dettagli utente non disponibili</div>");
        }
    }
}
