package testes;

import dao.ExemplarDao;
import dao.ExemplarDaoFactory;

import entidades.Usuario;
import entidades.Exemplar;
import entidades.Livro;
import entidades.Unidade;

public class TestaExemplar {
	static void teste1() {
		testa();
	}
	
	static void testa(){
		long ISBN = 1234567890123L;
		String titulo = "Física Quântica Só Para Baixinhos";
		String autor = "Axe of Assis";
		String editora = "Abril";
		int ano = 1994;
		int edicao = 3;
		String sinopse = "Um livro muito bom.";
		int numPaginas = 768;
		String idioma = "Mandarin";
		Livro livro = new Livro(ISBN, titulo, autor, editora, ano, edicao, sinopse, numPaginas, idioma);
		
		Usuario usuario = new Usuario(1239482, "Roy G. Biv", Unidade.each, "roygbiv@usp.br");
		
		System.out.println(usuario);
		
		Exemplar exemplar = new Exemplar(livro, usuario, "fotoLivro");
		usuario.incluiExemplar(exemplar);
		
		System.out.println(usuario);
		System.out.println(exemplar);
	}
}