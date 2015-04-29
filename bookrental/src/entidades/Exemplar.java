package entidades;
import java.io.Serializable;
import java.util.*;

public class Exemplar implements Serializable {
	
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
		this.setLivro(livro);
		this.setProprietario(proprietario);
		this.setFoto(foto);
	}
	
	
	/*-------------------------------------------------------------------------------
	 * Getters e Setters
	 *------------------------------------------------------------------------------*/
	
	public Livro getLivro() {
		return this.livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	public boolean getDisponivel() {
		return this.disponivel;
	}
	
	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
	
	public Usuario getProprietario() {
		return this.proprietario;
	}

	public void setProprietario(Usuario novoProprietario) {
		this.proprietario = novoProprietario;
	}
	
	public List<Usuario> getHistoricoProprietario() { //é uma lista
		return this.historicoProprietario;
	}
	
	public void setHistoricoProprietario(Usuario novoProprietario){
		this.historicoProprietario.add(novoProprietario);
	}
	
	public String getFoto() {
		return this.foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	/*-------------------------------------------------------------------------------
	 * Métodos
	 *------------------------------------------------------------------------------*/
	public void modificaProprietario(Usuario novoProprietario){
		//exemplar muda de proprietario, atualiza o historico
		setProprietario(novoProprietario);
		setHistoricoProprietario(novoProprietario);
	}
	
	public void incluiSolicitacao (Solicitacao solicitacao) {
		this.solicitacoes.add(solicitacao);
	}
	
	public void excluiSolicitacao (Solicitacao solicitacao) {
		this.solicitacoes.remove(solicitacao);
	}
	

	
	
}