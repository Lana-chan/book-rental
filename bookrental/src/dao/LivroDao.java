package dao;

import java.text.Collator;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import entidades.Livro;

public abstract class LivroDao {

	final Collator comparadorDeStrings = Collator.getInstance();

	public LivroDao() {
		// Isto Ž para ignorar os acentos nas compara�›es de Strings
		comparadorDeStrings.setStrength(Collator.NO_DECOMPOSITION);
	}

	public void adiciona(Livro livro) {
		if (livro == null) {
			throw new IllegalArgumentException("Parâmetro livro não pode ser nulo.");
		}

		if (livro.getTitulo() == null) {
			throw new IllegalArgumentException("Não é possivel adicionar um livro sem título.");
		}

		if (buscaPorTitulo(livro.getTitulo()) != null) {
			throw new IllegalArgumentException("Já existe um livro com o título: " + livro.getTitulo()
					+ " na base de dados.");
		}

		adiciona_(livro);
	}

	protected abstract void adiciona_(Livro livro);

	public void atualiza(Livro livro) {
		if (livro == null) {
			throw new IllegalArgumentException("Parâmetro livro não pode ser nulo.");
		}

		if (livro.getTitulo() == null) {
			throw new IllegalArgumentException("Não é possível atualizar um livro sem título.");
		}

		if (buscaPorTitulo(livro.getTitulo()) == null) {
			throw new IllegalArgumentException("Não existe livro com o título: " + livro.getTitulo() + " na base de dados.");
		}

		atualiza_(livro);
	}

	protected abstract void atualiza_(Livro livro);

	public Livro buscaPorTitulo(String titulo) {
		if (titulo == null) {
			throw new IllegalArgumentException("Parâmetro titulo n‹o pode ser nulo.");
		}

		return buscaPorTitulo_(titulo);
	}

	protected abstract Livro buscaPorTitulo_(String titulo);

	public void remove(Livro livro) {
		if (livro == null) {
			throw new IllegalArgumentException("Parâmetro livro n‹o pode ser nulo.");
		}

		if (livro.getTitulo() == null) {
			throw new IllegalArgumentException("Não é possível remover um livro sem título.");
		}

		if (buscaPorTitulo(livro.getTitulo()) == null) {
			throw new IllegalArgumentException("Não existe livro com o título: " + livro.getTitulo() + " na base de dados.");
		}

		remove_(livro);
	}

	protected abstract void remove_(Livro livro);

	public List<Livro> listaTodosOrdenandoPorTitulo() {
		List<Livro> livros = listaTodos();

		Collections.sort(livros, new Comparator<Livro>() {

			@Override
			public int compare(Livro o1, Livro o2) {
				return comparadorDeStrings.compare(o1.getTitulo(), o2.getTitulo());
			}
		});

		return livros;
	}

	public List<Livro> listaTodosOrdenandoPorAutor() {
		List<Livro> livros = listaTodos();

		Collections.sort(livros, new Comparator<Livro>() {

			@Override
			public int compare(Livro o1, Livro o2) {
				return comparadorDeStrings.compare(o1.getAutor(), o2.getAutor());
			}
		});

		return livros;
	}

	public abstract List<Livro> listaTodos();
}
