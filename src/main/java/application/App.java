package application;

import java.sql.SQLException;
import java.util.List;

import model.bean.GruppoBean;
import model.bean.UtenteBean;
import model.dao.GruppoDao;
import model.dao.UtenteDao;

public class App {
	public static void main(String[] args) throws SQLException {
		
		UtenteDao utenteDao = new UtenteDao();
		UtenteBean utenteBean = utenteDao.findById(62l);
		System.out.println(utenteBean);
		
		System.out.println("Test findAllGroupless:");
		List<UtenteBean> utenti = utenteDao.findAllGroupless();
		for (UtenteBean u : utenti) {
			System.out.println("U: " + u);
		}
		
		GruppoDao gruppoDao = new GruppoDao();
		GruppoBean gruppoBean = gruppoDao.findById(9L);
		System.out.println("GruppoBean: " + gruppoBean);
	}
}
