package application;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
<<<<<<< HEAD

import model.bean.ParagrafoBean;
import model.bean.RuoloBean;
import model.bean.UtenteBean;
import model.dao.ParagrafoDao;
import service.UtenteService;

public class App {
	public static void main(String[] args) {
/*		RuoloBean ruolo_1 = new RuoloBean(1l, "responsabile");
//		System.out.println(ruolo_1);
//		System.out.println("Hash Code: " + ruolo_1.hashCode());
//		System.out.println("isEquals: " + ruolo_1.equals(ruolo_1));
		
=======
import model.bean.UtenteBean;
import model.dao.UtenteDao;
// import service.UtenteService;

public class App {
	public static void main(String[] args) {	
>>>>>>> develop
		
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
*/
		
		//ESEGUI QUERY SUL DATABASE
		
		ParagrafoBean pb = new ParagrafoBean();
		pb.setTitoloParagrafo("PROVA TITOLO1");
		pb.setDescrizioneParagrafo("PROVA DESCRIZIONE1");
		ParagrafoDao pd = new ParagrafoDao();
		
		try {
			int result;
			//AGGIUNGI PARAGRAFO
			result = pd.add(pb);
			if(result == 1) System.out.println("PARAGRAFO AGGIUNTO");
			else System.out.println("PARAGRAFO non INSERTIO CORRETTAMENTE");
			
			
			//VISUALIZZA TUTTI I PARAGRAFI
			List<ParagrafoBean> listaParagrafo;
			listaParagrafo = pd.findAll();
			for(ParagrafoBean paragrafo : listaParagrafo) {
				System.out.println(paragrafo.toString());
			}
			
			//ELIMINA UN PARAGRAFO
			result = pd.delete((long)32);
			if(result == 1) System.out.println("PARAGRAFO ELIMINATO");
			else System.out.println("PARAGRAFO non ELIMINATO CORRETTAMENTE");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
