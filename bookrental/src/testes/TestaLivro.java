package testes;

import entidades.Avaliacao;
import entidades.Exemplar;
import entidades.Livro;
import entidades.Solicitacao;
import entidades.Unidade;

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
	
}