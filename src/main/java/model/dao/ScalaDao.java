
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import model.bean.ScalaBean;
import utils.DbConnection;

public class ScalaDao {

	public List<ScalaBean> findAll() throws SQLException {
		String query = "SELECT * FROM scala;";

		DbConnection dbCon = new DbConnection(); //connessione al db
		Connection con = dbCon.getConnection();

		Statement st = con.createStatement(); //non c'è il punto di domanda nella query

		ResultSet rs = st.executeQuery(query);

		List<ScalaBean> scale = new ArrayList<>();

		while (rs.next()) {
			ScalaBean scalaBean = new ScalaBean();
			scalaBean.setIdScala(rs.getLong("id_scala"));
			scalaBean.setTitoloScala(rs.getString("titolo"));
			scalaBean.setDescrizioneScala(rs.getString("descrizione"));
			scalaBean.setDataCreazioneScala(rs.getTimestamp("data_creazione").toLocalDateTime());
			scalaBean.setDataModificaScala(rs.getTimestamp("data_modifica").toLocalDateTime());
			scalaBean.setFlgCancellatoScala(rs.getBoolean("flg_cancellato"));

			scale.add(scalaBean);

		}

		dbCon.closeConnection(con);
		return scale;

	}

	public ScalaBean findById(Long id) throws SQLException {
		String query = "SELECT * FROM scala WHERE id_scala = ?";

		DbConnection dbCon = new DbConnection();
		Connection con = dbCon.getConnection();

		PreparedStatement ps = con.prepareStatement(query); //c'è il punto di domanda nella query

		ps.setLong(1, id);

		ResultSet rs = ps.executeQuery();

		ScalaBean scalaBean = new ScalaBean();

		while (rs.next()) {
			scalaBean.setIdScala(rs.getLong("id_scala"));
			scalaBean.setTitoloScala(rs.getString("titolo"));
			scalaBean.setDescrizioneScala(rs.getString("descrizione"));
			scalaBean.setDataCreazioneScala(rs.getTimestamp("data_creazione").toLocalDateTime());
			scalaBean.setDataModificaScala(rs.getTimestamp("data_modifica").toLocalDateTime());
			scalaBean.setFlgCancellatoScala(rs.getBoolean("flg_cancellato"));
		}

		dbCon.closeConnection(con);

		return scalaBean;

	}

	public String removeById(Long id) throws SQLException {
		String query = "DELETE FROM scala WHERE id_scala = ?";

		DbConnection dbCon = new DbConnection();
		Connection con = dbCon.getConnection();

		PreparedStatement ps = con.prepareStatement(query);
		ps.setLong(1, id);

		int valid = ps.executeUpdate();
		dbCon.closeConnection(con);

		if (valid != 0) {
			return "Eliminato";
		} else {
			return "C'è stato un problema";
		}
	}

	public String addScala(String titolo, String descrizione) throws SQLException {
		String query = "INSERT INTO scala (titolo, descrizione, data_creazione, data_modifica) VALUES (?,?,now(),now())";

		DbConnection dbCon = new DbConnection();
		Connection con = dbCon.getConnection();

		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, titolo);
		ps.setString(2, descrizione);

		int valid = ps.executeUpdate();

		dbCon.closeConnection(con);

		if (valid == 0) {
			return "Scala Aggiunta";
		} else {
			return "C'è stato un problema";
		}
	}

	public int updateScala(ScalaBean scalaBean) {
		String query = "UPDATE scala SET titolo=?, descrizione=?, data_modifica= now(), flg_cancellato=? WHERE id_scala=?";

		DbConnection dbCon = new DbConnection();
		Connection con = dbCon.getConnection();

		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(query);

			ps.setString(1, scalaBean.getTitoloScala());
			ps.setString(2, scalaBean.getDescrizioneScala());
			ps.setBoolean(3, scalaBean.isFlgCancellatoScala());
			ps.setLong(4, scalaBean.getIdScala());
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
	
	public int deleteScala(ScalaBean scalaBean) {
		String query = "UPDATE scala SET flg_cancellato=? WHERE id_scala=?";

		DbConnection dbCon = new DbConnection();
		Connection con = dbCon.getConnection();

		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(query);
			
			ps.setBoolean(1, scalaBean.isFlgCancellatoScala());
			ps.setLong(2, scalaBean.getIdScala());
			
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
}
    
