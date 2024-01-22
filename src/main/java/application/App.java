package application;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import model.bean.RuoloBean;
import model.dao.ValoreDao;
import service.UtenteService;

public class App {
	public static void main(String[] args) {
		RuoloBean ruolo_1 = new RuoloBean(1l, "responsabile");
//		System.out.println(ruolo_1);
//		System.out.println("Hash Code: " + ruolo_1.hashCode());
//		System.out.println("isEquals: " + ruolo_1.equals(ruolo_1));
		
		
	/*	List<UtenteBean> utenti = new ArrayList<>();
		
		UtenteBean utente_1 = new UtenteBean(1L, "Mario", "Rossi", "mario@mail.it", "Password1!", "info generali", LocalDateTime.now(), LocalDateTime.now(), false);
		UtenteBean utente_2 = new UtenteBean(2L, "Giulio", "Bianchi", "giulio@mail.it", "Password1!", "info generali", LocalDateTime.now(), LocalDateTime.now(), false);
		UtenteBean utente_3 = new UtenteBean(3L, "Anna", "Verdi", "anna@mail.it", "Password1!", "info generali", LocalDateTime.now(), LocalDateTime.now(), false);
		
		utenti.add(utente_1);
		utenti.add(utente_2);
		
		UtenteService utenteService = new UtenteService();
		utenteService.signin(utente_3, utenti); */
		
		
		ValoreDao valore1 = new ValoreDao();
		
		try {
			System.out.println(valore1.deleteById(1l));
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
