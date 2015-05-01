package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import util.Propriedades;

public class JDBCConnectionFactory {
	private boolean jaRodou=false;
	
	public Connection getConnection() {
		Propriedades prop = new Propriedades();
		Connection c = null;
		 Statement stmt = null;
		
		 
		
		try {
			Class.forName(prop.getPropriedade("jdbcDriver"));
			 c=DriverManager.getConnection(prop.getPropriedade("jdbcConnectionString"), prop.getPropriedade("jdbcUser"),
					prop.getPropriedade("jdbcPassword"));
			 if(jaRodou==false){
				 stmt = c.createStatement();
				 stmt.executeUpdate(criaDatabase());
				 stmt.close();
			 }
			 
			 return c;
		} catch (SQLException e) {

			System.out.println(e.getErrorCode());
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
	
	public String criaDatabase() {
		String limpaDatabase=" DROP TABLE IF EXISTS Livro; DROP TABLE IF EXISTS Usuario; DROP TABLE IF EXISTS Avaliacao; "+
							" DROP TABLE IF EXISTS Exemplar;DROP TABLE IF EXISTS Solicitacao; DROP TABLE IF EXISTS Notificacao;";
	      String sql = " CREATE table Livro (" +
                       "ISBN     				BIGINT    	NOT NULL PRIMARY KEY, " + 
	                   " titulo         		TEXT   	NOT NULL, " +
	                   " autor          		TEXT   	NOT NULL, " + 
	                   " editora        		TEXT   	NOT NULL," + 
	                   " ano					INT		NOT NULL," +
	                   " edicao					INT		NOT NULL," +	                   
	                   " numPaginas				INT		NOT NULL," +
	                   " idioma         		TEXT    NOT NULL, " + 
	                   " sinopse        		TEXT    NOT NULL ); " +
	      //tabela usuario
	      
	      				"CREATE TABLE Usuario (" +
	                   " numUsp					TEXT	NOT NULL	PRIMARY KEY,"+
	                   " nome					TEXT	NOT NULL,"+
	                   " unidade        		TEXT    NOT NULL, " + //É DO TIPO UNIDADE, AINDA ESTOU EM DUVIDA
	                   " email       			TEXT    NOT NULL, " +
	                   " foto          			TEXT    NOT NULL, " + 
	                   " colecao 				TEXT	NOT NULL,"+ // private List<Exemplar> colecao = new ArrayList<Exemplar>(); //lista, talvez só precisa de select e não campo
	                   " reputacao      		TEXT    NOT NULL); " +//private List<Avaliacao> reputacao = new ArrayList<Avaliacao>(); //lista
	                   
	      //tabela avaliacao
	      				"CREATE TABLE Avaliacao (" +
	      				"id  				INT		AUTO_INCREMENT, " + 
	      				" nota          	INT    NOT NULL, " +
	      				" comentario        TEXT    NOT NULL, " +
	      				" critico			TEXT    NOT NULL," +
	      				" FOREIGN KEY (critico) REFERENCES Usuario(numUsp)" +
	      				"PRIMARY KEY	(id)); "; /* +
		  //tabela EXEMPLAR
		  				"CREATE TABLE Exemplar (" +
				        "id  			unsigned	NOT NULL	PRIMARY KEY	AUTO_INCREMENT, " + 
	      				"FOREIGN KEY (livro)	REFERENCES Livro(ISBN),"+
				        " disponivel					boolean			NOT NULL,"+
				        " FOREIGN KEY (proprietario)  REFERENCES  Usuario(numUsp) 	NOT NULL,"+ 
				        " FOREIGN KEY (receptor)  	REFERENCES  Usuario(numUsp) 	NOT NULL,"+
				        " confirmaEntregaDoador     	boolean    		NOT NULL,"+ 
				        " confirmaEntregaReceptor 		boolean			NOT NULL,"+ 
				      //  " solicitacoes					Solicitacoes    NOT NULL,"+
				        " foto							TEXT			NOT NULL);"
	      				+
	      //tabela SOLICITAÇÃO
	      				"CREATE TABLE Solicitacao (" +
				        "id  	unsigned	NOT NULL 	PRIMARY KEY		AUTO_INCREMENT, " + 
	      				" FOREIGN KEY (exemplar)			REFERENCES	Exemplar(id)	NOT NULL,"+
				        " FOREIGN KEY (doador)			REFERENCES  Usuario(numUsp)		NOT NULL,"+
				        " FOREIGN KEY (receptor)  		REFERENCES  Usuario(numUsp) 	NOT NULL, " + //É DO TIPO UNIDADE, AINDA ESTOU EM DUVIDA
				        " solicitacaoDeferida       	boolean    	NOT NULL, " +
				        " confirmaEntregaDoador         TEXT    	NOT NULL, " + 
				        " confirmaEntregaReceptor 		TEXT		NOT NULL,"+ // private List<Exemplar> colecao = new ArrayList<Exemplar>(); //lista
				        " mensagem				      	TEXT    	NOT NULL); "
				        +
		  //tabela NOTIFICACAO
		  				"CREATE TABLE Notificacao (" +
				        "id  	unsigned	NOT NULL 	PRIMARY KEY		AUTO_INCREMENT, " + 
	      				" FOREIGN KEY (remetente)					REFERENCES  Usuario(numUsp)			NOT NULL,"+
				        " FOREIGN KEY (destinatario)				REFERENCES  Usuario(numUsp)			NOT NULL,"+
				        " mensagem        			TEXT    		NOT NULL, "+ 
				        " data     					TIMESTAMP    	NOT NULL, "+
				        " lida     					BOOLEAN    		NOT NULL);";
		*/
	      jaRodou=true;
	     return limpaDatabase+sql;
	}
	
	/* public static void main( String args[] ) {
		JDBCConnectionFactory j=new JDBCConnectionFactory();
		j.getConnection();
	 }
	*/
	
	
	
	
}



