package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import model.bean.SezioneBean;
import utils.DbConnection;
// test
public class SezioneDao {
	
	public List<SezioneBean> findAll() {
		String query = "SELECT * FROM sezione;";
		
		DbConnection dbCon = new DbConnection();
		Connection con = dbCon.getConnection();
		
		Statement st = null;
		List<SezioneBean> sezioni = new ArrayList<>();
		try {
			st = con.createStatement();
			
			ResultSet rs = st.executeQuery(query);
			
			while (rs.next()) {
				SezioneBean sezioneBean = new SezioneBean();
				
				sezioneBean.setIdSezione(rs.getLong("id_sezione"));
				sezioneBean.setTitoloSezione(rs.getString("titolo"));
				
				sezioni.add(sezioneBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		dbCon.closeConnection(con);
		
		return sezioni;
	}
	
	public SezioneBean findById(Long id) {
		String query = "SELECT * FROM sezione WHERE id_sezione=?";
		
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
		SezioneBean sezioneBean = new SezioneBean();
		try {
			rs = ps.executeQuery();

			while (rs.next()) {
				sezioneBean.setIdSezione(rs.getLong("id_sezione"));
				sezioneBean.setTitoloSezione(rs.getString("titolo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		dbCon.closeConnection(con);
		
		return sezioneBean;
	}
	
	public SezioneBean insert(SezioneBean sezioneBean) {
		String query = "INSERT INTO sezione (titolo, data_creazione, data_modifica, flg_cancellato) VALUES (?, ?, ?, ?);";
		
		DbConnection dbCon = new DbConnection();
		Connection con = dbCon.getConnection();
		
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, sezioneBean.getTitoloSezione());
			ps.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
			ps.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
			ps.setBoolean(4, sezioneBean.isFlgCancellatoSezione());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		int insertOutput = 0;
		try {
			insertOutput = ps.executeUpdate();
			if (insertOutput == 1) {
			    ResultSet rs = ps.getGeneratedKeys();
			    if (rs.next()) {
			    	Long idNuovaSezione = rs.getLong(1);
			        return findById(idNuovaSezione);
			    }
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		dbCon.closeConnection(con);
		
		return new SezioneBean();
	}
	
	public int update(SezioneBean sezioneBean) {
	    String query = "UPDATE sezione SET titolo=? WHERE id_sezione=?";
	    
	    DbConnection dbCon = new DbConnection();
	    Connection con = dbCon.getConnection();
	    
	    PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(query);
			
		    ps.setString(1, sezioneBean.getTitoloSezione());
	        ps.setLong(2, sezioneBean.getIdSezione());
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
	
	public int trash(SezioneBean sezioneBean) {
	    String query = "UPDATE sezione SET flg_cancellato=? WHERE id_sezione=?";
	    
	    DbConnection dbCon = new DbConnection();
	    Connection con = dbCon.getConnection();
	    
	    PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(query);
			
	        ps.setBoolean(1, true);
	        ps.setLong(2, sezioneBean.getIdSezione());
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
        int trashOutput = 0;
		try {
			trashOutput = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
        dbCon.closeConnection(con);
        
        return trashOutput;
	}
	// prova
	public int deleteById(Long id) {
		String query = "DELETE FROM sezione WHERE id_sezione=?";
		
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
	
	public void test() {
		System.out.println("test");
	}
}

