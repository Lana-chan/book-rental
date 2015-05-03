package testes;

import java.text.Collator;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import entidades.Livro;
import entidades.Exemplar;
import dao.LivroDao;


public class TesteLivroDao {
	
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
