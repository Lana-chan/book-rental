package dao;

import java.text.Collator;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import entidades.Usuario;

public abstract class UsuarioDao {

	final Collator comparadorDeStrings = Collator.getInstance();

	public UsuarioDao() {
		// Isto Ž para ignorar os acentos nas compara�›es de Strings
		comparadorDeStrings.setStrength(Collator.NO_DECOMPOSITION);
	}

	public void adiciona(Usuario usuario) {
		if (usuario == null) {
			throw new IllegalArgumentException("Parâmetro usuario não pode ser nulo.");
		}

		if (usuario.getNumUsp().toString() == null) {
			throw new IllegalArgumentException("Não é possivel adicionar um usuario sem Numero USP.");
		}

		if (buscaPorNumUSP(usuario.getNumUsp()) != null) {
			throw new IllegalArgumentException("Já existe um usuario com o título: " + usuario.getNumUsp()
					+ " na base de dados.");
		}

		adiciona_(usuario);
	}

	protected abstract void adiciona_(Usuario usuario);

	public void atualiza(Usuario usuario) {
		if (usuario == null) {
			throw new IllegalArgumentException("Parâmetro usuario não pode ser nulo.");
		}

		if (usuario.getNumUsp() == ) {
			throw new IllegalArgumentException("Não é possível atualizar um usuario sem título.");
		}

		if (buscaPorTitulo(usuario.getTitulo()) == null) {
			throw new IllegalArgumentException("Não existe usuario com o título: " + usuario.getTitulo() + " na base de dados.");
		}

		atualiza_(usuario);
	}

	protected abstract void atualiza_(Usuario usuario);

	public usuario buscaPorTitulo(String titulo) {
		if (titulo == null) {
			throw new IllegalArgumentException("Parâmetro titulo n‹o pode ser nulo.");
		}

		return buscaPorTitulo_(titulo);
	}

	protected abstract usuario buscaPorTitulo_(String titulo);

	public void remove(usuario usuario) {
		if (usuario == null) {
			throw new IllegalArgumentException("Parâmetro usuario n‹o pode ser nulo.");
		}

		if (usuario.getTitulo() == null) {
			throw new IllegalArgumentException("Não é possível remover um usuario sem título.");
		}

		if (buscaPorTitulo(usuario.getTitulo()) == null) {
			throw new IllegalArgumentException("Não existe usuario com o título: " + usuario.getTitulo() + " na base de dados.");
		}

		remove_(usuario);
	}

	protected abstract void remove_(Usuario usuario);

	public List<usuario> listaTodosOrdenandoPorTitulo() {
		List<usuario> usuarios = listaTodos();

		Collections.sort(usuarios, new Comparator<usuario>() {

			@Override
			public int compare(usuario o1, usuario o2) {
				return comparadorDeStrings.compare(o1.getTitulo(), o2.getTitulo());
			}
		});

		return usuarios;
	}

	public List<usuario> listaTodosOrdenandoPorAutor() {
		List<usuario> usuarios = listaTodos();

		Collections.sort(usuarios, new Comparator<usuario>() {

			@Override
			public int compare(usuario o1, usuario o2) {
				return comparadorDeStrings.compare(o1.getAutor(), o2.getAutor());
			}
		});

		return usuarios;
	}

	public abstract List<usuario> listaTodos();
}
