package testes;

import entidades.Exemplar;
import entidades.Usuario;

public class TestaSolicitacao {
	//private static final long serialVersionUID = 1L;
	//private Usuario doador;
	//private Usuario receptor;
	//private Exemplar exemplar;
	
	//private boolean solicitacaoDeferida;
	static final boolean[] solicitacaoDeferida = {true,true,true,true,true,false,false,false,false,false};
	
	//private boolean confirmaEntregaDoador;
	static final boolean[] confirmaEntregaDoador = {true,true,true,true,true,false,false,false,false,false};
	
	//private boolean confirmaEntregaReceptor;
	static final boolean[] confirmaEntregaReceptor= {true,true,true,true,true,false,false,false,false,false};
	
	//private String mensagem;
	static final String[] mensagem = { "pessimo", "horrivel", "muito ruim", "ruim", "nao gostei",
		"mediano", "gostei", "gostei muito", "muito bom", "excelente"};
	
	public static void main(String[] args) {
		confirmaEntrega();
	
	}

	public void confirmaEntrega (boolean resposta){
		Usuario solicitante= this.exemplar.getProprietario();
		
		if(solicitante==this.doador){
			//Se o usuario que invocar o m�todo for igual o doador, ir� alterar o ConfirmaEntregaDoador
			this.confirmaEntregaDoador=true;
		} else if(solicitante==this.receptor){
			//Se quem invocar for igual o receptor, altera o ConfirmaEntregaReceptor
			this.confirmaEntregaReceptor=true;
		}
		
		if(this.confirmaEntregaDoador==this.confirmaEntregaReceptor==true){
			//o exemplar ser� exclu�do da Lista de Exemplares do Doador e inclu�do na Lista de Exemplares do Receptor.

			this.doador.removeExemplar(this.exemplar);
			this.receptor.incluiExemplar(this.exemplar);
			
			//A Lista de Solicita��es do Exmeplar � esvaziada. 
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