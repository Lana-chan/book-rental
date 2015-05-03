package testes;


import testes.TestaUsuario;



import java.util.ArrayList;
import java.util.List;

import dao.UsuarioDao;
import dao.UsuarioDaoFactory;
import entidades.Avaliacao;
import entidades.Exemplar;
import entidades.Usuario;
import entidades.Solicitacao;
import entidades.Unidade;

public class TestaUsuario {
	
	static final int[] numUSP = {11111,22222,33333,44444,55555,66666,77777,88888,99999,10101 };
	//private int numUSP;
	
	
	//private String nome;
	static final String[] nome = { "ana", "beatriz", "carlos", "carla", "joao",
		"jessica", "flavio", "carlos", "pablo", "vinicius" };
	
	
	//private Unidade unidade;
	static final String[] unidade = { "each", "each", "each", "each", "each",
		"ime", "ime", "ime", "ime", "ime" };
	
	//private String email;
	static final String[] email = { "ana@usp", "beatriz@usp", "carlos@usp", "carla@usp", "joao@usp",
		"jessica@usp", "flavio@usp", "carlos@usp", "pablo@usp", "vinicius@usp" };
	
	
	
	//private String foto;
	/* NÃO HAVERA MAIS FOTO static final String[] foto = { "Fotoana", "Fotobeatriz", "Fotocarlos", "Fotocarla", "Fotojoao",
		"Fotojessica", "Fotoflavio", "Fotocarlos", "Fotopablo", "Fotovinicius" };*/
	
	//pesquisar 
	private List<Exemplar> colecao = new ArrayList<Exemplar>(); //lista
	private List<Avaliacao> reputacao = new ArrayList<Avaliacao>(); //lista
	
	public static void main(String[] args) {
		testa();
	}
	
	static void testa(){
		populaBD();
		//testaBuscaPorTitulo();
		//testaListagens();
		//testaRemocao();
		testaListagens();
		//limpaBD();
	}
	
	static void populaBD() {
		UsuarioDao UsuarioDao = new UsuarioDaoFactory().getInstance();

		for (int i = 0; i < titulos.length; i++) {
			UsuarioDao.adiciona(new Usuario(ISBN[i], titulos[i], autores[i], editoras[i], 
					ano[i], edicao[i], sinopse[i], numPaginas[i], idioma[i]));
		}
	}

	static void limpaBD() {
		UsuarioDao UsuarioDao = new UsuarioDaoFactory().getInstance();

		for (Usuario Usuario : UsuarioDao.listaTodos()) {
			UsuarioDao.remove(Usuario);
		}
	}

	static void testaBuscaPorTitulo() {
		UsuarioDao UsuarioDao = new UsuarioDaoFactory().getInstance();
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("------------------------ Testa busca por título -----------------------------------");
		System.out.println("-----------------------------------------------------------------------------------");

		for (int i = 0; i < titulos.length; i++) {
			System.out.println(i+ " " + UsuarioDao.buscaPorTitulo(titulos[i]));
		}

		System.out.println("\n");
	}

	static void testaListagens() {
		UsuarioDao UsuarioDao = new UsuarioDaoFactory().getInstance();
	
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("------------------------- Usuarios ordenados por autor ------------------------------");
		System.out.println("-----------------------------------------------------------------------------------");
		for (Usuario Usuario : UsuarioDao.listaTodosOrdenandoPorTitulo()){ 
			System.out.println(Usuario);
			//System.out.println("\n");
		}
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("------------------------- Usuarios ordenados por título -----------------------------");
		System.out.println("-----------------------------------------------------------------------------------");
		for (Usuario Usuario : UsuarioDao.listaTodosOrdenandoPorTitulo()) {
			System.out.println(Usuario);
		}
		System.out.println("\n");
	}

	static void testaRemocao() {
		UsuarioDao UsuarioDao = new UsuarioDaoFactory().getInstance();

		for (int i = 0; i < titulos.length / 2; i++) {
			UsuarioDao.remove(UsuarioDao.buscaPorTitulo(titulos[i]));
		}
	}

	static void testaAtualiza() {
		UsuarioDao UsuarioDao = new UsuarioDaoFactory().getInstance();

		for (int i = 0; i < titulos.length / 2; i++) {
			Usuario Usuario = UsuarioDao.buscaPorTitulo(titulos[i]);
			Usuario.setAutor("Autor " + i);
			Usuario.setEditora("Editora " + i);
			UsuarioDao.atualiza(Usuario);
		}
	}
	
		

}
