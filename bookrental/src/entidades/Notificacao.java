package entidades;
import java.io.Serializable;
import java.sql.Date;

public class Notificacao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Usuario remetente;
	private Usuario destinatario;
	private String mensagem;
	private boolean lida;
	private Date data;
	
	public Notificacao(){
		
	}
	
	public Notificacao(Usuario remetente, Usuario destinatario, String mensagem, Date date){
		this.setRemetente(remetente);
		this.setDestinatario(destinatario);
		this.setMensagem(mensagem);
		this.setData(date);
	}
	
	/*-------------------------------------------------------------------------------
	 * Getters e Setters
	 *------------------------------------------------------------------------------*/
	
	public Usuario getRemetente() { return this.remetente; }
	public void setRemetente(Usuario remetente) { this.remetente = remetente; }
	
	public Usuario getDestinatario() { return this.destinatario; }
	public void setDestinatario(Usuario destinatario) { this.destinatario = destinatario; }
	
	public String getMensagem() { return this.mensagem; }
	public void setMensagem(String mensagem) { this.mensagem = mensagem; }
	
	public Date getData() { return this.data; }
	public void setData(Date data) { this.data = data; }
	
	
	
}