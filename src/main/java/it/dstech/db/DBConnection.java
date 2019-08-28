package it.dstech.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		prep.setString(2, transazione.getDescrizione());
		prep.setString(3, transazione.getCategoria());
		prep.setDouble(4, transazione.getImporto());
		prep.executeUpdate();

	}

	public boolean loginCheck(String username, String password) throws ClassNotFoundException, SQLException {
		String query = "SELECT * from esercitazione_estiva.account where account.username = '"+ username +"' and account.password = '"+ password +"';";
		PreparedStatement state = connessionedb().prepareStatement(query);
		ResultSet result = state.executeQuery();
		if (result.next()) {
			return true;
		}
		return false;
	}

	public List<Transazioni> transazioneObjectBySQL(int id) throws ClassNotFoundException, SQLException {
		List<Transazioni> listona = new ArrayList<Transazioni>();
		String query = "Select * from esercitazione_estiva.transazioni where transazioni.idaccount ='" + id + "';";
		
		PreparedStatement prep = connessionedb().prepareStatement(query);
		ResultSet result = prep.executeQuery();
		while (result.next()) {
			Transazioni transazione = new Transazioni();
			transazione.setData(result.getString("data"));
			transazione.setCategoria(result.getString("categoria"));
			transazione.setImporto(result.getDouble("importo"));
			transazione.setDescrizione(result.getString("descrizione"));
			listona.add(transazione);
		}
		return listona;
	}

//	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		DBConnection db = new DBConnection();
//		Account account = new Account();
//	account.setId(db.recoverId(account.getUsername()));
//	System.out.println(account.getId());
//	}

	public int recoverId(String username) throws ClassNotFoundException, SQLException {
		String query = "SELECT idaccount from esercitazione_estiva.account where account.username = '" + username
				+ "';";
		PreparedStatement prep = connessionedb().prepareStatement(query);
		prep.executeQuery(query);
		int id = 0;
		ResultSet result = prep.getResultSet();
		while (result.next()) {
			id =result.getInt("idaccount");

		}
		return id;
	}
}
