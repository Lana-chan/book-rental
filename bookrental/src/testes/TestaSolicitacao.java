package testes;

import entidades.Exemplar;

import entidades.Usuario;
import entidades.Solicitacao;
import entidades.Exemplar;

public class TestaSolicitacao {
	private static final long serialVersionUID = 1L;
	
	//private Usuario doador;
	Usuario doador = new Usuario();
	
	//private Usuario receptor;
	Usuario receptor = new Usuario();
	
	//private Exemplar exemplar;
	Exemplar exemplar = new Exemplar();
	
	//private boolean solicitacaoDeferida;
	static final boolean[] solicitacaoDeferida = {true,true,true,true,true,false,false,false,false,false};
	
	//private boolean confirmaEntregaDoador;
	static final boolean[] confirmaEntregaDoador = {true,true,true,true,true,false,false,false,false,false};
	
	//private boolean confirmaEntregaReceptor;
	static final boolean[] confirmaEntregaReceptor= {true,true,true,true,true,false,false,false,false,false};
	
	//por que essas coisas são listas??? -erin
	
	//private String mensagem;
	static final String[] mensagem = { "pessimo", "horrivel", "muito ruim", "ruim", "nao gostei",
		"mediano", "gostei", "gostei muito", "muito bom", "excelente"};
	
	public static void main(String[] args) {
		Solicitacao metodos = new Solicitacao();
		Usuario doador = new Usuario();
		Usuario receptor = new Usuario();
		Exemplar exemplar = new Exemplar();
		confirmaEntrega(true);
		metodos.cancelaTransacao ();
		metodos.criaAvaliacao(7,"bacana");
		
		System.out.println(3);
		
	
	}
	

	public static void confirmaEntrega (boolean resposta){
		//Usuario solicitante= this.exemplar.getProprietario();
		
		//THIS não funciona em classes estáticas, isso é um teste e não um objeto com instâncias -erin
		
		/*
		if(solicitante==this.doador){
			//Se o usuario que invocar o método for igual o doador, irá alterar o ConfirmaEntregaDoador
			//this.confirmaEntregaDoador=true;
		} else if(solicitante==this.receptor){
			//Se quem invocar for igual o receptor, altera o ConfirmaEntregaReceptor
			//this.confirmaEntregaReceptor=true;
		}
		
		if(this.confirmaEntregaDoador==this.confirmaEntregaReceptor==true){
			//o exemplar será excluído da Lista de Exemplares do Doador e incluído na Lista de Exemplares do Receptor.

			//this.doador.removeExemplar(this.exemplar);
			//this.receptor.incluiExemplar(this.exemplar);
			
			//A Lista de Solicitações do Exmeplar é esvaziada. 
			this.exemplar.excluiSolicitacao(this);
			
			//Altera-se o nome do proprietario
			this.exemplar.modificaProprietario(this.receptor);
			
		} else {
			//Exclui o exemplar da lista de exemplares do receptor. Coloca o exemplar como disponivel. 
			this.receptor.removeExemplar(this.exemplar);
			this.exemplar.deixaDisponivel(this.exemplar);
			
		}
		*/
	}


}
