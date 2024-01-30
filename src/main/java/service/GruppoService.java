package service;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import model.bean.GruppoBean;
import model.bean.UtenteBean;
import model.dao.GruppoDao;
import model.dto.GruppoDto;
import utils.GroupResult;
import utils.converter.GruppoConverter;

public class GruppoService {
	GruppoDao gruppoDao = new GruppoDao();
	
	public GroupResult insertGruppo(GruppoDto gruppoDto) {
		
		Map<String, String> errorMessages = new HashMap<>();
		
		GruppoDao gruppoDao = new GruppoDao();
		// verifica che non esiste un gruppo con lo stesso nome
		boolean isPresent = gruppoDao.findByName(gruppoDto.getNomeGruppo());
		if (isPresent) {
			errorMessages.put("existingNomeError", "Un gruppo con nome: '" + gruppoDto.getNomeGruppo() + "' esiste già");
		}
		
		// nome
		if (gruppoDto.getNomeGruppo().isBlank()) {
			errorMessages.put("emptyNomeError", "Il campo 'nome gruppo' non può essere vuoto");
		}
		
		if (!errorMessages.isEmpty()) {
			return new GroupResult(null, errorMessages);
		}
		
		GruppoConverter gruppoConverter = new GruppoConverter();
		GruppoBean gruppoBean = gruppoConverter.toBean(gruppoDto);
        gruppoBean.setDataCreazioneGruppo(LocalDateTime.now());
        gruppoBean.setDataModificaGruppo(LocalDateTime.now());
        gruppoBean.setFlgCancellatoGruppo(false);
		
		if(gruppoBean.getIdResponsabile() == 1L) {
			return new GroupResult(null, null); // un dipendente non può creare un gruppo
		}
		
		GruppoBean nuovoGruppo = gruppoDao.insert(gruppoBean);
		
		Map<String, String> successMessage = new HashMap<>();
		successMessage.put("successMessage", "Nuovo gruppo creato correttamente");
		
		return new GroupResult(nuovoGruppo, successMessage);
	}
	 
	 public String modNomeGruppo(UtenteBean responsabile, String nome, GruppoBean gruppo) throws SQLException {
		 if(responsabile.getIdRuolo() == 1L) {
			 return "Non sei un responsabile";
		 }
		 int x = gruppoDao.update(gruppo.getIdGruppo(), nome);
		 if (x != 0) {
			 return "Modificato il nome del gruppo";
		 } else {
			 return "Non hai modificato il nome del gruppo";
		 }
	 }
	 
	 public String logicDeleteGruppo(UtenteBean responsabile, GruppoBean gruppo) throws SQLException {
		 if(responsabile.getIdRuolo() == 1L) {
			 return "Non sei un responsabile";
		}
		 int x = gruppoDao.logicDelete(gruppo);
		 if (x != 0) {
			 return "Gruppo eliminato (logicamente)";
		 } else {
			 return "Gruppo non eliminato (logicamente)";
		 }
	 }
	 
	 /*
	  * public String deleteFisicaGruppo(UtenteBean responsabile, GruppoBean gruppo) throws SQLException {
		 if(responsabile.getIdRuolo() == 1L) {
			 return "Non sei un responsabile";
		} else {
			 return gruppoDao.deleteById(gruppo.getIdGruppo());
		}
	 }
	 */

}
