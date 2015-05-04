package testes;

import dao.ExemplarDao;
import dao.ExemplarDaoFactory;
import entidades.Exemplar;

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
	
	//private Livro livro;
	Livro  livro = new Livro();
	
	//private boolean disponivel;
	private boolean disponivel = true;
	
	//private Usuario proprietario;
	Usuario proprietario = new Usuario();
	
	//private List<Usuario> historicoProprietario = new ArrayList<Usuario>();
	private List<Usuario> historicoProprietario = new ArrayList<Usuario>();
	
	//private List<Solicitacao> solicitacoes = new ArrayList<Solicitacao>();
	private List<Solicitacao> solicitacoes = new ArrayList<Solicitacao>();
	
	//private String foto;
	static final String[] foto = { "Fotoana", "Fotobeatriz", "Fotocarlos", "Fotocarla", "Fotojoao",
		"Fotojessica", "Fotoflavio", "Fotocarlos", "Fotopablo", "Fotovinicius" };
	
	static void teste1() {
		testa();
		populaBD();
		limpaBD();
		
	}
	
	
	
	
	static void populaBD() {
		ExemplarDao ExemplarDao = new ExemplarDaoFactory().getInstance();

		for (int i = 0; i < titulos.length; i++) {
			ExemplarDao.adiciona(new Exemplar(ISBN[i], titulos[i], autores[i], editoras[i], 
					ano[i], edicao[i], sinopse[i], numPaginas[i], idioma[i]));
		}
	}

	static void limpaBD() {
		ExemplarDao ExemplarDao = new ExemplarDaoFactory().getInstance();

		for (Exemplar exemplar : ExemplarDao.listaTodos()) {
			ExemplarDao.remove(exemplar);
		}
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