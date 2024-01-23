package application;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import model.bean.UtenteBean;
import model.dao.UtenteDao;
// import service.UtenteService;

public class App {
	public static void main(String[] args) {	
		
		List<UtenteBean> utenti = new ArrayList<>();
		
		UtenteBean utente_1 = new UtenteBean(1L, "Mario", "Rossi", "mario@mail.it", "Password1!", "info generali", LocalDateTime.now(), LocalDateTime.now(), false);
		UtenteBean utente_2 = new UtenteBean(2L, "Giulio", "Bianchi", "giulio@mail.it", "Password1!", "info generali", LocalDateTime.now(), LocalDateTime.now(), false);
		UtenteBean utente_3 = new UtenteBean(3L, "Anna", "Verdi", "anna@mail.it", "Password1!", "info generali", LocalDateTime.now(), LocalDateTime.now(), false);
		
		/*
		utenti.add(utente_1);
		utenti.add(utente_2);
		
		// Test Service
		UtenteService utenteService = new UtenteService();
		utenteService.signin(utente_3, utenti);
		*/
		
		// Test Dao
		UtenteDao utenteDao = new UtenteDao();
		
		System.out.println("\nTEST FIND ALL:\n");
		utenti = utenteDao.findAll();
		for (UtenteBean utente : utenti) {
			System.out.println(utente);
		}
		
		System.out.println("\nTEST FIND BY ID:\n");
		UtenteBean utente = new UtenteBean();
		utente = utenteDao.findById(1L);
		System.out.println(utente);
		
		
		System.out.println("\nTEST INSERT:\n");
		UtenteBean nuovoUtente = new UtenteBean();
		
		nuovoUtente.setNomeUtente("testProperties");
		nuovoUtente.setCognomeUtente("TestUtente");
		nuovoUtente.setEmailUtente("wera@mail.it");
		nuovoUtente.setPasswordUtente("Password1234!");
		nuovoUtente.setInformazioniGeneraliUtente("info_generali");
		nuovoUtente.setDataCreazioneUtente(LocalDateTime.now());
		nuovoUtente.setDataModificaUtente(LocalDateTime.now());
		nuovoUtente.setFlgCancellatoUtente(false);
		
		UtenteBean outputNuovoUtente = utenteDao.insert(nuovoUtente);
		System.out.println(outputNuovoUtente);
		
		
		/*
		System.out.println("\nTEST UPDATE:");
		utente.setNomeUtente("NomeUtenteUpdated");
		int updateOutput = utenteDao.update(utente);
		System.out.println("Update output: " + updateOutput);
		
		System.out.println("\nTEST TRASH:");
		int trashOutput = utenteDao.trash(utente);
		System.out.println("Trash output: " + trashOutput);
		
		System.out.println("\nTEST DELETE:");
		int deleteOutput = utenteDao.deleteById(7L);
		System.out.println("Delete Output: " + deleteOutput);
		*/
	}
}