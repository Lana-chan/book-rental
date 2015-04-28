package entidades;
import java.io.Serializable;

public class Solicitacao implements Serializable {
<<<<<<< HEAD
=======
	
	private static final long serialVersionUID = 1L;
>>>>>>> origin/master
	
	private static final long serialVersionUID = 1L;
	private Usuario doador;
	private Usuario receptor;
	private Exemplar exemplar;
	private boolean solicitacaoDeferida;
	private boolean confirmaEntregaDoador;
	private boolean confirmaEntregaReceptor;
	private String mensagem;
	
	Solicitacao(Usuario doador, Usuario receptor, Exemplar exemplar, String mensagem){
		setDoador(doador);
		setReceptor(receptor);
		// this aqui se refere a um tipo solicitacao, isso não está no usuario.java, pessoal
		setExemplar(exemplar);
	}
	
	public Usuario getDoador() { return this.doador; }
	public void setDoador(Usuario doador) { this.doador = doador; }
	
	public Usuario getReceptor() { return this.receptor; }
	public void setReceptor(Usuario receptor) { this.receptor = receptor; }
	
	public Exemplar getExemplar() { return this.exemplar; }
	public void setExemplar(Exemplar exemplar) { this.exemplar = exemplar; }
	
	public boolean getSolicitacaoDeferida() { return this.solicitacaoDeferida; }
	public void setSolicitacaoDeferida(boolean deferida){ this.solicitacaoDeferida = deferida;}
	
	public String getMensagem() { return this.mensagem; }
	public void setMensagem(String mensagem){ this.mensagem = mensagem;}

	/*-------------------------------------------------------------------------------
	 * Métodos
	 *------------------------------------------------------------------------------*/
	
	public void confirmaEntrega (boolean resposta){
		Usuario solicitante= this.exemplar.getProprietario();
		
		if(solicitante==this.doador){
			//Se o usuario que invocar o método for igual o doador, irá alterar o ConfirmaEntregaDoador
			this.confirmaEntregaDoador=true;
		} else if(solicitante==this.receptor){
			//Se quem invocar for igual o receptor, altera o ConfirmaEntregaReceptor
			this.confirmaEntregaReceptor=true;
		}
		
		if(this.confirmaEntregaDoador==this.confirmaEntregaReceptor==true){
			//o exemplar será excluído da Lista de Exemplares do Doador e incluído na Lista de Exemplares do Receptor.

			this.doador.removeExemplar(this.exemplar);
			this.receptor.incluiExemplar(this.exemplar);
			
			//A Lista de Solicitações do Exmeplar é esvaziada. 
			this.exemplar.excluiSolicitacao(this);
			
			//Altera-se o nome do proprietario
			this.exemplar.modificaProprietario(this.receptor);
			
		} else {
			//Exclui o exemplar da lista de exemplares do receptor. Coloca o exemplar como disponivel. 
			this.receptor.removeExemplar(this.exemplar);
			this.exemplar.deixaDisponivel(this.exemplar);
			
		}
	}
	
}