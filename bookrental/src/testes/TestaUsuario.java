package testes;


import testes.TestaUsuario;





import java.util.ArrayList;
import java.util.List;

import dao.ExemplarDao;
import dao.ExemplarDaoFactory;
import dao.UsuarioDao;
import dao.UsuarioDaoFactory;
import entidades.Avaliacao;
import entidades.Exemplar;
import entidades.Usuario;
import entidades.Solicitacao;
import entidades.Unidade;

public class TestaUsuario {
	
	static final int[] numUsp = {11111,22222,33333,44444,55555,66666,77777,88888,99999,10101 };
	//private int numUSP;
	
	
	//private String nome;
	static final String[] nome = { "ana", "beatriz", "carlos", "carla", "joao",
		"jessica", "flavio", "carlos", "pablo", "vinicius" };
	
	//private Unidade unidade;
	static final Unidade[] unidade = { Unidade.each, Unidade.poli, Unidade.each, Unidade.med, Unidade.poli,
		Unidade.each, Unidade.poli, Unidade.each, Unidade.med, Unidade.poli};
	
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
		testaListagens();
		limpaBD();
	}
	
	static void populaBD() {
		UsuarioDao UsuarioDao = new UsuarioDaoFactory().getInstance();

		for (int i = 0; i < numUsp.length; i++) {
			UsuarioDao.adiciona(new Usuario(numUsp[i], nome[i], unidade[i], email[i]));
		}
	}

	static void limpaBD() {
		UsuarioDao UsuarioDao = new UsuarioDaoFactory().getInstance();

		for (Usuario Usuario : UsuarioDao.listaTodos()) {
			UsuarioDao.remove(Usuario);
		}
	}
	
	static void adicionaColecao(Exemplar exemplar){
		ExemplarDao ExemplarDao = new ExemplarDaoFactory().getInstance();
		
		ExemplarDao.adiciona(exemplar);
	}
	
	static void removeColecao(Exemplar exemplar){
		ExemplarDao ExemplarDao = new ExemplarDaoFactory().getInstance();
		
		ExemplarDao.adiciona(exemplar);
	}

	static void testaBuscaPorNumUsp() {
		UsuarioDao UsuarioDao = new UsuarioDaoFactory().getInstance();
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("------------------------ Testa busca por numUsp -----------------------------------");
		System.out.println("-----------------------------------------------------------------------------------");

		for (int i = 0; i < numUsp.length; i++) {
			System.out.println(i+ " " + UsuarioDao.buscaPorNumUsp(numUsp[i]));
		}

		System.out.println("\n");
	}

	static void testaListagens() {
		UsuarioDao UsuarioDao = new UsuarioDaoFactory().getInstance();
	
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("------------------------- Usuarios ordenados por numUsp----------------------------");
		System.out.println("-----------------------------------------------------------------------------------");
		for (Usuario Usuario : UsuarioDao.listaTodosOrdenandoPorNumUsp()){ 
			System.out.println("NumUsp: "+ Usuario.getNumUsp());
			System.out.println("Nome: "+ Usuario.getNome());
			System.out.println("Unidade: "+ Usuario.getUnidade());
			System.out.println("Colecao: "+ Usuario.getColecao());
			System.out.println("\n");
		}
	}
	
	
		

}
