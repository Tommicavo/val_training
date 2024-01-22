package service;

import java.sql.SQLException;

import model.bean.GruppoBean;
import model.bean.UtenteBean;
import model.dao.GruppoDao;


public class GruppoService {
	GruppoDao gruppoDao = new GruppoDao();
	
	 public String addGruppo(UtenteBean responsabile, String nome) throws SQLException {
		if(responsabile.getIdRuolo() == 1L) {
			return "Non sei un responsabile";
		} else {
			return gruppoDao.add(nome);
		}
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
