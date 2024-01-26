package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import model.bean.GruppoBean;
import utils.DbConnection;

public class GruppoDao {

	public List<GruppoBean> findAll() throws SQLException {
		String query = "SELECT * FROM gruppo;";
		List<GruppoBean> gruppi = new ArrayList<>();
		
		DbConnection dbCon = new DbConnection();
		Connection con = dbCon.getConnection();
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);	
			
		while (rs.next()) {
			GruppoBean gruppoBean = new GruppoBean();
			gruppoBean.setIdGruppo(rs.getLong("id_gruppo"));
			gruppoBean.setNomeGruppo(rs.getString("nome"));
			gruppoBean.setDataCreazioneGruppo(rs.getTimestamp("data_crezione").toLocalDateTime());
			gruppoBean.setDataModificaGruppo(rs.getTimestamp("data_modifica").toLocalDateTime());
			gruppoBean.setFlgCancellatoGruppo(rs.getBoolean("flg_cancellato"));
			gruppi.add(gruppoBean);
		}
		
		dbCon.closeConnection(con);
		return gruppi;
	}
	
	public GruppoBean findById(Long id) throws SQLException {
		String query = "SELECT * FROM gruppo WHERE id_gruppo=?;";
		
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
		GruppoBean gruppoBean = new GruppoBean();
		try {
			rs = ps.executeQuery();

			while (rs.next()) {
				gruppoBean.setIdGruppo(rs.getLong("id_gruppo"));
				gruppoBean.setNomeGruppo(rs.getString("nome"));
				gruppoBean.setDataCreazioneGruppo(rs.getTimestamp("data_creazione").toLocalDateTime());
				gruppoBean.setDataModificaGruppo(rs.getTimestamp("data_modifica").toLocalDateTime());
				gruppoBean.setFlgCancellatoGruppo(rs.getBoolean("flg_cancellato"));
				gruppoBean.setIdResponsabile(rs.getLong("id_responsabile"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		dbCon.closeConnection(con);
		
		return gruppoBean;
	}
	
	public boolean findByName(String nome) {
		return false;
	}
	
	public String deleteById(Long id) throws SQLException {
		String query = "DELETE FROM gruppo WHERE id_gruppo = ?";
		
		DbConnection dbCon = new DbConnection();
		Connection con = dbCon.getConnection();
		
		PreparedStatement ps = con.prepareStatement(query);
		ps.setLong(1, id);	
		
		int valid = 0;
        String validS = "";
        
        try {
        	valid = ps.executeUpdate();
        	if (valid != 0) {
        		validS = "Gruppo eliminato";
            } else {
            	validS = "C'è stato un problema";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            validS = "C'è stato un problema";
        }
        
        dbCon.closeConnection(con);
        return validS;
	}
		
	public GruppoBean insert(GruppoBean gruppoBean) {
		String query = "INSERT INTO gruppo (nome, data_creazione, data_modifica, flg_cancellato, id_responsabile) VALUES (?, ?, ?, ?, ?);";

		DbConnection dbCon = new DbConnection();
		Connection con = dbCon.getConnection();
		
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, gruppoBean.getNomeGruppo());
			ps.setTimestamp(2, Timestamp.valueOf(gruppoBean.getDataCreazioneGruppo()));
			ps.setTimestamp(3, Timestamp.valueOf(gruppoBean.getDataModificaGruppo()));
			ps.setBoolean(4, gruppoBean.isFlgCancellatoGruppo());
			ps.setLong(5, gruppoBean.getIdResponsabile());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		int insertOutput = 0;
		try {
			insertOutput = ps.executeUpdate();
			if (insertOutput == 1) {
			    ResultSet rs = ps.getGeneratedKeys();
			    if (rs.next()) {
			    	Long idNuovoGruppo = rs.getLong(1);
			        return findById(idNuovoGruppo);
			    }
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		dbCon.closeConnection(con);
		
		return new GruppoBean();
	}
	
	public int update(Long id, String nome) throws SQLException {
		String query = "UPDATE gruppo SET nome = ?, data_modifica = now() WHERE id_gruppo = ?";
		
		DbConnection dbCon = new DbConnection();
        Connection con = dbCon.getConnection();
        
        PreparedStatement ps = null;
        
        try {
          ps = con.prepareStatement(query);
          ps.setString(1, nome);
          ps.setLong(2, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        int valid = 0;
        
        try {
        	valid = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        dbCon.closeConnection(con);
        return valid;
	}
	
	public int logicDelete(GruppoBean gruppo) throws SQLException {
		String query = "UPDATE gruppo SET flg_cancellato = ? WHERE id_gruppo = ?";
		
		DbConnection dbCon = new DbConnection();
        Connection con = dbCon.getConnection();
        
        PreparedStatement ps = null;
        
        try {
          ps = con.prepareStatement(query);
          ps.setBoolean(1, gruppo.isFlgCancellatoGruppo());
          ps.setLong(2, gruppo.getIdGruppo());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        int valid = 0;
        
        try {
        	valid = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        dbCon.closeConnection(con);
        return valid;
	}
}
