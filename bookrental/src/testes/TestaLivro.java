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

	static final String[] titulos = { "Capitães da Areia", "O Tempo e o Vento", "Vidas Secas", "Senhora", "A Moreninha",
			"Os Lusíadas", "Iracema", "Dom Casmurro", "Macunaíma", "O Cortiço", "A Hora da Estrela",
			"Memórias de um Sargento de Milícias", "Os Sertões", "Auto da Barca do Inferno" };
	
	static final String[] autores = { "Jorge Amado", "Érico Veríssimo", "Graciliano Ramos", "José de Alencar", "Joaquim Manuel Macedo",
			 "Luís de Camões", "José de Alencar", "Machado de Assis", "Mário de Andrade", "Aluísio Azevedo", "Clarice Lispector", 
			 "Manuel Antônio de Almeida", "Euclides da Cunha", "Gil Vicente" };


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
	
	static final String[] idioma = { "Português", "Espanhol", "Italiano", "Português", "Inglês",
		"Português", "Espanhol", "Italiano", "Português", "Inglês", "Inglês",
		"Português", "Espanhol", "Italiano"};
	
}