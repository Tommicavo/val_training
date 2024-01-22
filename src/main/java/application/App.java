package application;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import model.bean.RuoloBean;
import model.bean.ScalaBean;
import model.bean.UtenteBean;
import model.dao.ScalaDao;
import service.UtenteService;

public class App {
	  public static void main(String[] args) { 
	 /* RuoloBean(1l, "responsabile"); // System.out.println(ruolo_1); //
	 * System.out.println("Hash Code: " + ruolo_1.hashCode()); //
	 * System.out.println("isEquals: " + ruolo_1.equals(ruolo_1));
	 * 
	 * 
	 * List<UtenteBean> utenti = new ArrayList<>();
	 * 
	 * UtenteBean utente_1 = new UtenteBean(1L, "Mario", "Rossi", "mario@mail.it",
	 * "Password1!", "info generali", LocalDateTime.now(), LocalDateTime.now(),
	 * false); UtenteBean utente_2 = new UtenteBean(2L, "Giulio", "Bianchi",
	 * "giulio@mail.it", "Password1!", "info generali", LocalDateTime.now(),
	 * LocalDateTime.now(), false); UtenteBean utente_3 = new UtenteBean(3L, "Anna",
	 * "Verdi", "anna@mail.it", "Password1!", "info generali", LocalDateTime.now(),
	 * LocalDateTime.now(), false);
	 * aaaaasss
	 * utenti.add(utente_1); utenti.add(utente_2);
	 * 
	 * UtenteService utenteService = new UtenteService();
	 * utenteService.signin(utente_3, utenti); } */
	
	ScalaDao scalaDao = new ScalaDao();
	ScalaBean scalaBean = new ScalaBean();
	
	//setddhvgv
	scalaBean.setIdScala(2l);
	scalaBean.setTitoloScala("Test");
	scalaBean.setDescrizioneScala("testtesttest");
	scalaBean.setFlgCancellatoScala(false);
	
	
		//System.out.println("funziona" + scalaDao.findById(3l));
		//System.out.println("funziona" + scalaDao.addScala("titolo", "titolo"));
		//System.out.println("funziona" + scalaDao.removeById(8l));
		//System.out.println("funziona" + scalaDao.updateScala(scalaBean));
	

}}
