package application;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import model.bean.GruppoBean;
import model.bean.RuoloBean;
import model.bean.UtenteBean;
import model.dao.GruppoDao;
import service.UtenteService;

public class App {
	public static void main(String[] args) {
		//RuoloBean ruolo_1 = new RuoloBean(1l, "responsabile");
//		System.out.println(ruolo_1);
//		System.out.println("Hash Code: " + ruolo_1.hashCode());
//		System.out.println("isEquals: " + ruolo_1.equals(ruolo_1));
		
		
		//List<UtenteBean> utenti = new ArrayList<>();
		//List<GruppoBean> gruppi = new ArrayList<>();
		
		//UtenteBean utente_1 = new UtenteBean(1L, "Mario", "Rossi", "mario@mail.it", "Password1!", "info generali", LocalDateTime.now(), LocalDateTime.now(), false);
		//UtenteBean utente_2 = new UtenteBean(2L, "Giulio", "Bianchi", "giulio@mail.it", "Password1!", "info generali", LocalDateTime.now(), LocalDateTime.now(), false);
		//UtenteBean utente_3 = new UtenteBean(3L, "Anna", "Verdi", "anna@mail.it", "Password1!", "info generali", LocalDateTime.now(), LocalDateTime.now(), false);
		
		//utenti.add(utente_1);
		//utenti.add(utente_2);
		
		//GruppoBean gruppo1 = new GruppoBean(1L, "Gruppo A", LocalDateTime.now(), LocalDateTime.now(), false);
		//GruppoBean gruppo2 = new GruppoBean(2L, "Gruppo A", LocalDateTime.now(), LocalDateTime.now(), false);
		//GruppoBean gruppo3 = new GruppoBean(3L, "Gruppo A", LocalDateTime.now(), LocalDateTime.now(), false);
		//GruppoBean gruppo4 = new GruppoBean(4L, "Gruppo A", LocalDateTime.now(), LocalDateTime.now(), false);
		
		//UtenteService utenteService = new UtenteService();
		//utenteService.signin(utente_3, utenti);
		
		GruppoDao gruppoDao = new GruppoDao();
		try {
			//System.out.println(gruppoDao.add("Gruppo Sato"));
			System.out.println("Uso findByID" + gruppoDao.findById(5L));
			//System.out.println("Uso update tramite id sopra. Righe modificate: " + gruppoDao.update(5L, "gruppo J"));
			//System.out.println("Uso removeByID" + gruppoDao.deleteById(8L));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
