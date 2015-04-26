package entidades;

public class Solicitacao {
	
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
	
	public Usuario getDoador() { return doador; }
	public void setDoador(Usuario doador) { this.doador = doador; }
	
	public Usuario getReceptor() { return receptor; }
	public void setReceptor(Usuario receptor) { this.receptor = receptor; }
	
	public Exemplar getExemplar() { return exemplar; }
	public void setExemplar(Exemplar exemplar) { this.exemplar = exemplar; }
	
	public boolean getSolicitacaoDeferida() { return solicitacaoDeferida; }
	public void setSolicitacaoDeferida(boolean deferida){ this.solicitacaoDeferida=deferida;}
	
	public String getMensagem() { return mensagem; }
	public void setMensagem(String mensagem){ this.mensagem=mensagem;}

	/*-------------------------------------------------------------------------------
	 * Métodos
	 *------------------------------------------------------------------------------*/
	
	public void confirmaEntrega (boolean resposta){
		/* Recebe um boolean dizendo se a entrega foi confirmada.
		Se for:
		Se o usuario que invocar o método for igual o doador, irá alterar o ConfirmaEntregaDoador
		Se quem invocar for igual o receptor, altera o ConfirmaEntregaReceptor
		Se ConfirmaEntregaDoador e ConfirmaEntregaRecebptor forem true, então o exemplar será excluído da Lista de Exemplares do Doador e incluido ns Lista de Exemplares do Receptor.
		A Lista de Solicitações do Exmeplar é esvaziada. 
		Se não:
		Exclui o exemplar da lista de exemplares do receptor. Coloca o exemplar como disponivel. 
		*/
	}
	
}