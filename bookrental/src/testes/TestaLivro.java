package testes;

import dao.LivroDao;
import dao.LivroDaoFactory;
import entidades.Livro;

public class TestaLivro {
	

	static final Long[] ISBN = { 9788535911691L, 9788535911692L, 9788535911693L, 9788535911694L, 9788535911695L, 
		9788535911681L, 9788535911682L, 9788535911683L, 9788535914061L, 9788535911685L, 9788535911686L,
		9788535911671L, 97885359172L, 9788535911673L };

	static final String[] titulos = { "Capit�es da Areia", "O Tempo e o Vento", "Vidas Secas", "Senhora", "A Moreninha",
			"Os Lus�adas", "Iracema", "Dom Casmurro", "Macuna�ma", "O Corti�o", "A Hora da Estrela",
			"Mem�rias de um Sargento de Mil�cias", "Os Sert�es", "Auto da Barca do Inferno" };
	
	static final String[] autores = { "Jorge Amado", "�rico Ver�ssimo", "Graciliano Ramos", "Jos� de Alencar", "Joaquim Manuel Macedo",
			 "Lu�s de Cam�es", "Jos� de Alencar", "Machado de Assis", "M�rio de Andrade", "Alu�sio Azevedo", "Clarice Lispector", 
			 "Manuel Ant�nio de Almeida", "Euclides da Cunha", "Gil Vicente" };


	static final String[] editoras = { "Editora Abril", "Editora ABC", "Editora Alpha", "Editora Beta", "Editora Abril",
			"Editora ABC", "Editora Alpha", "Editora Beta", "Editora Abril", "Editora ABC", "Editora Alpha", 
			"Editora Beta","Editora Abril", "Editora ABC" };
	
	static final int[] ano = {2001, 2002, 2003, 2004, 2005, 
			1991,  1992, 1993, 1994, 1995, 1996, 
			2011, 2012, 2013 };
	
	static final int[] edicao = { 1, 2, 3, 4, 5, 
			1, 2, 3, 4, 5, 6, 
			1, 2, 3 };
	
	static final String[] sinopse = { "Editora Abril", "Editora ABC", "Editora Alpha", "Editora Beta", "Editora Abril",
		"Editora ABC", "Editora Alpha", "Editora Beta", "Editora Abril", "Editora ABC", "Editora Alpha", 
		"Editora Beta","Editora Abril", "Editora ABC" };
	
	static final int[] numPaginas = { 110, 120, 130, 140, 150, 
		210, 220, 230, 240, 250, 260, 
		80, 30, 50 };
	
	static final String[] idioma = { "Portugu�s", "Espanhol", "Italiano", "Portugu�s", "Ingl�s",
		"Portugu�s", "Espanhol", "Italiano", "Portugu�s", "Ingl�s", "Ingl�s",
		"Portugu�s", "Espanhol", "Italiano"};


	static void teste1() {
		populaBD();
		testaBuscaPorTitulo();
		testaListagens();
		testaRemocao();
		testaListagens();
		limpaBD();
	}
	
	static void teste2() {
		populaBD();
		testaAtualiza();
		testaListagens();
		limpaBD();
	}
	
	static void populaBD() {
		LivroDao livroDao = new LivroDaoFactory().getInstance();

		for (int i = 0; i < titulos.length; i++) {
			livroDao.adiciona(new Livro(ISBN[i], titulos[i], autores[i], editoras[i], 
					ano[i], edicao[i], sinopse[i], numPaginas[i], idioma[i]));
		}
	}

	static void limpaBD() {
		LivroDao livroDao = new LivroDaoFactory().getInstance();

		for (Livro livro : livroDao.listaTodos()) {
			livroDao.remove(livro);
		}
	}

	static void testaBuscaPorTitulo() {
		LivroDao livroDao = new LivroDaoFactory().getInstance();
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("------------------------ Testa busca por t�tulo -----------------------------------");
		System.out.println("-----------------------------------------------------------------------------------");

		for (int i = 0; i < titulos.length; i++) {
			System.out.println(i+ " " + livroDao.buscaPorTitulo(titulos[i]));
		}

		System.out.println("\n");
	}

	static void testaListagens() {
		LivroDao livroDao = new LivroDaoFactory().getInstance();
	
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("------------------------- Livros ordenados por autor ------------------------------");
		System.out.println("-----------------------------------------------------------------------------------");
		for (Livro livro : livroDao.listaTodosOrdenandoPorTitulo()){ 
			System.out.println(livro);
			//System.out.println("\n");
		}
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("------------------------- Livros ordenados por t�tulo -----------------------------");
		System.out.println("-----------------------------------------------------------------------------------");
		for (Livro livro : livroDao.listaTodosOrdenandoPorTitulo()) {
			System.out.println(livro);
		}
		System.out.println("\n");
	}

	static void testaRemocao() {
		LivroDao livroDao = new LivroDaoFactory().getInstance();

		for (int i = 0; i < titulos.length / 2; i++) {
			livroDao.remove(livroDao.buscaPorTitulo(titulos[i]));
		}
	}

	static void testaAtualiza() {
		LivroDao livroDao = new LivroDaoFactory().getInstance();

		for (int i = 0; i < titulos.length / 2; i++) {
			Livro livro = livroDao.buscaPorTitulo(titulos[i]);
			livro.setAutor("Autor " + i);
			livro.setEditora("Editora " + i);
			livroDao.atualiza(livro);
		}
	}
}
