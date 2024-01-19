package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import model.bean.UtenteBean;
import utils.DbConnection;

public class UtenteDao {
	
	public List<UtenteBean> findAll() {
		String query = "SELECT * FROM utente;";
		
		DbConnection dbCon = new DbConnection();
		Connection con = dbCon.getConnection();
		
		Statement st = null;
		List<UtenteBean> utenti = new ArrayList<>();
		try {
			st = con.createStatement();
			
			ResultSet rs = st.executeQuery(query);
			
			while (rs.next()) {
				UtenteBean utenteBean = new UtenteBean();
				
				utenteBean.setIdUtente(rs.getLong("id_utente"));
				utenteBean.setNomeUtente(rs.getString("nome"));
				utenteBean.setCognomeUtente(rs.getString("cognome"));
				utenteBean.setInformazioniGeneraliUtente(rs.getString("informazioni_generali"));
				utenteBean.setEmailUtente(rs.getString("email"));
				utenteBean.setPasswordUtente(rs.getString("password"));
				utenteBean.setDataCreazioneUtente(rs.getTimestamp("data_creazione").toLocalDateTime());
				utenteBean.setDataModificaUtente(rs.getTimestamp("data_modifica").toLocalDateTime());
				utenteBean.setFlgCancellatoUtente(rs.getBoolean("flg_cancellato"));
				
				utenti.add(utenteBean);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		dbCon.closeConnection(con);
		
		return utenti;
	}
	
	public UtenteBean findById(Long id) {
		String query = "SELECT * FROM utente WHERE id_utente = ?";
		
		DbConnection dbCon = new DbConnection();
		Connection con = dbCon.getConnection();
		
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(query);
			
			ps.setLong(1, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ResultSet rs;
		UtenteBean utenteBean = new UtenteBean();
		try {
			rs = ps.executeQuery();

			while (rs.next()) {
				utenteBean.setIdUtente(rs.getLong("id_utente"));
				utenteBean.setNomeUtente(rs.getString("nome"));
				utenteBean.setCognomeUtente(rs.getString("cognome"));
				utenteBean.setInformazioniGeneraliUtente(rs.getString("informazioni_generali"));
				utenteBean.setEmailUtente(rs.getString("email"));
				utenteBean.setPasswordUtente(rs.getString("password"));
				utenteBean.setDataCreazioneUtente(rs.getTimestamp("data_creazione").toLocalDateTime());
				utenteBean.setDataModificaUtente(rs.getTimestamp("data_modifica").toLocalDateTime());
				utenteBean.setFlgCancellatoUtente(rs.getBoolean("flg_cancellato"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		dbCon.closeConnection(con);
		
		return utenteBean;
	}
	
	public UtenteBean insert(UtenteBean utenteBean) {
		String query = "INSERT INTO utente (nome, cognome, informazioni_generali, email, password, data_creazione, data_modifica, flg_cancellato) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
		
		DbConnection dbCon = new DbConnection();
		Connection con = dbCon.getConnection();
		
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, utenteBean.getNomeUtente());
			ps.setString(2, utenteBean.getCognomeUtente());
			ps.setString(3, utenteBean.getInformazioniGeneraliUtente());
			ps.setString(4, utenteBean.getEmailUtente());
			ps.setString(5, utenteBean.getPasswordUtente());
			ps.setTimestamp(6, Timestamp.valueOf(utenteBean.getDataCreazioneUtente()));
			ps.setTimestamp(7, Timestamp.valueOf(utenteBean.getDataModificaUtente()));
			ps.setBoolean(8, utenteBean.isFlgCancellatoUtente());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		int insertOutput = 0;
		try {
			insertOutput = ps.executeUpdate();
			if (insertOutput == 1) {
			    ResultSet rs = ps.getGeneratedKeys();
			    if (rs.next()) {
			        utenteBean.setIdUtente(rs.getLong(1));
			        return utenteBean;
			    }
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		dbCon.closeConnection(con);
		
		return new UtenteBean();
	}
	
	public int update(UtenteBean utenteBean) {
	    String query = "UPDATE utente SET nome=?, cognome=?, informazioni_generali=?, email=?, password=?, data_modifica=?, flg_cancellato=? WHERE id_utente=?";
	    
	    DbConnection dbCon = new DbConnection();
	    Connection con = dbCon.getConnection();
	    
	    PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(query);
			
		    ps.setString(1, utenteBean.getNomeUtente());
	        ps.setString(2, utenteBean.getCognomeUtente());
	        ps.setString(3, utenteBean.getInformazioniGeneraliUtente());
	        ps.setString(4, utenteBean.getEmailUtente());
	        ps.setString(5, utenteBean.getPasswordUtente());
	        ps.setTimestamp(6, Timestamp.valueOf(utenteBean.getDataModificaUtente()));
	        ps.setBoolean(7, utenteBean.isFlgCancellatoUtente());
	        ps.setLong(8, utenteBean.getIdUtente());
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
        int updateOutput = 0;
		try {
			updateOutput = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
        dbCon.closeConnection(con);
        
        return updateOutput;
	}
	
	public int trash(UtenteBean utenteBean) {
	    String query = "UPDATE utente SET flg_cancellato=? WHERE id_utente=?";
	    
	    DbConnection dbCon = new DbConnection();
	    Connection con = dbCon.getConnection();
	    
	    PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(query);
			
	        ps.setBoolean(1, true);
	        ps.setLong(2, utenteBean.getIdUtente());
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
        int updateOutput = 0;
		try {
			updateOutput = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
        dbCon.closeConnection(con);
        
        return updateOutput;
	}
	
	public int deleteById(Long id) {
		String query = "DELETE FROM utente WHERE id_utente=?";
		
	    DbConnection dbCon = new DbConnection();
	    Connection con = dbCon.getConnection();
	    
	    PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(query);
			
		    ps.setLong(1, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    
	    int deleteOutput = 0;
		try {
			deleteOutput = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    
	    dbCon.closeConnection(con);
	    
	    return deleteOutput;
	}
}
