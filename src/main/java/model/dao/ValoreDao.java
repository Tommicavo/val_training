package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.bean.ValoreBean;
import utils.DbConnection;

public class ValoreDao {
	public List<ValoreBean> findAll() throws SQLException {
		String query = "SELECT * FROM valore;";

		DbConnection dbCon = new DbConnection();
		Connection con = dbCon.getConnection();

		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery(query);

		List<ValoreBean> valori = new ArrayList<>();

		while (rs.next()) {
			ValoreBean valoreBean = new ValoreBean();
			valoreBean.setIdValore(rs.getLong("id_valore"));
			valoreBean.setNomeValore(rs.getString("nome"));
			valoreBean.setVotoValore(rs.getString("voto"));
			valoreBean.setDataCreazioneValore(rs.getTimestamp("data_creazione").toLocalDateTime());
			valoreBean.setDataModificaValore(rs.getTimestamp("data_modifica").toLocalDateTime());
			valoreBean.setFlgCancellatoValore(rs.getBoolean("flg_cancellato"));

			valori.add(valoreBean);
		}

		dbCon.closeConnection(con);
		return valori;
	}

	public ValoreBean findById(Long id) throws SQLException {
		String query = "SELECT * FROM valore WHERE id_valore = ?;";

		DbConnection dbCon = new DbConnection();
		Connection con = dbCon.getConnection();

		PreparedStatement ps = con.prepareStatement(query);
		ps.setLong(1, id);

		ResultSet rs = ps.executeQuery();

		ValoreBean valoreBean = new ValoreBean();

		while (rs.next()) {
			valoreBean.setIdValore(rs.getLong("id_valore"));
			valoreBean.setNomeValore(rs.getString("nome"));
			valoreBean.setVotoValore(rs.getString("voto"));
			valoreBean.setDataCreazioneValore(rs.getTimestamp("data_creazione").toLocalDateTime());
			valoreBean.setDataModificaValore(rs.getTimestamp("data_modifica").toLocalDateTime());
			valoreBean.setFlgCancellatoValore(rs.getBoolean("flg_cancellato"));
		}

		dbCon.closeConnection(con);

		return valoreBean;
	}

	public String deleteById(Long id) throws SQLException {
        String query = "DELETE FROM valore WHERE id_valore = ?";

        DbConnection dbCon = new DbConnection();
        Connection con = dbCon.getConnection();

        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, id);

        int valid = 0;
        String validS = "";

        try {
            valid = ps.executeUpdate();
            if (valid != 0) {
                validS = "valore eliminato";
            } else {
                validS = "Valore non eliminato";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            validS = "Errore nell'operazione eseguita";
        }

        dbCon.closeConnection(con);
        return validS;
    }

	public String addValore(String nome, String voto) throws SQLException {
		String query = "INSERT INTO valore(nome, voto, data_creazione, data_modifica) VALUES (?, ?, now(), now());";

		DbConnection dbCon = new DbConnection();
		Connection con = dbCon.getConnection();

		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, nome);
		ps.setString(2, voto);

		int valid = ps.executeUpdate();
		dbCon.closeConnection(con);
		if (valid != 0) {
			return "Valore aggiunto";
		} else {
			return "Errore nell'operazione eseguita";
		}

	}

	public int update(ValoreBean valoreBean) {
        String query = "UPDATE valore SET nome=?, voto=?, data_modifica=?, flg_cancellato=? WHERE id_valore=?";

        DbConnection dbCon = new DbConnection();
        Connection con = dbCon.getConnection();

        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(query);

            ps.setString(1, valoreBean.getNomeValore());
            ps.setString(2, valoreBean.getVotoValore());
            ps.setTimestamp(3, Timestamp.valueOf(valoreBean.getDataModificaValore()));
            ps.setBoolean(4, valoreBean.isFlgCancellatoValore());
            ps.setLong(5, valoreBean.getIdValore());
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

	public int cancellazioneLogicaValore(ValoreBean valoreBean) {
		String query = "UPDATE valore SET flg_cancellato = ? WHERE id_valore = ?";

		DbConnection dbCon = new DbConnection();
		Connection con = dbCon.getConnection();

		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(query);

			ps.setBoolean(1, valoreBean.isFlgCancellatoValore());
			ps.setLong(2, valoreBean.getIdValore());
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
