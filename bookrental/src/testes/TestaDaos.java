package testes;

import dao.LivroDao;
import dao.LivroDaoFactory;
import entidades.Livro;

public class TestaDaos {

	static final String[] titulos = { "Capitães da Areia", "O Tempo e o Vento", "Vidas Secas", "Senhora", "A Moreninha",
			"Os Lusíadas", "Iracema", "Dom Casmurro", "Macunaíma", "O Cortiço", "A Hora da Estrela",
			"Memórias de um Sargento de Milícias", "Os Sertões", "Auto da Barca do Inferno" };
	static final String[] autores = { "Jorge Amado", "Érico Veríssimo", "Graciliano Ramos", "José de Alencar",
			"Joaquim Manuel Macedo", "Luís de Camões", "José de Alencar", "Machado de Assis", "Mário de Andrade",
			"Aluísio Azevedo", "Clarice Lispector", "Manuel Antônio de Almeida", "Euclides da Cunha", "Gil Vicente" };

	static final String[] editoras = { "Editora Abril", "Editora ABC", "Editora Alpha", "Editora Beta", "Editora Abril",
			"Editora ABC", "Editora Alpha", "Editora Beta", "Editora Abril", "Editora ABC", "Editora Alpha", "Editora Beta",
			"Editora Abril", "Editora ABC" };

	public static void main(String[] args) {
		teste1();
		teste2();
	}

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

		for (int i = 0; i < autores.length; i++) {
			livroDao.adiciona(new Livro(autores[i], titulos[i], editoras[i]));
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
		System.out.println("------------------------ Testa busca por título -----------------------------------");
		System.out.println("-----------------------------------------------------------------------------------");

		for (int i = 0; i < titulos.length; i++) {
			System.out.println(livroDao.buscaPorTitulo(titulos[i]));
		}

		System.out.println("\n");
	}

	static void testaListagens() {
		LivroDao livroDao = new LivroDaoFactory().getInstance();

		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("------------------------- Livros ordenados por autor ------------------------------");
		System.out.println("-----------------------------------------------------------------------------------");
		for (Livro livro : livroDao.listaTodosOrdenandoPorAutor()) {
			System.out.println(livro);
		}
		System.out.println("\n");

		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("------------------------- Livros ordenados por título -----------------------------");
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
