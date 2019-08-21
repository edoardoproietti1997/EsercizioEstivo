package it.dstech.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.dstech.model.Account;
import it.dstech.model.Transazioni;

public class DBConnection {

	public Connection connessionedb() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/esercitazione_estiva?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
				"root", "root");
		return conn;
	}

	public void addAccount(Account account) throws SQLException, ClassNotFoundException {
		String query = "INSERT INTO esercitazione_estiva.account (`username`, `password`) VALUES( ? , ?);";
		PreparedStatement prep = connessionedb().prepareStatement(query);
		prep.setString(1, account.getUsername());
		prep.setString(2, account.getPassword());
		prep.executeUpdate();
		prep.close();
	}

	public boolean usernameCheck(String username) throws ClassNotFoundException, SQLException {
		String query = "SELECT * from esercitazione_estiva.account where account.username = ?;";
		PreparedStatement prep = connessionedb().prepareStatement(query);
		prep.setString(1, username);
		ResultSet result = prep.executeQuery();
		if (result.next()) {
			return true;
		}
		return false;

	}

	public void insertTransazione(Transazioni transazione) throws ClassNotFoundException, SQLException {
		String query = "INSERT INTO `esercitazione_estiva`.`transazioni` (`data`, `descrizione`, `categoria`, `importo`) VALUES (?, ?, ?, ?)";
		PreparedStatement prep = connessionedb().prepareStatement(query);
		prep.setString(1, transazione.getData());
		prep.setString(2 , transazione.getDescrizione());
		prep.setString(3 ,  transazione.getCategoria());
		prep.setDouble(4, transazione.getImporto());
		prep.executeUpdate();
		
	}
	
	public boolean loginCheck(String username, String password) throws ClassNotFoundException, SQLException {
		String query = "SELECT * from esercitazione_estiva.account where account.username = ? and account.password = ?;";
		PreparedStatement state = connessionedb().prepareStatement(query);
		state.setString(1, username);
		state.setString(2, password);
		ResultSet result = state.executeQuery(query);
		if (result.next()) {
			return true;
		}
		return false;
	}
	
	public Transazioni transazioneObjectBySQL(Transazioni transazione, Account account) throws ClassNotFoundException, SQLException {
		String query = "Select * from esercitazione_estiva.transazione where transazione.idaccount ='"+ account.getId() + "';";
		PreparedStatement prep = connessionedb().prepareStatement(query);
		ResultSet result = prep.executeQuery();
		transazione.setData(result.getString("data"));
		transazione.setCategoria((result.getString("categoria")));
		transazione.setImporto(result.getDouble("importo"));
		transazione.setDescrizione(result.getString("descrizione"));
		return transazione;
	}
}
