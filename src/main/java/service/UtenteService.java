package service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;


import model.bean.GruppoBean;
import model.bean.UtenteBean;
import model.dao.UtenteDao;
import model.dto.UtenteDto;
import utils.AuthResult;
import utils.converter.UtenteConverter;

public class UtenteService {

	public AuthResult signin(UtenteDto utenteDto) {
		
		Map<String, String> errorMessages = new HashMap<>();
		
		UtenteDao utenteDao = new UtenteDao();
		// verifica che l'utente esista già
		boolean isPresent = utenteDao.findByEmail(utenteDto.getEmailUtente());
		if (isPresent) {
			errorMessages.put("existingUtenteError", "Un utente con email: '" + utenteDto.getEmailUtente() + "' è già stato registrato");
		}

		// nome
		if (utenteDto.getNomeUtente().isBlank()) {
			errorMessages.put("emptyNomeError", "Il campo 'nome' non può essere vuoto");
		} else if (!Pattern.matches("[a-zA-Z]+", utenteDto.getNomeUtente())) {
			errorMessages.put("invalidNomeError", "Il campo 'nome' non può contenere numeri e caratteri speciali");
		}

		// cognome
		if (utenteDto.getCognomeUtente().isBlank()) {
			errorMessages.put("emptyCognomeError", "Il campo 'cognome' non può essere vuoto");
		} else if (!Pattern.matches("[a-zA-Z]+", utenteDto.getCognomeUtente())) {
			errorMessages.put("invalidCognomeError", "Il campo 'cognome' non può contenere numeri e caratteri speciali");
		}

		// email
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		if (!Pattern.compile(emailRegex).matcher(utenteDto.getEmailUtente()).matches()) {
			errorMessages.put("invalidEmailError", "L'email inserita non è valida");
		}

		// password
		String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
		if (!Pattern.compile(passwordRegex).matcher(utenteDto.getPasswordUtente()).matches()) {
			errorMessages.put("invalidPasswordError", "La password inserita non è valida");
		}
		
		if (!errorMessages.isEmpty()) {
			return new AuthResult(null, errorMessages);
		}

		UtenteConverter utenteConverter = new UtenteConverter();
		UtenteBean utenteBean = utenteConverter.toBean(utenteDto);
		utenteBean.setDataCreazioneUtente(LocalDateTime.now());
		utenteBean.setDataModificaUtente(LocalDateTime.now());
		utenteBean.setFlgCancellatoUtente(false);
		utenteBean.setIdRuolo(1L);
		
		UtenteBean nuovoUtente = utenteDao.insert(utenteBean);
		
		Map<String, String> successMessage = new HashMap<>();
		successMessage.put("successMessage", "Nuovo utente registrato correttamente");
		
		return new AuthResult(nuovoUtente, successMessage);
	}
	
	public AuthResult login(UtenteDto utenteDto) {
		
		Map<String, String> errorMessages = new HashMap<>();
		
		UtenteDao utenteDao = new UtenteDao();
		// verifica che l'utente esista già
		boolean isPresent = utenteDao.findByEmail(utenteDto.getEmailUtente());
		if (!isPresent) {
			errorMessages.put("unregisteredUtenteError", "La email: '" + utenteDto.getEmailUtente() + "' non è associata ad alcun utente");
		}
		
		// email
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		if (!Pattern.compile(emailRegex).matcher(utenteDto.getEmailUtente()).matches()) {
			errorMessages.put("invalidEmailError", "L'email inserita non è valida");
		}

		// password
		String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
		if (!Pattern.compile(passwordRegex).matcher(utenteDto.getPasswordUtente()).matches()) {
			errorMessages.put("invalidPasswordError", "La password inserita non è valida");
		}
		
		if (!errorMessages.isEmpty()) {
			return new AuthResult(null, errorMessages);
		}
		
		UtenteConverter utenteConverter = new UtenteConverter();
		UtenteBean utenteBean = utenteConverter.toBean(utenteDto);
		UtenteBean utenteLoggato = utenteDao.findByEmailAndPassword(utenteBean);
		
		Map<String, String> successMessage = new HashMap<>();
		successMessage.put("successMessage", "Utente loggato correttamente");
		
		return new AuthResult(utenteLoggato, successMessage);
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
		return "Utenti aggiunti al gruppo '" + gruppoBean.getNomeGruppo() + "'";
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
		return "Utenti rimossi dal gruppo '" + gruppoBean.getNomeGruppo() + "'";
	}
}
