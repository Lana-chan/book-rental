package dao;

import java.text.Collator;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import entidades.Exemplar;

public abstract class ExemplarDao {

	final Collator comparadorDeStrings = Collator.getInstance();

	public ExemplarDao() {
		// Isto é para ignorar os acentos nas comparações de Strings
		comparadorDeStrings.setStrength(Collator.NO_DECOMPOSITION);
	}

	public void adiciona(Exemplar exemplar) {
		if (exemplar == null) {
			throw new IllegalArgumentException("Parâmetro exemplar não pode ser nulo.");
		}

		if (exemplar.getTitulo() == null) {
			throw new IllegalArgumentException("Não é possível adicionar um exemplar sem livro.");
		}

		/* pode existir mais de um exemplar por livro
		if (buscaPorTitulo(livro.getTitulo()) != null) {
			throw new IllegalArgumentException("J‡ existe um livro com o t’tulo \"" + livro.getTitulo()
					+ "\" na base de dados.");
		}*/

		adiciona_(exemplar);
	}

	protected abstract void adiciona_(Exemplar exemplar);

	public void atualiza(Exemplar exemplar) {
		if (exemplar == null) {
			throw new IllegalArgumentException("Parâmetro exemplar não pode ser nulo.");
		}

		if (exemplar.getTitulo() == null) {
			throw new IllegalArgumentException("Não é possível atualizar um exemplar sem livro.");
		}

		if (buscaPorLivro(exemplar.getLivro()) == null) {
			throw new IllegalArgumentException("Não existe exemplar com o livro \"" + exemplar.getLivro().getTitulo() + "\" na base de dados.");
		}

		atualiza_(exemplar);
	}

	protected abstract void atualiza_(Livro livro);

	public Exemplar buscaPorLivro(Livro livro) {
		if (livro == null) {
			throw new IllegalArgumentException("Parâmetro livro não pode ser nulo.");
		}

		return buscaPorLivro_(livro);
	}

	protected abstract Livro buscaPorLivro_(String livro);

	public void remove(Exemplar exemplar) {
		if (exemplar == null) {
			throw new IllegalArgumentException("Parâmetro exemplar não pode ser null.");
		}

		if (exemplar.getLivro() == null) {
			throw new IllegalArgumentException("Não é possível remover um exemplar sem livro.");
		}

		if (buscaPorLivro(exemplar.getLivro()) == null) {
			throw new IllegalArgumentException("Não existe exemplar com o livro \"" + exemplar.getLivro().getTitulo() + "\" na base de dados.");
		}

		remove_(exemplar);
	}

	protected abstract void remove_(Exemplar exemplar);

	public List<Exemplar> listaTodosOrdenandoPorTitulo() {
		List<Exemplar> exemplares = listaTodos();

		Collections.sort(exemplares, new Comparator<Exemplar>() {

			@Override
			public int compare(Exemplar o1, Exemplar o2) {
				return comparadorDeStrings.compare(o1.getLivro().getTitulo(), o2.getLivro().getTitulo());
			}
		});

		return exemplares;
	}

	public List<Exemplar> listaTodosOrdenandoPorAutor() {
		List<Exemplar> exemplares = listaTodos();

		Collections.sort(exemplares, new Comparator<Exemplar>() {

			@Override
			public int compare(Exemplar o1, Exemplar o2) {
				return comparadorDeStrings.compare(o1.getLivro().getAutor(), o2.getLivro().getAutor());
			}
		});

		return exemplares;
	}

	public abstract List<Exemplar> listaTodos();
}
