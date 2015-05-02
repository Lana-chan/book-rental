package entidades;

public class Solicitacao {
	
	private static final long serialVersionUID = 1L;
	private Usuario doador;
	private Usuario receptor;
	private Exemplar exemplar;
	private boolean solicitacaoDeferida;
	private boolean confirmaEntregaDoador;
	private boolean confirmaEntregaReceptor;
	private String mensagem;
	
	public Solicitacao() {
		
	}
	
	public Solicitacao(Usuario doador, Usuario receptor, Exemplar exemplar, String mensagem){
		this.setDoador(doador);
		this.setReceptor(receptor);
		// this aqui se refere a um tipo solicitacao, isso n�o est� no usuario.java, pessoal
		this.setExemplar(exemplar);
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
	
	public boolean getConfirmaEntregaDoador() { return confirmaEntregaDoador;}
	public void setConfirmaEntregaDoador(boolean resp){ this.confirmaEntregaDoador = resp;}
	
	public boolean getConfirmaEntregaReceptor() { return confirmaEntregaReceptor;}
	public void setConfirmaEntregaReceptor(boolean resp){ this.confirmaEntregaReceptor = resp;}

	/*-------------------------------------------------------------------------------
	 * M�todos
	 *------------------------------------------------------------------------------*/
	
	public void confirmaEntrega (){
		Usuario solicitante= this.exemplar.getProprietario();
		
		if(solicitante==this.doador){
			//Se o usuario que invocar o m�todo for igual o doador, ir� alterar o ConfirmaEntregaDoador
			this.confirmaEntregaDoador=true;
		} else if(solicitante==this.receptor){
			//Se quem invocar for igual o receptor, altera o ConfirmaEntregaReceptor
			this.confirmaEntregaReceptor=true;
		}
		
		//se ambos usuarios j� tiverem confirmado a entrega, a transa��o � conclu�da.
		if(this.confirmaEntregaReceptor == this.confirmaEntregaDoador == true)
			this.exemplar.modificaProprietario(this.receptor); 
	
	}
	
	public void cancelaTransacao (){
		this.exemplar.setDisponivel(true);
		this.exemplar.excluiSolicitacao(this);
	}
	
	public Avaliacao criaAvaliacao(int nota, String comentario){
		Avaliacao novaAvaliacao= new Avaliacao(nota, comentario, this.receptor);
		return novaAvaliacao;

	}
	
}