package entidades;

import java.io.Serializable;

import util.StringUtils;

public class Livro implements Serializable {

	private static final long serialVersionUID = 1L;

	private long ISBN;
	private String titulo;
	private String autor;
	private String editora;
	private int ano;
	private int edicao;
	private int numPaginas;
	private String idioma;
	private String sinopse;

	public Livro() {
	}

	public Livro(long ISBN, String titulo, String autor, String editora, int ano, int edicao, String sinopse, int numPaginas, String idioma) {
		setISBN(ISBN);
		setTitulo(titulo);
		setAutor(autor);
		setEditora(editora);
		setAno(ano);
		setEdicao(edicao);
		setNumPaginas(numPaginas);
		setIdioma(idioma);
		setSinopse(sinopse);
		
	}

	/*-------------------------------------------------------------------------------
	 * Getters e Setters
	 *------------------------------------------------------------------------------*/

	public long getISBN() {
		return Long.valueOf(ISBN).longValue();
	}

	public void setISBN(long ISBN) {
		this.ISBN = ISBN;
	}
	
	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getEdicao() {
		return edicao;
	}

	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}

	public int getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(int numPaginas){
		this.numPaginas = numPaginas;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma){
		this.idioma = idioma;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}


	/*-------------------------------------------------------------------------------
	 * Métodos
	 *------------------------------------------------------------------------------*/
	
	// sobrescrevemos o método "toString" para imprimir o objeto Livro no
	// console
	@Override
	public String toString() {
		return StringUtils.fillOrTruncate(getTitulo(), 40, ' ') + StringUtils.fillOrTruncate(getAutor(), 30, ' ')
				+ StringUtils.fillOrTruncate(getEditora(), 20, ' ');
	}
}
