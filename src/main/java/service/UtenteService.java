package service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Pattern;

import model.bean.GruppoBean;
import model.bean.UtenteBean;
import model.dao.UtenteDao;

public class UtenteService {
	
	public UtenteBean signin(UtenteBean utenteBean) {
		
		UtenteDao utenteDao = new UtenteDao();
		
		// verifica che l'utente esista già
		boolean isPresent = utenteDao.findByEmail(utenteBean.getEmailUtente());
		if (isPresent) {
			System.out.println("L'utente con email '" + utenteBean.getEmailUtente() + "' è già stato registrato");
			return new UtenteBean();
		}
		
		// validazione campi
		
		// nome
		if (utenteBean.getNomeUtente().isBlank()) {
			System.out.println("Il campo 'nome' non può essere vuoto");
			return new UtenteBean();
		} else if (!Pattern.matches("[a-zA-Z]+", utenteBean.getNomeUtente())) {
			System.out.println("Il campo 'nome' non può contenere numeri e caratteri speciali");
			return new UtenteBean();
		}
		
		// cognome
		if (utenteBean.getCognomeUtente().isBlank()) {
			System.out.println("Il campo 'cognome' non può essere vuoto");
			return new UtenteBean();
		} else if (!Pattern.matches("[a-zA-Z]+", utenteBean.getCognomeUtente())) {
			System.out.println("Il campo 'cognome' non può contenere numeri e caratteri speciali");
			return new UtenteBean();
		}
		
		// email
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		if (!Pattern.compile(emailRegex).matcher(utenteBean.getEmailUtente()).matches()) {
			System.out.println("L'email inserita non è valida");
			return new UtenteBean();
		}
		
		// password
		String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
		if (!Pattern.compile(passwordRegex).matcher(utenteBean.getPasswordUtente()).matches()) {
			System.out.println("La password inserita non è valida");
			return new UtenteBean();
		}
		
		// data creazione
		if (utenteBean.getDataCreazioneUtente().isAfter(LocalDateTime.now())) {
			System.out.println("La data di creazione non può essere nel futuro");
			return new UtenteBean();
		}
		
		// data modifica
		if (utenteBean.getDataModificaUtente().isBefore(utenteBean.getDataCreazioneUtente())) {
			System.out.println("La data di modifica non può essere antecedente la data di creazione");
			return new UtenteBean();
		}
		
		System.out.println("Validazione Ok");
		
		// Ritorno il nuovo utente
		UtenteBean nuovoUtente = utenteDao.insert(utenteBean);
		return nuovoUtente;
	}
	
	public UtenteBean login(UtenteBean utenteBean) {
		
		// validazione campi
		
		// email
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		if (!Pattern.compile(emailRegex).matcher(utenteBean.getEmailUtente()).matches()) {
			System.out.println("L'email inserita non è valida");
			return new UtenteBean();
		}
		
		// password
		String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
		if (!Pattern.compile(passwordRegex).matcher(utenteBean.getPasswordUtente()).matches()) {
			System.out.println("La password inserita non è valida");
			return new UtenteBean();
		}
		
		UtenteDao utenteDao = new UtenteDao();
		
		// Ritorno l'utente
		UtenteBean loggedUtente = utenteDao.findByEmailAndPassword(utenteBean);
		return loggedUtente;
	}
	
	public String aggiungiUtentiAlGruppo(UtenteBean utenteBean, GruppoBean gruppoBean, List<UtenteBean> utenti) {
		
		if (utenteBean.getIdRuolo() == 1) {
			return "Non sei autorizzato ad aggiungere membri al gruppo";
		}
		
		UtenteDao utenteDao = new UtenteDao();
		
		for (UtenteBean utente : utenti) {
			utente.setIdGruppo(gruppoBean.getIdGruppo());
			int utenteAggiunto = utenteDao.update(utente);
			
			if (utenteAggiunto == 0) {
				return "Errore: Utente non aggiunto al gruppo!";
			}
		}
		return "Utenti aggiunti al gruppo" + gruppoBean.getNomeGruppo();
	}
	
	public String eliminaUtentiDalGruppo(UtenteBean utenteBean, GruppoBean gruppoBean, List<UtenteBean> utenti) {
		
		if (utenteBean.getIdRuolo() == 1) {
			return "Non sei autorizzato a rimuovere membri dal gruppo";
		}
		
		UtenteDao utenteDao = new UtenteDao();
		
		for (UtenteBean utente : utenti) {
			utente.setIdGruppo(null);
			int utenteEliminato = utenteDao.update(utente);
			
			if (utenteEliminato == 0) {
				return "Errore: Utente non rimosso dal gruppo!";
			}
		}
		return "Utenti rimossi dal gruppo" + gruppoBean.getNomeGruppo();
	}
}
