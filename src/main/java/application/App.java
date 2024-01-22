package application;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import model.bean.ParagrafoBean;
import model.bean.RuoloBean;
import model.bean.UtenteBean;
import model.dao.ParagrafoDao;
import service.UtenteService;

public class App {
	public static void main(String[] args) {
/*		RuoloBean ruolo_1 = new RuoloBean(1l, "responsabile");
//		System.out.println(ruolo_1);
//		System.out.println("Hash Code: " + ruolo_1.hashCode());
//		System.out.println("isEquals: " + ruolo_1.equals(ruolo_1));
		
		
		List<UtenteBean> utenti = new ArrayList<>();
		
		UtenteBean utente_1 = new UtenteBean(1L, "Mario", "Rossi", "mario@mail.it", "Password1!", "info generali", LocalDateTime.now(), LocalDateTime.now(), false);
		UtenteBean utente_2 = new UtenteBean(2L, "Giulio", "Bianchi", "giulio@mail.it", "Password1!", "info generali", LocalDateTime.now(), LocalDateTime.now(), false);
		UtenteBean utente_3 = new UtenteBean(3L, "Anna", "Verdi", "anna@mail.it", "Password1!", "info generali", LocalDateTime.now(), LocalDateTime.now(), false);
		
		utenti.add(utente_1);
		utenti.add(utente_2);
		
		UtenteService utenteService = new UtenteService();
		utenteService.signin(utente_3, utenti);
	}
*/
		
		//ESEGUI QUERY SUL DATABASE
		
		ParagrafoBean pb = new ParagrafoBean();
		pb.setTitoloParagrafo("PROVA TITOLO1");
		pb.setDescrizioneParagrafo("PROVA DESCRIZIONE1");
		ParagrafoDao pd = new ParagrafoDao();
		
		try {
			int result;
			//AGGIUNGI PARAGRAFO
			result = pd.add(pb);
			if(result == 1) System.out.println("PARAGRAFO AGGIUNTO");
			else System.out.println("PARAGRAFO non INSERTIO CORRETTAMENTE");
			
			
			//VISUALIZZA TUTTI I PARAGRAFI
			List<ParagrafoBean> listaParagrafo;
			listaParagrafo = pd.findAll();
			for(ParagrafoBean paragrafo : listaParagrafo) {
				System.out.println(paragrafo.toString());
			}
			
			//ELIMINA UN PARAGRAFO
			result = pd.delete((long)32);
			if(result == 1) System.out.println("PARAGRAFO ELIMINATO");
			else System.out.println("PARAGRAFO non ELIMINATO CORRETTAMENTE");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
