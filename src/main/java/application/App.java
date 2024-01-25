package application;

import java.util.ArrayList;
import java.util.List;
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
import model.dao.UtenteDao;
import model.dto.UtenteDto;
import service.UtenteService;
//import java.time.LocalDateTime;

public class App {
	
	public static void main(String[] args) throws ExistingUtenteException, EmptyNomeException, InvalidNomeException, EmptyCognomeException, InvalidCognomeException, InvalidEmailException, InvalidPasswordException, InvalidDataCreazioneException, InvalidDataModificaException {
		
		
	List<UtenteBean> utenti = new ArrayList<>();
	
	/*
	UtenteBean utente_1 = new UtenteBean(1L, "Mario", "Rossi", "mario@mail.it", "Password1!", "info generali", LocalDateTime.now(), LocalDateTime.now(), false);
	UtenteBean utente_2 = new UtenteBean(2L, "Giulio", "Bianchi", "giulio@mail.it", "Password1!", "info generali", LocalDateTime.now(), LocalDateTime.now(), false);
	UtenteBean utente_3 = new UtenteBean(3L, "Anna", "Verdi", "anna@mail.it", "Password1!", "info generali", LocalDateTime.now(), LocalDateTime.now(), false);
	
	utenti.add(utente_1);
	utenti.add(utente_2);
	*/
	
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
	
	/*
	System.out.println("\nTEST INSERT:\n");
	UtenteBean nuovoUtente = new UtenteBean();
	
	nuovoUtente.setNomeUtente("nuovo");
	nuovoUtente.setCognomeUtente("utente");
	nuovoUtente.setEmailUtente("mail_1@mail.it");
	nuovoUtente.setPasswordUtente("Password1!");
	nuovoUtente.setInformazioniGeneraliUtente("info_generali");
	nuovoUtente.setDataCreazioneUtente(LocalDateTime.now());
	nuovoUtente.setDataModificaUtente(LocalDateTime.now());
	nuovoUtente.setFlgCancellatoUtente(false);
	
	UtenteBean outputNuovoUtente = utenteDao.insert(nuovoUtente);
	System.out.println(outputNuovoUtente);

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
	
	
	// TEST SIGNIN
	UtenteDto newUtente = new UtenteDto();
	newUtente.setNomeUtente("Nome");
	newUtente.setCognomeUtente("Cognome");
	newUtente.setEmailUtente("nuova_email_1@mail.it");
	newUtente.setPasswordUtente("Password1!");
	
	UtenteService utenteService = new UtenteService();
	UtenteBean utenteIscritto = new UtenteBean();
	utenteIscritto = utenteService.signin(newUtente);
	System.out.println("TEST SIGNIN:\n" + utenteIscritto);
	
	// TEST LOGIN
	UtenteDto existingUtente= new UtenteDto();
	existingUtente.setEmailUtente("nuova_email_1@mail.it");
	existingUtente.setPasswordUtente("Password1!");
	
	UtenteBean utenteLoggato = new UtenteBean();
	utenteLoggato = utenteService.login(existingUtente);
	System.out.println("TEST LOGIN:\n" + utenteLoggato);
	}
}