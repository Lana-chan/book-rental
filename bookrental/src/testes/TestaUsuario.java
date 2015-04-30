package testes;

import java.util.ArrayList;
import java.util.List;

import entidades.Avaliacao;
import entidades.Exemplar;
import entidades.Livro;
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
	static final String[] foto = { "Fotoana", "Fotobeatriz", "Fotocarlos", "Fotocarla", "Fotojoao",
		"Fotojessica", "Fotoflavio", "Fotocarlos", "Fotopablo", "Fotovinicius" };
	
	//pesquisar 
	private List<Exemplar> colecao = new ArrayList<Exemplar>(); //lista
	private List<Avaliacao> reputacao = new ArrayList<Avaliacao>(); //lista
	
	public static void main(String[] args) {
		testa();
	}
	
	static void testa(){
		incluiExemplar();
		removeExemplar();
		cadastraLivro();
		criaAvaliacao();
		incluiReputacao();
		calculaReputacao();
		criaSolicitacao();
		respondeSolicitacao();

		
	}
	
	//public Exemplar incluiExemplar(Exemplar exemplar){
	//public void removeExemplar(Exemplar exemplar){
	//public void cadastraLivro(Livro livro){
	//public void criaAvaliacao(int nota, String comentario){
	//public void incluiReputacao(Avaliacao novaAvaliacao){
	//public void calculaReputacao(){}
	//public void criaSolicitacao(Exemplar exemplar, String mensagem){
	//public void respondeSolicitacao (Solicitacao solicitacao, boolean resposta)
	
	public Exemplar incluiExemplar(Exemplar exemplar){
		Exemplar incluso;
		incluso = new Exemplar(); //substituir
		return incluso;
	}

	public void removeExemplar(Exemplar exemplar){
		//talvez bool pra retornar se deu certo
	}

	public void cadastraLivro(Livro livro){

	}
	
	public void criaAvaliacao(int nota, String comentario){
		//a pensar
		Avaliacao novaAvaliacao=new Avaliacao(nota, comentario, this);
	}

	public void incluiReputacao(Avaliacao novaAvaliacao){
		
	}
	
	public void calculaReputacao(){
		
	}
	
	public void criaSolicitacao(Exemplar exemplar, String mensagem){
		//qndo a pessoa clicar no botão, requisitar livro.
		Solicitacao solic = new Solicitacao(exemplar.getProprietario(), this, exemplar, mensagem);
		exemplar.incluiSolicitacao(solic);
	}
	
	public void respondeSolicitacao (Solicitacao solicitacao, boolean resposta){
		//confirma se vai doar ou não ao possível receptor.
	}	
	

		

}
