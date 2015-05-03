package testes;

import java.text.Collator;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import entidades.Exemplar;
import entidades.Livro;
import dao.ExemplarDao;
public class TesteExemplarDao {
	
	public static void main(String[] args) {
		testa();
	}
	
	static void testa(){
		
		//buscaPorLivro_(dummyLivro);
		static void buscaPorLivro_() {
			LivroDao livroDao = new LivroDaoFactory().getInstance();
			System.out.println("-----------------------------------------------------------------------------------");
			System.out.println("------------------------ Testa busca por t’tulo -----------------------------------");
			System.out.println("-----------------------------------------------------------------------------------");

			for (int i = 0; i < titulos.length; i++) {
				System.out.println(livroDao.buscaPorTitulo(titulos[i]));
			}

			System.out.println("\n");
		}
		
		
		//adiciona_(dummyExem);
		static void adiciona_() {
			LivroDao livroDao = new LivroDaoFactory().getInstance();

			for (int i = 0; i < autores.length; i++) {
				livroDao.adiciona(new Livro(autores[i], titulos[i], editoras[i]));
			}
		}
		
		//remove_(dummyLivro);
		static void remove_() {
			LivroDao livroDao = new LivroDaoFactory().getInstance();

			for (int i = 0; i < titulos.length / 2; i++) {
				livroDao.remove(livroDao.buscaPorTitulo(titulos[i]));
			}
		}
	
	
		//atualiza_(dummyExem);
		static void atualiza_() {
			LivroDao livroDao = new LivroDaoFactory().getInstance();

			for (int i = 0; i < titulos.length / 2; i++) {
				Livro livro = livroDao.buscaPorTitulo(titulos[i]);
				livro.setAutor("Autor " + i);
				livro.setEditora("Editora " + i);
				livroDao.atualiza(livro);
			}
		}

}
}
