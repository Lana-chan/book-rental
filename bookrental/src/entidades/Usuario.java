package entidades;
import java.io.Serializable;

public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int numUSP;
	private String nome;
	private enum unidade;
	private String email;
	private String foto;
	private Exemplar colecao; //lista
	private Avaliacao reputacao; //lista
	
	public Usuario (){
		
	}
	
	public Usuario(int numUSP, String nome, enum unidade, String email){
		setNumUSP(numUSP);
		setNome(nome);
		setUnidade(unidade);
		setEmail(email);
	}
	
	/*-------------------------------------------------------------------------------
	 * Getters e Setters
	 *------------------------------------------------------------------------------*/
	
	public int getNumUSP() {
		return numUSP;
	}

	public void setNumUSP(int numUsp) {
		this.numUSP = numUsp;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public enum getUnidade() {
		return unidade;
	}

	public void setUnidade(enum unidade) {
		this.unidade = unidade ;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	/*-------------------------------------------------------------------------------
	 * Métodos
	 *------------------------------------------------------------------------------*/
	
	public Exemplar incluiExemplar(Exemplar exemplar){
		
	}

	public Exemplar removeExemplar(Exemplar exemplar){

	}

	public void cadastraLivro(Livro livro){

	}
	
	public void criaAvaliacao(Avaliacao avaliacao){
		//a pensar
	}

	public void incluiReputacao(Avaliacao novaAvaliacao){
		
	}
	
	
	public void criaSolicitacao(Exemplar exemplar, String mensagem){
		//qndo a pessoa clicar no botão, requisitar livro.
	}
	
	public void respondeSolicitacao (Solicitacao solicitacao, boolean resposta){
		//confirma se vai doar ou não ao possível receptor.
	}
	
	public enum unidade{
		EACH, FEA, POLI, MED
	}
	
}