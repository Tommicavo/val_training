package service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Pattern;
import model.bean.GruppoBean;
import model.bean.UtenteBean;
import model.dao.UtenteDao;
import model.dto.UtenteDto;
import utils.converter.UtenteConverter;
import exception.EmptyCognomeException;
import exception.EmptyNomeException;
import exception.ExistingUtenteException;
import exception.InvalidCognomeException;
import exception.InvalidDataCreazioneException;
import exception.InvalidDataModificaException;
import exception.InvalidEmailException;
import exception.InvalidNomeException;
import exception.InvalidPasswordException;

public class UtenteService {

	public UtenteBean signin(UtenteDto utenteDto) throws ExistingUtenteException, EmptyNomeException, InvalidNomeException, EmptyCognomeException, InvalidCognomeException, InvalidEmailException, InvalidPasswordException, InvalidDataCreazioneException, InvalidDataModificaException {
		
		UtenteDao utenteDao = new UtenteDao();
		
		// verifica che l'utente esista già
		boolean isPresent = utenteDao.findByEmail(utenteDto.getEmailUtente());
		if (isPresent) {
			throw new ExistingUtenteException("L'utente con email '" + utenteDto.getEmailUtente() + "' è già stato registrato");
		}
		
		// nome
		if (utenteDto.getNomeUtente().isBlank()) {
			throw new EmptyNomeException("Il campo 'nome' non può essere vuoto");
		} else if (!Pattern.matches("[a-zA-Z]+", utenteDto.getNomeUtente())) {
			throw new InvalidNomeException("Il campo 'nome' non può contenere numeri e caratteri speciali");
		}
		
		// cognome
		if (utenteDto.getCognomeUtente().isBlank()) {
			throw new EmptyCognomeException("Il campo 'cognome' non può essere vuoto");
		} else if (!Pattern.matches("[a-zA-Z]+", utenteDto.getCognomeUtente())) {
			throw new InvalidCognomeException("Il campo 'cognome' non può contenere numeri e caratteri speciali");
		}
		
		// email
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		if (!Pattern.compile(emailRegex).matcher(utenteDto.getEmailUtente()).matches()) {
			throw new InvalidEmailException("L'email inserita non è valida");
		}
		
		// password
		String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
		if (!Pattern.compile(passwordRegex).matcher(utenteDto.getPasswordUtente()).matches()) {
			throw new InvalidPasswordException("La password inserita non è valida");
		}
		
		UtenteConverter utenteConverter = new UtenteConverter();
		
		UtenteBean utenteBean = utenteConverter.toBean(utenteDto);
		utenteBean.setDataCreazioneUtente(LocalDateTime.now());
		utenteBean.setDataModificaUtente(LocalDateTime.now());
		utenteBean.setFlgCancellatoUtente(false);
		
		// data creazione
		if (utenteBean.getDataCreazioneUtente().isAfter(LocalDateTime.now())) {
			throw new InvalidDataCreazioneException("La data di creazione non può essere nel futuro");
		}
		
		// data modifica
		if (utenteBean.getDataModificaUtente().isBefore(utenteBean.getDataCreazioneUtente())) {
			throw new InvalidDataModificaException("La data di modifica non può essere antecedente la data di creazione");
		}
		
		UtenteBean nuovoUtente = utenteDao.insert(utenteBean);
		return nuovoUtente;
	}
	
	public UtenteBean login(UtenteDto utenteDto) throws InvalidEmailException, InvalidPasswordException {
		
		// email
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		if (!Pattern.compile(emailRegex).matcher(utenteDto.getEmailUtente()).matches()) {
			throw new InvalidEmailException("L'email inserita non è valida");
		}
		
		// password
		String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
		if (!Pattern.compile(passwordRegex).matcher(utenteDto.getPasswordUtente()).matches()) {
			throw new InvalidPasswordException("La password inserita non è valida");
		}
		
		UtenteConverter utenteConverter = new UtenteConverter();

		UtenteBean utenteBean = utenteConverter.toBean(utenteDto);
		
		UtenteDao utenteDao = new UtenteDao();
		
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
		return "Utenti aggiunti al gruppo '" + gruppoBean.getNomeGruppo() +"'";
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
