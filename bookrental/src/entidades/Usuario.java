package entidades;
import java.io.Serializable;

public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int numUSP;
	private String nome;
	private Unidade unidade;
	private String email;
	private String foto;
	private Exemplar colecao; //lista
	private Avaliacao reputacao; //lista
	
	public Usuario () {
		
	}
	
	public Usuario(int numUSP, String nome, Unidade unidade, String email) {
		this.setNumUSP(numUSP);
		this.setNome(nome);
		this.setUnidade(unidade);
		this.setEmail(email);
	}
	
	/*-------------------------------------------------------------------------------
	 * Getters e Setters
	 *------------------------------------------------------------------------------*/
	
	public int getNumUSP() {
		return this.numUSP;
	}

	public void setNumUSP(int numUsp) {
		this.numUSP = numUsp;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Unidade getUnidade() {
		return this.unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade ;
	}
	
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	/*-------------------------------------------------------------------------------
	 * Métodos
	 *------------------------------------------------------------------------------*/
	
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