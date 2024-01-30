package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.bean.ParagrafoBean;
import utils.DbConnection;

public class ParagrafoDao {
	
	public List<ParagrafoBean> findAll() throws SQLException {
		String query = "SELECT * FROM paragrafo;";
		
		DbConnection dbCon = new DbConnection();
		Connection con = dbCon.getConnection();
		
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery(query);
		
		List<ParagrafoBean> paragrafi = new ArrayList<>();
		
		while (rs.next()) {
			ParagrafoBean paragrafoBean = new ParagrafoBean();
			paragrafoBean.setIdParagrafo(rs.getLong("id_paragrafo"));
			paragrafoBean.setTitoloParagrafo(rs.getString("titolo"));
			paragrafoBean.setDescrizioneParagrafo(rs.getString("descrizione"));
			paragrafoBean.setDataCreazioneParagrafo(rs.getTimestamp("data_creazione").toLocalDateTime());
			paragrafoBean.setDataModificaParagrafo(rs.getTimestamp("data_modifica").toLocalDateTime());
			paragrafoBean.setFlgCancellatoParagrafo(rs.getBoolean("flg_cancellato"));
			
			paragrafi.add(paragrafoBean);
		}
		
		dbCon.closeConnection(con);
		return paragrafi;
	}
	
	public ParagrafoBean findById(Long id) throws SQLException {
		String query = "SELECT * FROM paragrafo WHERE id_paragrafo = ?";
		
		DbConnection dbCon = new DbConnection();
		Connection con = dbCon.getConnection();
		
		PreparedStatement ps = con.prepareStatement(query);
		ps.setLong(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		ParagrafoBean paragrafoBean = new ParagrafoBean();
		
		//estraggo l'unica riga ricavata
		rs.next();
		paragrafoBean.setIdParagrafo(rs.getLong("id_paragrafo"));
		paragrafoBean.setTitoloParagrafo(rs.getString("titolo"));
		paragrafoBean.setDescrizioneParagrafo(rs.getString("descrizione"));
		paragrafoBean.setDataCreazioneParagrafo(rs.getTimestamp("data_creazione").toLocalDateTime());
		paragrafoBean.setDataModificaParagrafo(rs.getTimestamp("data_modifica").toLocalDateTime());
		paragrafoBean.setFlgCancellatoParagrafo(rs.getBoolean("flg_cancellato"));
		
		dbCon.closeConnection(con);
		
		return paragrafoBean;
	}
	
	public int add(ParagrafoBean paragrafoBean) throws SQLException {
		String query = "INSERT INTO paragrafo (titolo, descrizione, data_creazione, data_modifica) VALUES (?, ?, NOW(), NOW())";
		
		DbConnection dbCon = new DbConnection();
		Connection con = dbCon.getConnection();
		
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, paragrafoBean.getTitoloParagrafo());
		ps.setString(2, paragrafoBean.getDescrizioneParagrafo());
		
		int result = ps.executeUpdate();
		
		dbCon.closeConnection(con);
		
		return result;
	}
	
	public int update(ParagrafoBean paragrafoBean) throws SQLException {
		String query = "UPDATE paragrafo SET titolo = ?, descrizione = ?, data_modifica = NOW() WHERE id_paragrafo = ?";
		
		DbConnection dbCon = new DbConnection();
		Connection con = dbCon.getConnection();
		
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, paragrafoBean.getTitoloParagrafo());
		ps.setString(2, paragrafoBean.getDescrizioneParagrafo());
		//ps.setTimestamp(3, Timestamp.valueOf(paragrafoBean.getDataModificaParagrafo()));
		ps.setLong(3, paragrafoBean.getIdParagrafo());
		
		int result = ps.executeUpdate();
		
		dbCon.closeConnection(con);
		
		return result;
	}
	
	public int delete(Long id) throws SQLException {
		/*
		 * String query = "DELETE FROM paragrafo WHERE id_paragrafo = ?"; //CANCELLAZIONE FISICA
		 */
		
		String query = "UPDATE paragrafo SET flg_cancellato = true WHERE id_paragrafo = ?"; //CANCELLAZIONE VIRTUALE
		
		DbConnection dbCon = new DbConnection();
		Connection con = dbCon.getConnection();
		
		PreparedStatement ps = con.prepareStatement(query);
		ps.setLong(1, id);
		
		int result = ps.executeUpdate();
		
		dbCon.closeConnection(con);
		
		return result;
	}

}











