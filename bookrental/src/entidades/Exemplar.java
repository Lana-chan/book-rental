package entidades;
import java.util.*;

public class Exemplar {
	
	private static final long serialVersionUID = 1L;
	private Livro livro;
	private boolean disponivel;
	private Usuario proprietario;
	private List<Usuario> historicoProprietario = new ArrayList<Usuario>();
	private List<Solicitacao> solicitacoes = new ArrayList<Solicitacao>();
	private String foto;
	
	
	public Exemplar() {
		
	}
	
	public Exemplar (Livro livro, Usuario proprietario, String foto){
		//super(ISBN, titulo, autor, editora, ano, edicao, sinopse, numPaginas, idioma);
		this.setLivro(livro);
		this.setDisponivel(true);
		this.setProprietario(proprietario);
		this.historicoProprietario.add(proprietario);
		this.setFoto(foto);
	}
	
	
	/*-------------------------------------------------------------------------------
	 * Getters e Setters
	 *------------------------------------------------------------------------------*/
	
	public Livro getLivro() {return this.livro;}
	public void setLivro(Livro livro) {this.livro = livro;}

	public boolean getDisponivel() {return this.disponivel;}
	public void setDisponivel(boolean disponivel) {this.disponivel = disponivel;}
	
	public Usuario getProprietario() {return this.proprietario;}
	public void setProprietario(Usuario novoProprietario) {this.proprietario = novoProprietario;}
	
	public List<Usuario> getHistoricoProprietario() {return this.historicoProprietario;}
	
	public List<Solicitacao> getSolicitacoes() {return this.solicitacoes;}
	
	public String getFoto() {return this.foto;}
	public void setFoto(String foto) {this.foto = foto;}
	
	/*-------------------------------------------------------------------------------
	 * Métodos
	 *------------------------------------------------------------------------------*/
	public void modificaProprietario(Usuario novoProprietario){
		//Atualiza o historico
		this.historicoProprietario.add(novoProprietario);
		
		//Remove o exemplar da lista do doador.
		//Nesse momento o exemplar já está na lista do receptor
		this.proprietario.removeExemplar(this);
		
		//Modifica o proprietario
		this.proprietario = novoProprietario;
		
		//Limpa todas as solicitações que ficaram pendentes
		this.solicitacoes.clear();		
	}
	
	public void incluiSolicitacao (Solicitacao solicitacao) {
		this.solicitacoes.add(solicitacao);
	}
	
	public void excluiSolicitacao (Solicitacao solicitacao) {
		this.solicitacoes.remove(solicitacao);
	}
	

	
	
	
	
}