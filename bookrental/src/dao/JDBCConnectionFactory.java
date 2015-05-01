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
                       " ISBN     					BIGINT  	NOT NULL , " + 
	                   " titulo         			TEXT   		NOT NULL, " +
	                   " autor          			TEXT   		NOT NULL, " + 
	                   " editora        			TEXT   		NOT NULL," + 
	                   " ano						INT			NOT NULL," +
	                   " edicao						INT			NOT NULL," +	                   
	                   " numPaginas					INT			NOT NULL," +
	                   " idioma         			TEXT    	NOT NULL, " + 
	                   " sinopse        			TEXT    	NOT NULL, " +
	                   " PRIMARY KEY(ISBN)); " +
	      
	      //tabela usuario
	      			   " CREATE TABLE Usuario (" +
	                   " numUsp						int			NOT NULL,"+
	                   " nome						TEXT		NOT NULL,"+
	                   " unidade        			TEXT    	NOT NULL, " + //É DO TIPO UNIDADE, AINDA ESTOU EM DUVIDA
	                   " email       				TEXT    	NOT NULL, " +
	                   " foto          				TEXT    	NOT NULL," +
	                   " PRIMARY KEY(numUsp)); " +	                   
 
	      //tabela avaliacao
	      				" CREATE TABLE Avaliacao (" +
	      				" id  						INT			AUTO_INCREMENT, " + 
	      				" nota          			INT    		NOT NULL, " +
	      				" comentario        		TEXT    	NOT NULL, " +
	      				" critico					int    		NOT NULL," +
	      				" FOREIGN KEY (critico) 	REFERENCES 	Usuario(numUsp)," +
	      				" PRIMARY KEY	(id)); "  +
		 
	      	//tabela EXEMPLAR
		  				"CREATE TABLE Exemplar (" +
				        " id  							int 		AUTO_INCREMENT, " + 
		  				" livro							bigint		NOT NULL, "+
				        " disponivel					boolean		NOT NULL,"+
		  				" proprietario					int			NOT NULL,"+
				        " receptor						int			NOT NULL,"+
				        " confirmaEntregaDoador     	boolean    	NOT NULL,"+ 
				        " confirmaEntregaReceptor 		boolean		NOT NULL,"+ 
				        " foto							TEXT		NOT NULL, "+
				        " FOREIGN KEY (proprietario)  	REFERENCES  Usuario(numUsp),"+ 
				        " FOREIGN KEY (receptor)  		REFERENCES  Usuario(numUsp),"+
				        " FOREIGN KEY (livro)			REFERENCES 	Livro(ISBN),"+
				        " PRIMARY KEY	(id));" +
	      				
	      //tabela SOLICITAÇÃO
	      				"CREATE TABLE Solicitacao (" +
				        " id  							int			AUTO_INCREMENT, " +
	      				" exemplar						int			NOT NULL," +
		  				" doador						int			NOT NULL,"+
				        " receptor						int			NOT NULL,"+
				        " solicitacaoDeferida       	boolean    	NOT NULL, " +
				        " confirmaEntregaDoador         boolean    	NOT NULL, " + 
				        " confirmaEntregaReceptor 		boolean		NOT NULL,"+ 
				        " mensagem				      	TEXT    	NOT NULL, " +
	      				" FOREIGN KEY (exemplar)		REFERENCES	Exemplar(id),"+
				        " FOREIGN KEY (doador)			REFERENCES  Usuario(numUsp),"+
				        " FOREIGN KEY (receptor)  		REFERENCES  Usuario(numUsp), " +
				        " PRIMARY KEY (id));"+
				        
		  //tabela NOTIFICACAO
		  				"CREATE TABLE Notificacao (" +
				        " id  							int			AUTO_INCREMENT, " + 
		  				" remetente						int			NOT NULL,"+
				        " destinatario					int			NOT NULL,"+
				        " mensagem        				TEXT    	NOT NULL, "+ 
				        " data     						TIMESTAMP   NOT NULL, "+
				        " lida     						BOOLEAN    	NOT NULL,"+
	      				" FOREIGN KEY (remetente)		REFERENCES  Usuario(numUsp),"+
				        " FOREIGN KEY (destinatario)	REFERENCES  Usuario(numUsp),"+
				        " PRIMARY KEY (id));";
		
	      jaRodou=true;
	     return limpaDatabase+sql;
	}
	
	/*
	 * Algumas outras instruções
			//calcula reputacao
			SELECT AVG(nota) As Reputacao From Avaliacao WHERE critico='Usuario.numUsp'
			
			//mostra os livros de um usuario
			SELECT * FROM Exemplar WHERE proprietario='Usuario.numUsp'
			
			//notifica doador
			SELECT * FROM Solicitacao WHERE doador='Usuario.numUsp'
			
			//notifica receptor
			SELECT * FROM Solicitacao WHERE receptor='Usuario.numUsp'
			
			//mostra as solicitacoes de um exemplar
			SELECT * FROM Solicitacao WHERE exemplar='exemplar.isbn'
	*/
	
	
	
	
}



