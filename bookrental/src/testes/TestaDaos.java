package testes;

import dao.LivroDao;
import dao.LivroDaoFactory;
import entidades.Livro;

public class TestaDaos {
	
	public static void main(String[] args) {
		TestaLivro tLivro=new TestaLivro();
		//tLivro.teste1();
		
		TestaUsuario tUsuario=new TestaUsuario();
		tUsuario.testa();
	}

}
