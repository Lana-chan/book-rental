package entidades;
import java.util.*;

public class Usuario  {
	
	
	private int numUSP;
	private String nome;
	private Unidade unidade;
	private String email;
	private String foto;
	private List<Exemplar> colecao = new ArrayList<Exemplar>(); //lista
	private List<Avaliacao> reputacao = new ArrayList<Avaliacao>(); //lista

	//private java.sql.Date date;
	
	public Usuario () {
		
	}
	
	public Usuario(int numUSP, String nome, Unidade unidade, String email) {
		this.setNumUsp(numUSP);
		this.setNome(nome);
		this.setUnidade(unidade);
		this.setEmail(email);
		//this.setColecao(colecao);
	}
	
	
	public Usuario(int numUSP, String nome, Unidade unidade, String email, List<Exemplar> colecao) {
		this.setNumUsp(numUSP);
		this.setNome(nome);
		this.setUnidade(unidade);
		this.setEmail(email);
		this.setColecao(colecao);
	}
	
	/*-------------------------------------------------------------------------------
	 * Getters e Setters
	 *------------------------------------------------------------------------------*/
	
	public int getNumUsp() {return this.numUSP;}
	public void setNumUsp(int numUsp) {	this.numUSP = numUsp;}
	
	public String getNome() {return this.nome;}
	public void setNome(String nome) {this.nome = nome;}
	
	public Unidade getUnidade() {return this.unidade;}
	public void setUnidade(Unidade unidade) {this.unidade = unidade ;}
	
	public String getEmail() {return this.email;}
	public void setEmail(String email) {this.email = email;}
	
	public List<Exemplar> getColecao() {return colecao;}
	public List<Exemplar> setColecao(List<Exemplar> colecao) {return this.colecao=colecao;}
	
	public String getFoto (){return this.foto;}
	public void setFoto (String foto){this.foto = foto;}
	
	
	/*-------------------------------------------------------------------------------
	 * Métodos
	 *------------------------------------------------------------------------------*/
	
	public boolean incluiExemplar(Exemplar exemplar){
		return this.colecao.add(exemplar);
	}

	public boolean removeExemplar(Exemplar exemplar){
		return this.colecao.remove(exemplar);
	}

	public Livro cadastraLivro(long ISBN, String titulo, String autor, String editora, int ano, int edicao, String sinopse, 
								int numPaginas, String idioma, String foto){
		Livro novoLivro=new Livro (ISBN, titulo, autor, editora, ano, edicao, sinopse, numPaginas, idioma);
		Exemplar novoExemplar=new Exemplar(novoLivro, this, foto);
		incluiExemplar(novoExemplar);
		return novoLivro;
	}
	

	public void incluiReputacao(Avaliacao novaAvaliacao){
		this.reputacao.add(novaAvaliacao);
	}
	
	public double calculaMediaReputacao(){
		double media = 0;
		for (Avaliacao aux : this.reputacao)
		   media += aux.getNota();
		media = media/this.reputacao.size();
		
		return media;
	}
	
	public void criaSolicitacao(Exemplar exemplar, String mensagem){
		Solicitacao solic = new Solicitacao(exemplar.getProprietario(), this, exemplar, mensagem);
		exemplar.incluiSolicitacao(solic);
		
		//O Exemplar é adicionado a lista do solicitante e fica pendente
		this.colecao.add(exemplar);
		
		/*Notificacao notifica=new Notificacao(this, exemplar.getProprietario(), 
				this.nome+ " solicita seu exemplar de "+ exemplar.getLivro().getTitulo(), this.date);*/
	}
	
	public void respondeSolicitacao (Solicitacao solicitacao, boolean resposta){
		//confirma se vai doar ou não ao possível receptor.
		if (resposta==true){			

			//Se aprovado, o exemplar nao será mais visivel na busca 
			solicitacao.getExemplar().setDisponivel(false);
			solicitacao.setSolicitacaoDeferida(true);			
			
			/*Notificacao notifica=new Notificacao(this, solicitacao.getDoador(), 
			this.nome+ " aceita doar "+ solicitacao.getExemplar().getLivro().getTitulo(), this.date);*/
					
		} else {
			//Se for negado, o exemplar é removido da lista do solicitante e a solicitação é excluida do exemplar
			solicitacao.getReceptor().removeExemplar(solicitacao.getExemplar());
			solicitacao.getExemplar().excluiSolicitacao(solicitacao);
			
			/*Notificacao notifica=new Notificacao(this, solicitacao.getDoador(), 
			this.nome+ " não aceita doar "+ solicitacao.getExemplar().getLivro().getTitulo(), this.date);*/
			
		}
	}	
	
}