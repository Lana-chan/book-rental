package testes;


import testes.TestaUsuario;





import java.util.ArrayList;
import java.util.List;

import dao.ExemplarDao;
import dao.ExemplarDaoFactory;
import dao.UsuarioDao;
import dao.UsuarioDaoFactory;
import entidades.*;

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
	
	private List<Exemplar> colecao = new ArrayList<Exemplar>(); //lista
	private List<Avaliacao> reputacao = new ArrayList<Avaliacao>(); //lista
	
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
	
	static void testaColecao(Usuario user) {
			UsuarioDao UsuarioDao = new UsuarioDaoFactory().getInstance();
			ExemplarDao ExemplarDao = new ExemplarDaoFactory().getInstance();

			System.out.println("-----------------------------------------------------------------------------------");
			System.out.println("-------------------------Coleção do Usuario---------------------------------------");
			System.out.println("-----------------------------------------------------------------------------------");
			//for (Exemplar exemplar : ExemplarDao.buscaPorId(this.exemplar)){ 
				//System.out.println("Livro:"+exemplar.getLivro().getTitulo());
			//	System.out.println("Autor:"+exemplar.getLivro().getAutor());
				//System.out.println("Edicao:"+exemplar.getLivro().getEdicao());
				//System.out.println("\n");
			//}
	}
	
	
	
	public static void testaCalculaMediaReputacao(){
		
		Usuario fabiano = new Usuario(989541436, "Fabiano", Unidade.each, "fabiano.sampaio@usp.br");
		Usuario critico1 = new Usuario(100000000, "Joao", Unidade.each, "critico1@usp.br" );
		Usuario critico2 = new Usuario(100000001, "Maria", Unidade.each, "critico2@usp.br" );
		Avaliacao avaliacao1 = new Avaliacao(4, "", critico1, fabiano);
		Avaliacao avaliacao2 = new Avaliacao(2, "", critico2, fabiano);
		fabiano.incluiReputacao(avaliacao1);
		fabiano.incluiReputacao(avaliacao2);
		
		//O usuario tem 2 avaliações, a primeira atribuiu nota 4 e a segunda nota 2.
		//Logo o resultado da média deve ser 3. 
		System.out.println("A media da reputacao eh:" + fabiano.calculaMediaReputacao());
		
		
	}
	
	//Testa os Metodos cadastraLivro, criaSolicitacao e respondeSolicitacao
	public static void testaMetodosSolicitacao(){
		
		Usuario fabiano = new Usuario(989541436, "Fabiano", Unidade.each, "fabiano.sampaio@usp.br");
		Usuario receptor1 = new Usuario(100000000, "Joao", Unidade.each, "receptor@usp.br" );
		Usuario receptor2 = new Usuario(100000001, "Maria", Unidade.each, "receptor2@usp.br" );
		
		//Testando o metodo cadastraLivro
		fabiano.cadastraLivro(123456789, "O Capital", "Karl Marx", "Civilizacao Brasileira", 2008, 25, "Altas Tretas", 574, "Portugues", "Foto");
		
		Exemplar meuLivro = fabiano.getColecao().get(0);
		
		//Testando o metodo criaSolicitacao
		receptor1.criaSolicitacao(meuLivro, "");
		receptor2.criaSolicitacao(meuLivro, "");
		
		System.out.println ("O Exemplar '" + meuLivro.getLivro().getTitulo() + "' possui "
		+ meuLivro.getSolicitacoes().size() + " solicitacoes. Sendo dos seguintes usuarios:");
		
		for (Solicitacao aux : meuLivro.getSolicitacoes()){
			System.out.println(aux.getReceptor().getNome());
		}
		
		//Testa o metodo responde solicitacao
		
		boolean resposta = true;
		
		System.out.print ("O Exemplar antes da resposta está ");
		if (meuLivro.getDisponivel()==true) System.out.println("Disponivel.");
		else System.out.println ("Indisponivel.");
		
		fabiano.respondeSolicitacao(meuLivro.getSolicitacoes().get(1),resposta);
	
		System.out.print ("O Exemplar depois da resposta está ");
		if (meuLivro.getDisponivel()==true) System.out.println("Disponivel.");
		else System.out.println ("Indisponivel.");
	}
	
		
	public static void main(String[] args) {
		testaMetodosSolicitacao();
	}
}
