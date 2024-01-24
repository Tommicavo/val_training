package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.bean.RuoloBean;
import utils.DbConnection;

public class RuoloDao {
	
	public List<RuoloBean> findAll() {
		String query = "SELECT * FROM ruolo;";
		
		DbConnection dbCon = new DbConnection();
		Connection con = dbCon.getConnection();
		
		Statement st = null;
		List<RuoloBean> ruoli = new ArrayList<>();
		try {
			st = con.createStatement();
			
			ResultSet rs = st.executeQuery(query);
			
			while (rs.next()) {
				RuoloBean ruoloBean = new RuoloBean();
				
				ruoloBean.setIdRuolo(rs.getLong("id_ruolo"));
				ruoloBean.setNomeRuolo(rs.getString("nome"));
				
				ruoli.add(ruoloBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		dbCon.closeConnection(con);
		
		return ruoli;
	}
	
	public RuoloBean findById(Long id) {
		String query = "SELECT * FROM ruolo WHERE id_ruolo=?";
		
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
		RuoloBean ruoloBean = new RuoloBean();
		try {
			rs = ps.executeQuery();

			while (rs.next()) {
				ruoloBean.setIdRuolo(rs.getLong("id_ruolo"));
				ruoloBean.setNomeRuolo(rs.getString("nome"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		dbCon.closeConnection(con);
		
		return ruoloBean;
	}
	
	public RuoloBean insert(RuoloBean ruoloBean) {
		String query = "INSERT INTO ruolo (nome) VALUES (?);";
		
		DbConnection dbCon = new DbConnection();
		Connection con = dbCon.getConnection();
		
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, ruoloBean.getNomeRuolo());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		int insertOutput = 0;
		try {
			insertOutput = ps.executeUpdate();
			if (insertOutput == 1) {
			    ResultSet rs = ps.getGeneratedKeys();
			    if (rs.next()) {
			    	Long idNuovoRuolo = rs.getLong(1);
			        return findById(idNuovoRuolo);
			    }
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		dbCon.closeConnection(con);
		
		return new RuoloBean();
	}
	
	public int update(RuoloBean ruoloBean) {
	    String query = "UPDATE ruolo SET nome=? WHERE id_ruolo=?";
	    
	    DbConnection dbCon = new DbConnection();
	    Connection con = dbCon.getConnection();
	    
	    PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(query);
			
		    ps.setString(1, ruoloBean.getNomeRuolo());
	        ps.setLong(2, ruoloBean.getIdRuolo());
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
		String query = "DELETE FROM ruolo WHERE id_ruolo=?";
		
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
