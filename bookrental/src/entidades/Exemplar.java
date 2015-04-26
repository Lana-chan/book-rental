package entidades;
import java.io.Serializable;

public class Exemplar implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Livro livro;
	private boolean disponivel;
	private Usuario proprietario;
	private Usuario historicoProprietario; //� uma lista
	private Solicitacao solicitacoes;
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

	public void setProprietario(Usuario proprietario) {
		this.proprietario = proprietario;
	}
	
	public Usuario getHistoricoProprietario() { //� uma lista
		return historicoProprietario;
	}
	
	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	/*-------------------------------------------------------------------------------
	 * M�todos
	 *------------------------------------------------------------------------------*/
	public void modificaProprietario(Usuario novoProprietario){
		this.proprietario=novoProprietario;
		//modifica quando a entrega � confirmada. Atualiza o hist�rico.
	}
	
	public void incluiSolicitacao (Solicitacao solicitacao){}
	
	public void excluiSolicitacao (Solicitacao solicitacao){}
	
	
}