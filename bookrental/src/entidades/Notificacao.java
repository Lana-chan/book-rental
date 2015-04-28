package entidades;
import java.io.Serializable;
import java.util.Date;

public class Notificacao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Usuario remetente;
	private Usuario destinatario;
	private String mensagem;
	private Date data;
	
	public Notificacao(){
		
	}
	
	public Notificacao(Usuario remetente, Usuario destinatario, String mensagem, Date data){
		
	}
	
	/*-------------------------------------------------------------------------------
	 * Getters e Setters
	 *------------------------------------------------------------------------------*/
	
	public Usuario getRemetente() { return remetente; }
	public void setRemetente(Usuario remetente) { this.remetente = remetente; }
	
	public Usuario getDestinatario() { return destinatario; }
	public void setDestinatario(Usuario destinatario) { this.destinatario = destinatario; }
	
	public String getMensagem() { return mensagem; }
	public void setMensagem(String mensagem) { this.mensagem = mensagem; }
	
	public Date getData() { return data; }
	public void setData(Date data) { this.data = data; }
	
	
	
}