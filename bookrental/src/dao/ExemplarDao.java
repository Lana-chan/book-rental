package dao;

import java.text.Collator;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import entidades.Exemplar;
import entidades.Solicitacao;
import entidades.Usuario;

public abstract class ExemplarDao {

	final Collator comparadorDeStrings = Collator.getInstance();

	public ExemplarDao() {
		// Isto é para ignorar os acentos nas comparações de Strings
		comparadorDeStrings.setStrength(Collator.NO_DECOMPOSITION);
	}

	//adiciona exemplares ao Usuario
	public void adiciona(Exemplar exemplar) {
		if (exemplar == null) {
			throw new IllegalArgumentException("Parâmetro exemplar não pode ser nulo.");
		}

		adiciona_(exemplar);
	}
	protected abstract void adiciona_(Exemplar exemplar);
	
	//Atualiza o proprietario do Exemplar
	public void atualiza(Exemplar exemplar) {
		if (exemplar == null) {
			throw new IllegalArgumentException("Parâmetro exemplar não pode ser nulo.");
		}

		if (exemplar.getProprietario() == null) {
			throw new IllegalArgumentException("Não é possível adicionar um exemplar sem proprietario.");
		}

		if (buscaPorTitulo(exemplar) == null) {
			throw new IllegalArgumentException("Não existe o livro \"" + exemplar.getLivro().getTitulo() + "\" cadastrado na base de dados.");
		}

		atualizaProprietario_(exemplar);
	}
	protected abstract void atualizaProprietario_(Exemplar exemplar);
	
	//Atualiza o status (disponivel ou nao) do exemplar
	public void modificaDisponibilidade(Exemplar exemplar, Boolean disponivel) {
		if (exemplar== null||disponivel== null ) {
			throw new IllegalArgumentException("Parâmetro exemplar não pode ser nulo.");
		}

		if (exemplar.getDisponivel() == disponivel) {
			throw new IllegalArgumentException("Não há nada a ser alterado.");
		}

		if (buscaPorTitulo(exemplar) == null) {
			throw new IllegalArgumentException("Não existe o livro \"" + exemplar.getLivro().getTitulo() + "\" cadastrado na base de dados.");
		}

		atualizaDisponibilidade_(exemplar, disponivel);
	}
	protected abstract void atualizaDisponibilidade_(Exemplar exemplar, Boolean disponivel);

	//Busca por titulo
	public Exemplar buscaPorTitulo(Exemplar exemplar) {
		if (exemplar == null) {
			throw new IllegalArgumentException("Parâmetro livro não pode ser nulo.");
		}

		return buscaPorTitulo_(exemplar.getLivro().getTitulo());
	}
	protected abstract Exemplar buscaPorTitulo_(String titulo);

	//Remove exemplar
	public void remove(Exemplar exemplar) {
		if (exemplar == null) {
			throw new IllegalArgumentException("Parâmetro exemplar não pode ser nulo.");
		}

		if (exemplar.getLivro() == null) {
			throw new IllegalArgumentException("Não é possível remover um exemplar não cadastrado.");
		}

		if (buscaPorTitulo(exemplar) == null) {
			throw new IllegalArgumentException("Não existe exemplar com o livro \"" + exemplar.getLivro().getTitulo() + "\" na base de dados.");
		}

		remove_(exemplar);
	}
	protected abstract void remove_(Exemplar exemplar);

	//Lista colecao do usuario por titulo
	public List<Exemplar> listaTodosOrdenandoPorTitulo(Usuario usuario) {
		List<Exemplar> exemplares = listaTodos(usuario);

		Collections.sort(exemplares, new Comparator<Exemplar>() {

			@Override
			public int compare(Exemplar o1, Exemplar o2) {
				return comparadorDeStrings.compare(o1.getLivro().getTitulo(), o2.getLivro().getTitulo());
			}
		});
		return exemplares;
	}
	//lista todos os livros
	public abstract List<Exemplar> listaTodos(Usuario usuario);
	
	
	//lista solicitacoes
	public List<Solicitacao> buscaSolicitacoes(Exemplar exemplar) {
		List<Solicitacao> solicitacoes = buscaSolicitacoes_(exemplar);

		Collections.sort(solicitacoes, new Comparator<Solicitacao>() {

			@Override
			public int compare(Solicitacao o1, Solicitacao o2) {
				return comparadorDeStrings.compare(o1.getExemplar().getLivro().getAutor(), o2.getExemplar().getLivro().getAutor());
			}
		});

		return solicitacoes;
	}
	public abstract List<Solicitacao> buscaSolicitacoes_(Exemplar exemplar);
}
