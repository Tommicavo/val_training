package servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.UtenteBean;
import model.dao.UtenteDao;
import model.dto.GruppoDto;
import service.GruppoService;
import utils.GroupResult;

@WebServlet("/GruppoServlet")
public class GruppoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		String idResponsabile = request.getParameter("idResponsabile");
		
		UtenteDao utenteDao = new UtenteDao();
    	List<UtenteBean> utentiSenzaGruppo = utenteDao.findAllGroupless();
        
    	request.setAttribute("utentiSenzaGruppo", utentiSenzaGruppo);
    	request.setAttribute("idResponsabile", idResponsabile);
        RequestDispatcher rd = request.getRequestDispatcher("/gruppo.jsp");
        rd.forward(request, response);	
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		UtenteDao utenteDao = new UtenteDao();
		
    	List<UtenteBean> utentiSenzaGruppo = utenteDao.findAllGroupless();
		String[] strIdUtentiDaAggiungere = request.getParameterValues("utentiDaAggiungere");
        String nomeGruppo = request.getParameter("nomeGruppo");
        String strIdResponsabile = request.getParameter("idResponsabile");
        Long idResponsabile = Long.valueOf(strIdResponsabile);
                
        // Creazione nuovo gruppo
        GruppoDto gruppoDto = new GruppoDto();
        gruppoDto.setNomeGruppo(nomeGruppo);
        gruppoDto.setIdResponsabile(idResponsabile);
        
        GruppoService gruppoService = new GruppoService();
        GroupResult groupResult = gruppoService.insertGruppo(gruppoDto);
        
        if (groupResult.getGruppoBean() != null) {
        	Map<String, String> successMessage = groupResult.getMessages();
        	System.out.println(successMessage);
        	
        	// assegno l'id del nuovo gruppo al responsabile e a tutti i partecipanti del gruppo
        	UtenteBean responsabile = utenteDao.findById(idResponsabile);
        	
        	if (responsabile != null) {
        		responsabile.setIdGruppo(groupResult.getGruppoBean().getIdGruppo());
        		utenteDao.update(responsabile);
        	}
        	
        	if (strIdUtentiDaAggiungere != null) {
            	for (String strId : strIdUtentiDaAggiungere) {
            		Long idUtenteDaAggiungere = Long.valueOf(strId);
            		UtenteBean utenteDaAggiungere = utenteDao.findById(idUtenteDaAggiungere);
            		utenteDaAggiungere.setIdGruppo(groupResult.getGruppoBean().getIdGruppo());
            		utenteDao.update(utenteDaAggiungere);
            	}
        	}
        } else {
        	Map<String, String> errorMessages = groupResult.getMessages();
        	System.out.println("errorMessages: " + errorMessages);
            request.setAttribute("errorMessages", errorMessages);
            request.setAttribute("idResponsabile", strIdResponsabile);
            request.setAttribute("utentiSenzaGruppo", utentiSenzaGruppo);
            RequestDispatcher rd = request.getRequestDispatcher("/gruppo.jsp");
            rd.forward(request, response);
        }        
	}
}
