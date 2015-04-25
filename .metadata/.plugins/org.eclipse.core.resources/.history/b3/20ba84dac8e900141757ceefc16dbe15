package entidades;

import java.io.Serializable;

import util.StringUtils;

public class Livro implements Serializable {

	private static final long serialVersionUID = 1L;

	private String autor; // deveria ser uma lista de autores
	private String titulo;
	private String editora; // deveria ser um objeto Editora contendo infos da
							// editora

	public Livro() {
	}

	public Livro(String autor, String titulo, String editora) {
		setAutor(autor);
		setTitulo(titulo);
		setEditora(editora);
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

	// sobrescrevemos o método "toString" para imprimir o objeto Livro no
	// console
	@Override
	public String toString() {
		return StringUtils.fillOrTruncate(getTitulo(), 40, ' ') + StringUtils.fillOrTruncate(getAutor(), 30, ' ')
				+ StringUtils.fillOrTruncate(getEditora(), 20, ' ');
	}
}
