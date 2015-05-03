package testes;

import java.util.ArrayList;

import java.util.List;
import entidades.Usuario;
import entidades.Avaliacao;
import entidades.Exemplar;
import entidades.Livro;
import entidades.Solicitacao;
import entidades.Unidade;
import entidades.Notificacao;

public class TestaExemplar {
	private static final long serialVersionUID = 1L;
	private Livro livro;
	private boolean disponivel;
	
	//private Usuario proprietario;
	//private List<Usuario> historicoProprietario = new ArrayList<Usuario>();
	//private List<Solicitacao> solicitacoes = new ArrayList<Solicitacao>();
	
	//private String foto;
	static final String[] foto = { "Fotoana", "Fotobeatriz", "Fotocarlos", "Fotocarla", "Fotojoao",
		"Fotojessica", "Fotoflavio", "Fotocarlos", "Fotopablo", "Fotovinicius" };
	
	
	public static void main(String[] args) {
		testa();
	}
	
	//testa metodos
	static void testa(){
		
		Usuario dummyUser = new Usuario();
		Solicitacao dummySol = new Solicitacao();
		Exemplar metodos = new Exemplar();
		
		
		metodos.modificaProprietario(dummyUser);	
		metodos.incluiSolicitacao (dummySol);	
		metodos.excluiSolicitacao (dummySol);
	
	}
	

	
}
