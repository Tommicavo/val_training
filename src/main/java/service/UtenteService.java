package service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Pattern;
import model.bean.UtenteBean;

public class UtenteService {
	public void signin(UtenteBean utenteBean, List<UtenteBean> utenteBeans) {
		
		// verifica che l'utente esista già
		for (UtenteBean utente : utenteBeans) {
			if (utente.getEmailUtente() == utenteBean.getEmailUtente()) {
				System.out.println("L'utente con email '" + utenteBean.getEmailUtente() + "' è già iscritto");
				return;
			}
		}
		
		// validazione campi
		
		// nome
		if (utenteBean.getNomeUtente().isBlank()) {
			System.out.println("Il campo 'nome' non può essere vuoto");
			return;
		} else if (!Pattern.matches("[a-zA-Z]+", utenteBean.getNomeUtente())) {
			System.out.println("Il campo 'nome' non può contenere caratteri speciali");
			return;
		}
		
		// cognome
		if (utenteBean.getCognomeUtente().isBlank()) {
			System.out.println("Il campo 'cognome' non può essere vuoto");
			return;
		} else if (!Pattern.matches("[a-zA-Z]+", utenteBean.getCognomeUtente())) {
			System.out.println("Il campo 'cognome' non può contenere caratteri speciali");
			return;
		}
		
		// email
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		if (!Pattern.compile(emailRegex).matcher(utenteBean.getEmailUtente()).matches()) {
			System.out.println("L'email inserita non è valida");
			return;
		}
		
		// password
		String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
		if (!Pattern.compile(passwordRegex).matcher(utenteBean.getPasswordUtente()).matches()) {
		    System.out.println("La password inserita non è valida");
		    return;
		}
		
		// data creazione
		if (utenteBean.getDataCreazioneUtente().isAfter(LocalDateTime.now())) {
			System.out.println("La data di creazione non può essere nel futuro");
			return;
		}
		
		// data modifica
		if (utenteBean.getDataModificaUtente().isBefore(utenteBean.getDataCreazioneUtente())) {
			System.out.println("La data di modifica non può essere antecedente la data di creazione");
			return;
		}
		
		// aggiungo l'utente nel db
		System.out.println("Validazione Ok");
	}
}
