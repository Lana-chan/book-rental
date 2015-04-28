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
		setLivro(livro);
		setProprietario(proprietario);
		setFoto(foto);
	}
	
	
	/*-------------------------------------------------------------------------------
	 * Getters e Setters
	 *------------------------------------------------------------------------------*/
	
	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	public boolean getDisponivel() {
		return disponivel;
	}
	
	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
	
	public Usuario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Usuario novoProprietario) {
		this.proprietario = novoProprietario;
	}
	
	public List<Usuario> getHistoricoProprietario() { //é uma lista
		return historicoProprietario;
	}
	
	public void setHistoricoProprietario(Usuario novoProprietario){
		this.historicoProprietario.add(novoProprietario);
	}
	
	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	/*-------------------------------------------------------------------------------
	 * Métodos
	 *------------------------------------------------------------------------------*/
	public void modificaProprietario(Usuario novoProprietario){
		setProprietario(novoProprietario);
		setHistoricoProprietario(novoProprietario);
		//modifica quando a entrega é confirmada. Atualiza o histórico.
	}
	
	public void incluiSolicitacao (Solicitacao solicitacao) {
		this.solicitacoes.add(solicitacao);
	}
	
	public void excluiSolicitacao (Solicitacao solicitacao) {
		this.solicitacoes.remove(solicitacao);
	}
	
	public void deixaDisponivel (Exemplar exemplar){
		exemplar.disponivel=true;
	}
	
	
}