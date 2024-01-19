package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.bean.UtenteBean;
import utils.DbConnection;

public class UserDao {
	
	public List<UtenteBean> findAll() throws SQLException {
		String query = "SELECT * FROM utente;";
		
		DbConnection dbCon = new DbConnection();
		Connection con = dbCon.getConnection();
		
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery(query);
		
		List<UtenteBean> utenti = new ArrayList<>();
		
		while (rs.next()) {
			UtenteBean utenteBean = new UtenteBean();
			utenteBean.setIdUtente(rs.getLong("id_utente"));
			utenteBean.setNomeUtente(rs.getString("nome"));
			utenteBean.setCognomeUtente(rs.getString("cognome"));
			utenteBean.setInformazioniGeneraliUtente(rs.getString("informazioni"));
			
			utenti.add(utenteBean);
		}
		
		dbCon.closeConnection(con);
		return utenti;
	}
	
	public UtenteBean findById(Long id) throws SQLException {
		String query = "SELECT * FROM utente WHERE id_utente = ?";
		
		DbConnection dbCon = new DbConnection();
		Connection con = dbCon.getConnection();
		
		PreparedStatement ps = con.prepareStatement(query);
		ps.setLong(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		UtenteBean utenteBean = new UtenteBean();
		
		while (rs.next()) {
			utenteBean.setIdUtente(rs.getLong("id_utente"));
		}
		
		dbCon.closeConnection(con);
		
		return utenteBean;
	}
}











