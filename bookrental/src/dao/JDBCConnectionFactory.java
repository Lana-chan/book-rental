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
                       "(id           	INT 	AUTO_INCREMENT, " + 
                  	   "(ISBN           BIGINT  NOT NULL, " + 
	                   " tiutlo         TEXT    NOT NULL, " +
	                   " autor          TEXT    NOT NULL, " + 
	                   " editora        TEXT    NOT NULL," + 
	                   " ano			INT		NOT NULL," +
	                   " edicao			INT		NOT NULL," +	                   
	                   " numPaginas		TEXT	NOT NULL," +
	                   " idioma         TEXT    NOT NULL, " + 
	                   " sinopse        TEXT    NOT NULL)";
	      //tabela usuario
	      String sql2 = "CREATE TABLE Usuario" +
	                   "(numUsp			TEXT	NOT NULL,"+
	                   " nome			TEXT	NOT NULL,"+
	                   " unidade        TEXT    NOT NULL, " + //É DO TIPO UNIDADE, AINDA ESTOU EM DUVIDA
	                   " email       	TEXT    NOT NULL, " +
	                   " foto          	TEXT    NOT NULL, " + 
	                   " colecao 		TEXT	NOT NULL,"+ // private List<Exemplar> colecao = new ArrayList<Exemplar>(); //lista, talvez só precisa de select e não campo
	                   " reputacao      TEXT    NOT NULL)"; //private List<Avaliacao> reputacao = new ArrayList<Avaliacao>(); //lista
	                   
	      //tabela avaliacao
	      	String sql3 = "CREATE TABLE Avaliacao " +
	      				"(nota          	INT    NOT NULL, " +
	      				" comentario        TEXT    NOT NULL, " +
	      				" FOREIGN KEY critico REFERENCES Usuario(id)       TEXT    NOT NULL)"; //é do tipo usuario
	      				
		  //tabela SOLICITAÇÃO
	      String sql4 = "CREATE TABLE Solicitacao" +
				        "(exemplar						Exemplar	NOT NULL,"+
				        " doador						Usuario		NOT NULL,"+
				        " FOREIGN KEY receptor  REFERENCES  Usuario(id) 	NOT NULL, " + //É DO TIPO UNIDADE, AINDA ESTOU EM DUVIDA
				        " solicitacaoDeferida       	TEXT    	NOT NULL, " +
				        " confirmaEntregaDoador         TEXT    	NOT NULL, " + 
				        " confirmaEntregaReceptor 		TEXT		NOT NULL,"+ // private List<Exemplar> colecao = new ArrayList<Exemplar>(); //lista
				        " mensagem				      	TEXT    	NOT NULL)";      
		 
		  //tabela EXEMPLAR
	      String sql5 = "CREATE TABLE Exemplar" +
				        "(FOREIGN KEY livro	REFERENCES Livro(id),"+
				        " disponivel					Usuario			NOT NULL,"+
				        " FOREIGN KEY proprietario  REFERENCES  Usuario(numUsp) 	NOT NULL,"+ 
				        " FOREIGN KEY receptor  REFERENCES  Usuario(numUsp) 	NOT NULL,"+
				        " confirmaEntregaDoador     	TEXT    		NOT NULL,"+ 
				        " confirmaEntregaReceptor 		TEXT			NOT NULL,"+ // private List<Exemplar> colecao = new ArrayList<Exemplar>(); //lista
				        " solicitacoes					Solicitacoes    NOT NULL,"+
				        " foto							TEXT			NOT NULL)"; 
	     
		  //tabela NOTIFICACAO
	      String sql6 = "CREATE TABLE Notificacao" +
				        "(remetente					Livro			NOT NULL,"+
				        " destinatario				Usuario			NOT NULL,"+
				        " mensagem        			TEXT    		NOT NULL, "+ 
				        " data     					TIMESTAMP    	NOT NULL, "+
				        " lida     					BOOLEAN    		NOT NULL)";

	 }
	
	
	
	
	
}



