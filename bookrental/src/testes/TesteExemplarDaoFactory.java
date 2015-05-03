package testes;

import util.Propriedades;

public class TesteExemplarDaoFactory {

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