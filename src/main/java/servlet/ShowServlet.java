package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.UtenteBean;
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

            request.setAttribute("utente", utenteBean);
            
            RequestDispatcher rd = request.getRequestDispatcher("/show.jsp");
            rd.forward(request, response);
            
        } else {
            response.getWriter().println("<div>Dettagli utente non disponibili</div>");
        }
    }
}
