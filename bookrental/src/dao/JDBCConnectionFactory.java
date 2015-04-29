package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import util.Propriedades;

public class JDBCConnectionFactory {

	public Connection getConnection() {
		Propriedades prop = new Propriedades();

		try {
			Class.forName(prop.getPropriedade("jdbcDriver"));
			return DriverManager.getConnection(prop.getPropriedade("jdbcConnectionString"), prop.getPropriedade("jdbcUser"),
					prop.getPropriedade("jdbcPassword"));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public void close(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	 public static void main( String args[] ) {
		 Statement stmt = null;
		 stmt = c.createStatement();
	      String sql = "CREATE TABLE livro " +
	                   "(ID INT PRIMARY KEY     NOT NULL," +
	                   " ISBN           TEXT    NOT NULL, " + 
	                   " TITULO         TEXT    NOT NULL, " +
	                   " AUTOR          TEXT    NOT NULL, " + 
	                   " EDITORA        TEXT    NOT NULL," + 
	                   " ANO			INT		NOT NULL," +
	                   " EDICAO			TEXT	NOT NULL," +	                   
	                   " NUMPAGINAS		TEXT	NOT NULL," +
	                   " IDIOMA         TEXT    NOT NULL, " + 
	                   " SINOPSE        TEXT    NOT NULL) +"
	      //tabela usuario
	                   "CREATE TABLE USUARIO" +
	                   "( numUsp		"+
		 
		 
	 }
	
	
	
	
	
}
