package testes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import entidades.Livro;

public class TesteLivroDaoJDBC {
	public static void main(String[] args) {
		testa();
	}
	
	static void testa(){
		Exemplar dummyExem = new Exemplar();		
		adiciona_(dummyExem);
		atualiza_(dummyExem);
		Livro dummyLivro = new Livro();
		buscaPorLivro_(dummyLivro);
		remove_(dummyLivro);
		
	
	}

}
